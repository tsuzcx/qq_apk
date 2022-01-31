package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import java.io.IOException;
import java.net.HttpURLConnection;

class QAPMHttpURLConnectionExtension$3
  implements QAPMStreamCompleteListener
{
  QAPMHttpURLConnectionExtension$3(QAPMHttpURLConnectionExtension paramQAPMHttpURLConnectionExtension) {}
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    QAPMTransactionState localQAPMTransactionState = QAPMHttpURLConnectionExtension.access$400(this.this$0);
    String str;
    long l2;
    long l1;
    if (!localQAPMTransactionState.isComplete())
    {
      str = QAPMHttpURLConnectionExtension.access$000(this.this$0).getRequestProperty("content-length");
      l2 = paramQAPMStreamCompleteEvent.getBytes();
      l1 = l2;
      if (str == null) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      localQAPMTransactionState.setBytesSentAfterComplete(l1);
      return;
    }
    catch (NumberFormatException paramQAPMStreamCompleteEvent)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    QAPMTransactionState localQAPMTransactionState = QAPMHttpURLConnectionExtension.access$400(this.this$0);
    if (!localQAPMTransactionState.isComplete()) {
      localQAPMTransactionState.setBytesSent(paramQAPMStreamCompleteEvent.getBytes());
    }
    try
    {
      localQAPMTransactionState.setStatusCode(QAPMHttpURLConnectionExtension.access$000(this.this$0).getResponseCode());
      label37:
      QAPMHttpURLConnectionExtension.access$100(this.this$0, paramQAPMStreamCompleteEvent.getException());
      return;
    }
    catch (IOException localIOException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpURLConnectionExtension.3
 * JD-Core Version:    0.7.0.1
 */