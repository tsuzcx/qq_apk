import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;

public class jrd
  implements Runnable
{
  public jrd(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void run()
  {
    this.a.c.setText(this.a.getResources().getString(2131429562));
    this.a.a.a(1);
    this.a.a(this.a.b, false, 2130840125);
    this.a.b.setClickable(true);
    if (CallbackWaitingActivityExt.a(this.a) != null)
    {
      CallbackWaitingActivityExt.a(this.a).a().a().b = 2;
      CallbackWaitingActivityExt.a(this.a).a().e(true);
      CallbackWaitingActivityExt.a(this.a).a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrd
 * JD-Core Version:    0.7.0.1
 */