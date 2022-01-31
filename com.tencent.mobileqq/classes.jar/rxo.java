import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;

public class rxo
  implements DialogInterface.OnDismissListener
{
  public rxo(BridgeModule paramBridgeModule) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!BridgeModule.access$300(this.a)) {}
    BridgeModule.access$302(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rxo
 * JD-Core Version:    0.7.0.1
 */