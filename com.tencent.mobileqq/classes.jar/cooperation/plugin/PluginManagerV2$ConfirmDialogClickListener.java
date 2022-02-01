package cooperation.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class PluginManagerV2$ConfirmDialogClickListener
  implements DialogInterface.OnClickListener
{
  IPluginManager.OnPluginReadyListener a;
  boolean b;
  Context c;
  IPluginManager.PluginParams d;
  boolean e;
  String f;
  
  private PluginManagerV2$ConfirmDialogClickListener(PluginManagerV2 paramPluginManagerV2, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, boolean paramBoolean1, Context paramContext, IPluginManager.PluginParams paramPluginParams, boolean paramBoolean2, String paramString)
  {
    this.a = paramOnPluginReadyListener;
    this.b = paramBoolean1;
    this.c = paramContext;
    this.d = paramPluginParams;
    this.e = paramBoolean2;
    this.f = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return;
      }
      PluginManagerV2.a(this.g, 1, this.c, this.d, this.a);
      return;
    }
    boolean bool = this.b;
    int i = 0;
    if ((!bool) && (this.e)) {
      if (PluginManagerV2.e())
      {
        bool = Dex2Oat.a(this.f);
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
    PluginManagerV2.a(this.g, i, this.c, this.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginManagerV2.ConfirmDialogClickListener
 * JD-Core Version:    0.7.0.1
 */