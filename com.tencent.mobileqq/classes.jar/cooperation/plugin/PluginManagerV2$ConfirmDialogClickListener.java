package cooperation.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class PluginManagerV2$ConfirmDialogClickListener
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  IPluginManager.OnPluginReadyListener jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
  IPluginManager.PluginParams jdField_a_of_type_CooperationPluginIPluginManager$PluginParams;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private PluginManagerV2$ConfirmDialogClickListener(PluginManagerV2 paramPluginManagerV2, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, boolean paramBoolean1, Context paramContext, IPluginManager.PluginParams paramPluginParams, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.b = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return;
      }
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      return;
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    int i = 0;
    if ((!bool) && (this.b)) {
      if (PluginManagerV2.a())
      {
        bool = Dex2Oat.a(this.jdField_a_of_type_JavaLangString);
        if (bool) {
          paramInt = 4;
        } else {
          paramInt = 2;
        }
        i = paramInt;
        if (QLog.isColorLevel())
        {
          paramDialogInterface = new StringBuilder();
          paramDialogInterface.append("dialog needOTA :");
          paramDialogInterface.append(bool);
          QLog.d("plugin_tag", 2, paramDialogInterface.toString());
          i = paramInt;
        }
      }
      else
      {
        i = 2;
      }
    }
    PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, i, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.ConfirmDialogClickListener
 * JD-Core Version:    0.7.0.1
 */