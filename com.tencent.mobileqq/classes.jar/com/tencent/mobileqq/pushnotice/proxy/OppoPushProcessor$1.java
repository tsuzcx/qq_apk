package com.tencent.mobileqq.pushnotice.proxy;

import com.heytap.msp.push.callback.ICallBackResultService;
import com.tencent.qphone.base.util.QLog;

class OppoPushProcessor$1
  implements ICallBackResultService
{
  OppoPushProcessor$1(OppoPushProcessor paramOppoPushProcessor) {}
  
  public void onGetNotificationStatus(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QLog.d("OPUSH", 1, "onGetNotificationStatus OK");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetNotificationStatus error code:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",status=");
    localStringBuilder.append(paramInt2);
    QLog.e("OPUSH", 1, localStringBuilder.toString());
  }
  
  public void onGetPushStatus(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      QLog.d("OPUSH", 1, "onGetPushStatus OK");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPushStatus error code:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",status=");
    localStringBuilder.append(paramInt2);
    QLog.e("OPUSH", 1, localStringBuilder.toString());
  }
  
  public void onRegister(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      this.a.a(paramString);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRegister code:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",msg=");
      localStringBuilder.append(paramString);
      QLog.d("OPUSH", 1, localStringBuilder.toString());
    }
  }
  
  public void onSetPushTime(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSetPushTime code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramString);
    QLog.d("OPUSH", 1, localStringBuilder.toString());
  }
  
  public void onUnRegister(int paramInt)
  {
    if (paramInt == 0)
    {
      QLog.d("OPUSH", 1, "onUnRegister succeed");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnRegister error code = ");
    localStringBuilder.append(paramInt);
    QLog.e("OPUSH", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.OppoPushProcessor.1
 * JD-Core Version:    0.7.0.1
 */