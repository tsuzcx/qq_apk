package cooperation.vip;

import bmkd;
import bmkh;
import bmkk;
import bmkl;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.adv_report.MobileAdvReportReq;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class VasAdvService$reportAd$1
  implements Runnable
{
  VasAdvService$reportAd$1(VasAdvService paramVasAdvService) {}
  
  public final void run()
  {
    if (!VasAdvService.c(this.this$0).compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("VasAdvService", 2, "repeating report ad, discard");
      }
    }
    do
    {
      return;
      if (this.this$0.c()) {
        break;
      }
      VasAdvService.c(this.this$0).set(false);
    } while (!QLog.isColorLevel());
    QLog.d("VasAdvService", 2, "reportAd: early return, beforeReportAd failed");
    return;
    try
    {
      byte[] arrayOfByte = this.this$0.a().toByteArray();
      bmkh localbmkh = new bmkh(this);
      bmkk localbmkk = bmkk.a.a();
      String str = VasAdvService.a(this.this$0);
      Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "reportReqBytes");
      localbmkk.a("MobileAdv.AdvReport", str, arrayOfByte, (bmkd)localbmkh);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.this$0.a(VasAdvService.ServiceCode.CREATE_REPORT_ERR, "create report request error, abort report ad");
      VasAdvService.c(this.this$0).set(false);
      QLog.e("VasAdvService", 1, "create report request error, abort report ad", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.VasAdvService.reportAd.1
 * JD-Core Version:    0.7.0.1
 */