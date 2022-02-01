package cooperation.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class PluginManagerV2$1
  implements DialogInterface.OnClickListener
{
  PluginManagerV2$1(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.onClick(paramDialogInterface, paramInt);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.1
 * JD-Core Version:    0.7.0.1
 */