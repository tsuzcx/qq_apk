package com.tencent.mobileqq.triton.views;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.APICallback;

class GameUserInfoBtnManager$1$1$2
  implements APICallback
{
  GameUserInfoBtnManager$1$1$2(GameUserInfoBtnManager.1.1 param1, UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam) {}
  
  public void onCallback(boolean paramBoolean, String paramString)
  {
    TTLog.i("GameGlobalView", "doAddFriend callback " + paramBoolean + " resp=" + paramString);
    GameUserInfoBtnManager.access$100(this.this$2.this$1.this$0).postRunnable(new GameUserInfoBtnManager.1.1.2.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.1.1.2
 * JD-Core Version:    0.7.0.1
 */