package com.tencent.mobileqq.qqgamepub.api.impl;

import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.qphone.base.util.QLog;

class QQGameHelperImpl$1$2
  implements Runnable
{
  QQGameHelperImpl$1$2(QQGameHelperImpl.1 param1, QQGamePubWebView paramQQGamePubWebView) {}
  
  public void run()
  {
    try
    {
      QLog.i("QQGamePub_QQGameHelper", 1, "---webview destroy-->");
      if (this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqgamepubWebViewQQGamePubWebView.destroy();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl.1.2
 * JD-Core Version:    0.7.0.1
 */