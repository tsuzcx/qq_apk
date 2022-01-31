import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;

public class lob
  implements Runnable
{
  public lob(ReadInJoyVideoChannelFragment paramReadInJoyVideoChannelFragment) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "", "0X8007C41", "0X8007C41", 0, 0, "0", "0", "", VideoReporter.a(56, null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lob
 * JD-Core Version:    0.7.0.1
 */