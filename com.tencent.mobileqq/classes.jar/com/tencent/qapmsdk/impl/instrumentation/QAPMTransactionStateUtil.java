package com.tencent.qapmsdk.impl.instrumentation;

import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.harvest.RequestMethodType;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class QAPMTransactionStateUtil
{
  private static final String TAG = "QAPM_Impl_QAPMTransactionStateUtil";
  
  public static String getSanitizedStackTrace()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = 0;
    for (;;)
    {
      if (i < arrayOfStackTraceElement.length)
      {
        localStringBuilder.append(arrayOfStackTraceElement[i].toString());
        if (i <= arrayOfStackTraceElement.length - 1) {
          localStringBuilder.append("\n");
        }
        j += 1;
        if (j < 1024) {}
      }
      else
      {
        return localStringBuilder.toString();
      }
      i += 1;
    }
  }
  
  public static int inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, int paramInt)
  {
    paramQAPMTransactionState.setStatusCode(paramInt);
    paramQAPMTransactionState.setBytesReceived(0L);
    return paramInt;
  }
  
  public static void inspectAndInstrumentResponse(QAPMTransactionState paramQAPMTransactionState, HttpURLConnection paramHttpURLConnection)
  {
    try
    {
      if (!TraceUtil.getCanMonitorHttp()) {
        return;
      }
      String str = paramHttpURLConnection.getHeaderField("X-QAPM-Tx-Data");
      if ((str != null) && (!"".equals(str)))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionStateUtil", "header:", str });
        paramQAPMTransactionState.setAppData(str);
      }
      processUrlParams(paramQAPMTransactionState, paramHttpURLConnection);
      i = paramHttpURLConnection.getContentLength();
      if (i >= 0) {
        paramQAPMTransactionState.setBytesReceived(i);
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionStateUtil", "content length:", String.valueOf(i) });
      i = paramQAPMTransactionState.getStatusCode();
    }
    catch (Exception paramQAPMTransactionState)
    {
      int i;
      int j;
      label120:
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTransactionStateUtil", "Failed to retrieve response code due to underlying (Harmony?) NPE", paramQAPMTransactionState);
      return;
    }
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      i = j;
    }
    catch (IOException paramHttpURLConnection)
    {
      break label120;
    }
    catch (NullPointerException paramHttpURLConnection)
    {
      break label120;
    }
    catch (Exception paramHttpURLConnection)
    {
      break label120;
    }
    paramQAPMTransactionState.setStatusCode(i);
  }
  
  public static boolean isSocketECONNRESET(Exception paramException)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramException != null) {
      bool1 = bool2;
    }
    try
    {
      if ((paramException instanceof SocketException))
      {
        boolean bool3 = paramException.getMessage().contains("recvfrom failed: ECONNRESET (Connection reset by peer)");
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMTransactionStateUtil", "isSocketECONNRESET error", paramException);
    }
    return false;
  }
  
  public static void processHeaderParam(String paramString, QAPMNetworkProcessHeader paramQAPMNetworkProcessHeader, QAPMTransactionState paramQAPMTransactionState)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQAPMTransactionState != null) && (paramQAPMNetworkProcessHeader != null)) {}
  }
  
  public static String processParamsFilter(QAPMTransactionState paramQAPMTransactionState, String paramString)
  {
    if ((!TextUtils.isEmpty(paramQAPMTransactionState.getUrl())) && (!TextUtils.isEmpty(paramString))) {
      return "";
    }
    paramQAPMTransactionState.setUrlParams("");
    return "";
  }
  
  public static void processUrlParams(QAPMTransactionState paramQAPMTransactionState, HttpURLConnection paramHttpURLConnection)
  {
    processParamsFilter(paramQAPMTransactionState, paramQAPMTransactionState.getUrlParams());
    paramHttpURLConnection = new QAPMTransactionStateUtil.1(paramHttpURLConnection);
    processHeaderParam(paramQAPMTransactionState.getUrl(), paramHttpURLConnection, paramQAPMTransactionState);
  }
  
  public static void setErrorCodeFromException(QAPMTransactionState paramQAPMTransactionState, Exception paramException)
  {
    if ((paramException instanceof IOException))
    {
      if (isSocketECONNRESET(paramException))
      {
        paramQAPMTransactionState.setErrorCode(911, paramException.toString());
        paramQAPMTransactionState.setStatusCode(911);
        return;
      }
      String str = paramException.getMessage();
      if ((paramException != null) && (str != null) && (str.contains("ftruncate failed: ENOENT (No such file or directory)")))
      {
        paramQAPMTransactionState.setErrorCode(917, paramException.toString());
        paramQAPMTransactionState.setStatusCode(917);
        return;
      }
    }
    if ((paramException instanceof UnknownHostException))
    {
      paramQAPMTransactionState.setErrorCode(901, paramException.toString());
      paramQAPMTransactionState.setStatusCode(901);
      return;
    }
    if ((paramException instanceof SocketTimeoutException))
    {
      paramQAPMTransactionState.setErrorCode(903, paramException.toString());
      paramQAPMTransactionState.setStatusCode(903);
      return;
    }
    if ((paramException instanceof ConnectException))
    {
      paramQAPMTransactionState.setErrorCode(902, paramException.toString());
      paramQAPMTransactionState.setStatusCode(902);
      return;
    }
    if ((paramException instanceof MalformedURLException))
    {
      paramQAPMTransactionState.setErrorCode(900, paramException.toString());
      paramQAPMTransactionState.setStatusCode(900);
      return;
    }
    if ((paramException instanceof SSLException))
    {
      paramQAPMTransactionState.setErrorCode(908, paramException.toString());
      paramQAPMTransactionState.setStatusCode(908);
      return;
    }
    paramQAPMTransactionState.setErrorCode(-1, paramException.toString());
    paramQAPMTransactionState.setStatusCode(-1);
  }
  
  public static RequestMethodType setRequestMethod(String paramString)
  {
    if (paramString.toUpperCase().equals("OPTIONS")) {
      return RequestMethodType.OPTIONS;
    }
    if (paramString.toUpperCase().equals("GET")) {
      return RequestMethodType.GET;
    }
    if (paramString.toUpperCase().equals("HEAD")) {
      return RequestMethodType.HEAD;
    }
    if (paramString.toUpperCase().equals("POST")) {
      return RequestMethodType.POST;
    }
    if (paramString.toUpperCase().equals("PUT")) {
      return RequestMethodType.PUT;
    }
    if (paramString.toUpperCase().equals("DELETE")) {
      return RequestMethodType.DELETE;
    }
    if (paramString.toUpperCase().equals("TRACE")) {
      return RequestMethodType.TRACE;
    }
    if (paramString.toUpperCase().equals("CONNECT")) {
      return RequestMethodType.CONNECT;
    }
    return RequestMethodType.GET;
  }
  
  public static void setRequestMethod(QAPMTransactionState paramQAPMTransactionState, String paramString)
  {
    paramQAPMTransactionState.setRequestMethod(setRequestMethod(paramString));
  }
  
  public static void setUrlAndCarrier(QAPMTransactionState paramQAPMTransactionState, HttpURLConnection paramHttpURLConnection)
  {
    Object localObject = paramHttpURLConnection.getURL().toString();
    paramHttpURLConnection = null;
    if (((String)localObject).contains("?"))
    {
      int i = ((String)localObject).indexOf("?");
      paramHttpURLConnection = ((String)localObject).substring(0, i);
      String str = ((String)localObject).substring(i + 1);
      localObject = paramHttpURLConnection;
      paramHttpURLConnection = str;
    }
    for (;;)
    {
      paramQAPMTransactionState.setUrl((String)localObject);
      paramQAPMTransactionState.setUrlParams(paramHttpURLConnection);
      paramQAPMTransactionState.setAllGetRequestParams(paramHttpURLConnection);
      paramQAPMTransactionState.setAllGetRequestParams(paramHttpURLConnection);
      paramQAPMTransactionState.setCarrier(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil
 * JD-Core Version:    0.7.0.1
 */