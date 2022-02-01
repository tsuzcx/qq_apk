package com.tencent.open.appcommon.js;

import android.os.Handler;
import android.os.Message;
import com.tencent.smtt.sdk.WebView;

public class WebviewHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    paramMessage = (WebViewJS)paramMessage.obj;
    if ((paramMessage != null) && (paramMessage.a != null) && (paramMessage.b != null)) {
      try
      {
        paramMessage.a.loadUrl(paramMessage.b);
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.WebviewHandler
 * JD-Core Version:    0.7.0.1
 */