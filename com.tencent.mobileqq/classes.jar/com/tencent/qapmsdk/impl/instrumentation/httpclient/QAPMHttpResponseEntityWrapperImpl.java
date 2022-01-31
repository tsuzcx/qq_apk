package com.tencent.qapmsdk.impl.instrumentation.httpclient;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
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
import org.apache.http.HttpResponse;
import org.apache.http.entity.HttpEntityWrapper;

public class QAPMHttpResponseEntityWrapperImpl
  extends HttpEntityWrapper
  implements QAPMStreamCompleteListener
{
  private static final String TAG = "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl";
  private final long contentLengthFromHeader;
  private QAPMCountingInputStream contentStream;
  private final HttpEntity impl;
  private HttpResponse response;
  private final QAPMTransactionState transactionState;
  
  public QAPMHttpResponseEntityWrapperImpl(HttpResponse paramHttpResponse, QAPMTransactionState paramQAPMTransactionState, long paramLong)
  {
    super(paramHttpResponse.getEntity());
    this.response = paramHttpResponse;
    this.impl = paramHttpResponse.getEntity();
    this.transactionState = paramQAPMTransactionState;
    this.contentLengthFromHeader = paramLong;
  }
  
  /* Error */
  private void addTransactionAndErrorData(QAPMTransactionState paramQAPMTransactionState)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 50	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:end	()Lcom/tencent/qapmsdk/impl/api/data/TransactionData;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +24 -> 30
    //   9: getstatic 56	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   12: iconst_2
    //   13: anewarray 58	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 10
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 60
    //   25: aastore
    //   26: invokevirtual 64	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokevirtual 68	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:isError	()Z
    //   34: ifeq +144 -> 178
    //   37: new 70	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   44: astore_2
    //   45: aload_0
    //   46: invokevirtual 77	com/tencent/qapmsdk/impl/instrumentation/httpclient/QAPMHttpResponseEntityWrapperImpl:getContent	()Ljava/io/InputStream;
    //   49: astore 4
    //   51: aload 4
    //   53: instanceof 79
    //   56: ifeq +16 -> 72
    //   59: aload_2
    //   60: aload 4
    //   62: checkcast 79	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream
    //   65: invokevirtual 83	com/tencent/qapmsdk/impl/instrumentation/io/QAPMCountingInputStream:getBufferAsString	()Ljava/lang/String;
    //   68: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: getfield 33	com/tencent/qapmsdk/impl/instrumentation/httpclient/QAPMHttpResponseEntityWrapperImpl:response	Lorg/apache/http/HttpResponse;
    //   76: invokestatic 93	com/tencent/qapmsdk/impl/instrumentation/QAPMHttpClientUtil:resolvingResponseHeader	(Lorg/apache/http/HttpResponse;)Ljava/util/Map;
    //   79: ldc 95
    //   81: aload_1
    //   82: invokevirtual 99	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getBytesReceived	()J
    //   85: invokestatic 105	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokeinterface 111 3 0
    //   93: pop
    //   94: ldc 113
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 116	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   101: ifnull +8 -> 109
    //   104: aload_1
    //   105: invokevirtual 116	com/tencent/qapmsdk/impl/instrumentation/QAPMTransactionState:getException	()Ljava/lang/String;
    //   108: astore_2
    //   109: getstatic 56	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   112: iconst_3
    //   113: anewarray 58	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc 10
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: ldc 118
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload_2
    //   129: aastore
    //   130: invokevirtual 64	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   133: aload_3
    //   134: aload_2
    //   135: invokestatic 124	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;Ljava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: getstatic 56	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   143: ldc 10
    //   145: ldc 125
    //   147: aload_1
    //   148: invokevirtual 129	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: return
    //   152: astore_2
    //   153: getstatic 56	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   156: iconst_2
    //   157: anewarray 58	java/lang/String
    //   160: dup
    //   161: iconst_0
    //   162: ldc 10
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_2
    //   168: invokevirtual 132	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: invokevirtual 135	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   175: goto -103 -> 72
    //   178: aload_3
    //   179: invokestatic 138	com/tencent/qapmsdk/impl/model/HttpDataModel:collectData	(Lcom/tencent/qapmsdk/impl/api/data/TransactionData;)V
    //   182: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	QAPMHttpResponseEntityWrapperImpl
    //   0	183	1	paramQAPMTransactionState	QAPMTransactionState
    //   44	91	2	localObject	java.lang.Object
    //   152	16	2	localException	java.lang.Exception
    //   4	175	3	localTransactionData	TransactionData
    //   49	12	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	5	139	java/lang/Exception
    //   9	29	139	java/lang/Exception
    //   30	45	139	java/lang/Exception
    //   72	94	139	java/lang/Exception
    //   97	109	139	java/lang/Exception
    //   109	138	139	java/lang/Exception
    //   153	175	139	java/lang/Exception
    //   178	182	139	java/lang/Exception
    //   45	72	152	java/lang/Exception
  }
  
  public void consumeContent()
  {
    TransactionData localTransactionData;
    try
    {
      this.impl.consumeContent();
      return;
    }
    catch (IOException localIOException)
    {
      QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, localIOException);
      if (!this.transactionState.isComplete())
      {
        localTransactionData = this.transactionState.end();
        if (!this.transactionState.isError()) {
          break label75;
        }
        String str = "";
        if (this.transactionState.getException() != null) {
          str = this.transactionState.getException();
        }
        HttpDataModel.collectData(localTransactionData, str);
      }
    }
    for (;;)
    {
      throw localIOException;
      label75:
      HttpDataModel.collectData(localTransactionData);
    }
  }
  
  public InputStream getContent()
  {
    if (this.contentStream != null) {
      return this.contentStream;
    }
    for (;;)
    {
      try
      {
        if ((this.impl instanceof HttpEntityWrapper))
        {
          if (!((HttpEntityWrapper)this.impl).isChunked())
          {
            bool = true;
            this.contentStream = new QAPMCountingInputStream(this.impl.getContent(), bool);
            this.contentStream.addStreamCompleteListener(this);
            QAPMCountingInputStream localQAPMCountingInputStream = this.contentStream;
            return localQAPMCountingInputStream;
          }
          bool = false;
          continue;
        }
        boolean bool = true;
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
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "streamComplete" });
    if (!this.transactionState.isComplete())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "transaction not complete" });
      if (this.contentLengthFromHeader < 0L) {
        break label92;
      }
      this.transactionState.setBytesReceived(this.contentLengthFromHeader);
    }
    for (;;)
    {
      addTransactionAndErrorData(this.transactionState);
      return;
      label92:
      this.transactionState.setBytesReceived(paramQAPMStreamCompleteEvent.getBytes());
    }
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    ((QAPMStreamCompleteListenerSource)paramQAPMStreamCompleteEvent.getSource()).removeStreamCompleteListener(this);
    QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, paramQAPMStreamCompleteEvent.getException());
    if (!this.transactionState.isComplete()) {
      this.transactionState.setBytesReceived(paramQAPMStreamCompleteEvent.getBytes());
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    if (!this.transactionState.isComplete())
    {
      paramOutputStream = new QAPMCountingOutputStream(paramOutputStream);
      for (;;)
      {
        try
        {
          this.impl.writeTo(paramOutputStream);
          if (!this.transactionState.isComplete())
          {
            if (this.contentLengthFromHeader >= 0L)
            {
              this.transactionState.setBytesReceived(this.contentLengthFromHeader);
              addTransactionAndErrorData(this.transactionState);
            }
          }
          else {
            return;
          }
        }
        catch (IOException localIOException)
        {
          QAPMHttpClientUtil.setErrorCodeFromException(this.transactionState, localIOException);
          if (!this.transactionState.isComplete())
          {
            this.transactionState.setBytesReceived(paramOutputStream.getCount());
            HttpDataModel.collectData(this.transactionState.end(), localIOException);
          }
          localIOException.printStackTrace();
          throw localIOException;
        }
        this.transactionState.setBytesReceived(paramOutputStream.getCount());
      }
    }
    this.impl.writeTo(paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMHttpResponseEntityWrapperImpl
 * JD-Core Version:    0.7.0.1
 */