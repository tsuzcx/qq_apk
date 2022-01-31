import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;

public class lda
  implements Runnable
{
  public lda(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new ldb(this));
    HtmlOffline.b("2464", this.a.app, true, new ldc(this));
    HtmlOffline.b("2463", this.a.app, true, new ldd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lda
 * JD-Core Version:    0.7.0.1
 */