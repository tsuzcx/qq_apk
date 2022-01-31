package com.tencent.mobileqq.triton.views;

import android.view.ViewGroup;
import java.util.Map;

class GameUserInfoBtnManager$3
  implements Runnable
{
  GameUserInfoBtnManager$3(GameUserInfoBtnManager paramGameUserInfoBtnManager, long paramLong) {}
  
  public void run()
  {
    UserInfoButton localUserInfoButton = (UserInfoButton)GameUserInfoBtnManager.access$300(this.this$0).get(Long.valueOf(this.val$address));
    GameUserInfoBtnManager.access$300(this.this$0).remove(Long.valueOf(this.val$address));
    if (localUserInfoButton != null)
    {
      GameUserInfoBtnManager.access$200(this.this$0).removeView(localUserInfoButton.getButton());
      localUserInfoButton.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.3
 * JD-Core Version:    0.7.0.1
 */