import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;

public class lfq
  implements Runnable
{
  public lfq(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    HtmlOffline.b("2378", this.a.app, true, new lfr(this));
    HtmlOffline.b("2464", this.a.app, true, new lfs(this));
    HtmlOffline.b("2463", this.a.app, true, new lft(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfq
 * JD-Core Version:    0.7.0.1
 */