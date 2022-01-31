package com.tencent.mobileqq.gamecenter.web;

import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;
import java.util.List;

class QQGameFeedWebFragment$11
  implements Runnable
{
  QQGameFeedWebFragment$11(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.this$0) != null) {
      QQGameFeedWebFragment.a(this.this$0).setCurrentItem(QQGameFeedWebFragment.a(this.this$0).size() - 1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.11
 * JD-Core Version:    0.7.0.1
 */