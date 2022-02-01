package com.tencent.mobileqq.vas.api;

import QC.LoginInfo;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class IJce$Util
{
  public static LoginInfo a()
  {
    try
    {
      Object localObject = VasUtil.a();
      if (localObject == null) {
        return null;
      }
      String str = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = ((String)localObject);
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = DeviceInfoUtil.c();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e("IJce", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(ToServiceMsg paramToServiceMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramToServiceMsg.getServiceCmd());
    localStringBuilder.append("_");
    localStringBuilder.append(paramToServiceMsg.extraData.get(BaseBusinessHandler.SEQ_KEY));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IJce.Util
 * JD-Core Version:    0.7.0.1
 */