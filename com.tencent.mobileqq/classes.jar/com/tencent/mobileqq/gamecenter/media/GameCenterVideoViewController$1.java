package com.tencent.mobileqq.gamecenter.media;

import amtj;
import android.content.Context;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$1
  implements Runnable
{
  GameCenterVideoViewController$1(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = amtj.a(2131704148);
    if (!NetworkUtil.isNetworkAvailable(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131717325);
    }
    for (;;)
    {
      QQToast.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.access$000(this.this$0).type == 1) {
        str = amtj.a(2131704155);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */