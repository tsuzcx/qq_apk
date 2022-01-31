package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PluginInterfaceHelper
{
  private static PluginInterface a;
  private static WeakReference b;
  private static ServiceConnection c = new e();
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(c);
  }
  
  public static void getPluginInterface(Context paramContext, OnPluginInterfaceLoadedListener paramOnPluginInterfaceLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginInterfaceHelper.getPluginInterface");
    }
    PluginInterface localPluginInterface = a;
    if ((localPluginInterface == null) || (!localPluginInterface.isValid()))
    {
      b = new WeakReference(paramOnPluginInterfaceLoadedListener);
      PluginRemoteProcessor.get().process(paramContext, c, 0);
    }
    while (paramOnPluginInterfaceLoadedListener == null) {
      return;
    }
    paramOnPluginInterfaceLoadedListener.onPluginInterfaceLoaded(localPluginInterface);
  }
  
  public static abstract interface OnPluginInterfaceLoadedListener
  {
    public abstract void onPluginInterfaceLoaded(PluginInterface paramPluginInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper
 * JD-Core Version:    0.7.0.1
 */