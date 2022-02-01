package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.ArrayList;

class QQGameWebPresenter$4
  implements Runnable
{
  QQGameWebPresenter$4(QQGameWebPresenter paramQQGameWebPresenter, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      this.this$0.c(this.a);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "clearUnreadMsg", null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameWebPresenter.4
 * JD-Core Version:    0.7.0.1
 */