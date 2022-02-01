package com.tencent.mobileqq.vas.adv.reward;

import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.service.VasAdvService;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface.DefaultImpls;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq;
import com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportRsp;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvReq;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacAdvRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService;", "", "()V", "isReportingAd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequestingAd", "isShowingAd", "beforeReportAd", "", "beforeRequestAd", "beforeShowAd", "createReportAdReq", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportReq;", "createRequestAdReq", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvReq;", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "", "getReportAdRunnable", "Ljava/lang/Runnable;", "getRequestAdRunnable", "onError", "", "serviceCode", "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "errMsg", "onReportAdSuccess", "rsp", "Lcom/tencent/mobileqq/vas/adv/common/pb/adv_report$MobileAdvReportRsp;", "onRequestAdSuccess", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacAdvRsp;", "realShowAd", "showAdCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasRewardAdBaseService$ShowAdCallback;", "reportAd", "reportAdFromService", "callback", "Lcom/tencent/mobileqq/vas/adv/base/VasAdvBizCallback;", "requestAd", "requestAdFromService", "showAd", "Companion", "ShowAdCallback", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public abstract class VasRewardAdBaseService
{
  public static final VasRewardAdBaseService.Companion a;
  private volatile AtomicBoolean a;
  private volatile AtomicBoolean b = new AtomicBoolean(false);
  private volatile AtomicBoolean c = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdvRewardVasRewardAdBaseService$Companion = new VasRewardAdBaseService.Companion(null);
  }
  
  public VasRewardAdBaseService()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private final Runnable a()
  {
    return (Runnable)new VasRewardAdBaseService.getRequestAdRunnable.1(this);
  }
  
  private final void a(VasAdvBizCallback<vac_adv_get.VacAdvRsp> paramVasAdvBizCallback)
  {
    VasAdvService.a.a(a(), paramVasAdvBizCallback);
  }
  
  private final Runnable b()
  {
    return (Runnable)new VasRewardAdBaseService.getReportAdRunnable.1(this);
  }
  
  private final void b(VasAdvBizCallback<adv_report.MobileAdvReportRsp> paramVasAdvBizCallback)
  {
    VasAdvService.a.a(a(), paramVasAdvBizCallback);
  }
  
  @NotNull
  protected abstract adv_report.MobileAdvReportReq a();
  
  @NotNull
  protected abstract vac_adv_get.VacAdvReq a();
  
  @Nullable
  protected final qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return VasAdvSupport.a.a().a(paramString);
  }
  
  public final void a()
  {
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), a(), true, false, 4, null);
  }
  
  protected abstract void a(@NotNull VasAdvServiceCode paramVasAdvServiceCode, @NotNull String paramString);
  
  protected abstract void a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp);
  
  protected abstract void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp);
  
  protected abstract void a(@NotNull VasRewardAdBaseService.ShowAdCallback paramShowAdCallback);
  
  protected abstract boolean a();
  
  public final void b()
  {
    if (!this.b.compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "repeating show ad, discard");
      }
      return;
    }
    if (!b())
    {
      this.b.set(false);
      if (QLog.isColorLevel()) {
        QLog.d("VasRewardAdBaseService", 2, "showAd: early return, beforeShowAd failed");
      }
      return;
    }
    a((VasRewardAdBaseService.ShowAdCallback)new VasRewardAdBaseService.showAd.showAdCallback.1(this));
  }
  
  protected abstract boolean b();
  
  protected final void c()
  {
    VasAdvAppInterface.DefaultImpls.a(VasAdvSupport.a.a(), b(), true, false, 4, null);
  }
  
  protected abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.reward.VasRewardAdBaseService
 * JD-Core Version:    0.7.0.1
 */