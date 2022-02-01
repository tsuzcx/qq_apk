package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

class PageWebviewContainer$5$1
  implements ValueCallback<String>
{
  PageWebviewContainer$5$1(PageWebviewContainer.5 param5) {}
  
  public void onReceiveValue(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openFileReader callback  : ");
    localStringBuilder.append(paramString);
    QMLog.d("PageWebviewContainer", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.5.1
 * JD-Core Version:    0.7.0.1
 */