import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.ui.AVGameOverlayFragment;

public class nev
  implements DialogInterface.OnClickListener
{
  public nev(AVGameOverlayFragment paramAVGameOverlayFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AVGameOverlayFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nev
 * JD-Core Version:    0.7.0.1
 */