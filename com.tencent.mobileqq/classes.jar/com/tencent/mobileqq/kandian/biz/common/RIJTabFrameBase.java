package com.tencent.mobileqq.kandian.biz.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.util.GifHelper;
import com.tencent.mobileqq.app.FrameFragment;
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
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoPlayController.Companion;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.publisher.api.impl.KanDianPublisher;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase;", "Lcom/tencent/mobileqq/kandian/biz/common/KDFragmentFrame;", "Lcom/tencent/mobileqq/kandian/base/tab/IRIJTabFrame;", "frameFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "feedsOperation", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$FeedsOperation;", "getFeedsOperation", "()Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$FeedsOperation;", "foreBackgroundCallback", "Lcom/tencent/mobileqq/kandian/repo/feeds/IForeBackGroundCallback;", "lastEnterTime", "", "lastExitTime", "launchFrom", "", "preloadTask", "Lcom/tencent/mobileqq/kandian/biz/common/RIJTabFrameBase$PreloadTaskManager;", "clearCacheWhenLeave", "", "doForEnterTab", "doForLeaveTab", "doReportWhenLeave", "getApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getCurrentFragment", "Lcom/tencent/mobileqq/kandian/biz/common/fragment/ReadInJoyBaseFragment;", "handleSchemaJump", "initForeBackgroundCallback", "markAccountCompleteAndShowToast", "notifyFragmentVisibilityChange", "visible", "", "onAccountChanged", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "onDestroy", "onResume", "tabChanged", "onStart", "onStop", "onTabChange", "isEnterTab", "requestAdInfo", "requestUgcAccountCreate", "resetStateWhenTabChange", "resetVideoStateWhenLeave", "setOperationFlag", "operationBitFlag", "setSuperMaskChannelId", "showTips", "delayTimeMs", "Companion", "FeedsOperation", "PreloadTaskManager", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class RIJTabFrameBase
  extends KDFragmentFrame
  implements IRIJTabFrame
{
  public static final RIJTabFrameBase.Companion d = new RIJTabFrameBase.Companion(null);
  private static boolean h;
  @JvmField
  public long a;
  @JvmField
  public long b;
  @JvmField
  public int c = 5;
  @NotNull
  private final RIJTabFrameBase.FeedsOperation e = new RIJTabFrameBase.FeedsOperation();
  private final RIJTabFrameBase.PreloadTaskManager f = new RIJTabFrameBase.PreloadTaskManager();
  private IForeBackGroundCallback g;
  
  public RIJTabFrameBase(@NotNull FrameFragment paramFrameFragment)
  {
    super(paramFrameFragment);
  }
  
  private final void A()
  {
    ReadInJoyWebDataManager.b();
    ReadInJoyWebDataManager.a().e();
    ReadInJoyUtils.e();
    ReadInJoyDisplayUtils.a();
    Object localObject1 = this.aF;
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
        localObject1 = ((ReadInJoyLogicEngine)localObject1).e();
        if (localObject1 != null) {
          ((ReadInJoyUserInfoModule)localObject1).c();
        }
      }
    }
    AppRuntime localAppRuntime = this.aF;
    localObject1 = localObject2;
    if (localAppRuntime != null) {
      localObject1 = localAppRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    }
    if (localObject1 != null)
    {
      localObject1 = (KandianMergeManager)localObject1;
      if (localObject1 != null) {
        ((KandianMergeManager)localObject1).S();
      }
      StyleConfigHelper.a().c();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  private final void B()
  {
    VideoReport.traverseExposure();
    RIJKanDianTabReport.a(this.c, this.b, false, this.e.a(), g());
    RIJKanDianTabReport.a(this.a - this.b);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.n();
    }
  }
  
  private final void C()
  {
    if (!RIJWebArticleUtil.a.i())
    {
      QLog.i("RIJTabFrameBase", 1, "[initForeBackgroundCallback] switch is off");
      return;
    }
    this.g = ((IForeBackGroundCallback)new RIJTabFrameBase.initForeBackgroundCallback.1(this));
    ReadinjoySPEventReport.ForeBackGround.a(this.g);
  }
  
  private final void a(long paramLong)
  {
    RIJThreadHandler.b().postDelayed((Runnable)new RIJTabFrameBase.showTips.1(this), paramLong);
  }
  
  private final void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.c();
      RIJThreadHandler.a(RIJQQAppInterfaceUtil.c());
    }
    IRuntimeService localIRuntimeService = RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class);
    if (localIRuntimeService != null)
    {
      ((IRIJADExposureService)localIRuntimeService).reportAllInvalidADExposure((Activity)P());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService");
  }
  
  private final void g(boolean paramBoolean)
  {
    try
    {
      ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
      if (localReadInJoyBaseFragment != null)
      {
        if (paramBoolean)
        {
          localObject = RIJChannelViewpagerEnterPathHelper.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJChannelViewpagerEnter…per.getChannelEntryPath()");
          ((Map)localObject).put(Integer.valueOf(localReadInJoyBaseFragment.d()), Integer.valueOf(0));
          localReadInJoyBaseFragment.a(false, (Activity)P(), null);
          return;
        }
        localReadInJoyBaseFragment.k();
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[notifyFragmentVisibilityChange] e = ");
      ((StringBuilder)localObject).append(localException);
      QLog.e("RIJTabFrameBase", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private final void w()
  {
    Object localObject = P();
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
        ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
        if (localReadInJoyBaseFragment != null) {
          localReadInJoyBaseFragment.l();
        }
      }
      ((Intent)localObject).removeExtra("arg_channel_cover_id");
    }
  }
  
  private final void x()
  {
    this.b = System.currentTimeMillis();
    this.e.e();
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = RIJKanDianFolderStatus.RED_PNT_INFO_FOR_REPORT.f;
    RIJKanDianTabReport.a(this.c, l1 - l2, true, this.e.a(), g());
    GifHelper.a();
    FeedsPreloadHelper.a();
    VideoVolumeControl.getInstance().inKandianModule((Activity)P());
    ReadInJoyHelper.z(this.aF);
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.b(), "ENTER_KD_TAB");
  }
  
  private final void y()
  {
    this.a = System.currentTimeMillis();
    this.e.d();
    RIJKanDianFolderStatus.updateKandianFolderStatus(t());
    GifHelper.b();
    Object localObject = P();
    if (localObject != null)
    {
      localObject = ((QBaseActivity)localObject).getIntent();
      if (localObject != null) {
        ((Intent)localObject).removeExtra("launch_from");
      }
    }
    z();
    A();
    B();
  }
  
  private final void z()
  {
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.b(), "LEAVE_KD_TAB");
    VideoVolumeControl.getInstance().outKandianModule((Activity)P());
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readInjoy doOnPause");
  }
  
  protected void a()
  {
    super.a();
    VideoReport.addToDetectionWhitelist((Activity)P());
    VideoReport.ignorePageInOutEvent(P(), true);
    C();
    q();
  }
  
  protected void a(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
    if (localReadInJoyBaseFragment != null) {
      localReadInJoyBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((paramInt1 == 10000) && (paramInt2 == -1) && (paramIntent != null))
    {
      if (paramIntent.getBooleanExtra("key_ugc_account_create", false))
      {
        r();
        return;
      }
      if (paramIntent.getBooleanExtra("key_ugc_account_edit", false))
      {
        s();
        return;
      }
      QLog.d("ReadInJoyTabFrame", 1, "ugc account create or edit profile canceled !");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    w();
    e(true);
  }
  
  public void b(int paramInt)
  {
    this.e.a(paramInt, g());
  }
  
  protected void bS_()
  {
    super.bS_();
    this.e.e();
  }
  
  public void c()
  {
    super.c();
    this.e.d();
    VideoVolumeControl.getInstance().requestOrAbandonAudioFocus(false, "readInjoy onStop");
  }
  
  protected void d()
  {
    super.d();
    h = false;
    IForeBackGroundCallback localIForeBackGroundCallback = this.g;
    if (localIForeBackGroundCallback != null) {
      ReadinjoySPEventReport.ForeBackGround.b(localIForeBackGroundCallback);
    }
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
  }
  
  public void d(boolean paramBoolean)
  {
    h = paramBoolean;
    Object localObject1 = P();
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
    this.c = i;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("enterTab: ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(", launchFrom: ");
    ((StringBuilder)localObject1).append(this.c);
    QLog.d("RIJTabFrameBase", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = t();
    i = this.c;
    localObject1 = P();
    if (localObject1 != null) {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
    } else {
      localObject1 = null;
    }
    RIJKanDianTabReport.a((QQAppInterface)localObject2, paramBoolean, i, (Intent)localObject1);
    f(paramBoolean);
    c(paramBoolean);
    g(paramBoolean);
    localObject1 = KanDianPublisher.INSTANCE;
    localObject2 = BaseApplication.context;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplication.context");
    ((KanDianPublisher)localObject1).init((Context)localObject2);
    if (paramBoolean)
    {
      BaseConfig.a.a();
      x();
      this.f.a(this, t());
      VideoPlayController.a.e();
    }
    else
    {
      y();
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
    Object localObject1 = p();
    if (localObject1 != null)
    {
      localObject2 = QRoute.api(IRIJSuperMaskService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "QRoute.api(IRIJSuperMaskService::class.java)");
      ((IRIJSuperMaskService)localObject2).setChannelID(((ReadInJoyBaseFragment)localObject1).d());
      localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSuperMaskChannelId ");
      localStringBuilder.append(((ReadInJoyBaseFragment)localObject1).d());
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
    RIJChannelStayTimeMonitor.INSTANCE.onAccountChanged();
    q();
    VideoPlayController.a.e();
  }
  
  public boolean h()
  {
    ReadInJoyBaseFragment localReadInJoyBaseFragment = p();
    if ((localReadInJoyBaseFragment instanceof ReadInJoyVideoChannelFragment))
    {
      VideoPlayManager localVideoPlayManager = ((ReadInJoyVideoChannelFragment)localReadInJoyBaseFragment).a();
      VideoUIManager localVideoUIManager;
      if (localVideoPlayManager != null) {
        localVideoUIManager = localVideoPlayManager.k();
      } else {
        localVideoUIManager = null;
      }
      if (localVideoUIManager != null)
      {
        localVideoUIManager = localVideoPlayManager.k();
        if ((localVideoUIManager != null) && (localVideoUIManager.c() == true))
        {
          localVideoUIManager.p();
          localVideoUIManager.i();
          return true;
        }
        if ((((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).isPatchPlaying((IVideoUIManager)localVideoPlayManager.k())) && (localVideoUIManager != null)) {
          localVideoUIManager.i();
        }
      }
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyRecommendFeedsFragment)) && (((ReadInJoyRecommendFeedsFragment)localReadInJoyBaseFragment).w())) {
      return true;
    }
    if (((localReadInJoyBaseFragment instanceof ReadInJoyViolaChannelFragment)) && (((ReadInJoyViolaChannelFragment)localReadInJoyBaseFragment).w())) {
      return true;
    }
    return super.h();
  }
  
  @NotNull
  public final RIJTabFrameBase.FeedsOperation o()
  {
    return this.e;
  }
  
  @Nullable
  public abstract ReadInJoyBaseFragment p();
  
  public final void q()
  {
    try
    {
      ((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).initRes(t());
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
  public final void r()
  {
    Object localObject = ReadInJoyLogicEngine.a();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyLogicEngine.getInstance()");
    localObject = ((ReadInJoyLogicEngine)localObject).o();
    if (localObject != null) {
      ((RIJUGCAccountCreateModule)localObject).a(RIJQQAppInterfaceUtil.c(), (RIJUGCAccountCreateModule.UGCAccountCreateCallback)new RIJTabFrameBase.requestUgcAccountCreate.1(this));
    }
  }
  
  @VisibleForTesting
  public final void s()
  {
    ReadInJoyHelper.U();
    RIJThreadHandler.b().post((Runnable)new RIJTabFrameBase.markAccountCompleteAndShowToast.1(this));
    a(2500L);
  }
  
  @NotNull
  public final QQAppInterface t()
  {
    AppRuntime localAppRuntime = this.aF;
    if (localAppRuntime != null) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.RIJTabFrameBase
 * JD-Core Version:    0.7.0.1
 */