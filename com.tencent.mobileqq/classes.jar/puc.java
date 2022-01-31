import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class puc
  implements DialogInterface.OnClickListener
{
  public puc(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SmartDevicePluginLoader.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     puc
 * JD-Core Version:    0.7.0.1
 */