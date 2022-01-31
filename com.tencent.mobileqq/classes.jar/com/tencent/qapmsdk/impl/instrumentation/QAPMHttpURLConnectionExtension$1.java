package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import java.io.IOException;
import java.net.HttpURLConnection;

class QAPMHttpURLConnectionExtension$1
  implements QAPMStreamCompleteListener
{
  QAPMHttpURLConnectionExtension$1(QAPMHttpURLConnectionExtension paramQAPMHttpURLConnectionExtension, QAPMTransactionState paramQAPMTransactionState) {}
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    long l1;
    long l2;
    if (!this.val$state.isComplete())
    {
      l1 = QAPMHttpURLConnectionExtension.access$000(this.this$0).getContentLength();
      l2 = paramQAPMStreamCompleteEvent.getBytes();
      if (l1 < 0L) {
        break label77;
      }
    }
    for (;;)
    {
      this.val$state.setBytesReceived(l1);
      try
      {
        int i = QAPMHttpURLConnectionExtension.access$000(this.this$0).getResponseCode();
        this.val$state.setStatusCode(i);
        label61:
        QAPMHttpURLConnectionExtension.access$200(this.this$0, this.val$state);
        return;
      }
      catch (IOException paramQAPMStreamCompleteEvent)
      {
        break label61;
      }
      label77:
      l1 = l2;
    }
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramQAPMStreamCompleteEvent.toString() });
    if (!this.val$state.isComplete()) {
      this.val$state.setBytesReceived(paramQAPMStreamCompleteEvent.getBytes());
    }
    try
    {
      int i = QAPMHttpURLConnectionExtension.access$000(this.this$0).getResponseCode();
      this.val$state.setStatusCode(i);
      label67:
      QAPMHttpURLConnectionExtension.access$100(this.this$0, paramQAPMStreamCompleteEvent.getException());
      return;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpURLConnectionExtension.1
 * JD-Core Version:    0.7.0.1
 */