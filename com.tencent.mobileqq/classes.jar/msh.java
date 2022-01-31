import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PopupDialog;

public class msh
  implements DialogInterface.OnClickListener
{
  public msh(PopupDialog paramPopupDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PopupDialog.a.b != null) {
      PopupDialog.a.b.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface.dismiss();
    PopupDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     msh
 * JD-Core Version:    0.7.0.1
 */