package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.harvest.HttpLibType;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil;
import com.tencent.qapmsdk.impl.model.HttpDataModel;
import com.tencent.qapmsdk.impl.util.StringUtil;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class QAPMOkHttp2TransactionStateUtil
  extends QAPMTransactionStateUtil
{
  private static final String NO_BODY_TEXT = "Response BODY not found.";
  private static final String TAG = "QAPM_Impl_QAPMOkHttp2TransactionStateUtil";
  
  private static void addTransactionAndErrorData(QAPMTransactionState paramQAPMTransactionState, Response paramResponse)
  {
    try
    {
      paramQAPMTransactionState.setContentType(StringUtil.contentType(paramResponse.header("Content-Type")));
      TransactionData localTransactionData = paramQAPMTransactionState.end();
      if (localTransactionData != null)
      {
        if (paramQAPMTransactionState.getStatusCode() < 400L) {
          break label172;
        }
        localTreeMap = new TreeMap();
        paramResponse = paramResponse.headers();
        if ((paramResponse != null) && (paramResponse.size() > 0))
        {
          Iterator localIterator = paramResponse.names().iterator();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = paramResponse.get(str1);
            if ((!str1.startsWith("X-QAPM-Qt")) && (str2 != null)) {
              localTreeMap.put(str1, str2);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      TreeMap localTreeMap;
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMOkHttp2TransactionStateUtil", "QAPMOkHttp2TransactionStateUtil content-type has an error " });
      }
      paramResponse = "";
      if (paramQAPMTransactionState.getException() != null) {
        paramResponse = paramQAPMTransactionState.getException();
      }
      HttpDataModel.collectData(localException, localTreeMap, paramResponse);
    }
    return;
    label172:
    HttpDataModel.collectData(localException);
  }
  
  public static void inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, Request paramRequest)
  {
    Object localObject2 = paramRequest.urlString();
    Object localObject1 = null;
    if ((localObject2 != null) && (((String)localObject2).contains("?")))
    {
      int i = ((String)localObject2).indexOf("?");
      localObject1 = ((String)localObject2).substring(0, i);
      String str = ((String)localObject2).substring(i + 1);
      localObject2 = localObject1;
      localObject1 = str;
    }
    for (;;)
    {
      paramQAPMTransactionState.setUrl((String)localObject2);
      paramQAPMTransactionState.setUrlParams((String)localObject1);
      paramQAPMTransactionState.setAllGetRequestParams((String)localObject1);
      paramQAPMTransactionState.setMethodType(paramRequest.method());
      QAPMTransactionStateUtil.setRequestMethod(paramQAPMTransactionState, paramRequest.method());
      paramQAPMTransactionState.setCarrier(NetworkWatcher.INSTANCE.activeNetworkCarrier());
      paramQAPMTransactionState.setHttpLibType(HttpLibType.OkHttp);
      if (localObject2 != null) {
        processParamsAndHeader(paramQAPMTransactionState, paramRequest);
      }
      return;
    }
  }
  
  public static void inspectAndInstrument(QAPMTransactionState paramQAPMTransactionState, String paramString1, String paramString2)
  {
    paramQAPMTransactionState.setUrl(paramString1);
    paramQAPMTransactionState.setMethodType(paramString2);
    paramQAPMTransactionState.setCarrier(NetworkWatcher.INSTANCE.activeNetworkCarrier());
  }
  
  public static void inspectAndInstrumentResponse(QAPMTransactionState paramQAPMTransactionState, Response paramResponse)
  {
    if (paramResponse == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttp2TransactionStateUtil", "okhttp2.0 ->CallBack.onResponse(response) response is null " });
      return;
    }
    String str = paramResponse.header("X-QAPM-Tx-Data");
    int i = paramResponse.code();
    try
    {
      inspectAndInstrumentResponse(paramQAPMTransactionState, str, (int)paramResponse.body().contentLength(), i);
      addTransactionAndErrorData(paramQAPMTransactionState, paramResponse);
      return;
    }
    catch (Exception paramQAPMTransactionState) {}
  }
  
  public static void inspectAndInstrumentResponse(QAPMTransactionState paramQAPMTransactionState, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (!"".equals(paramString))) {
      paramQAPMTransactionState.setAppData(paramString);
    }
    paramQAPMTransactionState.setStatusCode(paramInt2);
    if (paramInt1 >= 0)
    {
      paramQAPMTransactionState.setBytesReceived(paramInt1);
      return;
    }
    paramQAPMTransactionState.setBytesReceived(0L);
  }
  
  private static void processParamsAndHeader(QAPMTransactionState paramQAPMTransactionState, Request paramRequest)
  {
    QAPMTransactionStateUtil.processParamsFilter(paramQAPMTransactionState, paramQAPMTransactionState.getUrlParams());
    paramRequest = new QAPMOkHttp2TransactionStateUtil.1(paramRequest);
    QAPMTransactionStateUtil.processHeaderParam(paramQAPMTransactionState.getUrl(), paramRequest, paramQAPMTransactionState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMOkHttp2TransactionStateUtil
 * JD-Core Version:    0.7.0.1
 */