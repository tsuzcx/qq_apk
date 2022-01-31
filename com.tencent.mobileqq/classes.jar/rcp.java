import com.tencent.kingkong.Common;
import com.tencent.kingkong.Common.Log;
import com.tencent.kingkong.DataReport;
import com.tencent.kingkong.ReportThread;

public final class rcp
  extends Thread
{
  public void run()
  {
    try
    {
      Thread.sleep(1000L);
      Common.a.a(2088, 0, 0, "");
      Common.Log.a("KingKongCommon", "QQ Login " + DataReport.o());
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rcp
 * JD-Core Version:    0.7.0.1
 */