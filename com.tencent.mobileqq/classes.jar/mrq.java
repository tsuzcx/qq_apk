import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class mrq
  implements Runnable
{
  public mrq(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.a.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.b();
      this.a.leftView.post(new mrr(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrq
 * JD-Core Version:    0.7.0.1
 */