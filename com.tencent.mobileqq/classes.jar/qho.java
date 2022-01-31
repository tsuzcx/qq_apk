import android.os.Handler;
import android.os.Message;
import com.tencent.gamecenter.common.util.ReportInfoManager;
import com.tencent.gamecenter.common.util.TrafficStatistics;

public class qho
  extends Handler
{
  public qho(ReportInfoManager paramReportInfoManager, long paramLong) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    TrafficStatistics.a("post report", this.jdField_a_of_type_Long, (short)1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qho
 * JD-Core Version:    0.7.0.1
 */