import android.app.Activity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class tez
  implements Runnable
{
  private WeakReference a;
  private WeakReference b;
  
  public tez(Activity paramActivity, FormSimpleItem paramFormSimpleItem)
  {
    this.a = new WeakReference(paramFormSimpleItem);
    this.b = new WeakReference(paramActivity);
  }
  
  public void run()
  {
    boolean bool1 = JumpQqPimSecureUtil.a(MobileQQ.sMobileQQ);
    boolean bool2 = JumpQqPimSecureUtil.b(MobileQQ.sMobileQQ);
    if (!bool1)
    {
      i = LoginInfoActivity.a();
      if (i == LoginInfoActivity.c()) {
        break label85;
      }
    }
    label85:
    for (int i = 2131436666;; i = 2131436667)
    {
      Activity localActivity = (Activity)this.b.get();
      if (localActivity != null) {
        localActivity.runOnUiThread(new tfb(i, this.a));
      }
      return;
      if (!bool2)
      {
        i = LoginInfoActivity.b();
        break;
      }
      i = LoginInfoActivity.c();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tez
 * JD-Core Version:    0.7.0.1
 */