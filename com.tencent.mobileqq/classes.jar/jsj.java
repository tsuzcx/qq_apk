import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.UITools;
import java.lang.ref.WeakReference;

public class jsj
  implements DialogInterface.OnClickListener
{
  public jsj(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UITools.a((AVActivity)this.a.a.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsj
 * JD-Core Version:    0.7.0.1
 */