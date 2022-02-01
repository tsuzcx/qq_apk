package com.tencent.mobileqq.gamecenter.media;

import android.content.Context;
import anzj;
import bhnv;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$2
  implements Runnable
{
  GameCenterVideoViewController$2(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = anzj.a(2131703919);
    if (!bhnv.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131717088);
    }
    for (;;)
    {
      QQToast.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = anzj.a(2131703926);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */