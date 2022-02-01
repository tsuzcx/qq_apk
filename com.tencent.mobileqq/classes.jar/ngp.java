import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.avgame.ui.AVGameOverlayFragment;

public class ngp
  implements DialogInterface.OnClickListener
{
  public ngp(AVGameOverlayFragment paramAVGameOverlayFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AVGameOverlayFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngp
 * JD-Core Version:    0.7.0.1
 */