package com.tencent.mobileqq.flashshow.model.comment;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.events.FSAddCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSAddReplyCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSDeleteCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSDeleteReplyCommentEvent;
import com.tencent.mobileqq.flashshow.events.FSGetCommentEvent;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSAddFeedCommentBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteCommentReplyBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSDeleteFeedCommentBean;
import com.tencent.mobileqq.flashshow.model.comment.bean.FSLoadCommentListBean;
import com.tencent.mobileqq.flashshow.model.comment.cache.FSCommentCachePack;
import com.tencent.mobileqq.flashshow.model.comment.cache.FSCommentCachePack.FSCommentResponse;
import com.tencent.mobileqq.flashshow.request.comment.FSGetCommentListRequest;
import com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentReplyRequest;
import com.tencent.mobileqq.flashshow.request.comment.FSWriteCommentRequest;
import com.tencent.mobileqq.flashshow.utils.FSSafeListUtils;
import com.tencent.mobileqq.flashshow.utils.FSSafeMapUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import feedcloud.FeedCloudWrite.StDoCommentRsp;
import feedcloud.FeedCloudWrite.StDoReplyRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class FSCommentManager
  implements IFSCommentManager
{
  private static volatile IFSCommentManager a;
  private final FSCommentCachePack b = new FSCommentCachePack();
  
  public static IFSCommentManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSCommentManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private FeedCloudMeta.StComment a(List<FeedCloudMeta.StComment> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (FSSafeListUtils.a(paramList)) {
      return null;
    }
    int i = 0;
    while (i < paramList.size())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)paramList.get(i);
      if (TextUtils.equals(localStComment.id.get(), paramString)) {
        return localStComment;
      }
      i += 1;
    }
    return null;
  }
  
  private FeedCloudMeta.StReply a(FeedCloudMeta.StComment paramStComment, String paramString)
  {
    if (paramStComment == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramStComment = paramStComment.vecReply.get();
    int i = 0;
    while (i < paramStComment.size())
    {
      FeedCloudMeta.StReply localStReply = (FeedCloudMeta.StReply)paramStComment.get(i);
      if (TextUtils.equals(localStReply.id.get(), paramString)) {
        return localStReply;
      }
      i += 1;
    }
    return null;
  }
  
  private String a(FeedCloudMeta.StComment paramStComment)
  {
    if (paramStComment == null) {
      return null;
    }
    return paramStComment.content.get();
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private String a(FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply == null) {
      return null;
    }
    return paramStReply.content.get();
  }
  
  private String a(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser == null) {
      return null;
    }
    return paramStUser.id.get();
  }
  
  private void a(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean, long paramLong, String paramString)
  {
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[handleGetCommentListFail] ret code: ", Long.valueOf(paramLong), " | err msg: ", paramString, " | isLoadMore: ", Boolean.valueOf(paramFSLoadCommentListBean.d()) });
    paramFSLoadCommentListBean = a(paramFSLoadCommentListBean.c());
    paramFSLoadCommentListBean = FSGetCommentEvent.build().setLoadSuccess(false).setFeedId(paramFSLoadCommentListBean).setRetCode(paramLong).setErrMsg(paramString);
    SimpleEventBus.getInstance().dispatchEvent(paramFSLoadCommentListBean);
  }
  
  private void a(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str = a(paramFSLoadCommentListBean.c());
    if (TextUtils.isEmpty(str))
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleGetCommentDataSource] current feed id is empty, handle fail.");
      return;
    }
    List localList = paramStGetCommentListRsp.vecComment.get();
    if (localList == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleGetCommentDataSource] comment list is null, handler fail.");
      return;
    }
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[handleGetCommentDataSource] bean value: ", paramFSLoadCommentListBean.toString() });
    if (paramFSLoadCommentListBean.d())
    {
      a(str, localList);
      return;
    }
    int i = paramStGetCommentListRsp.totalNum.get();
    a(str, localList, i);
    paramFSLoadCommentListBean = FSDataCenter.a().a(FeedCloudMeta.StFeed.class, str);
    if (paramFSLoadCommentListBean == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleGetCommentDataSource] state data should not be null.");
      return;
    }
    paramStGetCommentListRsp = (FeedCloudMeta.StFeed)paramFSLoadCommentListBean.getValue();
    if (paramStGetCommentListRsp == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleGetCommentDataSource] state data should not be null.");
      return;
    }
    paramStGetCommentListRsp.commentCount.set(i);
    paramFSLoadCommentListBean.postValue(paramStGetCommentListRsp);
  }
  
  private void a(FSLoadCommentListBean paramFSLoadCommentListBean, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, long paramLong, String paramString)
  {
    paramFSLoadCommentListBean = a(paramFSLoadCommentListBean.c());
    int i = paramStGetCommentListRsp.totalNum.get();
    paramStGetCommentListRsp = paramStGetCommentListRsp.vecComment.get();
    paramFSLoadCommentListBean = FSGetCommentEvent.build().setLoadSuccess(true).setFeedId(paramFSLoadCommentListBean).setRetCode(paramLong).setErrMsg(paramString).setTotal(i).setCommentList(paramStGetCommentListRsp);
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[notifyGetCommentListFinish] ret code: ", Long.valueOf(paramLong), " | err msg: ", paramString, " | count: ", Integer.valueOf(FSSafeListUtils.b(paramStGetCommentListRsp)) });
    SimpleEventBus.getInstance().dispatchEvent(paramFSLoadCommentListBean);
  }
  
  private void a(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 4))
    {
      boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
      long l = ((Long)paramVarArgs[1]).longValue();
      String str = (String)paramVarArgs[2];
      paramVarArgs = (FeedCloudRead.StGetCommentListRsp)paramVarArgs[3];
      if ((bool) && (l == 0L) && (paramVarArgs != null))
      {
        f(paramFSLoadCommentListBean.c().id.get());
        b(paramFSLoadCommentListBean, paramVarArgs);
        a(paramFSLoadCommentListBean, paramVarArgs);
        a(paramFSLoadCommentListBean, paramVarArgs, l, str);
        return;
      }
      a(paramFSLoadCommentListBean, l, str);
      return;
    }
    QLog.e("FSC-FSCommentManager", 1, "[handleGetCommentListResponse] handle args is null or args length < 4");
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, int paramInt1, int paramInt2)
  {
    if (paramStComment == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[updateCommentPraiseNum] comment should not be null.");
      return;
    }
    paramStComment.likeInfo.count.set(paramInt1);
    paramStComment.likeInfo.status.set(paramInt2);
  }
  
  private void a(FeedCloudMeta.StReply paramStReply, int paramInt1, int paramInt2)
  {
    if (paramStReply == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[updateCommentPraiseStatus] reply should not be null.");
      return;
    }
    paramStReply.likeInfo.count.set(paramInt1);
    paramStReply.likeInfo.status.set(paramInt2);
  }
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList)
  {
    List localList = d(paramString);
    localList.addAll(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | server call comment count: ");
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[updateCommentLoadMoreData] update feed id: ", localStringBuilder.toString(), Integer.valueOf(paramList.size()), " | current cache comment count: ", Integer.valueOf(localList.size()) });
  }
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    b(paramString, paramList, paramInt);
    FSSafeMapUtils.a(e(paramString), paramString, new ArrayList(paramList));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = c(paramString);
    if (paramBoolean) {
      i += 1;
    } else {
      i -= 1;
    }
    i = Math.max(i, 0);
    a().a(paramString, i);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp, FSAddFeedCommentBean paramFSAddFeedCommentBean)
  {
    if (paramStDoCommentRsp == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleAddCommentResult] rsp should not be null.");
      return;
    }
    FeedCloudMeta.StComment localStComment;
    if (paramFSAddFeedCommentBean == null) {
      localStComment = null;
    } else {
      localStComment = paramFSAddFeedCommentBean.d();
    }
    if (paramFSAddFeedCommentBean == null) {
      paramFSAddFeedCommentBean = null;
    } else {
      paramFSAddFeedCommentBean = paramFSAddFeedCommentBean.c();
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new FSAddCommentEvent(localStComment, paramStDoCommentRsp.comment);
      paramString.setRequestSuccess(true).setFeed(paramFSAddFeedCommentBean);
    }
    else
    {
      paramStDoCommentRsp = new FSAddCommentEvent(localStComment, null);
      paramStDoCommentRsp.setRequestSuccess(false).setErrMsg(paramString).setFeed(paramFSAddFeedCommentBean);
      paramString = paramStDoCommentRsp;
    }
    a(a(paramFSAddFeedCommentBean), true);
    SimpleEventBus.getInstance().dispatchEvent(paramString);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoCommentRsp paramStDoCommentRsp, FSDeleteFeedCommentBean paramFSDeleteFeedCommentBean)
  {
    if (paramStDoCommentRsp == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleAddCommentResult] rsp should not be null.");
      return;
    }
    if (paramFSDeleteFeedCommentBean == null) {
      paramFSDeleteFeedCommentBean = null;
    } else {
      paramFSDeleteFeedCommentBean = paramFSDeleteFeedCommentBean.c();
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new FSDeleteCommentEvent(paramStDoCommentRsp.comment);
      paramString.setRequestSuccess(true).setFeed(paramFSDeleteFeedCommentBean);
    }
    else
    {
      paramStDoCommentRsp = new FSDeleteCommentEvent(null);
      paramStDoCommentRsp.setRequestSuccess(false).setErrMsg(paramString).setFeed(paramFSDeleteFeedCommentBean);
      paramString = paramStDoCommentRsp;
    }
    a(a(paramFSDeleteFeedCommentBean), false);
    SimpleEventBus.getInstance().dispatchEvent(paramString);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp, FSAddCommentReplyBean paramFSAddCommentReplyBean)
  {
    if (paramStDoReplyRsp == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleAddReplyCommentCallback] rsp should not be null.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed;
    if (paramFSAddCommentReplyBean == null) {
      localStFeed = null;
    } else {
      localStFeed = paramFSAddCommentReplyBean.c();
    }
    FeedCloudMeta.StComment localStComment;
    if (paramFSAddCommentReplyBean == null) {
      localStComment = null;
    } else {
      localStComment = paramFSAddCommentReplyBean.d();
    }
    if (paramFSAddCommentReplyBean == null) {
      paramFSAddCommentReplyBean = null;
    } else {
      paramFSAddCommentReplyBean = paramFSAddCommentReplyBean.e();
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new FSAddReplyCommentEvent(localStComment, paramFSAddCommentReplyBean, paramStDoReplyRsp.reply);
      paramString.setRequestSuccess(true).setFeed(localStFeed);
    }
    else
    {
      paramStDoReplyRsp = new FSAddReplyCommentEvent(localStComment, paramFSAddCommentReplyBean, null);
      paramStDoReplyRsp.setRequestSuccess(false).setErrMsg(paramString).setFeed(localStFeed);
      paramString = paramStDoReplyRsp;
    }
    a(a(localStFeed), true);
    SimpleEventBus.getInstance().dispatchEvent(paramString);
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoReplyRsp paramStDoReplyRsp, FSDeleteCommentReplyBean paramFSDeleteCommentReplyBean)
  {
    if (paramStDoReplyRsp == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[handleDeleteReplyCommentCallback] rsp should not be null.");
      return;
    }
    FeedCloudMeta.StFeed localStFeed;
    if (paramFSDeleteCommentReplyBean == null) {
      localStFeed = null;
    } else {
      localStFeed = paramFSDeleteCommentReplyBean.c();
    }
    if (paramFSDeleteCommentReplyBean == null) {
      paramFSDeleteCommentReplyBean = null;
    } else {
      paramFSDeleteCommentReplyBean = paramFSDeleteCommentReplyBean.d();
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = new FSDeleteReplyCommentEvent(paramFSDeleteCommentReplyBean, paramStDoReplyRsp.reply);
      paramString.setRequestSuccess(true).setFeed(localStFeed);
    }
    else
    {
      paramStDoReplyRsp = new FSDeleteReplyCommentEvent(paramFSDeleteCommentReplyBean, null);
      paramStDoReplyRsp.setRequestSuccess(false).setErrMsg(paramString).setFeed(localStFeed);
      paramString = paramStDoReplyRsp;
    }
    a(a(localStFeed), false);
    SimpleEventBus.getInstance().dispatchEvent(paramString);
  }
  
  public static void b()
  {
    QLog.d("FSC-FSCommentManager", 1, "releaseInstance");
    if (a == null) {
      return;
    }
    try
    {
      if (a == null) {
        return;
      }
      a = null;
      return;
    }
    finally {}
  }
  
  private void b(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean)
  {
    if (paramFSLoadCommentListBean.d())
    {
      c(paramFSLoadCommentListBean);
      return;
    }
    if (PreLoader.exists("3001"))
    {
      PreLoader.addListener("3001", new FSCommentManager.LoadTaskCallback(paramFSLoadCommentListBean, this));
      return;
    }
    d(paramFSLoadCommentListBean);
  }
  
  private void b(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str1 = a(paramFSLoadCommentListBean.c());
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("FSC-FSCommentManager", 1, "[updateResponseAttachInfo] feed id not is empty.");
      return;
    }
    String str2 = paramStGetCommentListRsp.feedAttchInfo.get();
    boolean bool;
    if (paramStGetCommentListRsp.isFinish.get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[updateResponseAttachInfo] feed id: ", a(paramFSLoadCommentListBean.c()), " | attachInfo: ", str2, " | isFinish: ", Boolean.valueOf(bool) });
    paramFSLoadCommentListBean = this.b.c();
    paramStGetCommentListRsp = (FSCommentCachePack.FSCommentResponse)FSSafeMapUtils.a(paramFSLoadCommentListBean, str1);
    if (paramStGetCommentListRsp == null)
    {
      paramStGetCommentListRsp = FSCommentCachePack.FSCommentResponse.a();
      paramStGetCommentListRsp.a(str2);
      paramStGetCommentListRsp.a(bool);
      paramStGetCommentListRsp.b(true);
      paramFSLoadCommentListBean.put(str1, paramStGetCommentListRsp);
      return;
    }
    paramStGetCommentListRsp.a(bool);
    paramStGetCommentListRsp.a(str2);
  }
  
  private void b(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    Map localMap = this.b.b();
    if (paramList.size() > 0)
    {
      FSSafeMapUtils.a(localMap, paramString, Integer.valueOf(paramInt));
      return;
    }
    FSSafeMapUtils.a(localMap, paramString, Integer.valueOf(0));
  }
  
  private void c(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean)
  {
    if (a(a(paramFSLoadCommentListBean.c())))
    {
      QLog.d("FSC-FSCommentManager", 1, "[requestFeedCommentData] current load data finish, not load more.");
      return;
    }
    d(paramFSLoadCommentListBean);
  }
  
  private List<FeedCloudMeta.StComment> d(@NonNull String paramString)
  {
    ArrayList localArrayList = (ArrayList)FSSafeMapUtils.a(e(paramString), paramString);
    paramString = localArrayList;
    if (localArrayList == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[getCommentCache] comment cache is empty, create comment cache.");
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  private void d(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean)
  {
    if (paramFSLoadCommentListBean.d()) {
      localObject = g(paramFSLoadCommentListBean.c().id.get());
    } else {
      localObject = "";
    }
    int i = paramFSLoadCommentListBean.b();
    Object localObject = new FSGetCommentListRequest(paramFSLoadCommentListBean, (String)localObject, 20);
    if ((paramFSLoadCommentListBean.e() != null) && (paramFSLoadCommentListBean.e().has())) {
      ((FSGetCommentListRequest)localObject).mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramFSLoadCommentListBean.e().toByteArray()));
    }
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSCommentManager.LoadTaskCallback(paramFSLoadCommentListBean, this));
  }
  
  private Map<String, ArrayList<FeedCloudMeta.StComment>> e(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FSC-FSCommentManager", 1, "[getCommentCacheMap] feed id not is empty.");
      return null;
    }
    return this.b.a();
  }
  
  private boolean e(@NonNull FSLoadCommentListBean paramFSLoadCommentListBean)
  {
    if (!paramFSLoadCommentListBean.d()) {
      return false;
    }
    return TextUtils.isEmpty(g(a(paramFSLoadCommentListBean.c())));
  }
  
  private void f(String paramString)
  {
    paramString = (FSCommentCachePack.FSCommentResponse)FSSafeMapUtils.a(this.b.c(), paramString);
    if (paramString == null) {
      return;
    }
    paramString.b(true);
  }
  
  private String g(String paramString)
  {
    paramString = (FSCommentCachePack.FSCommentResponse)FSSafeMapUtils.a(this.b.c(), paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.c();
  }
  
  public void a(FSAddCommentReplyBean paramFSAddCommentReplyBean)
  {
    FeedCloudMeta.StFeed localStFeed = paramFSAddCommentReplyBean.c();
    FeedCloudMeta.StComment localStComment = paramFSAddCommentReplyBean.d();
    FeedCloudMeta.StReply localStReply = paramFSAddCommentReplyBean.e();
    String str1 = a(localStFeed);
    String str2 = a(localStComment);
    String str3 = a(localStReply);
    FeedCloudMeta.StUser localStUser = null;
    if (localStComment == null) {
      localObject = null;
    } else {
      localObject = localStComment.postUser;
    }
    if (localStComment != null) {
      localStUser = localStReply.postUser;
    }
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[addCommentReplay] feed id: ", str1, " | comment content:", str2, " | reply content: ", str3, " | comment uin: ", a((FeedCloudMeta.StUser)localObject), " | replyUserId: ", a(localStUser) });
    boolean bool = paramFSAddCommentReplyBean.f();
    int i = paramFSAddCommentReplyBean.b();
    Object localObject = new FSWriteCommentReplyRequest(localStFeed, localStComment, localStReply, 1, bool);
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSCommentManager.AddReplyCommentCallback(this, paramFSAddCommentReplyBean));
  }
  
  public void a(FSAddFeedCommentBean paramFSAddFeedCommentBean)
  {
    Object localObject = paramFSAddFeedCommentBean.c();
    FeedCloudMeta.StComment localStComment = paramFSAddFeedCommentBean.d();
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[addFeedComment] feed id: ", a((FeedCloudMeta.StFeed)localObject), " | comment content:", a(localStComment) });
    boolean bool = paramFSAddFeedCommentBean.e();
    int i = paramFSAddFeedCommentBean.b();
    localObject = new FSWriteCommentRequest((FeedCloudMeta.StFeed)localObject, localStComment, 1, bool);
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSCommentManager.AddCommentCallback(this, paramFSAddFeedCommentBean));
  }
  
  public void a(FSDeleteCommentReplyBean paramFSDeleteCommentReplyBean)
  {
    FeedCloudMeta.StFeed localStFeed = paramFSDeleteCommentReplyBean.c();
    FeedCloudMeta.StComment localStComment = paramFSDeleteCommentReplyBean.d();
    FeedCloudMeta.StReply localStReply = paramFSDeleteCommentReplyBean.e();
    String str1 = a(localStFeed);
    String str2 = a(localStComment);
    String str3 = a(localStReply);
    FeedCloudMeta.StUser localStUser = null;
    if (localStComment == null) {
      localObject = null;
    } else {
      localObject = localStComment.postUser;
    }
    if (localStComment != null) {
      localStUser = localStReply.postUser;
    }
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[deleteCommentReplay] feed id: ", str1, " | comment content:", str2, " | reply content: ", str3, " | comment uin: ", a((FeedCloudMeta.StUser)localObject), " | replyUserId: ", a(localStUser) });
    boolean bool = paramFSDeleteCommentReplyBean.f();
    int i = paramFSDeleteCommentReplyBean.b();
    Object localObject = new FSWriteCommentReplyRequest(localStFeed, localStComment, localStReply, 0, bool);
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSCommentManager.DeleteReplyCommentCallback(this, paramFSDeleteCommentReplyBean));
  }
  
  public void a(FSDeleteFeedCommentBean paramFSDeleteFeedCommentBean)
  {
    Object localObject = paramFSDeleteFeedCommentBean.c();
    FeedCloudMeta.StComment localStComment = paramFSDeleteFeedCommentBean.d();
    QLog.d("FSC-FSCommentManager", 1, new Object[] { "[deleteFeedComment] feed id: ", a((FeedCloudMeta.StFeed)localObject), " | comment content:", a(localStComment) });
    boolean bool = paramFSDeleteFeedCommentBean.e();
    int i = paramFSDeleteFeedCommentBean.b();
    localObject = new FSWriteCommentRequest((FeedCloudMeta.StFeed)localObject, localStComment, 0, bool);
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSCommentManager.DeleteCommentCallback(this, paramFSDeleteFeedCommentBean));
  }
  
  public void a(FSLoadCommentListBean paramFSLoadCommentListBean)
  {
    if (paramFSLoadCommentListBean == null)
    {
      QLog.d("FSC-FSCommentManager", 1, "[loadCommentList] bean should not be null.");
      return;
    }
    if (e(paramFSLoadCommentListBean))
    {
      QLog.d("FSC-FSCommentManager", 1, "[loadCommentList] load more param illegality, load handle fail.");
      return;
    }
    b(paramFSLoadCommentListBean);
  }
  
  public void a(String paramString, int paramInt)
  {
    FSSafeMapUtils.a(this.b.b(), paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("FSC-FSCommentManager", 1, "[updateCommentsPraiseCache] current feed id should not be null.");
      return;
    }
    paramString1 = a((List)FSSafeMapUtils.a(this.b.a(), paramString1), paramString2);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      a(a(paramString1, paramString3), paramInt1, paramInt2);
      return;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      a(paramString1, paramInt1, paramInt2);
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.d("FSC-FSCommentManager", 1, "[isLoadFinish] current feed id should not be null.");
      return false;
    }
    paramString = (FSCommentCachePack.FSCommentResponse)FSSafeMapUtils.a(this.b.c(), paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public List<FeedCloudMeta.StComment> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FSC-FSCommentManager", 1, "[getLoadedComments] current feed id should not be null.");
      return null;
    }
    return (List)FSSafeMapUtils.a(this.b.a(), paramString);
  }
  
  public int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("FSC-FSCommentManager", 1, "[getLoadedComments] current feed id should not be null.");
      return 0;
    }
    paramString = (Integer)FSSafeMapUtils.a(this.b.b(), paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.comment.FSCommentManager
 * JD-Core Version:    0.7.0.1
 */