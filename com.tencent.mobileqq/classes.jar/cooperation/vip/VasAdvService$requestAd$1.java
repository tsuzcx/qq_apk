package cooperation.vip;

import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.vac_adv_get.VacAdvReq;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvService$requestAd$1
  implements Runnable
{
  VasAdvService$requestAd$1(VasAdvService paramVasAdvService) {}
  
  public final void run()
  {
    if (!VasAdvService.a(this.this$0).compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("VasAdvService", 2, "repeating request ad, discard");
      }
    }
    do
    {
      return;
      if (this.this$0.a()) {
        break;
      }
      VasAdvService.a(this.this$0).set(false);
    } while (!QLog.isColorLevel());
    QLog.d("VasAdvService", 2, "requestAd: early return, beforeRequestAd failed");
    return;
    try
    {
      byte[] arrayOfByte = this.this$0.a().toByteArray();
      VasAdvService.requestAd.1.callback.1 local1 = new VasAdvService.requestAd.1.callback.1(this);
      VasAdvSupport localVasAdvSupport = VasAdvSupport.a.a();
      String str = VasAdvService.a(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "reqBytes");
      localVasAdvSupport.a("MobileAdv.AdvGet", str, arrayOfByte, (VasAdvCallback)local1);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$0.a(VasAdvService.ServiceCode.CREATE_REQUEST_ERR, "create request ad error, abort request ad");
      VasAdvService.a(this.this$0).set(false);
      QLog.e("VasAdvService", 1, "create request ad error, abort request ad", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvService.requestAd.1
 * JD-Core Version:    0.7.0.1
 */