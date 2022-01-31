import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mnj
  implements DialogInterface.OnClickListener
{
  mnj(mni parammni) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mtq.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mnj
 * JD-Core Version:    0.7.0.1
 */