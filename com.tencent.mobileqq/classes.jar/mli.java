import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mli
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mru.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mli
 * JD-Core Version:    0.7.0.1
 */