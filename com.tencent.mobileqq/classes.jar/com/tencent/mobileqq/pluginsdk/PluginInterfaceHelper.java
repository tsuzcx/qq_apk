package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PluginInterfaceHelper
{
  private static PluginInterface sInterface;
  private static WeakReference<PluginInterfaceHelper.OnPluginInterfaceLoadedListener> sListener;
  private static ServiceConnection sSc = new PluginInterfaceHelper.1();
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(sSc);
  }
  
  public static void getPluginInterface(Context paramContext, PluginInterfaceHelper.OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginInterfaceHelper.getPluginInterface");
    }
    PluginInterface localPluginInterface = sInterface;
    if ((localPluginInterface == null) || (!localPluginInterface.isValid()))
    {
      sListener = new WeakReference(paramOnPluginInterfaceLoadedListener);
      PluginRemoteProcessor.get().process(paramContext, sSc, 0);
    }
    while (paramOnPluginInterfaceLoadedListener == null) {
      return;
    }
    paramOnPluginInterfaceLoadedListener.onPluginInterfaceLoaded(localPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */