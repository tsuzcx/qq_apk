package com.tencent.xweb.xwalk;

import android.os.Handler;
import android.os.Message;
import android.webkit.WebBackForwardList;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

class k$7
  extends Handler
{
  k$7(k paramk) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      paramMessage = ((WebView.d)paramMessage.obj).a();
      if (paramMessage != this.a.a)
      {
        if ((paramMessage != null) && (paramMessage.copyBackForwardList().getSize() != 0)) {
          throw new IllegalArgumentException("New WebView for popup window must not have been  previously navigated.");
        }
        k.a(this.a.a, paramMessage);
        return;
      }
      throw new IllegalArgumentException("Parent WebView cannot host its own popup window. Please use WebSettings.setSupportMultipleWindows(false)");
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.7
 * JD-Core Version:    0.7.0.1
 */