import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;

class ldh
  implements Runnable
{
  ldh(ldg paramldg) {}
  
  public void run()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.a.a.app.getManager(161);
    if (localKandianMergeManager != null) {
      localKandianMergeManager.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldh
 * JD-Core Version:    0.7.0.1
 */