package com.tencent.qqmini.miniapp.core.worker;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniAppWorker$ServiceInterface
{
  public MiniAppWorker$ServiceInterface(MiniAppWorker paramMiniAppWorker) {}
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    QMLog.d("minisdk-worker", "invokeHandler|service: " + paramString1 + " |id:" + paramInt);
    return "";
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    QMLog.d("minisdk-worker", "publishHandler|service: " + paramString1 + " |webviewIds:" + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.ServiceInterface
 * JD-Core Version:    0.7.0.1
 */