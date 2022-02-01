package cooperation.qqdataline.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DatalineRemoteManager$5
  implements DialogInterface.OnClickListener
{
  DatalineRemoteManager$5(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.f = true;
    DatalineRemoteManager.a(paramDialogInterface, 1);
    DatalineRemoteManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.5
 * JD-Core Version:    0.7.0.1
 */