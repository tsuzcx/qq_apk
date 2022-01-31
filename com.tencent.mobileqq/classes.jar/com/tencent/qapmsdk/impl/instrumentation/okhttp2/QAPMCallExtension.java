package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil;
import com.tencent.qapmsdk.impl.model.HttpDataModel;
import com.tencent.qapmsdk.impl.util.StringUtil;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class QAPMCallExtension
  extends Call
{
  private static final String TAG = "QAPM_Impl_QAPMCallExtension";
  private Call impl;
  private boolean isOkhttp2 = true;
  private Request request = a(paramRequest, paramOkHttpClient);
  private QAPMTransactionState transactionState;
  
  QAPMCallExtension(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    super(paramOkHttpClient, paramRequest);
    this.impl = paramOkHttpClient.newCall(this.request);
  }
  
  private Request a(Request paramRequest, OkHttpClient paramOkHttpClient)
  {
    Request localRequest = paramRequest;
    if (paramRequest != null) {
      localRequest = paramRequest;
    }
    try
    {
      if (TraceUtil.getCanMonitorHttp())
      {
        if (this.transactionState == null) {
          this.transactionState = new QAPMTransactionState(this.isOkhttp2);
        }
        addInterceptor(paramOkHttpClient);
        this.transactionState.setAppPhase(0);
        localRequest = paramRequest.newBuilder().build();
        QAPMOkHttp2TransactionStateUtil.inspectAndInstrument(this.transactionState, localRequest);
      }
      return localRequest;
    }
    catch (Exception paramOkHttpClient) {}
    return paramRequest;
  }
  
  private void addInterceptor(OkHttpClient paramOkHttpClient)
  {
    try
    {
      Iterator localIterator = paramOkHttpClient.interceptors().iterator();
      while (localIterator.hasNext()) {
        if (((Interceptor)localIterator.next() instanceof QAPMOKhttp2Interceptor)) {
          return;
        }
      }
      paramOkHttpClient.interceptors().add(new QAPMOKhttp2Interceptor());
      return;
    }
    catch (Exception paramOkHttpClient)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "error add interceptor in ok2 ", paramOkHttpClient.getMessage() });
    }
  }
  
  private void doFailure(Exception paramException, Response paramResponse)
  {
    TransactionData localTransactionData;
    try
    {
      if (!TraceUtil.getCanMonitorHttp()) {
        return;
      }
      QAPMTransactionState localQAPMTransactionState = getTransactionState();
      QAPMTransactionStateUtil.setErrorCodeFromException(localQAPMTransactionState, paramException);
      if (localQAPMTransactionState.isComplete()) {
        return;
      }
      localTransactionData = localQAPMTransactionState.end();
      if (localTransactionData == null) {
        return;
      }
      if (paramResponse != null) {
        localQAPMTransactionState.setContentType(StringUtil.contentType(paramResponse.header("Content-Type")));
      }
      if (localQAPMTransactionState.isError())
      {
        paramException = "";
        if (localQAPMTransactionState.getException() != null) {
          paramException = localQAPMTransactionState.getException();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMCallExtension", "error message:", paramException });
        if (!localQAPMTransactionState.isError()) {
          return;
        }
        HttpDataModel.collectData(localTransactionData, paramException);
        return;
      }
    }
    catch (Exception paramException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "QAPMCallExtension error() har an error :", paramException.toString() });
      return;
    }
    HttpDataModel.collectData(localTransactionData);
  }
  
  private void doResponse(Response paramResponse)
  {
    try
    {
      if (!TraceUtil.getCanMonitorHttp()) {
        return;
      }
      if (!getTransactionState().isComplete())
      {
        QAPMOkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), paramResponse);
        return;
      }
    }
    catch (Exception paramResponse)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "QAPMCallExtension checkResponse() : ", paramResponse.toString() });
    }
  }
  
  private QAPMTransactionState getTransactionState()
  {
    if (this.transactionState == null) {
      this.transactionState = new QAPMTransactionState(this.isOkhttp2);
    }
    return this.transactionState;
  }
  
  public void cancel()
  {
    this.impl.cancel();
  }
  
  public void enqueue(Callback paramCallback)
  {
    try
    {
      getTransactionState().setQueueTimeStamp(System.currentTimeMillis());
      this.impl.enqueue(new QAPMCallbackExtension(paramCallback, getTransactionState()));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallExtension", "add enqueue time in ok3 enqueue error:", localException.getMessage() });
      }
    }
  }
  
  public Response execute()
  {
    try
    {
      Response localResponse = this.impl.execute();
      doResponse(localResponse);
      return localResponse;
    }
    catch (IOException localIOException)
    {
      doFailure(localIOException, null);
      throw localIOException;
    }
  }
  
  public boolean isCanceled()
  {
    return this.impl.isCanceled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMCallExtension
 * JD-Core Version:    0.7.0.1
 */