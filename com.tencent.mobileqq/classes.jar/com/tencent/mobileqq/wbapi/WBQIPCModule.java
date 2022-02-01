package com.tencent.mobileqq.wbapi;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class WBQIPCModule
  extends QIPCModule
{
  private static volatile WBQIPCModule a;
  
  private WBQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static WBQIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new WBQIPCModule("weibo_qipc_module");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.d("WeiBoQIPCModule", 1, "onCall main proc action : " + paramString);
    if ("action_install_weibo_sdk".equals(paramString))
    {
      WBShareHelper.a(3);
      callbackResult(paramInt, EIPCResult.createSuccessResult(new Bundle()));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wbapi.WBQIPCModule
 * JD-Core Version:    0.7.0.1
 */