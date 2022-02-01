package com.tencent.mobileqq.vashealth.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class PathTraceManagerImpl$9
  extends Handler
{
  PathTraceManagerImpl$9(PathTraceManagerImpl paramPathTraceManagerImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    try
    {
      paramMessage = (JSONObject)paramMessage.obj;
      String str = paramMessage.getString("callback");
      if (this.a.mPathTracePlug != null)
      {
        WebViewPlugin localWebViewPlugin = (WebViewPlugin)this.a.mPathTracePlug.get();
        if (localWebViewPlugin != null) {
          localWebViewPlugin.callJs(str, new String[] { paramMessage.toString() });
        }
      }
      return;
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.9
 * JD-Core Version:    0.7.0.1
 */