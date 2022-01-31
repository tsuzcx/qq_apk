import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class ldy
  implements Runnable
{
  public ldy(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.a.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.b();
      this.a.f(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldy
 * JD-Core Version:    0.7.0.1
 */