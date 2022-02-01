package com.tencent.mobileqq.mini.network.http;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONObject;

public class MiniappHttpUtil
{
  public static final int C_TIME_OUT = 60000;
  public static final String HTTP_GET = "GET";
  public static final String HTTP_POST = "POST";
  public static final int LOCAL_RET_CODE_ABORTED = -5;
  public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
  public static final int LOCAL_RET_CODE_CONNECT = -2;
  public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
  public static final int LOCAL_RET_CODE_CONNECT_NOT_OPEN = 50007;
  public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
  public static final int LOCAL_RET_CODE_CONNECT_REFUSED = 50006;
  public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
  public static final int LOCAL_RET_CODE_CONTENT_LENGTH_VALID = 50002;
  public static final int LOCAL_RET_CODE_EXCEPTION = -1;
  public static final int LOCAL_RET_CODE_EXP = 4;
  public static final int LOCAL_RET_CODE_FNF_EXP = 1;
  public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT_360WIFI = 50001;
  public static final int LOCAL_RET_CODE_ILL_EXP = 5;
  public static final int LOCAL_RET_CODE_IO_EXP = 2;
  public static final int LOCAL_RET_CODE_METHOD_NOT_SUPPORT = -3;
  public static final int LOCAL_RET_CODE_NETWORK_UNREACHABLE = 50004;
  public static final int LOCAL_RET_CODE_NOSPACE_LEFT_ON_DEVICE = 50003;
  public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
  public static final int LOCAL_RET_CODE_NO_ROUTE_TO_HOST = 50005;
  public static final int LOCAL_RET_CODE_OOM_ERR = 3;
  public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
  public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
  public static final int LOCAL_RET_CODE_SSL_HANDSHAKE_EXP = 15;
  public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
  public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
  public static final int LOCAL_RET_CODE_URL_INVALID = -4;
  public static final int R_TIMEOUT = 60000;
  private static final String TAG = "MiniappHttpUtil";
  private static ConcurrentHashMap<String, HttpURLConnection> uploadMap = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, ArrayList<MiniappHttpUtil.UploadTask>> uploadMapV2 = new ConcurrentHashMap();
  
  private static Request buildRequest(String paramString1, String[] paramArrayOfString, String paramString2, MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Request.Builder localBuilder = new Request.Builder();
    Object localObject = null;
    if (paramArrayOfString != null)
    {
      String str1 = null;
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (i % 2 == 0)
        {
          str1 = paramArrayOfString[i];
        }
        else
        {
          String str2 = paramArrayOfString[i];
          try
          {
            localBuilder.addHeader(str1, str2);
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("areqBuilder.addHeader.error: ");
            localStringBuilder.append(localThrowable);
            QLog.e("MiniappHttpUtil", 1, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    localBuilder.url(paramString1);
    if ("GET".equals(paramString2))
    {
      localBuilder.get();
    }
    else
    {
      paramString1 = localObject;
      if (HttpMethod.requiresRequestBody(paramString2))
      {
        paramString1 = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          paramString1 = new byte[0];
        }
        paramString1 = RequestBody.create(paramMediaType, paramString1);
      }
      localBuilder.method(paramString2, paramString1);
    }
    return localBuilder.build();
  }
  
  public static void fillErrMsg(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if ((paramInt == -5) || ((paramInt != -3) && (paramInt != -2))) {}
    try
    {
      paramJSONObject.put("errMsg", "unknown reason");
      return;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder;
      break label86;
    }
    paramJSONObject.put("errMsg", "request protocol error");
    return;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "abort";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(":fail abort");
      paramString = localStringBuilder.toString();
    }
    paramJSONObject.put("errMsg", paramString);
    return;
    label86:
    QLog.e("MiniappHttpUtil", 1, "fillErrMsg", paramString);
  }
  
  private static String getContentType(String paramString)
  {
    if ((!paramString.endsWith(".jpg")) && (!paramString.endsWith(".jpeg")))
    {
      if (paramString.endsWith(".png")) {
        return "image/png";
      }
      return "application/octet-stream";
    }
    return "image/jpg";
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
    int i = paramInt;
    if (paramThrowable != null)
    {
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof SSLHandshakeException)) {
        return 15;
      }
      if ((paramThrowable instanceof IllegalStateException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("Connection is not open"))) {
          return 50007;
        }
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No space left on device"))) {
          return 50003;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Network is unreachable"))) {
          return 50004;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("No route to host"))) {
          return 50005;
        }
        if ((paramThrowable != null) && (paramThrowable.contains("Connection refused"))) {
          return 50006;
        }
        return 2;
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      i = paramInt;
      if ((paramThrowable instanceof OutOfMemoryError)) {
        i = 3;
      }
    }
    return i;
  }
  
  private static Call httpConnect(String paramString1, String paramString2, String[] paramArrayOfString, byte[] paramArrayOfByte, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    if ((!TextUtils.isEmpty(paramString2)) && ((paramString2.startsWith("https://")) || (paramString2.startsWith("http://"))))
    {
      paramString1 = MiniOkHttpClientFactory.getRequestClient().newCall(buildRequest(paramString2, paramArrayOfString, paramString1, null, paramArrayOfByte));
      paramString1.enqueue(new MiniappHttpUtil.1(paramString2, paramHttpCallBack));
      return paramString1;
    }
    paramHttpCallBack.httpCallBack(-4, null, null);
    paramString1 = new StringBuilder();
    paramString1.append("httpConnect error! url invalid. url:");
    paramString1.append(paramString2);
    QLog.e("MiniappHttpUtil", 1, paramString1.toString());
    return null;
  }
  
  public static Call httpGetV2(String paramString, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    return httpConnect("GET", paramString, paramArrayOfString, null, paramHttpCallBack, paramRequestConfig);
  }
  
  public static Call httpPostV2(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    return httpConnect("POST", paramString, paramArrayOfString, paramArrayOfByte, paramHttpCallBack, paramRequestConfig);
  }
  
  public static Call httpSendV2(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, HttpCallBack paramHttpCallBack, RequestConfig paramRequestConfig)
  {
    if ("CONNECT".equals(paramString1))
    {
      paramHttpCallBack.httpCallBack(-3, null, null);
      return null;
    }
    return httpConnect(paramString1, paramString2, paramArrayOfString, paramArrayOfByte, paramHttpCallBack, paramRequestConfig);
  }
  
  public static MiniappHttpUtil.UploadTask httpUpload(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    return httpUploadInnerV2(paramString1, paramString2, paramString3, paramJSONObject1, paramJSONObject2, paramString4, paramString5, paramHttpCallBack);
  }
  
  private static MiniappHttpUtil.UploadTask httpUploadInnerV2(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString4, String paramString5, HttpCallBack paramHttpCallBack)
  {
    paramString1 = new MiniappHttpUtil.UploadTask(paramString1, paramString2, paramString3, paramJSONObject1, paramJSONObject2, paramString4, paramString5, paramHttpCallBack);
    ThreadPools.getNetworkIOThreadPool().execute(paramString1);
    return paramString1;
  }
  
  public static String[] mapToString(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    String[] arrayOfString = new String[paramMap.size() * 2];
    Object localObject = paramMap.keySet();
    int i = 0;
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      arrayOfString[i] = str;
      i += 1;
      arrayOfString[i] = ((String)paramMap.get(str));
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.MiniappHttpUtil
 * JD-Core Version:    0.7.0.1
 */