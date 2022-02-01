package com.tencent.mobileqq.pluginsdk.ipc;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class PluginCommunicationHandler
{
  private static volatile PluginCommunicationHandler sInstance;
  private PluginCommunicationHandler.PluginCommunicationChannelImpl mChannel;
  private HashMap<String, RemoteCommand> mCmdMap = new HashMap();
  private AbstractPluginCommunicationChannel mCustomChannel;
  
  public static final PluginCommunicationHandler getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, "PluginCommunicationHandler.init");
          }
          sInstance = new PluginCommunicationHandler();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public boolean containsCmd(String paramString)
  {
    return this.mCmdMap.containsKey(paramString);
  }
  
  public PluginCommunicationHandler.PluginCommunicationChannelImpl getBinder()
  {
    if (this.mChannel == null) {
      this.mChannel = new PluginCommunicationHandler.PluginCommunicationChannelImpl(this);
    }
    return this.mChannel;
  }
  
  public void register(RemoteCommand paramRemoteCommand)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("register cmd, ");
      ((StringBuilder)???).append(paramRemoteCommand);
      QLog.d("plugin_tag", 2, ((StringBuilder)???).toString());
    }
    if (paramRemoteCommand == null) {
      return;
    }
    synchronized (this.mCmdMap)
    {
      this.mCmdMap.put(paramRemoteCommand.getCmd(), paramRemoteCommand);
      return;
    }
  }
  
  public void setCommunicationChannel(AbstractPluginCommunicationChannel paramAbstractPluginCommunicationChannel)
  {
    this.mCustomChannel = paramAbstractPluginCommunicationChannel;
  }
  
  public void unregister(RemoteCommand paramRemoteCommand)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregister cmd, ");
      localStringBuilder.append(paramRemoteCommand);
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    if (paramRemoteCommand == null) {
      return;
    }
    unregister(paramRemoteCommand.getCmd());
  }
  
  public void unregister(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("unregister cmd, ");
      ((StringBuilder)???).append(paramString);
      QLog.d("plugin_tag", 2, ((StringBuilder)???).toString());
    }
    if (paramString == null) {
      return;
    }
    synchronized (this.mCmdMap)
    {
      this.mCmdMap.remove(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler
 * JD-Core Version:    0.7.0.1
 */