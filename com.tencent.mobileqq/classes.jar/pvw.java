import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;

public class pvw
  implements DialogInterface.OnClickListener
{
  public pvw(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    SmartDevicePluginLoader.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pvw
 * JD-Core Version:    0.7.0.1
 */