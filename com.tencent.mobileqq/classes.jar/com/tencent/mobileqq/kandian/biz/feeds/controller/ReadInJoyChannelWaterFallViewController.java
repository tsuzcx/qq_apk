package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.entity.SerializableMap;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView;
import com.tencent.mobileqq.kandian.biz.tab.ReadInjoyXRecyclerView.RefreshCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.Constants.LogoutReason;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class ReadInJoyChannelWaterFallViewController
  extends ReadInJoyBaseViewController
  implements ReadInjoyXRecyclerView.RefreshCallback
{
  ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface a;
  boolean i = false;
  protected boolean j = false;
  protected ReadInJoyPageItemCache k;
  protected boolean l = false;
  private int m;
  private boolean n = false;
  private long o;
  private int p = 1;
  private int q = -1;
  private ReadInJoyObserver r = new ReadInJoyChannelWaterFallViewController.InnerReadInJoyObserver(this, null);
  private ArrayList<ChannelCoverInfo> s = new ArrayList();
  private boolean t = false;
  
  public ReadInJoyChannelWaterFallViewController(int paramInt1, int paramInt2, Activity paramActivity, ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface paramReadInjoyViewInterface)
  {
    super(paramActivity);
    this.q = paramInt2;
    this.m = paramInt1;
    this.a = ((ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface)paramReadInjoyViewInterface);
    this.k = new ReadInJoyPageItemCache();
    this.k.b = ReadInJoyHelper.a(paramInt1, (QQAppInterface)RIJQQAppInterfaceUtil.e());
  }
  
  private void a(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      if (localAbsBaseArticleInfo.mGalleryFeedsInfo == null) {
        paramList.remove();
      } else if ((localAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 4) && (localAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 5)) {
        paramList.remove();
      } else if ((localAbsBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() == 4) && (localAbsBaseArticleInfo.mJsonPictureList == null)) {
        paramList.remove();
      }
    }
  }
  
  private void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    a(paramList);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.c());
    paramList = ReadinjoyFixPosArticleManager.getInstant().insertFixPosArticles(this.m, paramList, localArrayList, paramInt);
    this.a.a(paramList);
    this.a.a();
  }
  
  private void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.k.b = System.currentTimeMillis();
    ReadInJoyHelper.a(this.m, this.k.b, (QQAppInterface)RIJQQAppInterfaceUtil.e());
    Object localObject = (KandianMergeManager)((BaseActivity)cQ_()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l1 = w();
    localObject = (AbsBaseArticleInfo)this.a.a(0);
    int i1;
    if ((l1 != -1L) && (localObject != null) && (l1 != ((AbsBaseArticleInfo)localObject).mArticleID))
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(l1));
      i1 = 6;
    }
    else
    {
      localObject = null;
      i1 = -1;
    }
    this.a.a(paramBoolean1);
    ArrayList localArrayList = new ArrayList();
    ReadInJoyLogicEngine.a().a(this.m, (List)localObject, i1, true, false, this.p, null, -1L, null, y(), 0L, 0L, null, paramInt1, false, null, 0, localArrayList);
    this.p += 1;
    ReadinjoyReportUtils.a(paramInt1, this.m, cQ_(), paramBoolean2, paramInt2);
  }
  
  private boolean b(boolean paramBoolean)
  {
    paramBoolean = r();
    Object localObject1 = Boolean.valueOf(false);
    if (!paramBoolean) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    boolean bool2 = this.a.b();
    boolean bool3 = ReadInJoyChannelViewPagerController.e(this.m);
    Object localObject2 = (KandianMergeManager)((BaseActivity)cQ_()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1;
    if (System.currentTimeMillis() - this.k.g > 300000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = u();
    if ((!bool2) && (!bool1) && (!bool4)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ReadInJoyChannelWaterFallViewController_");
    ((StringBuilder)localObject2).append(this.m);
    QLog.d(((StringBuilder)localObject2).toString(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), localObject1, localObject1, localObject1 }));
    if (n())
    {
      bool1 = RIJChannelStayTimeMonitor.INSTANCE.isLastExitChannelOverTimeLimit(this.m);
      if ((!bool2) && (!bool1) && (!bool4) && (!bool3)) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      QLog.d("ReadInJoyChannelWaterFallViewController", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), localObject1, localObject1, localObject1, Boolean.valueOf(bool3) }));
      bool1 = paramBoolean;
    }
    else
    {
      i1 = this.m;
      bool1 = paramBoolean;
      if (i1 != 70)
      {
        bool1 = paramBoolean;
        if (i1 != 56)
        {
          bool1 = paramBoolean;
          if (i1 != 40677)
          {
            bool1 = paramBoolean;
            if (!DailyModeConfigHandler.c(i1)) {
              bool1 = true;
            }
          }
        }
      }
    }
    if (bool1)
    {
      a(true, 2);
      return true;
    }
    localObject1 = this.k;
    if (((ReadInJoyPageItemCache)localObject1).b != 0L) {
      l1 = this.k.b;
    }
    ((ReadInJoyPageItemCache)localObject1).b = l1;
    int i1 = this.m;
    return false;
  }
  
  private boolean r()
  {
    return this.l;
  }
  
  private boolean u()
  {
    return false;
  }
  
  private void v() {}
  
  private long w()
  {
    if ((x()) && (cQ_().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)cQ_().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((SerializableMap)localObject).getMap() != null))
      {
        localObject = ((SerializableMap)localObject).getMap();
        long l1 = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l1;
        }
      }
    }
    return -1L;
  }
  
  private boolean x()
  {
    return this.m != 0;
  }
  
  private int y()
  {
    int i1 = this.q;
    if (i1 != -1) {
      return i1;
    }
    return cQ_().getIntent().getIntExtra("channel_type", 0);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, int paramInt)
  {
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.n = bool;
    int i1;
    if (this.m == 40830)
    {
      i1 = this.p;
      this.p = (i1 + 1);
    }
    else
    {
      i1 = 1;
    }
    ReadInJoyLogicEngine.a().a(this.m, y(), paramInt, 0, i1);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.2(this));
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, boolean paramBoolean)
  {
    if (DailyModeConfigHandler.c(this.m)) {
      KandianDailyReportUtils.a(1);
    }
    int i1;
    if ((RIJQQAppInterfaceUtil.g()) && (!x()) && (!paramBoolean)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      i1 = 3;
    } else {
      i1 = 1001;
    }
    if (!paramBoolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      RIJTabFrameBase localRIJTabFrameBase = (RIJTabFrameBase)RIJJumpUtils.a(cQ_());
      if (localRIJTabFrameBase != null) {
        localRIJTabFrameBase.b(1);
      }
      RIJThreadHandler.a(3);
    }
    else
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      i1 = 1;
    }
    a(true, i1, paramBoolean, -paramReadInjoyXRecyclerView.getScrollY());
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.a.c();
    this.a.a(paramAbsBaseArticleInfo, paramInt);
    QQToast.makeText(this.b, -1, this.b.getString(2131897938), 0).show(((BaseActivity)this.b).getTitleBarHeight());
    if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(paramAbsBaseArticleInfo.mRecommendSeq))
    {
      ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.m, paramAbsBaseArticleInfo.mRecommendSeq);
      return;
    }
    String str = RIJQQAppInterfaceUtil.d();
    DislikeInfo localDislikeInfo = new DislikeInfo();
    localDislikeInfo.c = HardCodeUtil.a(2131910243);
    localDislikeInfo.d = 9;
    localDislikeInfo.f = "";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localDislikeInfo);
    ReadInJoyLogicEngine.a().a(Long.valueOf(str).longValue(), BaseArticleInfoKt.a(paramAbsBaseArticleInfo, localArrayList));
    ReadInJoyLogicEngine.a().a(this.m, paramAbsBaseArticleInfo);
    if (paramInt == 0)
    {
      paramAbsBaseArticleInfo = (KandianMergeManager)((QQAppInterface)RIJQQAppInterfaceUtil.e()).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (this.a.c().size() > 0) {
        return;
      }
      ReadInJoyLogicEngine.a().a(this.m, 20, 9223372036854775807L, true);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.j) {
      return;
    }
    this.a.e();
    if (paramBoolean) {
      this.a.d();
    }
  }
  
  public void b()
  {
    if (this.i) {
      return;
    }
    this.i = true;
    super.b();
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.a;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(c(Integer.valueOf(this.m)), d(Integer.valueOf(this.m)));
    }
    this.k.c = System.currentTimeMillis();
    this.k.g = ReadInJoyHelper.b((QQAppInterface)RIJQQAppInterfaceUtil.e(), this.m);
    m();
  }
  
  public boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.d.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public Set<Long> c(Integer paramInteger)
  {
    Set localSet = (Set)this.c.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.c.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void c()
  {
    if (!this.i) {
      return;
    }
    this.i = false;
    super.c();
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.a;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(d(Integer.valueOf(this.m)), b(Integer.valueOf(this.m)));
    }
  }
  
  public void cR_()
  {
    if (this.a != null)
    {
      Map localMap1 = a(Integer.valueOf(this.m));
      Map localMap2 = ReadinjoyReportUtils.a(this.m);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.1(this, localMap1, b(Integer.valueOf(this.m)), localMap2, RIJKanDianFolderStatus.getFolderStatus(this.m)));
      d(Integer.valueOf(this.m)).clear();
      this.c.clear();
    }
  }
  
  public void cT_()
  {
    super.cT_();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.r);
    this.d.put(Integer.valueOf(this.m), Boolean.valueOf(true));
    b();
  }
  
  public Map<Long, BaseReportData> d(Integer paramInteger)
  {
    Map localMap = (Map)this.e.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.e.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.r);
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.a;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(d(Integer.valueOf(this.m)), b(Integer.valueOf(this.m)));
    }
    super.e();
    this.c.clear();
    this.e.clear();
    this.d.clear();
    this.f.clear();
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    super.i();
    this.l = true;
    m();
  }
  
  public void k()
  {
    this.s = ((ArrayList)ReadInJoyLogicEngine.a().c(this.m));
    ArrayList localArrayList = this.s;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      ReadInJoyLogicEngine.a().e(this.m);
    }
    localArrayList = this.s;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.a.c(this.s);
    }
    ReadInJoyLogicEngine.a().a(this.m);
  }
  
  public void m()
  {
    if (!this.j)
    {
      ReadInJoyLogicEngine.a().a(this.m, 20, 9223372036854775807L, true);
      this.j = true;
      return;
    }
    QLog.d("ReadInJoyChannelWaterFallViewController", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.m) });
  }
  
  public boolean n()
  {
    return cQ_() instanceof SplashActivity;
  }
  
  public void p() {}
  
  public void q() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController
 * JD-Core Version:    0.7.0.1
 */