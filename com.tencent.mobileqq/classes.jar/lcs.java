import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

class lcs
  implements Runnable
{
  lcs(lcr paramlcr) {}
  
  public void run()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.a.app.getManager(161);
    if (localKandianMergeManager != null) {
      localKandianMergeManager.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcs
 * JD-Core Version:    0.7.0.1
 */