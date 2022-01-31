package com.tencent.open.business.base.appreport;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.smtt.sdk.WebView;

public final class AppReport$2
  implements Runnable
{
  public AppReport$2(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new AppReport.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport.2
 * JD-Core Version:    0.7.0.1
 */