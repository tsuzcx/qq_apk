package com.tencent.mobileqq.gamecenter.view;

import avme;
import com.tencent.ark.open.ArkView;
import com.tencent.qphone.base.util.QLog;

class GameArkView$1
  implements Runnable
{
  GameArkView$1(GameArkView paramGameArkView) {}
  
  public void run()
  {
    try
    {
      if ((avme.a(GameArkView.a(this.this$0))) && (GameArkView.a(this.this$0)) && (GameArkView.a(this.this$0) != null)) {
        GameArkView.a(this.this$0).onPause();
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
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameArkView.1
 * JD-Core Version:    0.7.0.1
 */