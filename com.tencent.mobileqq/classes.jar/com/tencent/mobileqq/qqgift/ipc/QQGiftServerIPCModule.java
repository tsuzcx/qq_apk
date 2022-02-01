package com.tencent.mobileqq.qqgift.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class QQGiftServerIPCModule
  extends QIPCModule
{
  private QQGiftServerIPCModule()
  {
    super("QQGiftServerIPCModule");
  }
  
  public static QQGiftServerIPCModule a()
  {
    return QQGiftServerIPCModule.Holder.a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action = ");
      localStringBuilder.append(paramString);
      QLog.d("QQGiftServerIPCModule", 2, localStringBuilder.toString());
    }
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("QQGiftServerIPCModule Err params = null, action = ");
      paramBundle.append(paramString);
      QLog.d("QQGiftServerIPCModule", 2, paramBundle.toString());
      return null;
    }
    if (paramString.equals("action_notify_recharge_callback"))
    {
      boolean bool = paramBundle.getBoolean("params_key_success");
      paramInt = paramBundle.getInt("params_key_code", 0);
      paramString = paramBundle.getString("params_key_msg", "");
      int i = paramBundle.getInt("params_key_business_id", 0);
      int j = paramBundle.getInt("params_key_callback_key", 0);
      ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(i).f().a(j, bool, paramInt, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.ipc.QQGiftServerIPCModule
 * JD-Core Version:    0.7.0.1
 */