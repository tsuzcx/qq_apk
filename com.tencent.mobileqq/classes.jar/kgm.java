import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.utils.PopupDialogQQSide;

public class kgm
  implements DialogInterface.OnDismissListener
{
  public kgm(PopupDialogQQSide paramPopupDialogQQSide) {}
  
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
 * Qualified Name:     kgm
 * JD-Core Version:    0.7.0.1
 */