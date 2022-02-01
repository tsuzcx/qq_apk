import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavPanel;

public class lnu
  implements DialogInterface.OnClickListener
{
  public lnu(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    msa.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a != null) && (this.a.a.a != null)) {
        this.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnu
 * JD-Core Version:    0.7.0.1
 */