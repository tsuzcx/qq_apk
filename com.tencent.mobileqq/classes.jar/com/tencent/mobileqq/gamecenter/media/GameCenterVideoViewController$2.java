package com.tencent.mobileqq.gamecenter.media;

import android.content.Context;
import anni;
import bgnt;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$2
  implements Runnable
{
  GameCenterVideoViewController$2(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = anni.a(2131703812);
    if (!bgnt.g(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131716972);
    }
    for (;;)
    {
      QQToast.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.a(this.this$0).type == 1) {
        str = anni.a(2131703819);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.2
 * JD-Core Version:    0.7.0.1
 */