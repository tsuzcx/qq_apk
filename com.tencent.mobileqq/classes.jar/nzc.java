import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Map;

public class nzc
  extends oxe
{
  public nzc(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyFeedsActivity.a(this.a) == 1)
    {
      ((KandianMergeManager)this.a.app.getManager(162)).b(1);
      return;
    }
    ReadInJoyFeedsActivity.b(this.a, paramInt1);
    ((nwc)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
  }
  
  public void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void c(int paramInt)
  {
    ReadInJoyFeedsActivity.a(this.a, paramInt);
    if ((paramInt > 0) && (ReadInJoyFeedsActivity.a(this.a) == 0)) {
      ((nwc)this.a.a.get(Integer.valueOf(ReadInJoyFeedsActivity.a(this.a)))).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nzc
 * JD-Core Version:    0.7.0.1
 */