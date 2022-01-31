package com.tencent.mobileqq.triton.views;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.APIProxy;

class GameUserInfoBtnManager$1$1
  implements UserInfoButton.OnClickListener
{
  GameUserInfoBtnManager$1$1(GameUserInfoBtnManager.1 param1) {}
  
  public void onClick(UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam)
  {
    if (paramUserInfoButtonParam == null)
    {
      TTLog.e("GameGlobalView", "UserInfoButton.OnClickListener exception param==null");
      return;
    }
    if (paramUserInfoButtonParam.buttonType == 2)
    {
      GameUserInfoBtnManager.access$100(this.this$1.this$0).getApiProxy().gotoPermissionSetting(GameUserInfoBtnManager.access$000(this.this$1.this$0));
      GameUserInfoBtnManager.access$100(this.this$1.this$0).postRunnable(new GameUserInfoBtnManager.1.1.1(this, paramUserInfoButtonParam));
      return;
    }
    if (paramUserInfoButtonParam.buttonType == 5)
    {
      GameUserInfoBtnManager.access$100(this.this$1.this$0).getApiProxy().doAddFriend(GameUserInfoBtnManager.access$000(this.this$1.this$0), paramUserInfoButtonParam.openId, new GameUserInfoBtnManager.1.1.2(this, paramUserInfoButtonParam));
      return;
    }
    GameUserInfoBtnManager.access$100(this.this$1.this$0).postRunnable(new GameUserInfoBtnManager.1.1.3(this, paramUserInfoButtonParam));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.1.1
 * JD-Core Version:    0.7.0.1
 */