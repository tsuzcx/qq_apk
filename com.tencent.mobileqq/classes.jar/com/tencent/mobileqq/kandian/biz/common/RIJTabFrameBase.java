package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.Companion;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyVideoChannelFragment;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.glue.baseconfig.BaseConfig;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJKanDianTabReport;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadHelper;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGCAccountCreateModule.UGCAccountCreateCallback;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase;", "Lcom/tencent/mobileqq/app/Frame;", "Lcom/tencent/mobileqq/kandian/base/tab/IRIJTabFrame;", "()V", "feedsOperation", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$FeedsOperation;", "getFeedsOperation", "()Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$FeedsOperation;", "foreBackgroundCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "lastEnterTime", "", "lastExitTime", "launchFrom", "", "preloadTask", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$PreloadTaskManager;", "clearCacheWhenLeave", "", "doForEnterTab", "doForLeaveTab", "doReportWhenLeave", "getApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getCurrentFragment", "Lcom/tencent/mobileqq/kandian/biz/common/fragment/ReadInJoyBaseFragment;", "handleSchemaJump", "initForeBackgroundCallback", "markAccountCompleteAndShowToast", "notifyFragmentVisibilityChange", "visible", "", "onAccountChanged", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onResume", "tabChanged", "onStart", "onStop", "onTabChange", "isEnterTab", "requestAdInfo", "requestUgcAccountCreate", "resetStateWhenTabChange", "resetVideoStateWhenLeave", "setOperationFlag", "operationBitFlag", "setSuperMaskChannelId", "showTips", "delayTimeMs", "Companion", "FeedsOperation", "PreloadTaskManager", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class RIJTabFrameBase
  extends Frame
  implements IRIJTabFrame
{
  public static final RIJTabFrameBase.Companion a;
  private static boolean jdField_a_of_type_Boolean;
  @JvmField
  public int a;
  @JvmField
  public long a;
  @NotNull
  private final RIJTabFrameBase.FeedsOperation jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation = new RIJTabFrameBase.FeedsOperation();
  private final RIJTabFrameBase.PreloadTaskManager jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$PreloadTaskManager = new RIJTabFrameBase.PreloadTaskManager();
  private IForeBackGroundCallback jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsIForeBackGroundCallback;
  @JvmField
  public long b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$Companion = new RIJTabFrameBase.Companion(null);
  }
  
  public RIJTabFrameBase()
  {
    this.jdField_a_of_type_Int = 5;
  }
  
  private final void a(long paramLong)
  {
    RIJThreadHandler.b().postDelayed((Runnable)new RIJTabFrameBase.showTips.1(this), paramLong);
  }
  
  private final void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.a();
      RIJThreadHandler.a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin());
    }
    IRuntimeService localIRuntimeService = RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class);
    if (localIRuntimeService != null)
    {
      ((IRIJADExposureService)localIRuntimeService).reportAllInvalidADExposure((Activity)a());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService");
  }
  
  private final void g(boolean paramBoolean)
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null)
    {
      if (paramBoolean)
      {
        HashMap localHashMap = RIJChannelViewpagerEnterPathHelper.a();
        Intrinsics.checkExpressionValueIsNotNull(localHashMap, "RIJChannelViewpagerEnter…per.getChannelEntryPath()");
        ((Map)localHashMap).put(Integer.valueOf(localReadInJoyBaseFragment.b()), Integer.valueOf(0));
        localReadInJoyBaseFragment.a(false, (Activity)a(), null);
        return;
      }
      localReadInJoyBaseFragment.e();
    }
  }
  
  private final void m()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = ((QBaseActivity)localObject).getIntent();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Intent)localObject).hasExtra("arg_channel_cover_id")))
    {
      a(((Intent)localObject).getIntExtra("arg_channel_cover_id", 0));
      if (((Intent)localObject).getBooleanExtra("edit_video_jump_and_refresh", false))
      {
        ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
        if (localReadInJoyBaseFragment != null) {
          localReadInJoyBaseFragment.f();
        }
      }
      ((Intent)localObject).removeExtra("arg_channel_cover_id");
    }
  }
  
  private final void n()
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.c();
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.jdField_a_of_type_Long;
    RIJKanDianTabReport.a(this.jdField_a_of_type_Int, l1 - l2, true, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.a(), a());
    GifHelper.a();
    FeedsPreloadHelper.a();
    VideoVolumeControl.getInstance().inKandianModule((Activity)a());
    ReadInJoyHelper.b(this.jdField_a_of_type_MqqAppAppRuntime);
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "ENTER_KD_TAB");
  }
  
  private final void o()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.b();
    RIJKanDianFolderStatus.updateKandianFolderStatus(a());
    GifHelper.b();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((QBaseActivity)localObject).getIntent();
      if (localObject != null) {
        ((Intent)localObject).removeExtra("launch_from");
      }
    }
    p();
    r();
    s();
  }
  
  private final void p()
  {
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "LEAVE_KD_TAB");
    VideoVolumeControl.getInstance().outKandianModule((Activity)a());
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readInjoy doOnPause");
  }
  
  private final void r()
  {
    ReadInJoyWebDataManager.a();
    ReadInJoyWebDataManager.a().b();
    ReadInJoyUtils.a();
    ReadInJoyDisplayUtils.a();
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((AppRuntime)localObject1).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    } else {
      localObject1 = null;
    }
    localObject1 = (ReadInJoyLogicManager)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((ReadInJoyLogicManager)localObject1).getReadInJoyLogicEngine();
      if (localObject1 != null)
      {
        localObject1 = ((ReadInJoyLogicEngine)localObject1).a();
        if (localObject1 != null) {
          ((ReadInJoyUserInfoModule)localObject1).a();
        }
      }
    }
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    localObject1 = localObject2;
    if (localAppRuntime != null) {
      localObject1 = localAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    }
    if (localObject1 != null)
    {
      localObject1 = (KandianMergeManager)localObject1;
      if (localObject1 != null) {
        ((KandianMergeManager)localObject1).p();
      }
      StyleConfigHelper.a().b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  private final void s()
  {
    VideoReport.traverseExposure();
    RIJKanDianTabReport.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.a(), a());
    RIJKanDianTabReport.a(this.jdField_a_of_type_Long - this.b);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.g();
    }
  }
  
  private final void t()
  {
    if (!RIJWebArticleUtil.a.h())
    {
      QLog.i("RIJTabFrameBase", 1, "[initForeBackgroundCallback] switch is off");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsIForeBackGroundCallback = ((IForeBackGroundCallback)new RIJTabFrameBase.initForeBackgroundCallback.1(this));
    ReadinjoySPEventReport.ForeBackGround.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsIForeBackGroundCallback);
  }
  
  protected void V_()
  {
    super.V_();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.c();
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @NotNull
  public final RIJTabFrameBase.FeedsOperation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation;
  }
  
  @Nullable
  public abstract ReadInJoyBaseFragment a();
  
  protected void a()
  {
    super.a();
    VideoReport.addToDetectionWhitelist((Activity)a());
    VideoReport.ignorePageInOutEvent(a(), true);
    t();
    j();
  }
  
  protected void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_ugc_account_create", false))
      {
        k();
        return;
      }
      if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
      {
        l();
        return;
      }
      QLog.d("ReadInJoyTabFrame", 1, "ugc account create or edit profile canceled !");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    m();
    e(true);
  }
  
  public boolean a()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = a();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      VideoPlayManager localVideoPlayManager = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      VideoUIManager localVideoUIManager;
      if (localVideoPlayManager != null) {
        localVideoUIManager = localVideoPlayManager.a();
      } else {
        localVideoUIManager = null;
      }
      if (localVideoUIManager != null)
      {
        localVideoUIManager = localVideoPlayManager.a();
        if ((localVideoUIManager != null) && (localVideoUIManager.a() == true))
        {
          localVideoUIManager.j();
          localVideoUIManager.c();
          return true;
        }
        if ((((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).isPatchPlaying((IVideoUIManager)localVideoPlayManager.a())) && (localVideoUIManager != null)) {
          localVideoUIManager.c();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).f())) {
      return true;
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyViolaChannelFragment)) && (((ReadInJoyViolaChannelFragment)localReadInJoyBaseFragment).g())) {
      return true;
    }
    return super.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.a(paramInt, a());
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$FeedsOperation.b();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readInjoy onStop");
  }
  
  protected void d()
  {
    super.d();
    jdField_a_of_type_Boolean = false;
    IForeBackGroundCallback localIForeBackGroundCallback = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsIForeBackGroundCallback;
    if (localIForeBackGroundCallback != null) {
      ReadinjoySPEventReport.ForeBackGround.b(localIForeBackGroundCallback);
    }
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
  }
  
  public void d(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    Object localObject1 = a();
    int j = 5;
    int i = j;
    if (localObject1 != null)
    {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
      i = j;
      if (localObject1 != null) {
        i = ((Intent)localObject1).getIntExtra("launch_from", 5);
      }
    }
    this.jdField_a_of_type_Int = i;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enterTab: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", launchFrom: ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    QLog.d("RIJTabFrameBase", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = a();
    i = this.jdField_a_of_type_Int;
    localObject1 = a();
    if (localObject1 != null) {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
    } else {
      localObject1 = null;
    }
    RIJKanDianTabReport.a((QQAppInterface)localObject2, paramBoolean, i, (Intent)localObject1);
    f(paramBoolean);
    c(paramBoolean);
    g(paramBoolean);
    localObject1 = (IKanDianPublisher)QRoute.api(IKanDianPublisher.class);
    localObject2 = BaseApplication.context;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.context");
    ((IKanDianPublisher)localObject1).init((Context)localObject2);
    if (paramBoolean)
    {
      BaseConfig.a.a();
      n();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonRIJTabFrameBase$PreloadTaskManager.a(this, a());
      VideoPlayController.a.a();
    }
    else
    {
      o();
    }
    RIJUserLevelModule.getInstance().requestUserLevel(10, null);
    e(paramBoolean);
  }
  
  protected void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject1 = QRoute.api(IRIJSuperMaskService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IRIJSuperMaskService::class.java)");
      ((IRIJSuperMaskService)localObject1).setChannelID(-1);
      localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setSuperMaskChannelId -1 : visible = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject2 = QRoute.api(IRIJSuperMaskService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IRIJSuperMaskService::class.java)");
      ((IRIJSuperMaskService)localObject2).setChannelID(((ReadInJoyBaseFragment)localObject1).b());
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSuperMaskChannelId ");
      localStringBuilder.append(((ReadInJoyBaseFragment)localObject1).b());
      localStringBuilder.append(" : visible = ");
      localStringBuilder.append(paramBoolean);
      ((IRIJAdLogService)localObject2).d("ReadInJoySuperMaskAd", localStringBuilder.toString());
      return;
    }
    localObject1 = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "QRoute.api(IRIJSuperMaskService::class.java)");
    ((IRIJSuperMaskService)localObject1).setChannelID(-1);
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setSuperMaskChannelId -1 : visible = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((IRIJAdLogService)localObject1).d("ReadInJoySuperMaskAd", ((StringBuilder)localObject2).toString());
  }
  
  protected void f()
  {
    super.f();
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).onAccountChanged();
    j();
    VideoPlayController.a.a();
  }
  
  public final void j()
  {
    try
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).initRes(a());
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestAdInfo error! e = ");
      localStringBuilder.append(localThrowable);
      QLog.d("RIJTabFrameBase", 1, localStringBuilder.toString());
    }
  }
  
  @VisibleForTesting
  public final void k()
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).a();
    if (localObject != null) {
      ((RIJUGCAccountCreateModule)localObject).a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), (RIJUGCAccountCreateModule.UGCAccountCreateCallback)new RIJTabFrameBase.requestUgcAccountCreate.1(this));
    }
  }
  
  @VisibleForTesting
  public final void l()
  {
    ReadInJoyHelper.h();
    RIJThreadHandler.b().post((Runnable)new RIJTabFrameBase.markAccountCompleteAndShowToast.1(this));
    a(2500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase
 * JD-Core Version:    0.7.0.1
 */