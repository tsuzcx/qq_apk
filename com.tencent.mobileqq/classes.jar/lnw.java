import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.gaudio.GaInviteLockActivity;

public class lnw
  implements DialogInterface.OnClickListener
{
  public lnw(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    msa.e(false, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnw
 * JD-Core Version:    0.7.0.1
 */