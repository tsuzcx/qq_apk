package com.tencent.qqmini.sdk.core.manager;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.service.RequestProxyDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@MiniKeep
public class HttpServer
{
  private static final String TAG = "HttpServer";
  private static RequestProxyDefault mRequestProxy = new RequestProxyDefault();
  private static Random sRandom = new Random();
  private static boolean useHttpDirectly;
  
  static
  {
    boolean bool;
    if ((!QUAUtil.isAlienApp()) && (!QUAUtil.isDemoApp())) {
      bool = false;
    } else {
      bool = true;
    }
    useHttpDirectly = bool;
  }
  
  private static String getPlatformKey()
  {
    return "test";
  }
  
  private static String getRequestUrl()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Nonce=");
    ((StringBuilder)localObject1).append(sRandom.nextInt());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("PlatformID=");
    ((StringBuilder)localObject2).append(((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId());
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("Timestamp=");
    ((StringBuilder)localObject3).append(System.currentTimeMillis() / 1000L);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("POST /mini/OpenChannel?");
    ((StringBuilder)localObject4).append("Action=input");
    ((StringBuilder)localObject4).append("&");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("&");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("&");
    ((StringBuilder)localObject4).append("SignatureMethod=HmacSHA256");
    ((StringBuilder)localObject4).append("&");
    ((StringBuilder)localObject4).append((String)localObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Signature=");
    localStringBuilder.append(getSignature(((StringBuilder)localObject4).toString()));
    localObject4 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://q.qq.com/mini/OpenChannel?");
    localStringBuilder.append("Action=input");
    localStringBuilder.append("&");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("&");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("&");
    localStringBuilder.append("SignatureMethod=HmacSHA256");
    localStringBuilder.append("&");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append("&");
    localStringBuilder.append((String)localObject4);
    return localStringBuilder.toString();
  }
  
  private static String getSignature(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSignature(). original request = ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("HttpServer", ((StringBuilder)localObject).toString());
      paramString = hmacSHA256(paramString, getPlatformKey());
      if (paramString == null) {
        return null;
      }
      localObject = Base64.encodeToString(paramString, 0);
      int i = ((String)localObject).length() - 1;
      paramString = (String)localObject;
      if (i >= 0)
      {
        paramString = (String)localObject;
        if (((String)localObject).charAt(i) == '\n') {
          paramString = ((String)localObject).substring(0, i);
        }
      }
      paramString = URLEncoder.encode(paramString, "UTF-8");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSignature(). signature = ");
      ((StringBuilder)localObject).append(paramString);
      QMLog.d("HttpServer", ((StringBuilder)localObject).toString());
      return paramString;
    }
    catch (InvalidKeyException paramString) {}catch (UnsupportedEncodingException paramString)
    {
      break label140;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label147;
    }
    paramString.printStackTrace();
    break label151;
    label140:
    paramString.printStackTrace();
    break label151;
    label147:
    paramString.printStackTrace();
    label151:
    return "";
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
      Log.e("HttpServer", "no request data");
      paramSenderListener.onReply(-1, null, "no request data");
      return;
    }
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    try
    {
      localStQWebReq.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (RequestProxy)ProxyManager.get(RequestProxy.class);
      if (useHttpDirectly) {
        paramArrayOfByte = mRequestProxy;
      }
      paramArrayOfByte.request(getRequestUrl(), localStQWebReq.toByteArray(), null, "post", 60, new HttpServer.1(paramSenderListener));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.HttpServer
 * JD-Core Version:    0.7.0.1
 */