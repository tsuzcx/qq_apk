package com.tencent.mobileqq.gamecenter.web;

import com.tencent.mobileqq.gamecenter.web.view.GameContentView;

class QQGameFeedWebFragment$MessageQGameReceiver$2
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$2(QQGameFeedWebFragment.MessageQGameReceiver paramMessageQGameReceiver) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.a.a) == null) {
      return;
    }
    QQGameFeedWebFragment.a(this.a.a).postDelayed(new QQGameFeedWebFragment.MessageQGameReceiver.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.2
 * JD-Core Version:    0.7.0.1
 */