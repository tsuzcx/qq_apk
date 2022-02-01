package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qqgamepub.mvp.view.buisness.IQQGameHippyView;
import java.lang.ref.WeakReference;

class QQGameHippyPresenter$1
  extends Handler
{
  QQGameHippyPresenter$1(QQGameHippyPresenter paramQQGameHippyPresenter) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
    {
      if (i != 102) {
        return;
      }
      i = paramMessage.arg1;
      try
      {
        if (!this.a.c()) {
          return;
        }
        ((IQQGameHippyView)QQGameHippyPresenter.a(this.a).get()).c(i);
        return;
      }
      catch (Throwable paramMessage)
      {
        paramMessage.printStackTrace();
        return;
      }
    }
    else
    {
      this.a.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2, (String)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter.1
 * JD-Core Version:    0.7.0.1
 */