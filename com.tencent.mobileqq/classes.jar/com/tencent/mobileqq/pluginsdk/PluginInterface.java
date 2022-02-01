package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel.Stub;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PluginInterface
{
  PluginCommunicationChannel mClient;
  
  public void destory()
  {
    this.mClient = null;
  }
  
  public String getNickName()
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return null;
      }
      String str = this.mClient.getNickName();
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, localException, new Object[0]);
      }
    }
    return null;
  }
  
  public String getSKey()
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return null;
      }
      String str = this.mClient.getSKey();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, localRemoteException, new Object[0]);
      }
    }
    return null;
  }
  
  public String getSid()
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return null;
      }
      String str = this.mClient.getSid();
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, localException, new Object[0]);
      }
    }
    return null;
  }
  
  public long getUin()
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return 0L;
      }
      long l = this.mClient.getUin();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, localException, new Object[0]);
      }
    }
    return 0L;
  }
  
  public boolean isValid()
  {
    Object localObject = this.mClient;
    if (localObject != null)
    {
      localObject = ((PluginCommunicationChannel)localObject).asBinder();
      if ((((IBinder)localObject).isBinderAlive()) && (((IBinder)localObject).pingBinder())) {
        return true;
      }
    }
    return false;
  }
  
  void setBinder(IBinder paramIBinder)
  {
    PluginCommunicationChannel localPluginCommunicationChannel;
    if ((paramIBinder != null) && (paramIBinder.isBinderAlive()) && (paramIBinder.pingBinder())) {
      localPluginCommunicationChannel = PluginCommunicationChannel.Stub.asInterface(paramIBinder);
    } else {
      localPluginCommunicationChannel = null;
    }
    this.mClient = localPluginCommunicationChannel;
    try
    {
      paramIBinder.linkToDeath(new PluginInterface.1(this, paramIBinder), 0);
      return;
    }
    catch (Exception paramIBinder)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, paramIBinder, new Object[0]);
      }
    }
  }
  
  public Bundle transfer(String paramString, Bundle paramBundle)
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return null;
      }
      if (paramBundle != null) {
        paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      }
      paramString = this.mClient.transfer(paramString, paramBundle);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public void transferAsync(String paramString, Bundle paramBundle, RemoteResultCallback paramRemoteResultCallback)
  {
    try
    {
      if (!isValid())
      {
        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
        return;
      }
      if (paramBundle != null) {
        paramBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      }
      this.mClient.transferAsync(paramString, paramBundle, paramRemoteResultCallback);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("plugin_tag", 2, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterface
 * JD-Core Version:    0.7.0.1
 */