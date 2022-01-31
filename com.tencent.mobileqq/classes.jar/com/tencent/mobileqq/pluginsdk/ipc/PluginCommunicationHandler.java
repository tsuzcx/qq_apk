package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public final class PluginCommunicationHandler
{
  private static volatile PluginCommunicationHandler e;
  private HashMap a = new HashMap();
  private PluginCommunicationChannelImpl b;
  private Handler c;
  private AbstractPluginCommunicationChannel d;
  
  private PluginCommunicationHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("ipc_async_cmd_invoker", 10);
    localHandlerThread.start();
    this.c = new Handler(localHandlerThread.getLooper());
  }
  
  public static final PluginCommunicationHandler getInstance()
  {
    if (e == null) {}
    try
    {
      if (e == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("plugin_tag", 2, "PluginCommunicationHandler.init");
        }
        e = new PluginCommunicationHandler();
      }
      return e;
    }
    finally {}
  }
  
  public boolean containsCmd(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public PluginCommunicationChannelImpl getBinder()
  {
    if (this.b == null) {
      this.b = new PluginCommunicationChannelImpl();
    }
    return this.b;
  }
  
  public void register(RemoteCommand paramRemoteCommand)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "register cmd, " + paramRemoteCommand);
    }
    if (paramRemoteCommand == null) {
      return;
    }
    synchronized (this.a)
    {
      this.a.put(paramRemoteCommand.getCmd(), paramRemoteCommand);
      return;
    }
  }
  
  public void setCommunicationChannel(AbstractPluginCommunicationChannel paramAbstractPluginCommunicationChannel)
  {
    this.d = paramAbstractPluginCommunicationChannel;
  }
  
  public void unregister(RemoteCommand paramRemoteCommand)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "unregister cmd, " + paramRemoteCommand);
    }
    if (paramRemoteCommand == null) {
      return;
    }
    unregister(paramRemoteCommand.getCmd());
  }
  
  public void unregister(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "unregister cmd, " + paramString);
    }
    if (paramString == null) {
      return;
    }
    synchronized (this.a)
    {
      this.a.remove(paramString);
      return;
    }
  }
  
  public class PluginCommunicationChannelImpl
    extends PluginCommunicationChannel.Stub
  {
    public PluginCommunicationChannelImpl() {}
    
    private Bundle a(String paramString, Bundle paramBundle)
    {
      synchronized (PluginCommunicationHandler.c(PluginCommunicationHandler.this))
      {
        paramString = (RemoteCommand)PluginCommunicationHandler.c(PluginCommunicationHandler.this).get(paramString);
        if (paramBundle != null) {
          paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        if (paramString != null)
        {
          paramString = paramString.invoke(paramBundle, null);
          if (paramString != null) {
            paramString.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          }
          return paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
      }
      return null;
    }
    
    public String getNickName()
      throws RemoteException
    {
      if (PluginCommunicationHandler.a(PluginCommunicationHandler.this) == null) {
        return null;
      }
      return PluginCommunicationHandler.a(PluginCommunicationHandler.this).getNickName();
    }
    
    public String getSKey()
      throws RemoteException
    {
      if (PluginCommunicationHandler.a(PluginCommunicationHandler.this) == null) {
        return null;
      }
      return "getSKey";
    }
    
    public String getSid()
      throws RemoteException
    {
      if (PluginCommunicationHandler.a(PluginCommunicationHandler.this) == null) {
        return null;
      }
      return PluginCommunicationHandler.a(PluginCommunicationHandler.this).getSid();
    }
    
    public long getUin()
      throws RemoteException
    {
      if (PluginCommunicationHandler.a(PluginCommunicationHandler.this) == null) {
        return 0L;
      }
      return PluginCommunicationHandler.a(PluginCommunicationHandler.this).getUin();
    }
    
    public Bundle transfer(String paramString, Bundle paramBundle)
      throws RemoteException
    {
      return a(paramString, paramBundle);
    }
    
    public void transferAsync(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
      throws RemoteException
    {
      PluginCommunicationHandler.b(PluginCommunicationHandler.this).post(new a(paramString, paramBundle, paramRemoteCallback));
    }
    
    private class a
      implements Runnable
    {
      private String b;
      private RemoteCallback c;
      private Bundle d;
      private RemoteCommand.OnInvokeFinishLinstener e;
      
      a(String paramString, Bundle paramBundle, RemoteCallback paramRemoteCallback)
      {
        this.b = paramString;
        this.c = paramRemoteCallback;
        this.d = paramBundle;
        if (this.d != null) {
          this.d.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        if (this.c != null) {
          this.e = new b(this, PluginCommunicationHandler.PluginCommunicationChannelImpl.this);
        }
      }
      
      public void run()
      {
        do
        {
          synchronized (PluginCommunicationHandler.c(PluginCommunicationHandler.this))
          {
            RemoteCommand localRemoteCommand = (RemoteCommand)PluginCommunicationHandler.c(PluginCommunicationHandler.this).get(this.b);
            if (QLog.isColorLevel()) {
              QLog.d("plugin_tag", 2, "tranferAsync," + localRemoteCommand);
            }
            if (localRemoteCommand == null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "no cmd found to invoke, have you already register?");
              }
              return;
            }
          }
          if (!localObject2.isSynchronized()) {
            break;
          }
          ??? = PluginCommunicationHandler.PluginCommunicationChannelImpl.a(PluginCommunicationHandler.PluginCommunicationChannelImpl.this, this.b, this.d);
          if (??? != null) {}
          try
          {
            ((Bundle)???).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            this.c.onRemoteCallback((Bundle)???);
            return;
          }
          catch (RemoteException localRemoteException) {}
        } while (!QLog.isColorLevel());
        QLog.w("plugin_tag", 2, "tranferAsync ", localRemoteException);
        return;
        localObject2.invoke(this.d, this.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler
 * JD-Core Version:    0.7.0.1
 */