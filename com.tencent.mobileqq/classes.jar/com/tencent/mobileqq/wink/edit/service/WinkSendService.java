package com.tencent.mobileqq.wink.edit.service;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public class WinkSendService
{
  public static final HashMap<String, String> a = new HashMap();
  public static volatile int b = 0;
  private static String c = "WinkSendService";
  
  public static void a(ToServiceMsg paramToServiceMsg, String paramString, Class<? extends MSFServlet> paramClass)
  {
    String str = paramToServiceMsg.getServiceCmd();
    int i = 1;
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setEncodeName("utf-8");
    int j = b;
    b = j + 1;
    localUniPacket.setRequestId(j);
    WinkDataBaseServiceHandler localWinkDataBaseServiceHandler = (WinkDataBaseServiceHandler)QQWinkEnvironment.c().getBusinessHandler(paramString);
    if (localWinkDataBaseServiceHandler.a(paramToServiceMsg, localUniPacket)) {
      paramToServiceMsg.putWupBuffer(localUniPacket.encode());
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramClass = new NewIntent(QQWinkEnvironment.a(), paramClass);
      paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
      paramClass.putExtra("receive_handler", paramString);
      QQWinkEnvironment.c().startServlet(paramClass);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("sendtimekey", l);
      return;
    }
    paramString = new FromServiceMsg(QQWinkEnvironment.b().getCurrentAccountUin(), str);
    if (localWinkDataBaseServiceHandler != null) {
      try
      {
        localWinkDataBaseServiceHandler.onReceive(paramToServiceMsg, paramString, null);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        paramString = c;
        paramClass = new StringBuilder();
        paramClass.append(localWinkDataBaseServiceHandler.getClass().getSimpleName());
        paramClass.append(" onReceive error,");
        WinkQLog.a(paramString, paramClass.toString(), paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.service.WinkSendService
 * JD-Core Version:    0.7.0.1
 */