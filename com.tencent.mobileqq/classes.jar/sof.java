import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class sof
  implements DialogInterface.OnDismissListener
{
  public sof(BridgeModule paramBridgeModule) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!BridgeModule.access$300(this.a)) {}
    BridgeModule.access$302(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */