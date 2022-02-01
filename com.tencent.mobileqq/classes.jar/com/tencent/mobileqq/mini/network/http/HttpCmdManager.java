package com.tencent.mobileqq.mini.network.http;

import NS_COMM.COMM.StCommonExt;
import android.util.Log;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpCheckNavigateRightRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByIdRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetAppInfoByLinkRequest;
import com.tencent.mobileqq.mini.network.http.httpRequest.HttpGetCodeRequest;
import com.tencent.mobileqq.utils.WupUtil;
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
    Object localObject1;
    try
    {
      byte[] arrayOfByte = paramHttpProtoBufRequest.encode();
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleRequest Exception: ");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(localException));
      QLog.e("HttpCmdManager", 1, ((StringBuilder)localObject2).toString());
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new byte[4];
    }
    MiniappHttpUtil.httpPostV2(paramString, WupUtil.a((byte[])localObject2), null, new HttpCmdManager.1(this, paramHttpCmdResult, paramHttpProtoBufRequest), null);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, String paramString3, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpCheckNavigateRightRequest(paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("https://q.qq.com/security/bypass_channel?forbid_token=");
    paramString2.append(paramString3);
    sendRequest(paramString2.toString(), paramString1, paramHttpCmdResult);
  }
  
  public void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HttpCmdResult paramHttpCmdResult)
  {
    paramStCommonExt = new HttpGetAppInfoByIdRequest(paramStCommonExt, paramString1, 1, 0, paramString2, paramString3, paramString5);
    paramString1 = new StringBuilder();
    paramString1.append("https://q.qq.com/security/bypass_channel?forbid_token=");
    paramString1.append(paramString4);
    sendRequest(paramString1.toString(), paramStCommonExt, paramHttpCmdResult);
  }
  
  public void getAppInfoByLink(String paramString1, int paramInt, String paramString2, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpGetAppInfoByLinkRequest(paramString1, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://q.qq.com/security/bypass_channel?forbid_token=");
    localStringBuilder.append(paramString2);
    sendRequest(localStringBuilder.toString(), paramString1, paramHttpCmdResult);
  }
  
  public void getCode(String paramString1, String paramString2, HttpCmdResult paramHttpCmdResult)
  {
    paramString1 = new HttpGetCodeRequest(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://q.qq.com/security/bypass_channel?forbid_token=");
    localStringBuilder.append(paramString2);
    sendRequest(localStringBuilder.toString(), paramString1, paramHttpCmdResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.HttpCmdManager
 * JD-Core Version:    0.7.0.1
 */