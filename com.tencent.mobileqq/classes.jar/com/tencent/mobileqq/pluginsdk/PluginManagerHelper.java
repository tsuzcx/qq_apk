package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class PluginManagerHelper
{
  private static PluginManagerClient a;
  private static ArrayList b = new ArrayList();
  private static RemotePluginManager.Stub c = new i();
  private static ServiceConnection d = new j();
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(d);
  }
  
  private static void e()
  {
    b.clear();
  }
  
  public static void getPluginInterface(Context paramContext, OnPluginManagerLoadedListener paramOnPluginManagerLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManagerHelper.getPluginInterface");
    }
    if ((a == null) || (!a.useful()))
    {
      b.add(new WeakReference(paramOnPluginManagerLoadedListener));
      PluginRemoteProcessor.get().process(paramContext, d, 1);
      return;
    }
    paramOnPluginManagerLoadedListener.onPluginManagerLoaded(a);
  }
  
  public static abstract interface OnPluginManagerLoadedListener
  {
    public abstract void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper
 * JD-Core Version:    0.7.0.1
 */