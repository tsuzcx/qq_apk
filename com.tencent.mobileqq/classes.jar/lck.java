import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;

public class lck
  implements Runnable
{
  public lck(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a();
    ReadInJoyGlobalReporter.a().b(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lck
 * JD-Core Version:    0.7.0.1
 */