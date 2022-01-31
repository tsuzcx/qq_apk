package com.tencent.mobileqq.mini.http;

import NS_COMM.COMM.StCommonExt;
import android.util.Log;
import bbma;
import com.tencent.mobileqq.mini.http.httpRequest.HttpCheckNavigateRightRequest;
import com.tencent.mobileqq.mini.http.httpRequest.HttpGetAppInfoByIdRequest;
import com.tencent.mobileqq.mini.http.httpRequest.HttpGetAppInfoByLinkRequest;
import com.tencent.mobileqq.mini.http.httpRequest.HttpGetCodeRequest;
import com.tencent.qphone.base.util.QLog;

public class HttpCmdManager
{
  public static final String SECURITY_URL = "https://q.qq.com/security/bypass_channel";
  public static final String TAG = "HttpCmdManager";
  private static final HttpCmdManager sInstance = new HttpCmdManager();
  
  public static HttpCmdManager g()
  {
    return sInstance;
  }
  
  private void sendRequest(String paramString, HttpProtoBufRequest paramHttpProtoBufRequest, HttpCmdResult paramHttpCmdResult)
  {
    try
    {
      byte[] arrayOfByte1 = paramHttpProtoBufRequest.encode();
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null) {
        arrayOfByte2 = new byte[4];
      }
      MiniappHttpUtil.httpPostV2(paramString, bbma.a(arrayOfByte2), null, new HttpCmdManager.1(this, paramHttpCmdResult, paramHttpProtoBufRequest), null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("HttpCmdManager", 1, "handleRequest Exception: " + Log.getStackTraceString(localException));
        Object localObject = null;
      }
    }
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, String paramString3, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpCheckNavigateRightRequest(paramString1, paramString2);
    sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + paramString3, paramString1, paramHttpCmdResult);
  }
  
  public void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, HttpCmdResult paramHttpCmdResult)
  {
    paramStCommonExt = new HttpGetAppInfoByIdRequest(paramStCommonExt, paramString1, 1, 0, paramString2, paramString3);
    sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + paramString4, paramStCommonExt, paramHttpCmdResult);
  }
  
  public void getAppInfoByLink(String paramString1, int paramInt, String paramString2, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpGetAppInfoByLinkRequest(paramString1, paramInt);
    sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + paramString2, paramString1, paramHttpCmdResult);
  }
  
  public void getCode(String paramString1, String paramString2, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpGetCodeRequest(paramString1);
    sendRequest("https://q.qq.com/security/bypass_channel?forbid_token=" + paramString2, paramString1, paramHttpCmdResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.HttpCmdManager
 * JD-Core Version:    0.7.0.1
 */