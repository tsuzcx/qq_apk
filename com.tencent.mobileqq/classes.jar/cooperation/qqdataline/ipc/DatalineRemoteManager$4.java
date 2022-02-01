package cooperation.qqdataline.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DatalineRemoteManager$4
  implements DialogInterface.OnClickListener
{
  DatalineRemoteManager$4(DatalineRemoteManager paramDatalineRemoteManager) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    paramDialogInterface.f = true;
    DatalineRemoteManager.a(paramDialogInterface, 2);
    DatalineRemoteManager.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.4
 * JD-Core Version:    0.7.0.1
 */