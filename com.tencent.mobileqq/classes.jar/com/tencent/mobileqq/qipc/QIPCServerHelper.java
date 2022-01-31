package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import eipc.EIPCConnection;
import eipc.EIPCModuleManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.Iterator;

public class QIPCServerHelper
{
  static volatile QIPCServerHelper sInstance;
  
  public static QIPCServerHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QIPCServerHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void callClient(String paramString1, String paramString2, String paramString3, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    getServer().callClient(paramString1, 1, paramString2, paramString3, paramBundle, paramEIPCResultCallback);
  }
  
  public EIPCServer getServer()
  {
    return EIPCServer.getServer();
  }
  
  public boolean isModuleRunning(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("module_id", paramString);
    paramString = getServer().getClientConnectionList().iterator();
    while (paramString.hasNext())
    {
      EIPCConnection localEIPCConnection = (EIPCConnection)paramString.next();
      try
      {
        boolean bool = localEIPCConnection.callModule("QIPCClientModuleCore", "isrun", localBundle).isSuccess();
        if (bool) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean isProcessRunning(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    Iterator localIterator = getServer().getClientConnectionList().iterator();
    while (localIterator.hasNext())
    {
      EIPCConnection localEIPCConnection = (EIPCConnection)localIterator.next();
      try
      {
        boolean bool = paramString.equals(localEIPCConnection.procName);
        if (bool) {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
  
  public void notifyOnAccountChanged()
  {
    EIPCModuleManager.excuteOnAsyncThread(new QIPCServerHelper.1(this));
  }
  
  public void register(QIPCModule paramQIPCModule)
  {
    getServer().registerModule(paramQIPCModule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerHelper
 * JD-Core Version:    0.7.0.1
 */