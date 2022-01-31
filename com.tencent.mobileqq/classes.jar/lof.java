import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.gaudio.GaInviteLockActivity;

public class lof
  implements DialogInterface.OnClickListener
{
  public lof(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mqw.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lof
 * JD-Core Version:    0.7.0.1
 */