import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mrx
  implements Runnable
{
  private WeakReference a;
  
  public mrx(SubscriptFeedsNewActivity paramSubscriptFeedsNewActivity)
  {
    this.a = new WeakReference(paramSubscriptFeedsNewActivity);
  }
  
  public void run()
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      WebProcessManager localWebProcessManager = (WebProcessManager)((SubscriptFeedsNewActivity)this.a.get()).app.getManager(12);
      if (localWebProcessManager != null) {
        localWebProcessManager.a(1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "enter folder preload web process");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrx
 * JD-Core Version:    0.7.0.1
 */