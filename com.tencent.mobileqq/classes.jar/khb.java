import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.utils.PopupDialogQQSide;

public class khb
  implements DialogInterface.OnDismissListener
{
  public khb(PopupDialogQQSide paramPopupDialogQQSide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    if (this.a.getActivity() != null) {
      this.a.getActivity().doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khb
 * JD-Core Version:    0.7.0.1
 */