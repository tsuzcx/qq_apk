package com.tencent.mobileqq.gamecenter.media;

import alud;
import android.content.Context;
import bdin;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$1
  implements Runnable
{
  GameCenterVideoViewController$1(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = alud.a(2131705416);
    if (!bdin.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131718836);
    }
    for (;;)
    {
      QQToast.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = alud.a(2131705423);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */