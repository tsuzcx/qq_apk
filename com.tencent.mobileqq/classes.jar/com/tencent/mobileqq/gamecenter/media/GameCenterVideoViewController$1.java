package com.tencent.mobileqq.gamecenter.media;

import ajyc;
import android.content.Context;
import bbev;
import bcpw;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

class GameCenterVideoViewController$1
  implements Runnable
{
  GameCenterVideoViewController$1(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = ajyc.a(2131705021);
    if (!bbev.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131718391);
    }
    for (;;)
    {
      bcpw.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = ajyc.a(2131705028);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */