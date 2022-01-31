package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import javax.net.ssl.HttpsURLConnection;

class QAPMHttpsURLConnectionExtension$2
  implements QAPMStreamCompleteListener
{
  QAPMHttpsURLConnectionExtension$2(QAPMHttpsURLConnectionExtension paramQAPMHttpsURLConnectionExtension, QAPMTransactionState paramQAPMTransactionState) {}
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    String str;
    long l2;
    long l1;
    if (!this.val$state.isComplete())
    {
      str = QAPMHttpsURLConnectionExtension.access$000(this.this$0).getRequestProperty("content-length");
      l2 = paramQAPMStreamCompleteEvent.getBytes();
      l1 = l2;
      if (str == null) {}
    }
    try
    {
      l1 = Long.parseLong(str);
      this.val$state.setBytesSent(l1);
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
    if (!this.val$state.isComplete()) {
      this.val$state.setBytesSent(paramQAPMStreamCompleteEvent.getBytes());
    }
    QAPMHttpsURLConnectionExtension.access$100(this.this$0, paramQAPMStreamCompleteEvent.getException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpsURLConnectionExtension.2
 * JD-Core Version:    0.7.0.1
 */