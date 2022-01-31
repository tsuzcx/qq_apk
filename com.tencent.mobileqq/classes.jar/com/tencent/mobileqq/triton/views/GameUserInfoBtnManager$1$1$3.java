package com.tencent.mobileqq.triton.views;

import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.engine.TTEngine;

class GameUserInfoBtnManager$1$1$3
  implements Runnable
{
  GameUserInfoBtnManager$1$1$3(GameUserInfoBtnManager.1.1 param1, UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam) {}
  
  public void run()
  {
    GameUserInfoBtnManager.access$100(this.this$2.this$1.this$0).getTTChannel().nativeAuthDialogCallback(this.val$param.address, 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.1.1.3
 * JD-Core Version:    0.7.0.1
 */