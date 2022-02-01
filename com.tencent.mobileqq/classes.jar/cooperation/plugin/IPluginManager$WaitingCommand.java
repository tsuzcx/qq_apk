package cooperation.plugin;

import android.content.Context;

final class IPluginManager$WaitingCommand
{
  Context a;
  IPluginManager.PluginParams b;
  IPluginManager.OnPluginReadyListener c;
  
  IPluginManager$WaitingCommand(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    this.a = paramContext;
    this.b = paramPluginParams;
    this.c = paramOnPluginReadyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.IPluginManager.WaitingCommand
 * JD-Core Version:    0.7.0.1
 */