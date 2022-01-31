import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.utils.SignalStrengthReport;

public class khn
  implements Runnable
{
  public khn(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void run()
  {
    int m = 0;
    int n = SignalStrengthReport.e();
    int i;
    int j;
    label22:
    int k;
    int i1;
    if (n == 0)
    {
      i = 0;
      if (n != 0) {
        break label228;
      }
      j = 0;
      k = j;
      if (j == -1) {
        k = 0;
      }
      i1 = Math.abs(k);
      if (n != 1) {
        break label256;
      }
      k = this.a.jdField_b_of_type_Int;
      label51:
      if (n != 0) {
        break label261;
      }
      j = m;
    }
    for (;;)
    {
      VideoController.a().a(n, j, k);
      this.a.jdField_b_of_type_JavaLangString = ("networkType:" + n + " signalStrength:" + j + " pingResult:" + k);
      AVLog.c("SignalStrengthReport", "setGatewayTestResult networkType:" + n + " | levelPercent:" + i + " | dbm:" + i1 + "| pingResult:" + this.a.jdField_b_of_type_Int);
      if (this.a.a != null) {
        this.a.a.postDelayed(this, 2000L);
      }
      return;
      if (n == 1)
      {
        i = this.a.c();
        break;
      }
      i = this.a.b();
      break;
      label228:
      if (n == 1)
      {
        j = this.a.d();
        break label22;
      }
      j = this.a.a();
      break label22;
      label256:
      k = 0;
      break label51;
      label261:
      if (n == 1) {
        j = i;
      } else if (Build.VERSION.SDK_INT >= 23) {
        j = i;
      } else {
        j = i1 + 1000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khn
 * JD-Core Version:    0.7.0.1
 */