import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;

public class lvm
  implements DialogInterface.OnClickListener
{
  public lvm(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mga.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lvm
 * JD-Core Version:    0.7.0.1
 */