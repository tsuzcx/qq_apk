package com.tencent.mobileqq.mini.servlet;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

public class MiniAppSSOCmdHelper
{
  private static final String TAG = "MiniAppSSOCmdHelper";
  
  public static <REQUEST extends MessageMicro<REQUEST>, RESPONSE extends MessageMicro<RESPONSE>> void sendSSOCmdRequest(@NonNull String paramString1, String paramString2, @NonNull REQUEST paramREQUEST, @NonNull Class<RESPONSE> paramClass, MiniAppSSOCmdHelper.MiniAppCmdCallback<RESPONSE> paramMiniAppCmdCallback)
  {
    if (paramClass == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append("sendSSOCmdRequest response class is null, not send sso request for ");
      paramString2.append(paramString1);
      QLog.e("MiniAppSSOCmdHelper", 2, paramString2.toString());
      return;
    }
    MiniAppSSOCmdObserver.defaultObserver().sendSSOCmdRequest(paramString1, paramString2, paramREQUEST, new MiniAppSSOCmdHelper.1(paramMiniAppCmdCallback, paramClass));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper
 * JD-Core Version:    0.7.0.1
 */