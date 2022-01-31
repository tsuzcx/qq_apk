import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class lct
  extends ReadInJoyObserver
{
  public lct(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void a(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.a, paramInt);
    if ((paramInt > 0) && (ReadInJoyFeedsActivity.a(this.a) == 0)) {
      ((KanDianViewController)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyFeedsActivity.a(this.a) == 1)
    {
      ((KandianMergeManager)this.a.app.getManager(161)).b(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.a, paramInt1);
    ((KanDianViewController)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lct
 * JD-Core Version:    0.7.0.1
 */