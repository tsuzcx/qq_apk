package com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class QQGameHippyBasePresenter$AdHandleBroadCastReceiver
  extends BroadcastReceiver
{
  private QQGameHippyBasePresenter$AdHandleBroadCastReceiver(QQGameHippyBasePresenter paramQQGameHippyBasePresenter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("action_qgame_delete_ad".equals(paramIntent.getAction())) {
      try
      {
        if (this.a.c())
        {
          QQGameHippyBasePresenter.a(this.a, paramIntent);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyBasePresenter.AdHandleBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */