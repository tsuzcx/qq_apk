import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class mwr
  implements Runnable
{
  public mwr(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.a.app.a();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.b();
      this.a.leftView.post(new mws(this, i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwr
 * JD-Core Version:    0.7.0.1
 */