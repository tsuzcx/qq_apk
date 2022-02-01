package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameWebFeedView;

class QQGameWebPresenter$1
  extends Handler
{
  QQGameWebPresenter$1(QQGameWebPresenter paramQQGameWebPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i != 100)
      {
        if (i != 102) {
          return;
        }
        this.a.b(paramMessage.arg1);
        return;
      }
      if (this.a.c()) {
        this.a.y().b();
      }
    }
    else
    {
      this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.1
 * JD-Core Version:    0.7.0.1
 */