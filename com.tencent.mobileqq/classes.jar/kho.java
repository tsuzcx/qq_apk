import android.os.Handler;
import com.tencent.av.AVLog;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.av.utils.SignalStrengthReport.PingUtil;

public class kho
  implements Runnable
{
  public kho(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void run()
  {
    this.a.b = 0;
    if ((this.a.jdField_a_of_type_Int == -1) || (SignalStrengthReport.e() == 1)) {}
    try
    {
      String str = SignalStrengthReport.a(this.a);
      this.a.b = SignalStrengthReport.PingUtil.a("http://" + str);
      if (this.a.b < 0) {
        this.a.b = 0;
      }
      AVLog.c("SignalStrengthReport", "mPingTask gatewayIP:" + str + " | avgRtt:" + this.a.b);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AVLog.c("SignalStrengthReport", "mPingTask e:" + localException);
      }
    }
    if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this, this.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kho
 * JD-Core Version:    0.7.0.1
 */