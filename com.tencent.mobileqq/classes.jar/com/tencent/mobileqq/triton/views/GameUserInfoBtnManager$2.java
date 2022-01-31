package com.tencent.mobileqq.triton.views;

import java.util.Map;

class GameUserInfoBtnManager$2
  implements Runnable
{
  GameUserInfoBtnManager$2(GameUserInfoBtnManager paramGameUserInfoBtnManager, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    UserInfoButton localUserInfoButton = (UserInfoButton)GameUserInfoBtnManager.access$300(this.this$0).get(Long.valueOf(this.val$address));
    if (localUserInfoButton != null) {
      localUserInfoButton.setVisible(this.val$visible);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.2
 * JD-Core Version:    0.7.0.1
 */