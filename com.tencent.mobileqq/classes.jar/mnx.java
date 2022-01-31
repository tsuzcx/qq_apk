import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mnx
  implements DialogInterface.OnClickListener
{
  mnx(mnv parammnv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnx
 * JD-Core Version:    0.7.0.1
 */