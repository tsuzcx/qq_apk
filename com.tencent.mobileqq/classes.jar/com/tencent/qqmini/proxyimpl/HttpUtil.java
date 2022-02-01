package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil
{
  public static int a(Throwable paramThrowable, int paramInt)
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
  
  private static String a(String paramString)
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
  
  public static Request a(String paramString1, Map<String, String> paramMap, String paramString2, MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    Request.Builder localBuilder = new Request.Builder();
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.addHeader(str, (String)paramMap.get(str));
      }
    }
    localBuilder.url(paramString1);
    if ("GET".equals(paramString2))
    {
      localBuilder.get();
    }
    else
    {
      paramString1 = null;
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
  
  public static RequestBody a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, UploaderProxy.UploadListener paramUploadListener)
  {
    MultipartBody.Builder localBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localBuilder.addFormDataPart(str, (String)paramMap.get(str));
      }
    }
    paramMap = new File(paramString1);
    paramUploadListener = new ProgressRequestBody(RequestBody.create(MediaType.parse(a(paramString1)), paramMap), new HttpUtil.1(paramUploadListener));
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = paramMap.getName();
    }
    localBuilder.addFormDataPart(paramString2, paramString1, paramUploadListener);
    return localBuilder.build();
  }
  
  public static JSONObject a(Map<String, String> paramMap)
  {
    JSONObject localJSONObject;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localJSONObject = new JSONObject();
      paramMap = paramMap.entrySet().iterator();
    }
    for (;;)
    {
      Map.Entry localEntry;
      if (paramMap.hasNext()) {
        localEntry = (Map.Entry)paramMap.next();
      }
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException) {}
      return localJSONObject;
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.HttpUtil
 * JD-Core Version:    0.7.0.1
 */