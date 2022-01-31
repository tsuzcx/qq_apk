package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteEvent;
import com.tencent.qapmsdk.impl.instrumentation.io.QAPMStreamCompleteListener;
import java.io.IOException;
import java.net.HttpURLConnection;

class QAPMHttpURLConnectionExtension$2
  implements QAPMStreamCompleteListener
{
  QAPMHttpURLConnectionExtension$2(QAPMHttpURLConnectionExtension paramQAPMHttpURLConnectionExtension) {}
  
  public void streamComplete(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    int i;
    if (!QAPMHttpURLConnectionExtension.access$300(this.this$0).isComplete()) {
      i = 0;
    }
    try
    {
      int j = QAPMHttpURLConnectionExtension.access$000(this.this$0).getResponseCode();
      i = j;
      QAPMHttpURLConnectionExtension.access$300(this.this$0).setStatusCode(j);
      i = j;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        long l1;
        long l2;
      }
    }
    l1 = paramQAPMStreamCompleteEvent.getBytes();
    if (i != 206)
    {
      l2 = QAPMHttpURLConnectionExtension.access$000(this.this$0).getContentLength();
      if (l2 >= 0L) {
        l1 = l2;
      }
      for (;;)
      {
        QAPMHttpURLConnectionExtension.access$300(this.this$0).setBytesReceived(l1);
        QAPMHttpURLConnectionExtension.access$200(this.this$0, QAPMHttpURLConnectionExtension.access$300(this.this$0));
        return;
      }
    }
  }
  
  public void streamError(QAPMStreamCompleteEvent paramQAPMStreamCompleteEvent)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "streamError:", paramQAPMStreamCompleteEvent.toString() });
    if (!QAPMHttpURLConnectionExtension.access$300(this.this$0).isComplete()) {
      QAPMHttpURLConnectionExtension.access$300(this.this$0).setBytesReceived(paramQAPMStreamCompleteEvent.getBytes());
    }
    QAPMHttpURLConnectionExtension.access$100(this.this$0, paramQAPMStreamCompleteEvent.getException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMHttpURLConnectionExtension.2
 * JD-Core Version:    0.7.0.1
 */