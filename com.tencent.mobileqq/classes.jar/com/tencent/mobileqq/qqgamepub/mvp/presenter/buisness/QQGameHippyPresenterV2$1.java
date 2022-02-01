package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.os.Handler;
import android.os.Message;

class QQGameHippyPresenterV2$1
  extends Handler
{
  QQGameHippyPresenterV2$1(QQGameHippyPresenterV2 paramQQGameHippyPresenterV2) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4)) {
      return;
    }
    this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenterV2.1
 * JD-Core Version:    0.7.0.1
 */