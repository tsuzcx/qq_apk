import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;

public class lcl
  implements Runnable
{
  public lcl(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new lcm(this));
    HtmlOffline.b("2464", this.a.app, true, new lcn(this));
    HtmlOffline.b("2463", this.a.app, true, new lco(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcl
 * JD-Core Version:    0.7.0.1
 */