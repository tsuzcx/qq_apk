package cooperation.vip;

import com.tencent.mobileqq.pb.PBInt32Field;
import cooperation.vip.pb.adv_report.MobileAdvReportRsp;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cooperation/vip/VasAdvService$reportAd$1$callback$1", "Lcooperation/vip/VasAdvCallback;", "onError", "", "errMsg", "", "e", "", "onRsp", "rspBytes", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvService$reportAd$1$callback$1
  implements VasAdvCallback
{
  public void a(@NotNull String paramString, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.this$0.a(VasAdvService.ServiceCode.REPORT_CMD_ERROR, "report ad onError: " + paramString);
    VasAdvService.c(this.a.this$0).set(false);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "rspBytes");
    for (;;)
    {
      try
      {
        localMobileAdvReportRsp = new adv_report.MobileAdvReportRsp();
        localMobileAdvReportRsp.mergeFrom(paramArrayOfByte);
        bool = VasAdvService.a(this.a.this$0, localMobileAdvReportRsp);
        if (bool != true) {
          continue;
        }
        this.a.this$0.a(localMobileAdvReportRsp);
      }
      catch (Exception paramArrayOfByte)
      {
        adv_report.MobileAdvReportRsp localMobileAdvReportRsp;
        boolean bool;
        this.a.this$0.a(VasAdvService.ServiceCode.REPORT_RSP_PARSE_ERR, "parse report rsp exception: " + paramArrayOfByte.getMessage());
        continue;
      }
      VasAdvService.c(this.a.this$0).set(false);
      return;
      if (!bool) {
        this.a.this$0.a(VasAdvService.ServiceCode.REPORT_RSP_FAIL, "report rsp ret code:" + localMobileAdvReportRsp.ret_code.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.VasAdvService.reportAd.1.callback.1
 * JD-Core Version:    0.7.0.1
 */