package com.tencent.mobileqq.webprocess;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;

class WebAccelerateHelper$3
  implements SwiftBrowserOfflineHandler.CheckOfflineCallback
{
  WebAccelerateHelper$3(WebAccelerateHelper paramWebAccelerateHelper) {}
  
  public void onCheckOfflineFinish(int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.b = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebAccelerateHelper.3
 * JD-Core Version:    0.7.0.1
 */