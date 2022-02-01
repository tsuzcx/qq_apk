package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class QIPCServerModulePlugin
  extends QIPCModule
{
  public static final String ACTION_GET_MANAGE_CLIENT = "qipc_action_manager_client";
  public static final String MODULE_NAME = "qipc_plugin_module";
  public static final String RESULT_CLIENT_BINDER = "plugin_client_binder";
  private static volatile QIPCServerModulePlugin sPluginServer;
  
  public QIPCServerModulePlugin()
  {
    super("qipc_plugin_module");
  }
  
  public static QIPCServerModulePlugin getInstance()
  {
    if (sPluginServer == null) {
      try
      {
        if (sPluginServer == null) {
          sPluginServer = new QIPCServerModulePlugin();
        }
      }
      finally {}
    }
    return sPluginServer;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("qipc_action_manager_client".equals(paramString))
    {
      paramString = new Bundle();
      paramString.putParcelable("plugin_client_binder", new BinderParcelable(PluginManageHandler.getInstance().getBinder()));
      return EIPCResult.createSuccessResult(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.QIPCServerModulePlugin
 * JD-Core Version:    0.7.0.1
 */