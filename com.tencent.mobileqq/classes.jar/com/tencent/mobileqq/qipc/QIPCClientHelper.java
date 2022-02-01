package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCThreadEngine;
import mqq.app.MobileQQ;

public class QIPCClientHelper
{
  public static final int QIPC_CLIENT_ID = 1;
  public static final String TAG = "QIPCClientHelper";
  static volatile EIPCClient sClient = null;
  static QIPCClientHelper sInstance;
  public static EIPCThreadEngine sThreadEngine;
  
  public static QIPCClientHelper getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new QIPCClientHelper();
      }
      QIPCClientHelper localQIPCClientHelper = sInstance;
      return localQIPCClientHelper;
    }
    finally {}
  }
  
  public static void setupThreadEngine(EIPCThreadEngine paramEIPCThreadEngine)
  {
    sThreadEngine = paramEIPCThreadEngine;
  }
  
  public EIPCResult callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    return getClient().callServer(paramString1, paramString2, paramBundle);
  }
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    getClient().callServer(paramString1, paramString2, paramBundle, paramEIPCResultCallback);
  }
  
  public void disconnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCClientHelper", 2, "disconnect, " + sClient);
    }
    if (sClient != null)
    {
      sClient.disConnect();
      sClient = null;
    }
  }
  
  public EIPCClient getClient()
  {
    if (sClient == null) {}
    try
    {
      if (sClient == null)
      {
        sClient = new EIPCClient(MobileQQ.sMobileQQ, 1);
        sClient.registerModule(new QIPCClientModuleCore());
      }
      return sClient;
    }
    finally {}
  }
  
  public void register(QIPCModule paramQIPCModule)
  {
    getClient().registerModule(paramQIPCModule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCClientHelper
 * JD-Core Version:    0.7.0.1
 */