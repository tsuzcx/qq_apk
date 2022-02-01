package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModuleManager;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class PluginCommunicationHandler$PluginCommunicationChannelImpl
  extends PluginCommunicationChannel.Stub
{
  public PluginCommunicationHandler$PluginCommunicationChannelImpl(PluginCommunicationHandler paramPluginCommunicationHandler) {}
  
  private Bundle transferInner(String paramString, Bundle paramBundle)
  {
    synchronized (PluginCommunicationHandler.access$100(this.this$0))
    {
      paramString = (RemoteCommand)PluginCommunicationHandler.access$100(this.this$0).get(paramString);
      if (paramBundle != null) {
        paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      }
      ??? = null;
      if (paramString != null)
      {
        paramBundle = paramString.invoke(paramBundle, null);
        paramString = paramBundle;
        if (paramBundle != null)
        {
          paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          return paramBundle;
        }
      }
      else
      {
        paramString = ???;
        if (QLog.isColorLevel())
        {
          QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
          paramString = ???;
        }
      }
      return paramString;
    }
  }
  
  public String getNickName()
  {
    if (PluginCommunicationHandler.access$000(this.this$0) == null) {
      return null;
    }
    return PluginCommunicationHandler.access$000(this.this$0).getNickName();
  }
  
  public String getSKey()
  {
    if (PluginCommunicationHandler.access$000(this.this$0) == null) {
      return null;
    }
    return "getSKey";
  }
  
  public String getSid()
  {
    if (PluginCommunicationHandler.access$000(this.this$0) == null) {
      return null;
    }
    return PluginCommunicationHandler.access$000(this.this$0).getSid();
  }
  
  public long getUin()
  {
    if (PluginCommunicationHandler.access$000(this.this$0) == null) {
      return 0L;
    }
    return PluginCommunicationHandler.access$000(this.this$0).getUin();
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    return transferInner(paramString, paramBundle);
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
  {
    EIPCModuleManager.getAsyncHandler().post(new PluginCommunicationHandler.PluginCommunicationChannelImpl.TransferRunnable(this, paramString, paramBundle, paramRemoteCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler.PluginCommunicationChannelImpl
 * JD-Core Version:    0.7.0.1
 */