package com.tencent.qqmini.sdk.server;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager.Stub;
import java.util.HashMap;

public class MiniServiceManagerService
  extends IMiniServiceManager.Stub
{
  private static HashMap<String, IBinder> services;
  
  public MiniServiceManagerService()
  {
    services = new HashMap();
  }
  
  public static IMiniServiceManager asInterface()
  {
    return new MiniServiceManagerService();
  }
  
  public void addService(String paramString, IBinder paramIBinder)
  {
    if (checkService(paramString) == null)
    {
      services.put(paramString, paramIBinder);
      return;
    }
    paramIBinder = new StringBuilder();
    paramIBinder.append("MiniService already exists. ");
    paramIBinder.append(paramString);
    throw new RemoteException(paramIBinder.toString());
  }
  
  public IBinder checkService(String paramString)
  {
    return (IBinder)services.get(paramString);
  }
  
  public IBinder getService(String paramString)
  {
    return (IBinder)services.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.MiniServiceManagerService
 * JD-Core Version:    0.7.0.1
 */