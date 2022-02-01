package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;

public class VivoPushProcessor$VivoPushMsgReceiverImpl
  extends OpenClientPushMessageReceiver
{
  public void onReceiveRegId(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("onReceiveRegId : ");
      paramContext.append(paramString);
      QLog.d("VPUSH", 2, paramContext.toString());
    }
    if (!TextUtils.isEmpty(paramString)) {
      ThirdPushManager.a().a(paramString);
    }
  }
  
  public void onTransmissionMessage(Context paramContext, UnvarnishedMessage paramUnvarnishedMessage)
  {
    super.onTransmissionMessage(paramContext, paramUnvarnishedMessage);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append(" onTransmissionMessage= ");
      paramContext.append(paramUnvarnishedMessage.getMessage());
      QLog.d("VPUSH", 2, paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor.VivoPushMsgReceiverImpl
 * JD-Core Version:    0.7.0.1
 */