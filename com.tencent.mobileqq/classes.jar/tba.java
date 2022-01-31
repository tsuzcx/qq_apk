import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.MainFragment;

public class tba
  implements DialogInterface.OnDismissListener
{
  public tba(MainFragment paramMainFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tba
 * JD-Core Version:    0.7.0.1
 */