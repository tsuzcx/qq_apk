import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PopupDialog;

public class mte
  implements DialogInterface.OnClickListener
{
  public mte(PopupDialog paramPopupDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PopupDialog.a.a != null) {
      PopupDialog.a.a.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface.dismiss();
    PopupDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mte
 * JD-Core Version:    0.7.0.1
 */