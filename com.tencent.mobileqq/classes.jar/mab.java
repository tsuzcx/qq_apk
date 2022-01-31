import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mab
  implements DialogInterface.OnClickListener
{
  mab(maa parammaa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mga.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mab
 * JD-Core Version:    0.7.0.1
 */