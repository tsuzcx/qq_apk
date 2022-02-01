import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.av.utils.PopupDialogQQSide;

public class mtj
  implements DialogInterface.OnDismissListener
{
  public mtj(PopupDialogQQSide paramPopupDialogQQSide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
    if (this.a.getActivity() != null)
    {
      this.a.getActivity().doOnBackPressed();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtj
 * JD-Core Version:    0.7.0.1
 */