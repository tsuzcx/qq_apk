import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class msv
  implements DialogInterface.OnClickListener
{
  msv(mst parammst) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msv
 * JD-Core Version:    0.7.0.1
 */