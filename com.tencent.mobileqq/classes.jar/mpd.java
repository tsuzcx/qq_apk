import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class mpd
  implements DialogInterface.OnClickListener
{
  mpd(mpb parammpb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mpd
 * JD-Core Version:    0.7.0.1
 */