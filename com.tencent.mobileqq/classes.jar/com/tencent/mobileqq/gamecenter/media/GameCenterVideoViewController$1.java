package com.tencent.mobileqq.gamecenter.media;

import ajjy;
import android.content.Context;
import badq;
import bbmy;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

class GameCenterVideoViewController$1
  implements Runnable
{
  GameCenterVideoViewController$1(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = ajjy.a(2131639236);
    if (!badq.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131652572);
    }
    for (;;)
    {
      bbmy.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = ajjy.a(2131639243);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */