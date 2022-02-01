package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.app.Activity;
import com.tencent.mtt.hippy.HippyEngine.BackPressHandler;
import com.tencent.qphone.base.util.QLog;

class QQGameHippyBasePresenter$1
  implements HippyEngine.BackPressHandler
{
  QQGameHippyBasePresenter$1(QQGameHippyBasePresenter paramQQGameHippyBasePresenter, Activity paramActivity) {}
  
  public void handleBackPress()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGameHippyBasePresenter", 1, "do Back Event,to finish");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.1
 * JD-Core Version:    0.7.0.1
 */