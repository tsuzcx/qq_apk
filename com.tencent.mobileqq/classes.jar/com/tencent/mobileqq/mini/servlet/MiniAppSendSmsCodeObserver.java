package com.tencent.mobileqq.mini.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_0x87a.RspBody;
import tencent.im.oidb.oidb_0x87c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class MiniAppSendSmsCodeObserver
  implements BusinessObserver
{
  private static final String TAG = "MiniAppSendSmsCodeObserver";
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("cmd");
    if (!paramBoolean) {}
    try
    {
      localObject = paramBundle.getString("dataErrorMsg", "");
      paramInt = paramBundle.getInt("dataErrorCode");
      QLog.e("MiniAppSendSmsCodeObserver", 1, "MiniAppSendSmsCodeObserver onReceive error, code is : " + paramInt + ", error msg is : " + (String)localObject + " cmd is : " + str);
      onFailedResponse(str, paramInt, (String)localObject);
      return;
    }
    catch (Throwable paramBundle)
    {
      onFailedResponse(str, -1, paramBundle.getMessage());
      return;
    }
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null)
    {
      QLog.e("MiniAppSendSmsCodeObserver", 1, "MiniAppSendSmsCodeObserver onReceive success but data is null");
      onFailedResponse(str, -1, "data is null");
      return;
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramBundle);
    paramInt = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
    if (paramInt != 0)
    {
      paramBundle = ((oidb_sso.OIDBSSOPkg)localObject).str_error_msg.get();
      onFailedResponse(str, paramInt, paramBundle);
      QLog.e("MiniAppSendSmsCodeObserver", 1, "sso result error, ret : " + paramInt + "  error : " + paramBundle);
      return;
    }
    paramBundle = ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray();
    if ("OidbSvc.0x87a_112".equals(str))
    {
      localObject = new oidb_0x87a.RspBody();
      ((oidb_0x87a.RspBody)localObject).mergeFrom(paramBundle);
      sendSmsCodeSuccess((oidb_0x87a.RspBody)localObject);
      return;
    }
    if ("OidbSvc.0x87c_112".equals(str))
    {
      localObject = new oidb_0x87c.RspBody();
      ((oidb_0x87c.RspBody)localObject).mergeFrom(paramBundle);
      verifySmsCodeSuccess((oidb_0x87c.RspBody)localObject);
    }
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody) {}
  
  public void verifySmsCodeSuccess(oidb_0x87c.RspBody paramRspBody) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeObserver
 * JD-Core Version:    0.7.0.1
 */