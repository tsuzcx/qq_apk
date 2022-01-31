import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;

public class lcz
  implements Runnable
{
  public lcz(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a();
    ReadInJoyGlobalReporter.a().b(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcz
 * JD-Core Version:    0.7.0.1
 */