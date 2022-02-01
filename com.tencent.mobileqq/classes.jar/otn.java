import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Map;

public class otn
  extends pvq
{
  public otn(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyFeedsActivity.a(this.a) == 1)
    {
      ((KandianMergeManager)this.a.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.a, paramInt1);
    ((oqo)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
  }
  
  public void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void c(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.a, paramInt);
    if ((paramInt > 0) && (ReadInJoyFeedsActivity.a(this.a) == 0)) {
      ((oqo)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otn
 * JD-Core Version:    0.7.0.1
 */