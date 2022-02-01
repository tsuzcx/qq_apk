package com.tencent.qqmini.miniapp.core.worker;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

public class MiniAppWorker$ServiceInterface
{
  public MiniAppWorker$ServiceInterface(MiniAppWorker paramMiniAppWorker) {}
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new StringBuilder();
    paramString2.append("invokeHandler|service: ");
    paramString2.append(paramString1);
    paramString2.append(" |id:");
    paramString2.append(paramInt);
    QMLog.d("minisdk-worker", paramString2.toString());
    return "";
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new StringBuilder();
    paramString2.append("publishHandler|service: ");
    paramString2.append(paramString1);
    paramString2.append(" |webviewIds:");
    paramString2.append(paramString3);
    QMLog.d("minisdk-worker", paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorker.ServiceInterface
 * JD-Core Version:    0.7.0.1
 */