import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;

public class ldr
  implements Runnable
{
  public ldr(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new lds(this));
    HtmlOffline.b("2464", this.a.app, true, new ldt(this));
    HtmlOffline.b("2463", this.a.app, true, new ldu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldr
 * JD-Core Version:    0.7.0.1
 */