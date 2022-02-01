package cooperation.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class PluginManagerV2$CancelDownloadClickListener
  implements DialogInterface.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  private PluginManagerV2$CancelDownloadClickListener(PluginManagerV2 paramPluginManagerV2, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_CooperationPluginPluginManagerV2.cancelInstall(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.CancelDownloadClickListener
 * JD-Core Version:    0.7.0.1
 */