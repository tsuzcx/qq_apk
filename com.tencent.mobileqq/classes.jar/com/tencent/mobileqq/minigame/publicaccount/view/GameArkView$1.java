package com.tencent.mobileqq.minigame.publicaccount.view;

import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;

class GameArkView$1
  implements Runnable
{
  GameArkView$1(GameArkView paramGameArkView) {}
  
  public void run()
  {
    try
    {
      if ((GamePubAccountHelper.a(GameArkView.access$000(this.this$0))) && (GameArkView.access$100(this.this$0)) && (GameArkView.access$200(this.this$0) != null))
      {
        GameArkView.access$200(this.this$0).onPause();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->onLoadState init arkview faile:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.d("GameArkView", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.view.GameArkView.1
 * JD-Core Version:    0.7.0.1
 */