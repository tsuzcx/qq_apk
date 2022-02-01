package com.tencent.mobileqq.qqgamepub.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$MessageQGameReceiver$2$1
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$2$1(QQGameFeedWebFragment.MessageQGameReceiver.2 param2) {}
  
  public void run()
  {
    if ((QQGameFeedWebFragment.a(this.a.a.a) != null) && (!QQGameFeedWebFragment.a(this.a.a.a).isFinishing()))
    {
      QLog.d("GameWebPage", 4, "receiver broadcast,web page loaded");
      QQGameFeedWebFragment.c(this.a.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.MessageQGameReceiver.2.1
 * JD-Core Version:    0.7.0.1
 */