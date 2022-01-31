import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qeu
  implements DialogInterface.OnDismissListener
{
  public qeu(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ReadInJoyDeliverUGCActivity.b(this.a, false);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverUGCActivity.8.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qeu
 * JD-Core Version:    0.7.0.1
 */