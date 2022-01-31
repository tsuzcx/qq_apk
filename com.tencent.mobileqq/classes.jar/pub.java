import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.bind.DevicePluginDownloadActivity;

public class pub
  implements DialogInterface.OnClickListener
{
  public pub(DevicePluginDownloadActivity paramDevicePluginDownloadActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pub
 * JD-Core Version:    0.7.0.1
 */