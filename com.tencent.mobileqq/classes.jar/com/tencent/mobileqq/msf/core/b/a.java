package com.tencent.mobileqq.msf.core.b;

import android.util.Base64;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class a
{
  private static final String a = "JCPTZXEZ";
  
  public static String a(FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("FromServiceMsg");
      localStringBuilder.append(" msName:");
      localStringBuilder.append(paramFromServiceMsg.getMsfCommand());
      localStringBuilder.append(" ssoSeq:");
      localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" failCode:");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      localStringBuilder.append(" errorMsg:");
      localStringBuilder.append(paramFromServiceMsg.getBusinessFailMsg());
      localStringBuilder.append(" uin:");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
      localStringBuilder.append(" serviceCmd:");
      String str2 = paramFromServiceMsg.getServiceCmd();
      String str1 = str2;
      if (!QLog.isDebugVersion()) {
        str1 = a(str2);
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" appId:");
      localStringBuilder.append(paramFromServiceMsg.getAppId());
      localStringBuilder.append(" appSeq:");
      localStringBuilder.append(paramFromServiceMsg.getAppSeq());
      paramFromServiceMsg = localStringBuilder.toString();
      return paramFromServiceMsg;
    }
    catch (Exception paramFromServiceMsg)
    {
      label163:
      break label163;
    }
    return "FSM toString error";
  }
  
  public static String a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("ToServiceMsg");
      localStringBuilder.append(" msName:");
      localStringBuilder.append(paramToServiceMsg.getMsfCommand());
      localStringBuilder.append(" ssoSeq:");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      localStringBuilder.append(" appId:");
      localStringBuilder.append(paramToServiceMsg.getAppId());
      localStringBuilder.append(" appSeq:");
      localStringBuilder.append(paramToServiceMsg.getAppSeq());
      localStringBuilder.append(" uin:");
      localStringBuilder.append(MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()));
      localStringBuilder.append(" sCmd:");
      String str2 = paramToServiceMsg.getServiceCmd();
      String str1 = str2;
      if (!QLog.isDebugVersion()) {
        str1 = a(str2);
      }
      localStringBuilder.append(str1);
      localStringBuilder.append(" t:");
      localStringBuilder.append(paramToServiceMsg.getTimeout());
      localStringBuilder.append(" needResp:");
      localStringBuilder.append(paramToServiceMsg.isNeedCallback());
      localStringBuilder.append(" needQuickSend:");
      localStringBuilder.append(paramToServiceMsg.isQuickSendEnable());
      localStringBuilder.append(" strategy:");
      localStringBuilder.append(paramToServiceMsg.getQuickSendStrategy());
      localStringBuilder.append("IsSupportRetry");
      localStringBuilder.append(paramToServiceMsg.isSupportRetry());
      paramToServiceMsg = localStringBuilder.toString();
      return paramToServiceMsg;
    }
    catch (Throwable paramToServiceMsg)
    {
      label211:
      break label211;
    }
    return "TSM toString error";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Base64.encodeToString(a(paramString.getBytes(), "JCPTZXEZ"), 3);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramString = paramString.toCharArray();
        int j = paramArrayOfByte.length;
        byte[] arrayOfByte = new byte[j];
        int i = 0;
        while (i < j)
        {
          arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramString[(i % paramString.length)]));
          i += 1;
        }
        return arrayOfByte;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LogUtils", 2, "xor Exception! ", paramString);
        }
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.b.a
 * JD-Core Version:    0.7.0.1
 */