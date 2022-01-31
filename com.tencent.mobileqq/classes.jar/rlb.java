import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class rlb
  implements DialogInterface.OnDismissListener
{
  public rlb(BridgeModule paramBridgeModule) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!BridgeModule.access$300(this.a)) {}
    BridgeModule.access$302(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlb
 * JD-Core Version:    0.7.0.1
 */