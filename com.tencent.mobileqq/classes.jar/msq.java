import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class msq
  implements Runnable
{
  public msq(SubscriptFeedsActivity paramSubscriptFeedsActivity) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.app.getManager(12);
    if (localWebProcessManager != null) {
      localWebProcessManager.a(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptFeedsActivity", 2, "enter folder preload web process");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msq
 * JD-Core Version:    0.7.0.1
 */