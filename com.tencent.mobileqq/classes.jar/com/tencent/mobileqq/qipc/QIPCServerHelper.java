package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import eipc.EIPCConnection;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class QIPCServerHelper
{
  static QIPCServerHelper a;
  EIPCServer b = null;
  
  public static QIPCServerHelper getInstance()
  {
    try
    {
      if (a == null) {
        a = new QIPCServerHelper();
      }
      QIPCServerHelper localQIPCServerHelper = a;
      return localQIPCServerHelper;
    }
    finally {}
  }
  
  public void callClient(String paramString1, String paramString2, String paramString3, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    getServer().callClient(paramString1, 1, paramString2, paramString3, paramBundle, paramEIPCResultCallback);
  }
  
  public EIPCServer getServer()
  {
    try
    {
      if (this.b == null) {
        this.b = new EIPCServer(MobileQQ.sMobileQQ);
      }
      EIPCServer localEIPCServer = this.b;
      return localEIPCServer;
    }
    finally {}
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
  
  public void register(QIPCModule paramQIPCModule)
  {
    getServer().registerModule(paramQIPCModule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerHelper
 * JD-Core Version:    0.7.0.1
 */