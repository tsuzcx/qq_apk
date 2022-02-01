import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavPanel;

public class lnr
  implements DialogInterface.OnClickListener
{
  public lnr(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mru.e(false, false);
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
 * Qualified Name:     lnr
 * JD-Core Version:    0.7.0.1
 */