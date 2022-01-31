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
  PluginCommunicationChannel a;
  
  void a(IBinder paramIBinder)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramIBinder != null)
    {
      localObject1 = localObject2;
      if (paramIBinder.isBinderAlive())
      {
        localObject1 = localObject2;
        if (paramIBinder.pingBinder()) {
          localObject1 = PluginCommunicationChannel.Stub.asInterface(paramIBinder);
        }
      }
    }
    this.a = ((PluginCommunicationChannel)localObject1);
    try
    {
      paramIBinder.linkToDeath(new d(this, paramIBinder), 0);
      return;
    }
    catch (Exception paramIBinder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("plugin_tag", 2, paramIBinder, new Object[0]);
    }
  }
  
  public void destory()
  {
    this.a = null;
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
      String str = this.a.getNickName();
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
      String str = this.a.getSKey();
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
      String str = this.a.getSid();
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
      long l = this.a.getUin();
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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((PluginCommunicationChannel)localObject).asBinder();
      if ((((IBinder)localObject).isBinderAlive()) && (((IBinder)localObject).pingBinder())) {
        return true;
      }
    }
    return false;
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
      paramString = this.a.transfer(paramString, paramBundle);
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
      this.a.transferAsync(paramString, paramBundle, paramRemoteResultCallback);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginInterface
 * JD-Core Version:    0.7.0.1
 */