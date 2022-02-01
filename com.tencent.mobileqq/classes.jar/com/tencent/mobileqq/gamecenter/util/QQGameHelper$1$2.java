package com.tencent.mobileqq.gamecenter.util;

import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;

class QQGameHelper$1$2
  implements Runnable
{
  QQGameHelper$1$2(QQGameHelper.1 param1, QQGamePubWebView paramQQGamePubWebView) {}
  
  public void run()
  {
    try
    {
      QLog.i("QQGameHelper", 1, "---webview destroy-->");
      if (this.a != null) {
        this.a.destroy();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */