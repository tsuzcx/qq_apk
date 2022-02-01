package com.tencent.mobileqq.gamecenter.web;

import android.support.v4.app.FragmentActivity;
import avgq;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$MessageQGameReceiver$2$1
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$2$1(QQGameFeedWebFragment.MessageQGameReceiver.2 param2) {}
  
  public void run()
  {
    if ((this.a.a.a.getActivity() != null) && (!this.a.a.a.getActivity().isFinishing()))
    {
      QLog.d("GameWebPage", 4, "receiver broadcast,web page loaded");
      QQGameFeedWebFragment.c(this.a.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.2.1
 * JD-Core Version:    0.7.0.1
 */