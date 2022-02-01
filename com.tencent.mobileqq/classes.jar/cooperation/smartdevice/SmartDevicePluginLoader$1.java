package cooperation.smartdevice;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class SmartDevicePluginLoader$1
  implements DialogInterface.OnDismissListener
{
  SmartDevicePluginLoader$1(SmartDevicePluginLoader paramSmartDevicePluginLoader, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnDismissListener localOnDismissListener = this.a;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginLoader.1
 * JD-Core Version:    0.7.0.1
 */