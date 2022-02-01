import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mso
  implements DialogInterface.OnClickListener
{
  mso(msm parammsm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    msm.a(this.a, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mso
 * JD-Core Version:    0.7.0.1
 */