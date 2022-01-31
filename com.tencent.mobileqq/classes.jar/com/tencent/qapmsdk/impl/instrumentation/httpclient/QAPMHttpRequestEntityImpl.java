package com.tencent.qapmsdk.impl.instrumentation.httpclient;

import com.tencent.qapmsdk.impl.instrumentation.QAPMHttpClientUtil;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingInputStream;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingOutputStream;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListenerSource;
import com.tencent.qapmsdk.impl.model.HttpDataModel;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class QAPMHttpRequestEntityImpl
  implements QAPMStreamCompleteListener, HttpEntity
{
  private final HttpEntity impl;
  private final QAPMTransactionState transactionState;
  
  public QAPMHttpRequestEntityImpl(HttpEntity paramHttpEntity, QAPMTransactionState paramQAPMTransactionState)
  {
    this.impl = paramHttpEntity;
    this.transactionState = paramQAPMTransactionState;
  }
  
  public void consumeContent()
  {
    try
    {
      this.impl.consumeContent();
      return;
    }
    catch (IOException localIOException)
    {
      QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, localIOException);
      if (!this.transactionState.isComplete()) {
        HttpDataModel.collectData(this.transactionState.end(), localIOException);
      }
      throw localIOException;
    }
  }
  
  public InputStream getContent()
  {
    try
    {
      if (!this.transactionState.isSent())
      {
        localObject = new QAPMCountingInputStream(this.impl.getContent());
        ((QAPMCountingInputStream)localObject).addStreamCompleteListener(this);
        return localObject;
      }
      Object localObject = this.impl.getContent();
      return localObject;
    }
    catch (IOException localIOException)
    {
      QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, localIOException);
      if (!this.transactionState.isComplete()) {
        HttpDataModel.collectData(this.transactionState.end(), localIOException);
      }
      throw localIOException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, localIllegalStateException);
      if (!this.transactionState.isComplete()) {
        HttpDataModel.collectData(this.transactionState.end(), localIllegalStateException);
      }
      throw localIllegalStateException;
    }
  }
  
  public Header getContentEncoding()
  {
    return this.impl.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.impl.getContentLength();
  }
  
  public Header getContentType()
  {
    return this.impl.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.impl.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.impl.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.impl.isStreaming();
  }
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    ((QAPMStreamCompleteListenerSource)paramQAPMStreamCompleteEvent.getSource()).removeStreamCompleteListener(this);
    this.transactionState.setBytesSent(paramQAPMStreamCompleteEvent.getBytes());
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    ((QAPMStreamCompleteListenerSource)paramQAPMStreamCompleteEvent.getSource()).removeStreamCompleteListener(this);
    QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, paramQAPMStreamCompleteEvent.getException());
    if (!this.transactionState.isComplete())
    {
      this.transactionState.setBytesSent(paramQAPMStreamCompleteEvent.getBytes());
      HttpDataModel.collectData(this.transactionState.end(), paramQAPMStreamCompleteEvent.getException());
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    try
    {
      if (!this.transactionState.isSent())
      {
        paramOutputStream = new QAPMCountingOutputStream(paramOutputStream);
        this.impl.writeTo(paramOutputStream);
        this.transactionState.setBytesSent(paramOutputStream.getCount());
        return;
      }
      this.impl.writeTo(paramOutputStream);
      return;
    }
    catch (IOException paramOutputStream)
    {
      QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, paramOutputStream);
      if (!this.transactionState.isComplete()) {
        HttpDataModel.collectData(this.transactionState.end(), paramOutputStream);
      }
      throw paramOutputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMHttpRequestEntityImpl
 * JD-Core Version:    0.7.0.1
 */