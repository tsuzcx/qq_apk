package com.tencent.qqprotect.qsec;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class SecSvcHandlerHelper
{
  private static ConcurrentHashMap<String, SecSvcHandlerHelper.ISecSvcRespListener> a = new ConcurrentHashMap();
  
  public static void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null)
    {
      Object localObject = paramFromServiceMsg.getServiceCmd();
      localObject = (SecSvcHandlerHelper.ISecSvcRespListener)a.get(localObject);
      if (localObject != null) {
        ((SecSvcHandlerHelper.ISecSvcRespListener)localObject).a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static void a(String paramString, SecSvcHandlerHelper.ISecSvcRespListener paramISecSvcRespListener)
  {
    if ((paramString != null) && (paramISecSvcRespListener != null)) {
      a.put(paramString, paramISecSvcRespListener);
    }
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface == null) {
      return false;
    }
    paramString = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    localQQAppInterface.sendToService(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.SecSvcHandlerHelper
 * JD-Core Version:    0.7.0.1
 */