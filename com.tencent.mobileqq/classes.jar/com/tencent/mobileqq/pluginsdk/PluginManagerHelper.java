package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PluginManagerHelper
{
  private static RemotePluginManager.Stub mStub = new PluginManagerHelper.1();
  private static PluginManagerClient sClient;
  private static List<WeakReference<PluginManagerHelper.OnPluginManagerLoadedListener>> sListener = Collections.synchronizedList(new ArrayList());
  private static ServiceConnection sSc = new PluginManagerHelper.2();
  
  private static void clear()
  {
    sListener.clear();
  }
  
  public static void destory(Context paramContext)
  {
    PluginRemoteProcessor.get().cancel(sSc);
  }
  
  public static PluginManagerClient getPluginInterface(Context paramContext)
  {
    paramContext = QIPCClientHelper.getInstance().callServer("qipc_plugin_module", "qipc_action_manager_client", null);
    if (paramContext.isSuccess()) {
      return new PluginManagerClient(RemotePluginManager.Stub.asInterface(((BinderParcelable)paramContext.data.getParcelable("plugin_client_binder")).mBinder));
    }
    return new PluginManagerClient(null);
  }
  
  public static void getPluginInterface(Context paramContext, PluginManagerHelper.OnPluginManagerLoadedListener paramOnPluginManagerLoadedListener)
  {
    if (QLog.isColorLevel()) {
      QLog.i("plugin_tag", 2, "PluginManagerHelper.getPluginInterface");
    }
    if ((sClient == null) || (!sClient.useful()))
    {
      sListener.add(new WeakReference(paramOnPluginManagerLoadedListener));
      PluginRemoteProcessor.get().process(paramContext, sSc, 1);
      return;
    }
    paramOnPluginManagerLoadedListener.onPluginManagerLoaded(sClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginManagerHelper
 * JD-Core Version:    0.7.0.1
 */