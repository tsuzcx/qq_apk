package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import eipc.EIPCThreadEngine;
import mqq.app.MobileQQ;

public class QIPCClientHelper
{
  public static final int QIPC_CLIENT_ID = 1;
  public static final String TAG = "QIPCClientHelper";
  static QIPCClientHelper a;
  public static EIPCThreadEngine sThreadEngine;
  public Class adapterService;
  EIPCClient b = null;
  
  public static QIPCClientHelper getInstance()
  {
    try
    {
      if (a == null) {
        a = new QIPCClientHelper();
      }
      QIPCClientHelper localQIPCClientHelper = a;
      return localQIPCClientHelper;
    }
    finally {}
  }
  
  public static void setupThreadEngine(EIPCThreadEngine paramEIPCThreadEngine)
  {
    sThreadEngine = paramEIPCThreadEngine;
  }
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    getClient().callServer(paramString1, paramString2, paramBundle, paramEIPCResultCallback);
  }
  
  public void disconnect()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIPCClientHelper", 2, "disconnect, " + this.b);
    }
    if (this.b != null)
    {
      this.b.disConnect();
      this.b = null;
    }
  }
  
  public EIPCClient getClient()
  {
    try
    {
      if (this.b == null)
      {
        Class localClass = this.adapterService;
        localObject1 = localClass;
        if (localClass == null) {
          localObject1 = QIPCService.class;
        }
        this.b = new EIPCClient(MobileQQ.sMobileQQ, (Class)localObject1, 1);
        this.b.registerModule(new QIPCClientModuleCore());
      }
      Object localObject1 = this.b;
      return localObject1;
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