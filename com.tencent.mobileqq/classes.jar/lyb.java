import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class lyb
  implements DialogInterface.OnDismissListener
{
  public lyb(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ReadInJoyDeliverUGCActivity.a(this.a, false);
    ThreadManager.getUIHandler().postDelayed(new lyc(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyb
 * JD-Core Version:    0.7.0.1
 */