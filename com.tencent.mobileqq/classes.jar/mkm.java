import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mkm
  implements DialogInterface.OnClickListener
{
  mkm(mkl parammkl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mqw.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkm
 * JD-Core Version:    0.7.0.1
 */