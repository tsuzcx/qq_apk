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
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
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
import com.tencent.mobileqq.qroute.QRoute;
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
  private long jdField_a_of_type_Long;
  protected ReadInJoyPageItemCache a;
  ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyChannelWaterFallViewController.InnerReadInJoyObserver(this, null);
  private ArrayList<ChannelCoverInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private int b;
  protected boolean b;
  private int c;
  protected boolean c;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  public ReadInJoyChannelWaterFallViewController(int paramInt1, int paramInt2, Activity paramActivity, ReadInJoyFragmentWithSubChannel.ReadInjoyViewInterface paramReadInjoyViewInterface)
  {
    super(paramActivity);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface = ((ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface)paramReadInjoyViewInterface);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache = new ReadInJoyPageItemCache();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long = ReadInJoyHelper.a(paramInt1, (QQAppInterface)RIJQQAppInterfaceUtil.a());
  }
  
  private int a()
  {
    int i = this.jdField_d_of_type_Int;
    if (i != -1) {
      return i;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private long a()
  {
    if ((d()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((SerializableMap)localObject).getMap() != null))
      {
        localObject = ((SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
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
    localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a());
    paramList = ReadinjoyFixPosArticleManager.getInstant().insertFixPosArticles(this.jdField_b_of_type_Int, paramList, localArrayList, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a();
  }
  
  private void a(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long = System.currentTimeMillis();
    ReadInJoyHelper.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long, (QQAppInterface)RIJQQAppInterfaceUtil.a());
    Object localObject = (KandianMergeManager)((BaseActivity)a()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    long l = a();
    localObject = (AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a(0);
    int i;
    if ((l != -1L) && (localObject != null) && (l != ((AbsBaseArticleInfo)localObject).mArticleID))
    {
      localObject = new ArrayList();
      ((List)localObject).add(Long.valueOf(l));
      i = 6;
    }
    else
    {
      localObject = null;
      i = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a(paramBoolean1);
    ArrayList localArrayList = new ArrayList();
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, (List)localObject, i, true, false, this.jdField_c_of_type_Int, null, -1L, null, a(), 0L, 0L, null, paramInt1, false, null, 0, localArrayList);
    this.jdField_c_of_type_Int += 1;
    ReadinjoyReportUtils.a(paramInt1, this.jdField_b_of_type_Int, a(), paramBoolean2, paramInt2);
  }
  
  private boolean a(boolean paramBoolean)
  {
    paramBoolean = b();
    Object localObject1 = Boolean.valueOf(false);
    if (!paramBoolean) {
      return false;
    }
    long l = System.currentTimeMillis();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a();
    boolean bool3 = ReadInJoyChannelViewPagerController.a(this.jdField_b_of_type_Int);
    Object localObject2 = (KandianMergeManager)((BaseActivity)a()).app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    boolean bool1;
    if (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.d > 300000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = c();
    if ((!bool2) && (!bool1) && (!bool4)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ReadInJoyChannelWaterFallViewController_");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
    QLog.d(((StringBuilder)localObject2).toString(), 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), localObject1, localObject1, localObject1 }));
    if (a())
    {
      bool1 = ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isLastExitChannelOverTimeLimit(this.jdField_b_of_type_Int);
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
      i = this.jdField_b_of_type_Int;
      bool1 = paramBoolean;
      if (i != 70)
      {
        bool1 = paramBoolean;
        if (i != 56)
        {
          bool1 = paramBoolean;
          if (i != 40677)
          {
            bool1 = paramBoolean;
            if (!DailyModeConfigHandler.c(i)) {
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache;
    if (((ReadInJoyPageItemCache)localObject1).jdField_a_of_type_Long != 0L) {
      l = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.jdField_a_of_type_Long;
    }
    ((ReadInJoyPageItemCache)localObject1).jdField_a_of_type_Long = l;
    int i = this.jdField_b_of_type_Int;
    return false;
  }
  
  private boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  private boolean c()
  {
    return false;
  }
  
  private boolean d()
  {
    return this.jdField_b_of_type_Int != 0;
  }
  
  private void o() {}
  
  public Set<Long> a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
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
    this.jdField_d_of_type_Boolean = bool;
    int i;
    if (this.jdField_b_of_type_Int == 40830)
    {
      i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (i + 1);
    }
    else
    {
      i = 1;
    }
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, a(), paramInt, 0, i);
    ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.2(this));
  }
  
  public void a(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, boolean paramBoolean)
  {
    if (DailyModeConfigHandler.c(this.jdField_b_of_type_Int)) {
      KandianDailyReportUtils.a(1);
    }
    int i;
    if ((RIJQQAppInterfaceUtil.a()) && (!d()) && (!paramBoolean)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 3;
    } else {
      i = 1001;
    }
    if (!paramBoolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      RIJTabFrameBase localRIJTabFrameBase = (RIJTabFrameBase)RIJJumpUtils.a(a());
      if (localRIJTabFrameBase != null) {
        localRIJTabFrameBase.b(1);
      }
      RIJThreadHandler.a(3);
    }
    else
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(2, null);
      i = 1;
    }
    a(true, i, paramBoolean, -paramReadInjoyXRecyclerView.getScrollY());
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a(paramAbsBaseArticleInfo, paramInt);
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, -1, this.jdField_a_of_type_AndroidAppActivity.getString(2131699885), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(paramAbsBaseArticleInfo.mRecommendSeq))
    {
      ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.jdField_b_of_type_Int, paramAbsBaseArticleInfo.mRecommendSeq);
      return;
    }
    String str = RIJQQAppInterfaceUtil.a();
    DislikeInfo localDislikeInfo = new DislikeInfo();
    localDislikeInfo.a = HardCodeUtil.a(2131712665);
    localDislikeInfo.jdField_c_of_type_Int = 9;
    localDislikeInfo.b = "";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localDislikeInfo);
    ReadInJoyLogicEngine.a().a(Long.valueOf(str).longValue(), BaseArticleInfoKt.a(paramAbsBaseArticleInfo, localArrayList));
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, paramAbsBaseArticleInfo);
    if (paramInt == 0)
    {
      paramAbsBaseArticleInfo = (KandianMergeManager)((QQAppInterface)RIJQQAppInterfaceUtil.a()).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.a().size() > 0) {
        return;
      }
      ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
    }
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.c();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.b();
    }
  }
  
  public boolean a()
  {
    return a() instanceof SplashActivity;
  }
  
  public boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public void aw_()
  {
    super.aw_();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(true));
    b();
  }
  
  public Map<Long, BaseReportData> b(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.b();
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(a(Integer.valueOf(this.jdField_b_of_type_Int)), b(Integer.valueOf(this.jdField_b_of_type_Int)));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.b = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.d = ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.a(), this.jdField_b_of_type_Int);
    j();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    super.c();
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(b(Integer.valueOf(this.jdField_b_of_type_Int)), a(Integer.valueOf(this.jdField_b_of_type_Int)));
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int));
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      ReadInJoyLogicEngine.a().c(this.jdField_b_of_type_Int);
    }
    localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface.c(this.jdField_a_of_type_JavaUtilArrayList);
    }
    ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int);
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface;
    if (localPicWaterFallViewInterface != null) {
      localPicWaterFallViewInterface.a(b(Integer.valueOf(this.jdField_b_of_type_Int)), a(Integer.valueOf(this.jdField_b_of_type_Int)));
    }
    super.e();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_d_of_type_JavaUtilMap.clear();
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    super.i();
    this.jdField_c_of_type_Boolean = true;
    j();
  }
  
  public void j()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      ReadInJoyLogicEngine.a().a(this.jdField_b_of_type_Int, 20, 9223372036854775807L, true);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    QLog.d("ReadInJoyChannelWaterFallViewController", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int) });
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$PicWaterFallViewInterface != null)
    {
      Map localMap1 = a(Integer.valueOf(this.jdField_b_of_type_Int));
      Map localMap2 = ReadinjoyReportUtils.a(this.jdField_b_of_type_Int);
      ThreadManager.executeOnSubThread(new ReadInJoyChannelWaterFallViewController.1(this, localMap1, a(Integer.valueOf(this.jdField_b_of_type_Int)), localMap2, RIJKanDianFolderStatus.getFolderStatus(this.jdField_b_of_type_Int)));
      b(Integer.valueOf(this.jdField_b_of_type_Int)).clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public void l() {}
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyChannelWaterFallViewController
 * JD-Core Version:    0.7.0.1
 */