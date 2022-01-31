import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;

public class lfk
  implements Runnable
{
  public lfk(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X8007C41", "0X8007C41", 0, 0, "0", "0", "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.b(this.a), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */