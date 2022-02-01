package com.tencent.mobileqq.flashshow.model.barrage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.events.FSGetBarrageEvent;
import com.tencent.mobileqq.flashshow.model.barrage.bean.FSLoadBarrageListBean;
import com.tencent.mobileqq.flashshow.model.barrage.cache.FSBarrageCachePack;
import com.tencent.mobileqq.flashshow.model.barrage.cache.FSBarrageCachePack.FSBarrageResponse;
import com.tencent.mobileqq.flashshow.request.barrage.FSGetBarrageListRequest;
import com.tencent.mobileqq.flashshow.utils.FSSafeListUtils;
import com.tencent.mobileqq.flashshow.utils.FSSafeMapUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FSBarrageModel
  implements IFSBarrageModel
{
  private static volatile IFSBarrageModel a;
  private final FSBarrageCachePack b = new FSBarrageCachePack();
  
  public static IFSBarrageModel a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSBarrageModel();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private List<FeedCloudMeta.StComment> a(@NonNull String paramString)
  {
    ArrayList localArrayList = (ArrayList)FSSafeMapUtils.a(b(paramString), paramString);
    paramString = localArrayList;
    if (localArrayList == null)
    {
      QLog.d("DM-FSBarrageModel", 1, "[getCommentCache] comment cache is empty, create comment cache.");
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  private void a(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean, long paramLong, String paramString)
  {
    boolean bool = paramFSLoadBarrageListBean.d();
    String str = a(paramFSLoadBarrageListBean.c());
    FSGetBarrageEvent localFSGetBarrageEvent = FSGetBarrageEvent.build();
    localFSGetBarrageEvent.setLoadSuccess(false);
    localFSGetBarrageEvent.setFeedId(str);
    localFSGetBarrageEvent.setRetCode(paramLong);
    localFSGetBarrageEvent.setLoadMore(bool);
    localFSGetBarrageEvent.setErrMsg(paramString);
    SimpleEventBus.getInstance().dispatchEvent(localFSGetBarrageEvent);
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[handleGetCommentListFail] ret code: ", Long.valueOf(paramLong), " | err msg: ", paramString, " | isLoadMore: ", Boolean.valueOf(bool), " | feed id: ", str, " | hash code: ", Integer.valueOf(paramFSLoadBarrageListBean.b()) });
  }
  
  private void a(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str = a(paramFSLoadBarrageListBean.c());
    if (TextUtils.isEmpty(str))
    {
      QLog.d("DM-FSBarrageModel", 1, "[handleGetBarrageDataSource] current feed id is empty, handle fail.");
      return;
    }
    List localList = paramStGetCommentListRsp.vecComment.get();
    if (localList == null)
    {
      QLog.d("DM-FSBarrageModel", 1, "[handleGetBarrageDataSource] comment list is empty, handler fail.");
      return;
    }
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[handleGetBarrageDataSource] bean value: ", paramFSLoadBarrageListBean.toString() });
    if (paramFSLoadBarrageListBean.d())
    {
      a(str, localList);
      return;
    }
    a(str, localList, paramStGetCommentListRsp.totalNum.get());
  }
  
  private void a(FSLoadBarrageListBean paramFSLoadBarrageListBean, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, int paramInt, long paramLong, String paramString)
  {
    String str = a(paramFSLoadBarrageListBean.c());
    int i = paramStGetCommentListRsp.totalNum.get();
    boolean bool = paramFSLoadBarrageListBean.d();
    paramStGetCommentListRsp = paramStGetCommentListRsp.vecComment.get();
    FSGetBarrageEvent localFSGetBarrageEvent = FSGetBarrageEvent.build();
    localFSGetBarrageEvent.setLoadSuccess(false);
    localFSGetBarrageEvent.setFeedId(str);
    localFSGetBarrageEvent.setRetCode(paramLong);
    localFSGetBarrageEvent.setLoadMore(bool);
    localFSGetBarrageEvent.setErrMsg(paramString);
    localFSGetBarrageEvent.setTotal(i);
    localFSGetBarrageEvent.setCommentList(paramStGetCommentListRsp);
    localFSGetBarrageEvent.setStartIndex(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(localFSGetBarrageEvent);
    i = FSSafeListUtils.b(paramStGetCommentListRsp);
    paramStGetCommentListRsp = new StringBuilder();
    paramStGetCommentListRsp.append("ret code: ");
    paramStGetCommentListRsp.append(paramLong);
    paramStGetCommentListRsp.append(" | err msg: ");
    paramStGetCommentListRsp.append(paramString);
    paramStGetCommentListRsp.append(" | count: ");
    paramStGetCommentListRsp.append(i);
    paramStGetCommentListRsp.append(" | startIndex: ");
    paramStGetCommentListRsp.append(paramInt);
    paramStGetCommentListRsp.append(" | isLoadMore: ");
    paramStGetCommentListRsp.append(bool);
    paramStGetCommentListRsp.append(" | feedId: ");
    paramStGetCommentListRsp.append(str);
    paramStGetCommentListRsp.append(" | hash code: ");
    paramStGetCommentListRsp.append(paramFSLoadBarrageListBean.b());
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[notifyGetBarrageListFinish]", paramStGetCommentListRsp.toString() });
  }
  
  private void a(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 4))
    {
      boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
      long l = ((Long)paramVarArgs[1]).longValue();
      String str = (String)paramVarArgs[2];
      paramVarArgs = (FeedCloudRead.StGetCommentListRsp)paramVarArgs[3];
      if ((bool) && (l == 0L) && (paramVarArgs != null))
      {
        Object localObject = a(paramFSLoadBarrageListBean.c());
        a((String)localObject, true);
        b(paramFSLoadBarrageListBean, paramVarArgs);
        localObject = (List)FSSafeMapUtils.a(this.b.a(), localObject);
        int i;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((List)localObject).size();
        }
        a(paramFSLoadBarrageListBean, paramVarArgs);
        a(paramFSLoadBarrageListBean, paramVarArgs, i, l, str);
        return;
      }
      a(paramFSLoadBarrageListBean, l, str);
      return;
    }
    QLog.e("DM-FSBarrageModel", 1, "[handleGetCommentListResponse] handle args is null or args length < 4");
  }
  
  private void a(String paramString, int paramInt) {}
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList)
  {
    List localList = a(paramString);
    localList.addAll(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | server call comment count: ");
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[updateBarrageLoadMoreData] update feed id: ", localStringBuilder.toString(), Integer.valueOf(paramList.size()), " | current cache comment count: ", Integer.valueOf(localList.size()) });
  }
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    a(paramString, paramInt);
    FSSafeMapUtils.a(b(paramString), paramString, new ArrayList(paramList));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    FSBarrageCachePack localFSBarrageCachePack = this.b;
    if (localFSBarrageCachePack == null) {
      return;
    }
    paramString = (FSBarrageCachePack.FSBarrageResponse)FSSafeMapUtils.a(localFSBarrageCachePack.b(), paramString);
    if (paramString == null) {
      return;
    }
    paramString.b(paramBoolean);
  }
  
  private Map<String, ArrayList<FeedCloudMeta.StComment>> b(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("DM-FSBarrageModel", 1, "[getBarrageCacheMap] feed id not is empty.");
      return null;
    }
    paramString = this.b;
    if (paramString == null)
    {
      QLog.d("DM-FSBarrageModel", 1, "[getBarrageCacheMap] comment cache pack should not be null.");
      return null;
    }
    return paramString.a();
  }
  
  public static void b()
  {
    QLog.d("DM-FSBarrageModel", 1, "releaseInstance");
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
  
  private void b(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean)
  {
    if (paramFSLoadBarrageListBean.d())
    {
      c(paramFSLoadBarrageListBean);
      return;
    }
    d(paramFSLoadBarrageListBean);
  }
  
  private void b(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str1 = a(paramFSLoadBarrageListBean.c());
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("DM-FSBarrageModel", 1, "[updateResponseAttachInfo] feed id not is empty.");
      return;
    }
    String str2 = paramStGetCommentListRsp.feedAttchInfo.get();
    boolean bool;
    if (paramStGetCommentListRsp.isFinish.get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[updateResponseAttachInfo] feed id: ", a(paramFSLoadBarrageListBean.c()), " | attachInfo: ", str2, " | isFinish: ", Boolean.valueOf(bool) });
    paramFSLoadBarrageListBean = this.b.b();
    paramStGetCommentListRsp = (FSBarrageCachePack.FSBarrageResponse)FSSafeMapUtils.a(paramFSLoadBarrageListBean, str1);
    if (paramStGetCommentListRsp == null)
    {
      paramStGetCommentListRsp = FSBarrageCachePack.FSBarrageResponse.a();
      paramStGetCommentListRsp.a(str2);
      paramStGetCommentListRsp.a(bool);
      paramStGetCommentListRsp.b(true);
      paramFSLoadBarrageListBean.put(str1, paramStGetCommentListRsp);
      return;
    }
    paramStGetCommentListRsp.a(bool);
    paramStGetCommentListRsp.a(str2);
  }
  
  private void c(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean)
  {
    if (c(a(paramFSLoadBarrageListBean.c())))
    {
      QLog.d("DM-FSBarrageModel", 1, "[requestFeedCommentData] current load data finish, not load more.");
      return;
    }
    d(paramFSLoadBarrageListBean);
  }
  
  private boolean c(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.d("DM-FSBarrageModel", 1, "[isLoadFinish] current feed id should not be null.");
      return false;
    }
    paramString = (FSBarrageCachePack.FSBarrageResponse)FSSafeMapUtils.a(this.b.b(), paramString);
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
  
  private String d(String paramString)
  {
    paramString = (FSBarrageCachePack.FSBarrageResponse)FSSafeMapUtils.a(this.b.b(), paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.c();
  }
  
  private void d(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean)
  {
    if (paramFSLoadBarrageListBean.d()) {
      localObject = d(paramFSLoadBarrageListBean.c().id.get());
    } else {
      localObject = "";
    }
    int i = paramFSLoadBarrageListBean.b();
    Object localObject = new FSGetBarrageListRequest(paramFSLoadBarrageListBean, (String)localObject, 20);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashCode: ");
    localStringBuilder.append(paramFSLoadBarrageListBean.b());
    localStringBuilder.append(" | feed id: ");
    localStringBuilder.append(a(paramFSLoadBarrageListBean.c()));
    localStringBuilder.append(" | isLoadMore: ");
    localStringBuilder.append(paramFSLoadBarrageListBean.d());
    QLog.d("DM-FSBarrageModel", 1, new Object[] { "[requestFeedCommentData]", localStringBuilder.toString() });
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new FSBarrageModel.LoadTaskCallback(paramFSLoadBarrageListBean, this));
  }
  
  private boolean e(@NonNull FSLoadBarrageListBean paramFSLoadBarrageListBean)
  {
    if (!paramFSLoadBarrageListBean.d()) {
      return false;
    }
    return TextUtils.isEmpty(d(a(paramFSLoadBarrageListBean.c())));
  }
  
  public void a(FSLoadBarrageListBean paramFSLoadBarrageListBean)
  {
    if (paramFSLoadBarrageListBean == null)
    {
      QLog.d("DM-FSBarrageModel", 1, "[loadBarrageList] bean should not be null.");
      return;
    }
    if (e(paramFSLoadBarrageListBean))
    {
      QLog.d("DM-FSBarrageModel", 1, "[loadBarrageList] load more param illegality, load handle fail.");
      return;
    }
    b(paramFSLoadBarrageListBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.model.barrage.FSBarrageModel
 * JD-Core Version:    0.7.0.1
 */