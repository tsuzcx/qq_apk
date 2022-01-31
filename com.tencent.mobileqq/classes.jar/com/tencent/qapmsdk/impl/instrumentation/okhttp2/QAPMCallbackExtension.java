package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionStateUtil;
import com.tencent.qapmsdk.impl.model.HttpDataModel;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.io.IOException;

public class QAPMCallbackExtension
  implements Callback
{
  private static final String TAG = "QAPM_Impl_QAPMCallbackExtension";
  private Callback impl;
  private QAPMTransactionState transactionState;
  
  public QAPMCallbackExtension(Callback paramCallback, QAPMTransactionState paramQAPMTransactionState)
  {
    this.impl = paramCallback;
    this.transactionState = paramQAPMTransactionState;
  }
  
  private void doFailure(Exception paramException)
  {
    QAPMTransactionState localQAPMTransactionState;
    TransactionData localTransactionData;
    if (TraceUtil.getCanMonitorHttp())
    {
      localQAPMTransactionState = getTransactionState();
      QAPMTransactionStateUtil.setErrorCodeFromException(localQAPMTransactionState, paramException);
      if (!localQAPMTransactionState.isComplete())
      {
        localTransactionData = localQAPMTransactionState.end();
        if (localTransactionData != null) {
          break label33;
        }
      }
    }
    return;
    label33:
    if (localQAPMTransactionState.isError())
    {
      paramException = "";
      if (localQAPMTransactionState.getException() != null) {
        paramException = localQAPMTransactionState.getException();
      }
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMCallbackExtension", "error message:", paramException });
      HttpDataModel.collectData(localTransactionData, paramException);
      return;
    }
    HttpDataModel.collectData(localTransactionData);
  }
  
  private void doResponse(Response paramResponse)
  {
    if ((TraceUtil.getCanMonitorHttp()) && (!getTransactionState().isComplete()))
    {
      getTransactionState().setQueueTime(getQueueTime(paramResponse, getTransactionState().getQueueTimeStamp()));
      QAPMOkHttp2TransactionStateUtil.inspectAndInstrumentResponse(getTransactionState(), paramResponse);
    }
  }
  
  private int getQueueTime(Response paramResponse, long paramLong)
  {
    try
    {
      long l = Long.parseLong(paramResponse.header("X-QAPM-Qt"));
      return (int)(l - paramLong);
    }
    catch (Exception paramResponse)
    {
      Logger.INSTANCE.e(new String[] { "getQueueTime error:" + paramResponse.getMessage() });
    }
    return 0;
  }
  
  private QAPMTransactionState getTransactionState()
  {
    return this.transactionState;
  }
  
  public void onFailure(Request paramRequest, IOException paramIOException)
  {
    try
    {
      doFailure(paramIOException);
      this.impl.onFailure(paramRequest, paramIOException);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onFailure : ", localException.toString() });
      }
    }
  }
  
  public void onResponse(Response paramResponse)
  {
    try
    {
      doResponse(paramResponse);
      this.impl.onResponse(paramResponse);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMCallbackExtension", "QAPMCallbackExtension onResponse ", localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMCallbackExtension
 * JD-Core Version:    0.7.0.1
 */