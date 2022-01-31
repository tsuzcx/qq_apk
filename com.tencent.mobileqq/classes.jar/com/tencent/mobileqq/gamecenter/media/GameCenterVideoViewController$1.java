package com.tencent.mobileqq.gamecenter.media;

import ajya;
import android.content.Context;
import bbfj;
import bcql;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;

class GameCenterVideoViewController$1
  implements Runnable
{
  GameCenterVideoViewController$1(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = ajya.a(2131705032);
    if (!bbfj.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131718402);
    }
    for (;;)
    {
      bcql.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = ajya.a(2131705039);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */