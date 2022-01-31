import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mkp
  implements DialogInterface.OnClickListener
{
  mkp(mko parammko) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mqw.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mkp
 * JD-Core Version:    0.7.0.1
 */