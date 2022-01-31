import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class lcj
  implements Runnable
{
  public lcj(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a(true);
    ReadInJoyGlobalReporter.a().a(this.a.app, NetConnInfoCenter.getServerTimeMillis(), -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcj
 * JD-Core Version:    0.7.0.1
 */