import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;

public class ley
  implements Runnable
{
  public ley(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new lez(this));
    HtmlOffline.b("2464", this.a.app, true, new lfa(this));
    HtmlOffline.b("2463", this.a.app, true, new lfb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ley
 * JD-Core Version:    0.7.0.1
 */