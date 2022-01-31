import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import cooperation.readinjoy.ReadInJoyHelper;

public class mlu
  implements Runnable
{
  public mlu(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    if (this.a.a == 40677) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009295", "0X8009295", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.a(this.a.a), false);
    }
    for (;;)
    {
      if (this.a.a == 56) {
        PublicAccountReportUtils.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "0", "", VideoReporter.a(this.a.a, null), false);
      }
      return;
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F9", "0X80066F9", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.a(this.a.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlu
 * JD-Core Version:    0.7.0.1
 */