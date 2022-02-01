package com.tencent.mobileqq.gamecenter.web;

import auaw;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView;

public class QQGameFeedWebFragment$MessageQGameReceiver$2
  implements Runnable
{
  public QQGameFeedWebFragment$MessageQGameReceiver$2(auaw paramauaw) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.a.a) == null) {
      return;
    }
    QQGameFeedWebFragment.a(this.a.a).postDelayed(new QQGameFeedWebFragment.MessageQGameReceiver.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.2
 * JD-Core Version:    0.7.0.1
 */