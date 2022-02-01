package cooperation.qqdataline.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class DatalineRemoteManager$6
  implements DialogInterface.OnDismissListener
{
  DatalineRemoteManager$6(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      DatalineRemoteManager.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.6
 * JD-Core Version:    0.7.0.1
 */