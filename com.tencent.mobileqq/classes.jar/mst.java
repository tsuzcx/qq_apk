import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;

public class mst
  implements Runnable
{
  public mst(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    SubscriptFeedsActivity.a(this.a, SubscriptRecommendController.b(this.a.app));
    if (PublicAccountUtil.a(this.a.app)) {
      SubscriptFeedsActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mst
 * JD-Core Version:    0.7.0.1
 */