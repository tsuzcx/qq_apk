package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import android.util.Log;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpUtil
{
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
  
  public static RequestBody buildMultiPartBody(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, UploaderProxy.UploadListener paramUploadListener)
  {
    MultipartBuilder localMultipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localMultipartBuilder.addFormDataPart(str, (String)paramMap.get(str));
      }
    }
    paramMap = new File(paramString1);
    paramUploadListener = new ProgressRequestBody(RequestBody.create(MediaType.parse(getContentType(paramString1)), paramMap), new HttpUtil.1(paramUploadListener));
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = paramMap.getName();
    }
    localMultipartBuilder.addFormDataPart(paramString2, paramString1, paramUploadListener);
    return localMultipartBuilder.build();
  }
  
  public static Request buildRequest(String paramString1, Map<String, String> paramMap, String paramString2, MediaType paramMediaType, byte[] paramArrayOfByte)
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
    if ("GET".equals(paramString2)) {
      localBuilder.get();
    }
    for (;;)
    {
      return localBuilder.build();
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
  }
  
  private static String getContentType(String paramString)
  {
    if ((paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg"))) {
      return "image/jpg";
    }
    if (paramString.endsWith(".png")) {
      return "image/png";
    }
    return "application/octet-stream";
  }
  
  public static int getRetCodeFrom(Throwable paramThrowable, int paramInt)
  {
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
      if ((paramThrowable instanceof OutOfMemoryError)) {
        return 3;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.HttpUtil
 * JD-Core Version:    0.7.0.1
 */