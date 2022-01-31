import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.ui.QavPanel;

public class lod
  implements DialogInterface.OnClickListener
{
  public lod(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mqw.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a != null) && (this.a.a.a != null)) {
        this.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lod
 * JD-Core Version:    0.7.0.1
 */