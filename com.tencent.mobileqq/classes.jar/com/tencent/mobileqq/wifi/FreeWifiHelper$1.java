package com.tencent.mobileqq.wifi;

import MWIFI.SCGet3rdCloudCheck;
import android.content.Context;
import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.WifiSdkObserver;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class FreeWifiHelper$1
  extends FreeWifiHelper.WifiSecurityCheckListener
{
  FreeWifiHelper$1(Context paramContext, String paramString, QQAppInterface paramQQAppInterface, WifiSdkObserver paramWifiSdkObserver) {}
  
  public void a(int paramInt)
  {
    if (1 == paramInt)
    {
      QQAppInterface localQQAppInterface = this.c;
      if (localQQAppInterface != null) {
        localQQAppInterface.removeObserver(this.d);
      }
    }
  }
  
  public void a(SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startCheck onGetWifiSecurityCheckInfo, result: ");
      ((StringBuilder)localObject).append(paramSCGet3rdCloudCheck);
      QLog.i("WifiSdk", 2, ((StringBuilder)localObject).toString());
    }
    if (paramSCGet3rdCloudCheck != null)
    {
      if (paramSCGet3rdCloudCheck.delayHour > 24) {
        WifiSdkSharedPreUtils.a(this.a, this.b, paramSCGet3rdCloudCheck.delayHour);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startCheck onGetWifiSecurityCheckInfo, tips: ");
        ((StringBuilder)localObject).append(paramSCGet3rdCloudCheck.tips);
        ((StringBuilder)localObject).append(" tipsType: ");
        ((StringBuilder)localObject).append(paramSCGet3rdCloudCheck.tipsType);
        ((StringBuilder)localObject).append(" delayHour: ");
        ((StringBuilder)localObject).append(paramSCGet3rdCloudCheck.delayHour);
        ((StringBuilder)localObject).append(" URL: ");
        ((StringBuilder)localObject).append(paramSCGet3rdCloudCheck.h5);
        QLog.i("WifiSdk", 2, ((StringBuilder)localObject).toString());
      }
      localObject = this.c;
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        Message localMessage = ((MqqHandler)localObject).obtainMessage(1134063);
        localMessage.obj = paramSCGet3rdCloudCheck;
        ((MqqHandler)localObject).sendMessage(localMessage);
        FreeWifiHelper.b(this.a, 398677);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.1
 * JD-Core Version:    0.7.0.1
 */