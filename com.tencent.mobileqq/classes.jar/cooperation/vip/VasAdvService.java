package cooperation.vip;

import bmkf;
import bmkg;
import bmkj;
import bmkk;
import bmkl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.adv_report.MobileAdvReportReq;
import cooperation.vip.pb.adv_report.MobileAdvReportRsp;
import cooperation.vip.pb.vac_adv_get.VacAdvReq;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvService;", "", "()V", "isReportingAd", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRequestingAd", "isShowingAd", "beforeReportAd", "", "beforeRequestAd", "beforeShowAd", "createReportAdReq", "Lcooperation/vip/pb/adv_report$MobileAdvReportReq;", "createRequestAdReq", "Lcooperation/vip/pb/vac_adv_get$VacAdvReq;", "generateCmdKey", "", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "onError", "", "serviceCode", "Lcooperation/vip/VasAdvService$ServiceCode;", "errMsg", "onReportAdSuccess", "rsp", "Lcooperation/vip/pb/adv_report$MobileAdvReportRsp;", "onRequestAdSuccess", "Lcooperation/vip/pb/vac_adv_get$VacAdvRsp;", "realShowAd", "showAdCallback", "Lcooperation/vip/VasAdvService$ShowAdCallback;", "reportAd", "requestAd", "showAd", "isSuccess", "Companion", "ServiceCode", "ShowAdCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class VasAdvService
{
  public static final bmkf a;
  private volatile AtomicBoolean a;
  private volatile AtomicBoolean b = new AtomicBoolean(false);
  private volatile AtomicBoolean c = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_Bmkf = new bmkf(null);
  }
  
  public VasAdvService()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private final String a()
  {
    String str = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "UUID.randomUUID().toString()");
    return str;
  }
  
  private final boolean a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp)
  {
    return paramMobileAdvReportRsp.ret_code.get() == 0;
  }
  
  private final boolean a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp)
  {
    return paramVacAdvRsp.err_code.get() == 0;
  }
  
  @NotNull
  protected abstract adv_report.MobileAdvReportReq a();
  
  @NotNull
  protected abstract vac_adv_get.VacAdvReq a();
  
  @Nullable
  protected final qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    return bmkk.a.a().a(paramString);
  }
  
  public final void a()
  {
    bmkk.a.a().a((Runnable)new VasAdvService.requestAd.1(this));
  }
  
  protected abstract void a(@NotNull bmkg parambmkg);
  
  public abstract void a(@NotNull VasAdvService.ServiceCode paramServiceCode, @NotNull String paramString);
  
  public abstract void a(@NotNull adv_report.MobileAdvReportRsp paramMobileAdvReportRsp);
  
  public abstract void a(@NotNull vac_adv_get.VacAdvRsp paramVacAdvRsp);
  
  protected abstract boolean a();
  
  public final void b()
  {
    if (!this.b.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("VasAdvService", 2, "repeating show ad, discard");
      }
    }
    do
    {
      return;
      if (b()) {
        break;
      }
      this.b.set(false);
    } while (!QLog.isColorLevel());
    QLog.d("VasAdvService", 2, "showAd: early return, beforeShowAd failed");
    return;
    a((bmkg)new bmkj(this));
  }
  
  protected abstract boolean b();
  
  public final void c()
  {
    bmkk.a.a().a((Runnable)new VasAdvService.reportAd.1(this));
  }
  
  protected abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.VasAdvService
 * JD-Core Version:    0.7.0.1
 */