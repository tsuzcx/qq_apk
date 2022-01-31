import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import cooperation.readinjoy.ReadInJoyHelper;

public class lex
  implements Runnable
{
  public lex(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity) {}
  
  public void run()
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.a(ReadInJoyVideoSubChannelActivity.a(this.a), "0", 0, 0), false);
    PublicAccountReportUtils.a("0X80066F8", "", "", "", "", ReadInJoyUtils.a(ReadInJoyVideoSubChannelActivity.a(this.a)));
    PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", VideoReporter.a(ReadInJoyVideoSubChannelActivity.b(this.a), null), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lex
 * JD-Core Version:    0.7.0.1
 */