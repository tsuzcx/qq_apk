package com.tencent.mobileqq.minigame.publicaccount.view;

import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.qphone.base.util.QLog;

class GameArkView$1
  implements Runnable
{
  GameArkView$1(GameArkView paramGameArkView) {}
  
  public void run()
  {
    try
    {
      if ((QQGameHelper.a(GameArkView.access$000(this.this$0))) && (GameArkView.access$100(this.this$0)) && (GameArkView.access$200(this.this$0) != null)) {
        GameArkView.access$200(this.this$0).onPause();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GameArkView", 4, "-->onLoadState init arkview faile:" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.view.GameArkView.1
 * JD-Core Version:    0.7.0.1
 */