package com.tencent.mobileqq.kandian.biz.comment.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.RIJCommentResultDispatcher;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.UserIdentityIcon;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentStickyData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.guide.GuideHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkWrapper;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LongSparseArray;
import com.tencent.util.Pair;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentDataManager
  extends ReadInJoyObserver
  implements ReadInJoyCommentBubbleObserver, ReadInJoyCommentObserver
{
  private static Map<String, ReadInJoyCommentDataManager> c = new HashMap();
  private static final LruCache<String, Boolean> d = new LruCache(20);
  private ReadInJoyCommentPBModule A = null;
  private List<ReadInJoyCommentDataManager.OnDataChangeListener> B = new ArrayList();
  private LongSparseArray<Pair<String, BaseCommentData>> C = new LongSparseArray();
  private ReadInJoyCommentDataManager.CommentAnchor D;
  private GuideHelper E = new GuideHelper();
  private String F = "";
  private String G = "";
  private boolean H = true;
  private boolean I;
  private ReadInJoyCommentPBModule.Label J = new ReadInJoyCommentPBModule.Label();
  private boolean K;
  private String L = "";
  private boolean M;
  protected String a = "";
  protected CommonCommentData b;
  private Map<String, BaseCommentData> e = new HashMap();
  private int f;
  private AbsBaseArticleInfo g;
  private List<String> h = new ArrayList();
  private List<String> i = new ArrayList();
  private String j = "";
  private boolean k = true;
  private List<String> l = new ArrayList();
  private String m = "";
  private boolean n = true;
  private long o = 0L;
  private long p = 0L;
  private String q = "";
  private boolean r = true;
  private long s = 0L;
  private String t = "";
  private boolean u = true;
  private long v = 0L;
  private String w = "";
  private boolean x = false;
  private List<String> y = new ArrayList();
  private ReadInJoyCommentSSOModule z = null;
  
  private ReadInJoyCommentDataManager(String paramString)
  {
    Object localObject = ReadInJoyUserInfoModule.e();
    if (localObject != null)
    {
      localObject = ((IReadInJoyLogicEngine)localObject).aj();
      if ((localObject instanceof ReadInJoyCommentPBModule))
      {
        this.A = ((ReadInJoyCommentPBModule)localObject);
        this.A.a(this);
      }
    }
    this.z = new ReadInJoyCommentSSOModule();
    this.z.a(this);
    a(this.E);
    u();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("constructor: rowkey=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", pbModule=");
    ((StringBuilder)localObject).append(this.A);
    QLog.d("ReadInJoyCommentDataManager", 1, ((StringBuilder)localObject).toString());
    RIJEmotionCacheManager.b();
  }
  
  private void A()
  {
    Iterator localIterator = this.e.values().iterator();
    while (localIterator.hasNext()) {
      if (((BaseCommentData)localIterator.next()).isComment())
      {
        i1 = 1;
        break label46;
      }
    }
    int i1 = 0;
    label46:
    if (i1 == 0) {
      B();
    }
  }
  
  private void B()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    localObject = this.h;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.i;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.y;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  private Pair<Integer, Integer> C()
  {
    int i2 = this.h.size() - 1;
    int i1 = 0;
    BaseCommentData localBaseCommentData;
    while (i2 >= 0)
    {
      localBaseCommentData = (BaseCommentData)this.e.get(this.h.get(i2));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorBottom)) {
        break;
      }
      i1 += 1;
      i2 -= 1;
    }
    i2 = D();
    int i3 = i2;
    while (i2 <= this.h.size() - 1 - i1)
    {
      localBaseCommentData = (BaseCommentData)this.e.get(this.h.get(i2));
      if ((localBaseCommentData == null) || (!localBaseCommentData.isAuthorSticky)) {
        break;
      }
      i3 += 1;
      i2 += 1;
    }
    return new Pair(Integer.valueOf(this.h.size() - i3 - i1), Integer.valueOf(i1));
  }
  
  private int D()
  {
    Object localObject1 = this.h;
    int i3 = 0;
    int i1 = 0;
    int i2 = i3;
    if (localObject1 != null)
    {
      i2 = i3;
      if (((List)localObject1).size() > 0)
      {
        localObject1 = this.h.iterator();
        for (;;)
        {
          i2 = i1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (BaseCommentData)this.e.get(localObject2);
          i2 = i1;
          if (localObject2 == null) {
            break;
          }
          i2 = i1;
          if (!((BaseCommentData)localObject2).isBanner) {
            break;
          }
          i1 += 1;
        }
      }
    }
    return i2;
  }
  
  public static ReadInJoyCommentDataManager a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    return (ReadInJoyCommentDataManager)c.get(paramAbsBaseArticleInfo.innerUniqueID);
  }
  
  public static ReadInJoyCommentDataManager a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = (ReadInJoyCommentDataManager)c.get(paramAbsBaseArticleInfo.innerUniqueID);
    if (localReadInJoyCommentDataManager != null) {
      return localReadInJoyCommentDataManager;
    }
    localReadInJoyCommentDataManager = new ReadInJoyCommentDataManager(paramAbsBaseArticleInfo.innerUniqueID);
    localReadInJoyCommentDataManager.c(paramAbsBaseArticleInfo);
    localReadInJoyCommentDataManager.f = paramInt;
    if ((paramInt != 1) && (paramInt != 10))
    {
      localReadInJoyCommentDataManager.a = paramAbsBaseArticleInfo.innerUniqueID;
      localReadInJoyCommentDataManager.G = paramAbsBaseArticleInfo.innerUniqueID;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      localStringBuilder.append("");
      localReadInJoyCommentDataManager.a = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      localStringBuilder.append("");
      localReadInJoyCommentDataManager.F = localStringBuilder.toString();
    }
    c.put(paramAbsBaseArticleInfo.innerUniqueID, localReadInJoyCommentDataManager);
    localReadInJoyCommentDataManager.G = paramAbsBaseArticleInfo.innerUniqueID;
    QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "create commentDataManager, articleInfo : ", paramAbsBaseArticleInfo, ", src : ", Integer.valueOf(paramInt) });
    return localReadInJoyCommentDataManager;
  }
  
  private List<CommentViewItem> a(boolean paramBoolean, BaseCommentData paramBaseCommentData, List<SubCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new CommentViewItem(0, paramBaseCommentData, this.g));
      localArrayList.add(new CommentViewItem(3, paramBaseCommentData, this.g));
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramBaseCommentData = paramList.iterator();
      while (paramBaseCommentData.hasNext())
      {
        paramList = (SubCommentData)paramBaseCommentData.next();
        int i1;
        if (paramList.isActivity()) {
          i1 = 4;
        } else {
          i1 = 0;
        }
        localArrayList.add(new CommentViewItem(i1, paramList, this.g));
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    y();
    if ((this.A != null) && (!TextUtils.isEmpty(this.a)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch sub commentList, id : ", paramString1, ", fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.m });
      this.A.a(this.g.innerUniqueID, paramString1, paramString2, this.m, 10, this.f, this.b);
      return;
    }
    a(new ReadInJoyCommentDataManager.13(this, paramInt));
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    a(paramCallbackActionJob, true);
  }
  
  private void a(ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob, boolean paramBoolean)
  {
    if ((!this.B.isEmpty()) && (paramCallbackActionJob != null)) {
      a(this.B, paramBoolean, paramCallbackActionJob);
    }
    ArrayList localArrayList = new ArrayList();
    if (RIJCommentResultDispatcher.a().b() != null) {
      localArrayList.addAll(RIJCommentResultDispatcher.a().b());
    }
    if (paramCallbackActionJob != null) {
      a(localArrayList, paramBoolean, paramCallbackActionJob);
    }
  }
  
  private void a(CommentData paramCommentData, int paramInt)
  {
    if (paramCommentData == null) {
      return;
    }
    Object localObject = this.h;
    if ((localObject != null) && (((List)localObject).contains(paramCommentData.commentId)))
    {
      this.s += paramInt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateCommentCount | mHotCommentCnt ");
      ((StringBuilder)localObject).append(this.s);
      QLog.d("ReadInJoyCommentDataManager", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = this.p;
    long l2 = paramInt;
    this.p = (l1 + l2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCommentCount | totalCommentCnt ");
    ((StringBuilder)localObject).append(this.p);
    QLog.d("ReadInJoyCommentDataManager", 2, ((StringBuilder)localObject).toString());
    localObject = this.y;
    if ((localObject != null) && (((List)localObject).contains(paramCommentData.commentId)))
    {
      this.v += l2;
      paramCommentData = new StringBuilder();
      paramCommentData.append("updateCommentCount | mFamilyCommentCnt ");
      paramCommentData.append(this.v);
      QLog.d("ReadInJoyCommentDataManager", 2, paramCommentData.toString());
    }
  }
  
  private void a(CreateCommentResult paramCreateCommentResult)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCreateCommentResult | create comment resp, seq ", Long.valueOf(paramCreateCommentResult.a), " succ : ", Boolean.valueOf(paramCreateCommentResult.b), " data : ", paramCreateCommentResult.e });
    int i1 = paramCreateCommentResult.i;
    if (this.i == null) {
      this.i = new ArrayList();
    }
    if (this.h == null) {
      this.h = new ArrayList();
    }
    Pair localPair = (Pair)this.C.a(paramCreateCommentResult.a);
    if (localPair == null)
    {
      QLog.d("ReadInJoyCommentDataManager", 1, "onCreateCommentResult | fake comment data not exist, return !");
      return;
    }
    BaseCommentData localBaseCommentData = (BaseCommentData)localPair.second;
    this.C.c(paramCreateCommentResult.a);
    if (!TextUtils.isEmpty(paramCreateCommentResult.g)) {
      localBaseCommentData.commentContent = paramCreateCommentResult.g;
    }
    localBaseCommentData.shareUrl = paramCreateCommentResult.h;
    if (paramCreateCommentResult.b)
    {
      localBaseCommentData.commentRptDataList = paramCreateCommentResult.k;
      ReadInJoyCommentUtils.a(this.g, (String)localPair.first);
      d(localBaseCommentData);
      a(localBaseCommentData, paramCreateCommentResult.e, i1);
      return;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      a(new ReadInJoyCommentDataManager.33(this, paramCreateCommentResult));
      return;
    }
    if ((localBaseCommentData instanceof SubCommentData)) {
      a(new ReadInJoyCommentDataManager.34(this));
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramBoolean)) {
      d.put(l(paramString), Boolean.TRUE);
    }
  }
  
  private void a(List<ReadInJoyCommentDataManager.OnDataChangeListener> paramList, boolean paramBoolean, ReadInJoyCommentDataManager.CallbackActionJob paramCallbackActionJob)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      ReadInJoyCommentDataManager.OnDataChangeListener localOnDataChangeListener = (ReadInJoyCommentDataManager.OnDataChangeListener)paramList.get(i1);
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.36(this, paramCallbackActionJob, localOnDataChangeListener));
      } else {
        paramCallbackActionJob.a(localOnDataChangeListener);
      }
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131915777), 0).show();
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    int i1;
    if (paramBoolean2)
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label61;
      }
      i1 = 2131915776;
    }
    else
    {
      i1 = 2131915775;
    }
    paramString = HardCodeUtil.a(i1);
    label61:
    QQToast.makeText(localBaseApplication, 1, paramString, 0).show();
  }
  
  private RIJRequestDataForComment b(String paramString1, String paramString2)
  {
    RIJRequestDataForComment localRIJRequestDataForComment = new RIJRequestDataForComment();
    localRIJRequestDataForComment.a = this.g.innerUniqueID;
    localRIJRequestDataForComment.b = paramString1;
    localRIJRequestDataForComment.c = 10;
    localRIJRequestDataForComment.d = this.f;
    localRIJRequestDataForComment.f = this.b;
    localRIJRequestDataForComment.e = paramString2;
    localRIJRequestDataForComment.i = this.g.mSubscribeID;
    localRIJRequestDataForComment.k = this.g.innerUniqueID;
    localRIJRequestDataForComment.j = this.g.getVideoVid();
    localRIJRequestDataForComment.g = this.g.tags;
    localRIJRequestDataForComment.h = this.g.unioChann;
    localRIJRequestDataForComment.l = this.g.mAdScene;
    return localRIJRequestDataForComment;
  }
  
  public static ReadInJoyCommentDataManager b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ReadInJoyCommentDataManager)c.get(paramString);
  }
  
  private void b(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof CommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)paramBaseCommentData;
    a(localCommentData, -(localCommentData.subCommentNum + 1));
    m(paramBaseCommentData.commentId);
  }
  
  private void b(CreateCommentResult paramCreateCommentResult)
  {
    if (this.g != null) {
      ThreadManager.getUIHandler().post(new ReadInJoyCommentDataManager.37(this, paramCreateCommentResult));
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    paramAbsBaseArticleInfo = (ReadInJoyCommentDataManager)c.remove(paramAbsBaseArticleInfo.innerUniqueID);
    if (paramAbsBaseArticleInfo != null)
    {
      paramAbsBaseArticleInfo.e();
      QLog.d("ReadInJoyCommentDataManager", 1, "removeCommentDataManager | destroy");
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (paramInt == 6)
    {
      paramAbsBaseArticleInfo = (ReadInJoyCommentDataManager)c.get(paramAbsBaseArticleInfo.innerUniqueID);
      if (paramAbsBaseArticleInfo != null) {
        paramAbsBaseArticleInfo.x();
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("removeCommentDataManager feedsType ");
      paramAbsBaseArticleInfo.append(paramInt);
      QLog.d("ReadInJoyCommentDataManager", 1, paramAbsBaseArticleInfo.toString());
      return;
    }
    b(paramAbsBaseArticleInfo);
  }
  
  private void c(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {
      return;
    }
    CommentData localCommentData = (CommentData)this.e.get(((SubCommentData)paramBaseCommentData).parentCommentId);
    if (localCommentData == null) {
      return;
    }
    if (localCommentData.subCommentNum > 0) {
      localCommentData.subCommentNum -= 1;
    }
    List localList = localCommentData.subCommentList;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
        if (localSubCommentData.commentId.equalsIgnoreCase(paramBaseCommentData.commentId)) {
          localList.remove(localSubCommentData);
        }
      }
    }
    a(localCommentData, -1);
    this.l.remove(paramBaseCommentData.commentId);
  }
  
  private void c(List<CommentData> paramList1, List<CommentData> paramList2)
  {
    if (this.e == null) {
      return;
    }
    Object localObject;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        localObject = (CommentData)paramList1.next();
        if (localObject != null)
        {
          this.e.put(((CommentData)localObject).commentId, localObject);
          List localList = this.h;
          if (localList != null) {
            localList.add(((CommentData)localObject).commentId);
          }
        }
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (CommentData)paramList1.next();
        if (paramList2 != null)
        {
          if (!this.e.containsKey(paramList2.commentId)) {
            this.e.put(paramList2.commentId, paramList2);
          }
          localObject = this.i;
          if (localObject != null) {
            ((List)localObject).add(paramList2.commentId);
          }
        }
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (d.get(l(paramString)) != null);
  }
  
  private void d(BaseCommentData paramBaseCommentData)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.c(), null);
    if ((localReadInJoyUserInfo != null) && (!TextUtils.isEmpty(localReadInJoyUserInfo.upIconUrl)) && (paramBaseCommentData != null))
    {
      paramBaseCommentData.userIdentityIcon = new BaseCommentData.UserIdentityIcon();
      paramBaseCommentData.userIdentityIcon.b = localReadInJoyUserInfo.upIconUrl;
    }
  }
  
  private void d(List<CommentData> paramList, List<String> paramList1)
  {
    if (this.e == null) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CommentData localCommentData = (CommentData)paramList.next();
        if (localCommentData != null)
        {
          this.e.put(localCommentData.commentId, localCommentData);
          if (paramList1 != null) {
            paramList1.add(localCommentData.commentId);
          }
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131910543), 0).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131897901), 0).show();
  }
  
  private boolean d(List<CommentData> paramList)
  {
    if (paramList != null)
    {
      Object localObject = this.D;
      if ((localObject != null) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).d))
      {
        if (this.D.b == null) {
          return false;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CommentData)paramList.next();
          if ((localObject != null) && (this.D.b.equals(((CommentData)localObject).commentId)))
          {
            ((CommentData)localObject).isAnchor = true;
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static int e(BaseCommentData paramBaseCommentData)
  {
    int i1 = 0;
    if (paramBaseCommentData == null) {
      return 0;
    }
    if (paramBaseCommentData.isActivity()) {
      return 4;
    }
    if (paramBaseCommentData.isBanner()) {
      return 5;
    }
    if (paramBaseCommentData.isDynamicComment()) {
      return 7;
    }
    if (paramBaseCommentData.isAd) {
      i1 = 9;
    }
    return i1;
  }
  
  private List<CommentViewItem> e(int paramInt, List<BaseCommentData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramList.next();
      localArrayList.add(new CommentViewItem(paramInt, e(localBaseCommentData), localBaseCommentData, this.g));
    }
    return localArrayList;
  }
  
  private List<CommentViewItem> f(int paramInt, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((!TextUtils.isEmpty(str)) && (this.e.get(str) != null)) {
          localArrayList.add(new CommentViewItem(paramInt, e((BaseCommentData)this.e.get(str)), (BaseCommentData)this.e.get(str), this.g));
        }
      }
    }
    return localArrayList;
  }
  
  private void g(int paramInt)
  {
    y();
    if ((this.A != null) && (!TextUtils.isEmpty(this.a)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch NewCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.q });
      if (paramInt == 1) {
        localObject1 = "";
      } else {
        localObject1 = this.q;
      }
      this.q = ((String)localObject1);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt == 1)
      {
        ReadInJoyCommentDataManager.CommentAnchor localCommentAnchor = this.D;
        localObject1 = localObject2;
        if (localCommentAnchor != null)
        {
          localObject1 = localObject2;
          if (localCommentAnchor.a) {
            localObject1 = this.D.b;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.9(this, (String)localObject1));
      return;
    }
    a(new ReadInJoyCommentDataManager.8(this, paramInt));
  }
  
  private void h(int paramInt)
  {
    y();
    if ((this.A != null) && (!TextUtils.isEmpty(this.a)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetch HotCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.t });
      if (paramInt == 1) {
        localObject1 = "";
      } else {
        localObject1 = this.t;
      }
      this.t = ((String)localObject1);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramInt == 1)
      {
        ReadInJoyCommentDataManager.CommentAnchor localCommentAnchor = this.D;
        localObject1 = localObject2;
        if (localCommentAnchor != null)
        {
          localObject1 = localObject2;
          if (localCommentAnchor.a) {
            localObject1 = this.D.b;
          }
        }
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.11(this, (String)localObject1));
      return;
    }
    a(new ReadInJoyCommentDataManager.10(this, paramInt));
  }
  
  private void i(int paramInt)
  {
    y();
    if ((this.A != null) && (!TextUtils.isEmpty(this.a)))
    {
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "fetchFamilyCommentList, fetchType : ", Integer.valueOf(paramInt), ", cookie : ", this.w });
      String str;
      if (paramInt == 1) {
        str = "";
      } else {
        str = this.w;
      }
      this.w = str;
      this.A.b(b(this.w, null));
      return;
    }
    a(new ReadInJoyCommentDataManager.12(this, paramInt));
  }
  
  private static String l(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append('_');
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void m(String paramString)
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).remove(paramString);
    }
    localObject = this.h;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    localObject = this.i;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    localObject = this.y;
    if (localObject != null) {
      ((List)localObject).remove(paramString);
    }
    A();
  }
  
  public static void r()
  {
    c.clear();
  }
  
  private void u()
  {
    ReadInJoyUserInfoModule.a(RIJQQAppInterfaceUtil.c(), null);
  }
  
  private void v()
  {
    List localList = this.h;
    if (localList != null) {
      localList.clear();
    }
    this.s = 0L;
    this.u = false;
    this.t = "";
  }
  
  private void w()
  {
    List localList = this.i;
    if (localList != null) {
      localList.clear();
    }
    this.q = "";
    this.r = false;
    this.p = 0L;
  }
  
  private void x()
  {
    List localList = this.y;
    if (localList != null) {
      localList.clear();
    }
    this.w = "";
    this.v = 0L;
    this.x = false;
  }
  
  private void y()
  {
    if (!this.M)
    {
      ReadInJoyCommentPBModule localReadInJoyCommentPBModule = this.A;
      if (localReadInJoyCommentPBModule != null) {
        localReadInJoyCommentPBModule.a(this);
      }
    }
  }
  
  private boolean z()
  {
    Object localObject = this.D;
    if (localObject != null) {
      localObject = ((ReadInJoyCommentDataManager.CommentAnchor)localObject).b;
    } else {
      localObject = "";
    }
    ReadInJoyCommentDataManager.CommentAnchor localCommentAnchor = this.D;
    return (localCommentAnchor != null) && (localCommentAnchor.a) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("MA==")) && (!((String)localObject).equals("0"));
  }
  
  public int a()
  {
    return this.f;
  }
  
  @VisibleForTesting
  int a(@NonNull CommentReportInfo paramCommentReportInfo)
  {
    paramCommentReportInfo = (CommentData)this.e.get(paramCommentReportInfo.b());
    if (paramCommentReportInfo != null)
    {
      a(paramCommentReportInfo, -(paramCommentReportInfo.subCommentNum + 1));
      m(paramCommentReportInfo.commentId);
    }
    return 1;
  }
  
  @Nullable
  public BaseCommentData a(int paramInt, String paramString)
  {
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = new CommentData();
    }
    else
    {
      if (paramInt != 2) {
        break label454;
      }
      localObject1 = new SubCommentData();
    }
    ((BaseCommentData)localObject1).level = paramInt;
    ((BaseCommentData)localObject1).anonymous = 0;
    ((BaseCommentData)localObject1).authorSelection = 0;
    ((BaseCommentData)localObject1).awesome = 0;
    ((BaseCommentData)localObject1).uin = RIJQQAppInterfaceUtil.d();
    ((BaseCommentData)localObject1).homepage = RIJJumpUtils.e(((BaseCommentData)localObject1).uin);
    ((BaseCommentData)localObject1).myself = 1;
    ((BaseCommentData)localObject1).like = 0;
    ((BaseCommentData)localObject1).disLike = 0;
    ((BaseCommentData)localObject1).likeCnt = 0;
    ((BaseCommentData)localObject1).rank = 0;
    ((BaseCommentData)localObject1).rowKey = this.g.innerUniqueID;
    ((BaseCommentData)localObject1).contentSrc = this.f;
    Object localObject3 = "";
    ((BaseCommentData)localObject1).authorComment = "";
    ((BaseCommentData)localObject1).commentTime = NetConnInfoCenter.getServerTime();
    Object localObject4 = ReadInJoyUserInfoModule.a(Long.parseLong(((BaseCommentData)localObject1).uin), null);
    if (localObject4 != null) {
      localObject2 = ((ReadInJoyUserInfo)localObject4).nick;
    } else {
      localObject2 = ReadInJoyUserInfoModule.d();
    }
    ((BaseCommentData)localObject1).nickName = ((String)localObject2);
    Object localObject2 = localObject3;
    if (localObject4 != null) {
      localObject2 = ((ReadInJoyUserInfo)localObject4).faceUrl;
    }
    ((BaseCommentData)localObject1).avatar = ((String)localObject2);
    try
    {
      paramString = new JSONObject(paramString);
      RIJCommentRptDataUtil.a(paramString, (BaseCommentData)localObject1);
      localObject2 = paramString.optJSONArray("linkList");
      if (localObject2 != null)
      {
        localObject3 = new ReadInJoyCommentDataManager.35(this).getType();
        ((BaseCommentData)localObject1).commentLinkDataList = ((List)new Gson().fromJson(((JSONArray)localObject2).toString(), (Type)localObject3));
      }
      if (paramInt == 2)
      {
        localObject2 = (SubCommentData)localObject1;
        localObject4 = paramString.getString("commentId");
        localObject3 = (BaseCommentData)this.e.get(localObject4);
        if ((localObject3 instanceof SubCommentData))
        {
          ((SubCommentData)localObject2).parentCommentId = ((SubCommentData)localObject3).parentCommentId;
        }
        else
        {
          if (!(localObject3 instanceof CommentData)) {
            break label445;
          }
          ((SubCommentData)localObject2).parentCommentId = ((BaseCommentData)localObject3).commentId;
        }
        if (paramString.optBoolean("isSecondReply", false))
        {
          ((SubCommentData)localObject2).repliedCommentId = ((String)localObject4);
          localObject4 = paramString.optString("replyUin");
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((SubCommentData)localObject2).repliedUserUin = ((String)localObject4);
            paramString = ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject4).longValue(), null);
            if (paramString != null) {
              paramString = paramString.nick;
            } else {
              paramString = ReadInJoyUserInfoModule.d();
            }
            ((SubCommentData)localObject2).repliedUserNickname = paramString;
            ((SubCommentData)localObject2).repliedUserHomePage = RIJJumpUtils.e((String)localObject4);
            ((SubCommentData)localObject2).hasTarget = 1;
            if ((localObject3 instanceof SubCommentData))
            {
              RIJCommentRptDataUtil.a((SubCommentData)localObject2, (SubCommentData)localObject3);
              return localObject1;
              label445:
              return null;
            }
          }
        }
      }
      return localObject1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    label454:
    return null;
  }
  
  @VisibleForTesting
  Pair<List<BaseCommentData>, List<BaseCommentData>> a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData == null) {
      return null;
    }
    String str = paramBaseCommentData.uin;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (TextUtils.isEmpty(str))
    {
      if ((paramBaseCommentData instanceof CommentData))
      {
        localArrayList1.add(paramBaseCommentData);
        b(paramBaseCommentData);
        return new Pair(localArrayList1, localArrayList2);
      }
      if ((paramBaseCommentData instanceof SubCommentData))
      {
        localArrayList2.add(paramBaseCommentData);
        c(paramBaseCommentData);
        return new Pair(localArrayList1, localArrayList2);
      }
      return null;
    }
    paramBaseCommentData = this.e.values().iterator();
    while (paramBaseCommentData.hasNext())
    {
      BaseCommentData localBaseCommentData = (BaseCommentData)paramBaseCommentData.next();
      if ((localBaseCommentData != null) && (str.equals(localBaseCommentData.uin))) {
        if ((localBaseCommentData instanceof CommentData)) {
          localArrayList1.add(localBaseCommentData);
        } else if ((localBaseCommentData instanceof SubCommentData)) {
          localArrayList2.add(localBaseCommentData);
        }
      }
    }
    paramBaseCommentData = localArrayList1.iterator();
    while (paramBaseCommentData.hasNext()) {
      b((BaseCommentData)paramBaseCommentData.next());
    }
    paramBaseCommentData = localArrayList2.iterator();
    while (paramBaseCommentData.hasNext()) {
      c((BaseCommentData)paramBaseCommentData.next());
    }
    return new Pair(localArrayList1, localArrayList2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    y();
    if ((this.A != null) && (!TextUtils.isEmpty(this.a)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFirstCommentList | feedsType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" contentSrc : ");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("; fetchType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { ((StringBuilder)localObject).toString(), ", cookie : ", this.j });
      if (paramInt2 == 1) {
        localObject = "";
      } else {
        localObject = this.j;
      }
      this.j = ((String)localObject);
      if ((paramInt2 == 1) && (z()))
      {
        ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.5(this, this.D.b));
        return;
      }
      if (paramInt1 == 6)
      {
        ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.6(this));
        return;
      }
      ThreadManager.executeOnSubThread(new ReadInJoyCommentDataManager.7(this, null));
      return;
    }
    a(new ReadInJoyCommentDataManager.4(this, paramInt2));
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo1, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo2, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = TextUtils.isEmpty(this.j);
    if (paramResponseCommentInfo1 == null) {
      paramResponseCommentInfo1 = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseCommentInfo2 == null) {
      paramResponseCommentInfo2 = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseExtraInfo == null) {
      paramResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    if (bool1)
    {
      this.r = paramResponseCommentInfo2.d;
      this.u = paramResponseCommentInfo1.d;
      long l1;
      if (paramResponseCommentInfo1.a != null) {
        l1 = paramResponseCommentInfo1.a.size();
      } else {
        l1 = 0L;
      }
      this.s = l1;
      this.q = paramResponseCommentInfo2.e;
      this.t = paramResponseCommentInfo1.e;
      a(this.G, paramResponseExtraInfo.e);
      this.J = paramResponseExtraInfo.f;
      this.K = paramResponseExtraInfo.g;
      this.L = paramResponseExtraInfo.h;
      c(paramResponseCommentInfo1.a, paramResponseCommentInfo2.a);
    }
    if (bool2)
    {
      if (paramResponseExtraInfo.a > 0L) {
        this.p = paramResponseExtraInfo.a;
      }
      this.o = paramResponseExtraInfo.b;
      Object localObject = this.D;
      if ((localObject != null) && (((ReadInJoyCommentDataManager.CommentAnchor)localObject).d))
      {
        if (!d(paramResponseCommentInfo1.a)) {
          a(new ReadInJoyCommentDataManager.19(this));
        }
        this.D.d = false;
      }
      localObject = d(3);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        paramInt = 3;
      }
      else
      {
        localObject = d(2);
        paramInt = 2;
      }
      if (paramInt == 3) {
        bool2 = this.u;
      } else {
        bool2 = this.r;
      }
      int i1;
      if (paramResponseCommentInfo1.a()) {
        i1 = paramResponseCommentInfo1.a.size();
      } else {
        i1 = 0;
      }
      paramResponseCommentInfo1 = new StringBuilder();
      paramResponseCommentInfo1.append(", new size : ");
      int i2;
      if (paramResponseCommentInfo2.a()) {
        i2 = paramResponseCommentInfo2.a.size();
      } else {
        i2 = 0;
      }
      paramResponseCommentInfo1.append(i2);
      paramResponseCommentInfo1 = paramResponseCommentInfo1.toString();
      paramResponseCommentInfo2 = new StringBuilder();
      paramResponseCommentInfo2.append(this.p);
      paramResponseCommentInfo2.append(" , hideCnt : ");
      paramResponseCommentInfo2.append(this.o);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(i1), paramResponseCommentInfo1, ", totalCnt : ", paramResponseCommentInfo2.toString() });
      a(new ReadInJoyCommentDataManager.20(this, bool1, (List)localObject, bool2, paramInt));
      paramResponseCommentInfo1 = this.D;
      if (paramResponseCommentInfo1 != null) {
        paramResponseCommentInfo1.a(false);
      }
      this.E.a(paramResponseExtraInfo.c);
      this.E.a(paramResponseExtraInfo.d);
      return;
    }
    if (paramResponseCommentInfo2 != null) {
      paramResponseCommentInfo1 = e(2, new ArrayList(paramResponseCommentInfo2.a));
    } else {
      paramResponseCommentInfo1 = new ArrayList();
    }
    bool2 = this.k;
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo1.size()), ", hasNext : ", Boolean.valueOf(bool2) });
    a(new ReadInJoyCommentDataManager.21(this, bool1, paramResponseCommentInfo1));
  }
  
  public void a(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.q);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.r = paramCommentData.d;
      this.q = paramCommentData.e;
      c(null, paramCommentData.a);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (bool2)
    {
      if (paramResponseCommentInfo.a > 0L) {
        this.p = paramResponseCommentInfo.a;
      }
      paramResponseCommentInfo = k();
      paramResponseExtraInfo = new StringBuilder();
      paramResponseExtraInfo.append(", new size : ");
      if (paramCommentData.a != null) {
        paramInt = paramCommentData.a.size();
      } else {
        paramInt = 0;
      }
      paramResponseExtraInfo.append(paramInt);
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadNewCommentFinish, ret : ", Boolean.valueOf(bool1), paramResponseExtraInfo.toString(), ", totalCnt : ", Long.valueOf(this.p) });
      a(new ReadInJoyCommentDataManager.22(this, bool1, paramResponseCommentInfo));
      paramResponseCommentInfo = this.D;
      if (paramResponseCommentInfo != null) {
        paramResponseCommentInfo.a(false);
      }
    }
    else
    {
      if (paramCommentData.a != null) {
        paramResponseCommentInfo = e(2, new ArrayList(paramCommentData.a));
      } else {
        paramResponseCommentInfo = new ArrayList();
      }
      bool2 = this.r;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreNewComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.23(this, bool1, paramResponseCommentInfo, bool2));
    }
  }
  
  public void a(int paramInt, String paramString, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo)
  {
    boolean bool3 = TextUtils.isEmpty(this.m);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    if (paramResponseExtraInfo == null) {
      new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    paramResponseExtraInfo = null;
    paramResponseCommentInfo = null;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 0)
    {
      this.n = localResponseCommentInfo.d;
      this.m = localResponseCommentInfo.e;
      if (localResponseCommentInfo.b != null)
      {
        paramResponseCommentInfo = localResponseCommentInfo.b.iterator();
        while (paramResponseCommentInfo.hasNext())
        {
          paramResponseExtraInfo = (SubCommentData)paramResponseCommentInfo.next();
          if (paramResponseExtraInfo != null)
          {
            if (TextUtils.isEmpty(paramResponseExtraInfo.parentCommentId)) {
              paramResponseExtraInfo.parentCommentId = paramString;
            }
            this.e.put(paramResponseExtraInfo.commentId, paramResponseExtraInfo);
            this.l.add(paramResponseExtraInfo.commentId);
          }
        }
        paramResponseExtraInfo = (BaseCommentData)this.e.get(paramString);
        if (!this.I)
        {
          paramResponseCommentInfo = paramResponseExtraInfo;
          if (paramResponseExtraInfo != null) {}
        }
        else
        {
          paramResponseCommentInfo = localResponseCommentInfo.c;
          this.e.put(paramString, paramResponseCommentInfo);
        }
        paramResponseCommentInfo = a(bool3, paramResponseCommentInfo, localResponseCommentInfo.b);
      }
      bool1 = true;
    }
    else
    {
      bool1 = false;
      paramResponseCommentInfo = paramResponseExtraInfo;
    }
    if (QLog.isColorLevel())
    {
      if (localResponseCommentInfo.b != null) {
        paramInt = localResponseCommentInfo.b.size();
      } else {
        paramInt = 0;
      }
      if ((localResponseCommentInfo == null) || (!localResponseCommentInfo.d)) {
        bool2 = false;
      }
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "getSubCommentListResp ret : ", Boolean.valueOf(bool1), ", mainCommentID : ", paramString, ", size : ", Integer.valueOf(paramInt), ", hasNext : ", Boolean.valueOf(bool2), ", isFirstFetch : ", Boolean.valueOf(bool3) });
    }
    a(new ReadInJoyCommentDataManager.30(this, bool3, bool1, paramResponseCommentInfo));
  }
  
  public void a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.c;
    if (paramCommentViewItem == null) {
      return;
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).remove(paramCommentViewItem);
    }
    paramCommentViewItem = paramCommentViewItem.commentId;
    localObject = this.h;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.h.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.1(this));
    }
    localObject = this.i;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.i.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.2(this));
    }
    localObject = this.y;
    if ((localObject != null) && (((List)localObject).contains(paramCommentViewItem)))
    {
      this.y.remove(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.3(this));
    }
  }
  
  public void a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if ((this.z != null) && (paramCommentViewItem != null))
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      BaseCommentData localBaseCommentData = paramCommentViewItem.c;
      CommentData localCommentData;
      if ((localBaseCommentData instanceof CommentData))
      {
        localCommentData = (CommentData)localBaseCommentData;
        a(localCommentData, -(localCommentData.subCommentNum + 1));
        m(localBaseCommentData.commentId);
      }
      if ((localBaseCommentData instanceof SubCommentData))
      {
        localCommentData = (CommentData)this.e.get(((SubCommentData)localBaseCommentData).parentCommentId);
        if (localCommentData != null)
        {
          if (localCommentData.subCommentNum > 0) {
            localCommentData.subCommentNum -= 1;
          }
          List localList = localCommentData.subCommentList;
          if (localList != null)
          {
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
              if (localSubCommentData.commentId.equalsIgnoreCase(localBaseCommentData.commentId)) {
                localList.remove(localSubCommentData);
              }
            }
          }
        }
        a(localCommentData, -1);
        this.l.remove(localBaseCommentData.commentId);
      }
      a(new ReadInJoyCommentDataManager.14(this, localBaseCommentData.getCommentLevel(), paramCommentViewItem, paramInt), false);
      this.z.a(localBaseCommentData, this.a, this.f);
    }
  }
  
  public void a(ReadInJoyCommentDataManager.CommentAnchor paramCommentAnchor)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setCommentAnchor | commentid : ");
    ((StringBuilder)localObject).append(paramCommentAnchor);
    if (((StringBuilder)localObject).toString() != null) {
      localObject = paramCommentAnchor.b;
    } else {
      localObject = "";
    }
    QLog.d("ReadInJoyCommentDataManager", 1, (String)localObject);
    this.D = paramCommentAnchor;
  }
  
  public void a(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    try
    {
      boolean bool = this.B.contains(paramOnDataChangeListener);
      if (bool) {
        return;
      }
      this.B.add(paramOnDataChangeListener);
      return;
    }
    finally {}
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    paramBaseCommentData.commentId = paramString;
    this.e.put(paramBaseCommentData.commentId, paramBaseCommentData);
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramInt == 6)
      {
        if (this.y == null) {
          this.y = new ArrayList();
        }
        if (this.y.size() == 0)
        {
          this.y.add(paramBaseCommentData.commentId);
        }
        else
        {
          paramString = (BaseCommentData)this.e.get(this.y.get(0));
          if ((paramString != null) && (paramString.isBanner()))
          {
            if (this.y.size() < 2) {
              this.y.add(paramBaseCommentData.commentId);
            } else {
              this.y.add(1, paramBaseCommentData.commentId);
            }
          }
          else {
            this.y.add(0, paramBaseCommentData.commentId);
          }
          QLog.d("ReadInJoyCommentDataManager", 2, "onCreateCommentResult | familyCommentFeeds");
        }
      }
      else
      {
        paramInt = 2;
      }
      if (this.i.size() == 0)
      {
        this.i.add(paramBaseCommentData.commentId);
      }
      else
      {
        paramString = (BaseCommentData)this.e.get(this.i.get(0));
        if ((paramString != null) && (paramString.isBanner()))
        {
          if (this.i.size() < 2) {
            this.i.add(paramBaseCommentData.commentId);
          } else {
            this.i.add(1, paramBaseCommentData.commentId);
          }
        }
        else {
          this.i.add(0, paramBaseCommentData.commentId);
        }
      }
      if ((!this.u) && (!this.h.contains(paramBaseCommentData.commentId))) {
        this.h.add(paramBaseCommentData.commentId);
      }
      boolean bool;
      if ((paramInt != 3) && (paramInt != 6)) {
        bool = false;
      } else {
        bool = true;
      }
      a((CommentData)paramBaseCommentData, 1);
      int i1;
      if (paramInt == 6) {
        i1 = 4;
      } else {
        i1 = 2;
      }
      paramString = new StringBuilder();
      paramString.append("onCreateCommentResult | createComment feedsType ");
      paramString.append(i1);
      QLog.d("ReadInJoyCommentDataManager", 2, paramString.toString());
      a(new ReadInJoyCommentDataManager.39(this, new CommentViewItem(i1, 0, paramBaseCommentData, this.g), bool, paramInt));
      return;
    }
    if ((paramBaseCommentData instanceof SubCommentData))
    {
      this.l.add(0, paramBaseCommentData.commentId);
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "add new sub comment, now size : ", Integer.valueOf(this.l.size()) });
      Object localObject = this.e;
      paramString = (SubCommentData)paramBaseCommentData;
      localObject = (BaseCommentData)((Map)localObject).get(paramString.parentCommentId);
      paramString = (CommentData)this.e.get(paramString.parentCommentId);
      if (paramString != null)
      {
        paramString.subCommentNum += 1;
        a(paramString, 1);
        a(new ReadInJoyCommentDataManager.40(this, paramBaseCommentData));
      }
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.b = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSinkCommentResult: id[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] opType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] success[");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("] overtimes[");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("]");
    QLog.d("ReadInJoyCommentDataManager", 1, ((StringBuilder)localObject).toString());
    boolean bool;
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramBoolean1)
    {
      localObject = (BaseCommentData)this.e.get(paramString);
      if (localObject == null) {
        return;
      }
      ((BaseCommentData)localObject).isAuthorSticky = false;
      ((BaseCommentData)localObject).isAuthorBottom = bool;
      if (bool)
      {
        if (this.u)
        {
          this.e.remove(paramString);
        }
        else
        {
          this.h.remove(paramString);
          this.h.add(paramString);
        }
        paramInt = 2131915787;
      }
      else
      {
        this.h.remove(paramString);
        localObject = C();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        int i1 = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10)
        {
          this.h.add(9, paramString);
        }
        else if (paramInt >= 2)
        {
          localObject = this.h;
          ((List)localObject).add(((List)localObject).size() - i1 - 1, paramString);
        }
        else if (i1 > 0)
        {
          localObject = this.h;
          ((List)localObject).add(((List)localObject).size() - i1, paramString);
        }
        else
        {
          this.h.add(paramString);
        }
        paramInt = 2131915798;
      }
      a(new ReadInJoyCommentDataManager.41(this, j()));
      QQToast.makeText(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).show();
      return;
    }
    if (bool)
    {
      if (paramBoolean2) {
        paramInt = 2131915786;
      } else {
        paramInt = 2131915785;
      }
    }
    else {
      paramInt = 2131915797;
    }
    QQToast.makeText(BaseApplicationImpl.context, HardCodeUtil.a(paramInt), 0).show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    g();
    a(1, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.H = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTitleShowData | showFamilyTitle : ");
    localStringBuilder.append(this.H);
    QLog.d("ReadInJoyCommentDataManager", 2, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, @NonNull CommentReportInfo paramCommentReportInfo)
  {
    d(paramBoolean);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onCommentReportResult(): success : ", Boolean.valueOf(paramBoolean), ", retCode : ", Integer.valueOf(paramInt), ", retMsg : ", paramString, "reportInfo :", paramCommentReportInfo });
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramCommentReportInfo.c())) {
        paramInt = b(paramCommentReportInfo);
      } else {
        paramInt = a(paramCommentReportInfo);
      }
    }
    else {
      paramInt = 0;
    }
    a(new ReadInJoyCommentDataManager.18(this, paramInt, paramBoolean, paramCommentReportInfo), false);
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, int paramInt, String paramString, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAuthorDeleteCommentResult | bSuccess ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" errMsg ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramCommentViewItem == null) {
      return;
    }
    paramString = paramCommentViewItem.c;
    if (paramString == null) {
      return;
    }
    if (paramBoolean1)
    {
      QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131910463), 0).show();
      b(paramString);
      c(paramString);
      a(new ReadInJoyCommentDataManager.31(this, paramString.getCommentLevel(), paramCommentViewItem, paramInt), false);
      return;
    }
    paramCommentViewItem = BaseApplicationImpl.context;
    if (paramBoolean2) {
      paramInt = 2131915780;
    } else {
      paramInt = 2131915779;
    }
    QQToast.makeText(paramCommentViewItem, paramBoolean2 ^ true, HardCodeUtil.a(paramInt), 0).show();
  }
  
  public void a(boolean paramBoolean1, CommentViewItem paramCommentViewItem, String paramString, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBlockUserCommentResult | bSuccess ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" errMsg ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramCommentViewItem == null) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.c;
    if (paramCommentViewItem == null) {
      return;
    }
    a(paramBoolean1, paramBoolean2, paramString);
    if (paramBoolean1)
    {
      paramString = a(paramCommentViewItem);
      a(new ReadInJoyCommentDataManager.43(this, paramCommentViewItem.getCommentLevel(), paramString), false);
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLikeOrDislikeCommentResult ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", opType ; ", Integer.valueOf(paramInt1), ", opValue : ", Integer.valueOf(paramInt2) });
    a(new ReadInJoyCommentDataManager.32(this, paramBoolean, paramBaseCommentData, paramInt1, paramInt2));
    Object localObject = QBaseActivity.sTopActivity;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
      if (localObject != null) {
        ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean, this.a, paramBaseCommentData.commentId, String.valueOf(paramInt2), "onCommentLike", ((Bundle)localObject).getInt("seq"));
      }
    }
  }
  
  public void a(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    if (paramBaseCommentData == null) {
      return;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "del comment resp, ret : ", Boolean.valueOf(paramBoolean), ", data : ", paramBaseCommentData });
    if (paramBoolean)
    {
      QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.a(2131910463), 0).show();
      paramString = QBaseActivity.sTopActivity.getIntent().getBundleExtra("bundle");
      int i1;
      if ((paramBaseCommentData instanceof CommentData)) {
        i1 = 1 + ((CommentData)paramBaseCommentData).subCommentNum;
      } else {
        i1 = 1;
      }
      if (paramString != null) {
        ReadInJoyLogicEngineEventDispatcher.a().a(true, this.a, paramBaseCommentData.commentId, "onCommentDelete", paramString.getInt("seq"), i1);
      }
    }
    else
    {
      QQToast.makeText(BaseApplication.getContext(), 1, paramString, 0).show();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, HardCodeUtil.a(2131915809), 0).show();
      return;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    if (TextUtils.isEmpty(paramString)) {
      paramString = HardCodeUtil.a(2131915808);
    }
    QQToast.makeText(localBaseApplication, 1, paramString, 0).show();
  }
  
  public void a_(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.e.get(paramString);
    if (paramString != null) {
      paramString.disLike = paramInt;
    }
    this.z.a(paramString, 1, paramInt, this.a, this.f);
  }
  
  @VisibleForTesting
  int b(@NonNull CommentReportInfo paramCommentReportInfo)
  {
    CommentData localCommentData = (CommentData)this.e.get(paramCommentReportInfo.b());
    if (localCommentData != null)
    {
      if (localCommentData.subCommentNum > 0) {
        localCommentData.subCommentNum -= 1;
      }
      List localList = localCommentData.subCommentList;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          SubCommentData localSubCommentData = (SubCommentData)localIterator.next();
          if (localSubCommentData.commentId.equalsIgnoreCase(paramCommentReportInfo.c())) {
            localList.remove(localSubCommentData);
          }
        }
      }
    }
    a(localCommentData, -1);
    this.l.remove(paramCommentReportInfo.c());
    return 2;
  }
  
  public long b(int paramInt)
  {
    long l1 = this.p;
    if (paramInt == 6) {
      l1 = this.v;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFirstCommentTotalCount | feedsType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("; totalCount ");
    localStringBuilder.append(l1);
    QLog.d("ReadInJoyCommentDataManager", 2, localStringBuilder.toString());
    return l1;
  }
  
  public ReadInJoyCommentPBModule.Label b()
  {
    return this.J;
  }
  
  public void b(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    boolean bool2 = TextUtils.isEmpty(this.t);
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool1;
    if (paramInt == 0)
    {
      this.u = paramCommentData.d;
      this.t = paramCommentData.e;
      a(this.G, paramResponseCommentInfo.e);
      c(paramCommentData.a, null);
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (bool2)
    {
      if ((bool1) && ((paramCommentData.a == null) || (paramCommentData.a.isEmpty())))
      {
        if (TextUtils.isEmpty(this.q))
        {
          QLog.d("ReadInJoyCommentDataManager", 1, "switchCommentFeedsType | hot is empty or first change to new : ");
          g(1);
          return;
        }
        a(new ReadInJoyCommentDataManager.24(this, d(3)));
        return;
      }
      paramResponseCommentInfo = this.D;
      if ((paramResponseCommentInfo != null) && (paramResponseCommentInfo.d))
      {
        if (!d(paramCommentData.a)) {
          a(new ReadInJoyCommentDataManager.25(this));
        }
        this.D.d = false;
      }
      paramResponseCommentInfo = j();
      if (paramCommentData.a != null) {
        paramInt = paramCommentData.a.size();
      } else {
        paramInt = 0;
      }
      paramResponseExtraInfo = new StringBuilder();
      paramResponseExtraInfo.append(", hot size : ");
      int i1;
      if (paramCommentData.a != null) {
        i1 = paramCommentData.a.size();
      } else {
        i1 = 0;
      }
      paramResponseExtraInfo.append(i1);
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadHotCommentFinish, ret : ", Boolean.valueOf(bool1), ", hot size : ", Integer.valueOf(paramInt), paramResponseExtraInfo.toString(), ", totalCnt : ", Long.valueOf(this.s) });
      a(new ReadInJoyCommentDataManager.26(this, bool1, paramResponseCommentInfo));
      paramResponseCommentInfo = this.D;
      if (paramResponseCommentInfo != null) {
        paramResponseCommentInfo.a(false);
      }
    }
    else
    {
      if (paramCommentData.a != null) {
        paramResponseCommentInfo = e(1, new ArrayList(paramCommentData.a));
      } else {
        paramResponseCommentInfo = new ArrayList();
      }
      bool2 = this.u;
      QLog.d("ReadInJoyCommentDataManager", 2, new Object[] { "onLoadMoreHotComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(bool2) });
      a(new ReadInJoyCommentDataManager.27(this, bool1, paramResponseCommentInfo, bool2));
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("blockUserComment | ");
      localStringBuilder.append(paramCommentViewItem.c);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.a(paramCommentViewItem, this);
    }
  }
  
  public void b(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("authorDeleteComment | ");
      localStringBuilder.append(paramCommentViewItem.c);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.a(this.f, paramCommentViewItem, paramInt, this);
    }
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateCommentStickyResult: id[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] success[");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("] overtimes[");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("ReadInJoyCommentDataManager", 1, (String)localObject);
    int i1;
    if (paramInt == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (paramBoolean1)
    {
      localObject = (BaseCommentData)this.e.get(paramString);
      if (localObject == null) {
        return;
      }
      if (paramInt == 1) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }
      ((BaseCommentData)localObject).isAuthorSticky = paramBoolean1;
      ((BaseCommentData)localObject).isAuthorBottom = false;
      if (i1 != 0)
      {
        this.h.remove(paramString);
        this.h.add(D(), paramString);
        paramInt = 2131915792;
      }
      else
      {
        this.h.remove(paramString);
        localObject = C();
        paramInt = ((Integer)((Pair)localObject).first).intValue();
        i1 = ((Integer)((Pair)localObject).second).intValue();
        if (paramInt >= 10)
        {
          this.h.add(9, paramString);
        }
        else if (i1 > 0)
        {
          localObject = this.h;
          ((List)localObject).add(((List)localObject).size() - i1, paramString);
        }
        else
        {
          this.h.add(paramString);
        }
        paramInt = 2131915796;
      }
      a(new ReadInJoyCommentDataManager.42(this, j()));
      QQToast.makeText(BaseApplicationImpl.context, 2, HardCodeUtil.a(paramInt), 0).show();
      return;
    }
    if (i1 != 0)
    {
      if (paramBoolean2) {
        paramInt = 2131915791;
      } else {
        paramInt = 2131915790;
      }
    }
    else {
      paramInt = 2131915795;
    }
    QQToast.makeText(BaseApplicationImpl.context, paramInt, 0).show();
  }
  
  public void b(String paramString1, String paramString2, int paramInt)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.e.get(paramString1);
    CommentReportInfo localCommentReportInfo = new CommentReportInfo();
    localCommentReportInfo.a(paramInt);
    localCommentReportInfo.d(paramString2);
    if ((localBaseCommentData instanceof CommentData))
    {
      localCommentReportInfo.a(localBaseCommentData.rowKey);
      localCommentReportInfo.b(localBaseCommentData.commentId);
      localCommentReportInfo.c("");
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      localCommentReportInfo.a(localBaseCommentData.rowKey);
      localCommentReportInfo.b(((SubCommentData)localBaseCommentData).parentCommentId);
      localCommentReportInfo.c(localBaseCommentData.commentId);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this);
    ReadInJoyLogicEngine.a().a(localCommentReportInfo);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "commentID : ", paramString1, ", reportReason : ", "reportInfo :", localCommentReportInfo });
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((BaseCommentData)this.e.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentSinkData(paramString, this.g.innerUniqueID, this.f, "");
    int i1;
    if (paramBoolean) {
      i1 = 3;
    } else {
      i1 = 2;
    }
    paramString.a(i1);
    RIJCommentNetworkHelper.a.a(paramString, this);
  }
  
  public void b(boolean paramBoolean, BaseCommentData paramBaseCommentData, String paramString)
  {
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onReportCommentResp ret : ", Boolean.valueOf(paramBoolean), ", commentData : ", paramBaseCommentData, ", extraData : ", paramString });
  }
  
  public boolean b(ReadInJoyCommentDataManager.OnDataChangeListener paramOnDataChangeListener)
  {
    try
    {
      boolean bool = this.B.remove(paramOnDataChangeListener);
      return bool;
    }
    finally
    {
      paramOnDataChangeListener = finally;
      throw paramOnDataChangeListener;
    }
  }
  
  public void b_(String paramString, int paramInt)
  {
    paramString = (BaseCommentData)this.e.get(paramString);
    if (paramString != null)
    {
      paramString.like = paramInt;
      int i2 = paramString.likeCnt;
      int i1;
      if (paramString.isLiked()) {
        i1 = 1;
      } else {
        i1 = -1;
      }
      paramString.likeCnt = (i2 + i1);
      if (paramString.likeCnt < 0) {
        paramString.likeCnt = 0;
      }
    }
    this.z.a(paramString, 0, paramInt, this.a, this.f);
  }
  
  public void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreComment | with feedsType : ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if ((paramInt != 3) && (paramInt != 5))
      {
        if (paramInt != 6) {
          return;
        }
        i(2);
        return;
      }
      h(2);
      return;
    }
    g(2);
  }
  
  public void c(int paramInt, ReadInJoyCommentPBModule.ResponseCommentInfo paramResponseCommentInfo, ReadInJoyCommentPBModule.ResponseExtraInfo paramResponseExtraInfo, CommentData paramCommentData)
  {
    paramCommentData = paramResponseCommentInfo;
    if (paramResponseCommentInfo == null) {
      paramCommentData = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    }
    paramResponseCommentInfo = paramResponseExtraInfo;
    if (paramResponseExtraInfo == null) {
      paramResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    }
    boolean bool2 = TextUtils.isEmpty(this.w);
    int i1 = 0;
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      this.w = paramCommentData.e;
      this.x = paramCommentData.d;
      d(paramCommentData.a, this.y);
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult succeed ");
    }
    else
    {
      QLog.d("ReadInJoyCommentDataManager", 2, "onFetchFamilyCommentListResult failed ");
    }
    if (bool2)
    {
      long l1;
      if (paramResponseCommentInfo != null) {
        l1 = paramResponseCommentInfo.a;
      } else {
        l1 = 0L;
      }
      this.v = l1;
      paramResponseCommentInfo = new StringBuilder();
      paramInt = i1;
      if (paramCommentData.a()) {
        paramInt = paramCommentData.a.size();
      }
      paramResponseCommentInfo.append(paramInt);
      paramResponseCommentInfo.append(", mFamilyCommentCnt : ");
      QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadFirstFaimilyCommentFinish, ret : ", Boolean.valueOf(bool1), ",  size : ", paramResponseCommentInfo.toString(), Long.valueOf(this.v) });
      a(new ReadInJoyCommentDataManager.28(this, bool1, l()));
      return;
    }
    if (paramCommentData != null) {
      paramResponseCommentInfo = e(4, new ArrayList(paramCommentData.a));
    } else {
      paramResponseCommentInfo = new ArrayList();
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "onLoadMoreFamilyComment, ret : ", Boolean.valueOf(bool1), ", size : ", Integer.valueOf(paramResponseCommentInfo.size()), ", hasNext : ", Boolean.valueOf(this.x) });
    a(new ReadInJoyCommentDataManager.29(this, bool1, paramResponseCommentInfo));
  }
  
  public void c(@NotNull CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem != null)
    {
      if (paramCommentViewItem.c == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("patrolArbitration | ");
      localStringBuilder.append(paramCommentViewItem.c);
      QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
      RIJCommentNetworkHelper.a.b(paramCommentViewItem, this);
    }
  }
  
  public void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.g = paramAbsBaseArticleInfo;
    this.E.a(paramAbsBaseArticleInfo);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((BaseCommentData)this.e.get(paramString) == null) {
      return;
    }
    paramString = new FirstCommentStickyData(this.g.innerUniqueID, this.f, "", paramString);
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    paramString.a(i1);
    RIJCommentNetworkHelper.a.a(paramString, this);
  }
  
  public boolean c()
  {
    return this.K;
  }
  
  public void cC_()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this);
  }
  
  public void c_(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SubCommentData localSubCommentData = (SubCommentData)a(2, paramString);
    if (localSubCommentData == null) {
      return;
    }
    SubCommentCreateData localSubCommentCreateData = new SubCommentCreateData(this.f, "");
    localSubCommentCreateData.a(localSubCommentData.parentCommentId);
    localSubCommentCreateData.b(this.G);
    localSubCommentCreateData.c(this.F);
    localSubCommentCreateData.d(localSubCommentData.commentContent);
    localSubCommentCreateData.a(localSubCommentData.commentRptDataList);
    localSubCommentCreateData.b(localSubCommentData.commentLinkDataList);
    if (localSubCommentData.hasTarget()) {
      localSubCommentCreateData.e(localSubCommentData.repliedCommentId);
    }
    try
    {
      localSubCommentCreateData.a(Long.parseLong(localSubCommentData.repliedUserUin));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label132:
      long l1;
      break label132;
    }
    QLog.e("ReadInJoyCommentDataManager", 1, "replyComment: Invalid repliedSubAuthorId.");
    l1 = RIJCommentNetworkWrapper.INSTANCE.createSubComment(localSubCommentCreateData, new ReadInJoyCommentDataManager.15(this, paramString, localSubCommentData), paramString, paramInt, false);
    paramString = new StringBuilder();
    paramString.append("create reply comment, seq : ");
    paramString.append(l1);
    paramString.append(", data : ");
    paramString.append(localSubCommentData);
    QLog.d("ReadInJoyCommentDataManager", 1, paramString.toString());
  }
  
  public long d(String paramString)
  {
    paramString = (BaseCommentData)this.e.get(paramString);
    if ((paramString != null) && ((paramString instanceof CommentData))) {
      return ((CommentData)paramString).subCommentNum;
    }
    return 0L;
  }
  
  public String d()
  {
    return this.L;
  }
  
  public List<CommentViewItem> d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCurrentFeedsTypeItemList | feedsType ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyCommentDataManager", 1, localStringBuilder.toString());
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 6) {
          return new ArrayList();
        }
        return l();
      }
      return j();
    }
    return k();
  }
  
  public void d(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseCommentData localBaseCommentData = a(1, paramString);
    if (localBaseCommentData == null) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.f, "");
    localFirstCommentCreateData.b(this.G);
    localFirstCommentCreateData.c(this.F);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    long l1 = RIJCommentNetworkWrapper.INSTANCE.createFirstComment(localFirstCommentCreateData, new ReadInJoyCommentDataManager.16(this, paramString, localBaseCommentData), paramString, paramInt, false);
    paramString = new StringBuilder();
    paramString.append("create main comment, seq : ");
    paramString.append(l1);
    paramString.append(", data : ");
    paramString.append(localBaseCommentData);
    QLog.d("ReadInJoyCommentDataManager", 1, paramString.toString());
  }
  
  public List<CommentViewItem> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (BaseCommentData)this.e.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.g));
    localArrayList.add(new CommentViewItem(3, paramString, this.g));
    return localArrayList;
  }
  
  public void e()
  {
    this.M = true;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(", pbModuel=");
    ((StringBuilder)localObject).append(this.A);
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "CommentDataManager destroy, articleInfo=", ((StringBuilder)localObject).toString() });
    localObject = this.e;
    if (localObject != null) {
      ((Map)localObject).clear();
    }
    v();
    w();
    x();
    this.a = "";
    this.k = false;
    this.j = "";
    localObject = this.C;
    if (localObject != null) {
      ((LongSparseArray)localObject).c();
    }
    localObject = this.B;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.A;
    if (localObject != null) {
      ((ReadInJoyCommentPBModule)localObject).unInitialize();
    }
    localObject = this.z;
    if (localObject != null) {
      ((ReadInJoyCommentSSOModule)localObject).a();
    }
    cC_();
  }
  
  public void f(String paramString)
  {
    a(2, paramString, null);
  }
  
  public BaseCommentData g(String paramString)
  {
    return (BaseCommentData)this.e.get(paramString);
  }
  
  public void g()
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.e.remove(str);
      }
      this.l.clear();
    }
    this.m = "";
    this.n = true;
  }
  
  public int h(String paramString)
  {
    BaseCommentData localBaseCommentData = (BaseCommentData)this.e.get(paramString);
    if (localBaseCommentData == null) {
      return 0;
    }
    if ((localBaseCommentData instanceof CommentData))
    {
      if (this.h.contains(paramString)) {
        return 1;
      }
      if (this.i.contains(paramString)) {
        return 2;
      }
    }
    else if ((localBaseCommentData instanceof SubCommentData))
    {
      return h(((SubCommentData)localBaseCommentData).parentCommentId);
    }
    return 0;
  }
  
  public long h()
  {
    return this.p;
  }
  
  public ReadInJoyCommentDataManager.CommentAnchor i()
  {
    return this.D;
  }
  
  public List<CommentViewItem> i(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = (CommentData)this.e.get(paramString);
    if (paramString == null) {
      return localArrayList;
    }
    localArrayList.add(new CommentViewItem(0, paramString, this.g));
    localArrayList.add(new CommentViewItem(3, paramString, this.g));
    localArrayList.addAll(f(0, this.l));
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { "get all sub comment list , parentID : ", paramString, ", sub list size : ", Integer.valueOf(this.l.size()) });
    return localArrayList;
  }
  
  public void i_(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public List<CommentViewItem> j()
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (this.h.size() > 0)
    {
      localObject = new ArrayList();
      i1 = 0;
      while (i1 < this.h.size())
      {
        CommentData localCommentData = (CommentData)this.e.get(this.h.get(i1));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a())))) {
          ((ArrayList)localObject).add(localCommentData);
        }
        i1 += 1;
      }
      if ((((ArrayList)localObject).size() > 0) && (this.H)) {
        localArrayList.add(new CommentViewItem(1, null, this.g));
      }
      localArrayList.addAll(e(1, new ArrayList((Collection)localObject)));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTotalHotCommentList ");
    ((StringBuilder)localObject).append(localArrayList);
    if (((StringBuilder)localObject).toString() != null) {
      i1 = localArrayList.size();
    } else {
      i1 = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i1) });
    return localArrayList;
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseCommentData localBaseCommentData = a(1, paramString);
    if (localBaseCommentData == null) {
      return;
    }
    FirstCommentCreateData localFirstCommentCreateData = new FirstCommentCreateData(this.f, "");
    localFirstCommentCreateData.b(this.G);
    localFirstCommentCreateData.c(this.F);
    localFirstCommentCreateData.a(localBaseCommentData.commentContent);
    localFirstCommentCreateData.a(localBaseCommentData.commentRptDataList);
    localFirstCommentCreateData.b(localBaseCommentData.commentLinkDataList);
    RIJCommentNetworkWrapper.INSTANCE.createFirstComment(localFirstCommentCreateData, new ReadInJoyCommentDataManager.17(this), paramString, 2, true);
  }
  
  public String k(String paramString)
  {
    paramString = (BaseCommentData)this.e.get(paramString);
    if ((paramString instanceof SubCommentData)) {
      return ((SubCommentData)paramString).parentCommentId;
    }
    if ((paramString instanceof CommentData)) {
      return paramString.commentId;
    }
    return "";
  }
  
  public List<CommentViewItem> k()
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (this.i.size() > 0)
    {
      localObject = new ArrayList();
      i1 = 0;
      while (i1 < this.i.size())
      {
        CommentData localCommentData = (CommentData)this.e.get(this.i.get(i1));
        if ((localCommentData != null) && ((!localCommentData.isFamilyTopEntry()) || ((localCommentData.isFamilyTopEntry()) && (!ReadInJoyCommentHelper.a())))) {
          ((ArrayList)localObject).add(localCommentData);
        }
        i1 += 1;
      }
      if ((((ArrayList)localObject).size() > 0) && (this.H)) {
        localArrayList.add(new CommentViewItem(2, null, this.g));
      }
      localArrayList.addAll(e(2, new ArrayList((Collection)localObject)));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTotalNewCommentList ");
    ((StringBuilder)localObject).append(localArrayList);
    if (((StringBuilder)localObject).toString() != null) {
      i1 = localArrayList.size();
    } else {
      i1 = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i1) });
    return localArrayList;
  }
  
  public List<CommentViewItem> l()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.y;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = new ArrayList();
      Iterator localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (CommentData)this.e.get(localObject2);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      if ((((ArrayList)localObject1).size() > 0) && (this.H))
      {
        QLog.d("ReadInJoyCommentDataManager", 1, "getTotalFamilyCommentList | showTitle dont showSwitch");
        localArrayList.add(new CommentViewItem(2, null, this.g));
      }
      localArrayList.addAll(e(4, new ArrayList((Collection)localObject1)));
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getTotalFamilyCommentList ");
    ((StringBuilder)localObject1).append(localArrayList);
    int i1;
    if (((StringBuilder)localObject1).toString() != null) {
      i1 = localArrayList.size();
    } else {
      i1 = 0;
    }
    QLog.d("ReadInJoyCommentDataManager", 1, new Object[] { Integer.valueOf(i1) });
    return localArrayList;
  }
  
  public void l_(int paramInt)
  {
    a(new ReadInJoyCommentDataManager.38(this, paramInt));
  }
  
  public void m()
  {
    try
    {
      this.B.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public GuideHelper n()
  {
    return this.E;
  }
  
  public CommonCommentData o()
  {
    return this.b;
  }
  
  public int p()
  {
    List localList = this.i;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int q()
  {
    List localList = this.h;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager
 * JD-Core Version:    0.7.0.1
 */