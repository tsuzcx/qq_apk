package com.tencent.qqmini.sdk.core.proxy.service;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HttpServer
{
  private static final String TAG = "HttpServer";
  private static Random sRandom = new Random();
  
  private static String getPlatformKey()
  {
    return "test";
  }
  
  private static String getRequestUrl()
  {
    String str1 = "Nonce=" + sRandom.nextInt();
    String str2 = "PlatformID=" + ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
    String str3 = "Timestamp=" + System.currentTimeMillis() / 1000L;
    Object localObject = new StringBuilder().append("POST /mini/OpenChannel?").append("Action=input").append("&").append(str1).append("&").append(str2).append("&").append("SignatureMethod=HmacSHA256").append("&").append(str3);
    localObject = "Signature=" + getSignature(((StringBuilder)localObject).toString());
    return "https://q.qq.com/mini/OpenChannel?" + "Action=input" + "&" + str1 + "&" + str2 + "&" + "SignatureMethod=HmacSHA256" + "&" + str3 + "&" + (String)localObject;
  }
  
  private static String getSignature(String paramString)
  {
    try
    {
      QMLog.d("HttpServer", "getSignature(). original request = " + paramString);
      paramString = hmacSHA256(paramString, getPlatformKey());
      if (paramString == null) {
        return null;
      }
      String str = Base64.encodeToString(paramString, 0);
      int i = str.length() - 1;
      paramString = str;
      if (i >= 0)
      {
        paramString = str;
        if (str.charAt(i) == '\n') {
          paramString = str.substring(0, i);
        }
      }
      paramString = URLEncoder.encode(paramString, "UTF-8");
      QMLog.d("HttpServer", "getSignature(). signature = " + paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static byte[] hmacSHA256(String paramString1, String paramString2)
  {
    Mac localMac = Mac.getInstance("HmacSHA256");
    localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
    return localMac.doFinal(paramString1.getBytes());
  }
  
  public static void sendData(byte[] paramArrayOfByte, MiniAppProxy.SenderListener paramSenderListener)
  {
    if (paramArrayOfByte == null)
    {
      Log.e("FakeServer", "no request data");
      paramSenderListener.onReply(-1, null, "no request data");
      return;
    }
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    try
    {
      localStQWebReq.mergeFrom(paramArrayOfByte);
      ((RequestProxy)ProxyManager.get(RequestProxy.class)).request(getRequestUrl(), localStQWebReq.toByteArray(), null, "post", 60, new HttpServer.1(paramSenderListener));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.HttpServer
 * JD-Core Version:    0.7.0.1
 */