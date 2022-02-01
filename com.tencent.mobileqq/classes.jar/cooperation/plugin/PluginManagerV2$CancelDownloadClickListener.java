package cooperation.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PluginManagerV2$CancelDownloadClickListener
  implements DialogInterface.OnClickListener
{
  private String b;
  
  private PluginManagerV2$CancelDownloadClickListener(PluginManagerV2 paramPluginManagerV2, String paramString)
  {
    this.b = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2) {
      return;
    }
    this.a.cancelInstall(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.CancelDownloadClickListener
 * JD-Core Version:    0.7.0.1
 */