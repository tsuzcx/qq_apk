package com.tencent.mobileqq.gamecenter.media;

import android.content.Context;
import anvx;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class GameCenterVideoViewController$3
  implements Runnable
{
  GameCenterVideoViewController$3(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void run()
  {
    String str = anvx.a(2131704499);
    if (!NetworkUtil.isNetworkAvailable(this.this$0.getContext())) {
      str = this.this$0.getContext().getString(2131717691);
    }
    for (;;)
    {
      QQToast.a(this.this$0.getContext(), 1, str, 0).b(0);
      return;
      if (GameCenterVideoViewController.access$300(this.this$0).type == 1) {
        str = anvx.a(2131704506);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.3
 * JD-Core Version:    0.7.0.1
 */