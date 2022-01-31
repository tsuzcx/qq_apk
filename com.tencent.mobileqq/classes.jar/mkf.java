import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.KandianAppInPush;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class mkf
  implements AppInPushNotification.OnDismissListener
{
  public mkf(KandianAppInPush paramKandianAppInPush) {}
  
  public void a(boolean paramBoolean)
  {
    KandianAppInPush.a(this.a, null);
    KandianAppInPush.a(this.a, null);
    if ((paramBoolean) && (KandianAppInPush.a(this.a) != null)) {
      ThreadManager.getSubThreadHandler().postDelayed(new mkg(this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkf
 * JD-Core Version:    0.7.0.1
 */