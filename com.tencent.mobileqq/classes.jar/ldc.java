import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;

public class ldc
  implements Runnable
{
  public ldc(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new ldd(this));
    HtmlOffline.b("2464", this.a.app, true, new lde(this));
    HtmlOffline.b("2463", this.a.app, true, new ldf(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldc
 * JD-Core Version:    0.7.0.1
 */