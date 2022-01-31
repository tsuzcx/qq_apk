import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;

public class loc
  implements Runnable
{
  public loc(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X8007C41", "0X8007C41", 0, 0, "0", "0", "", VideoReporter.a(56, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loc
 * JD-Core Version:    0.7.0.1
 */