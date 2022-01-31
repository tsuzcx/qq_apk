package com.tencent.mobileqq.triton.views;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import java.util.Map;

class GameUserInfoBtnManager$1
  implements Runnable
{
  GameUserInfoBtnManager$1(GameUserInfoBtnManager paramGameUserInfoBtnManager, UserInfoButton.UserInfoButtonParam paramUserInfoButtonParam) {}
  
  public void run()
  {
    if (this.val$param == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      localObject2 = null;
      localObject1 = localObject2;
      if ("image".equals(this.val$param.type))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.val$param.image))
        {
          localObject2 = GameUserInfoBtnManager.access$100(this.this$0).getQQEnv().getDrawable(GameUserInfoBtnManager.access$000(this.this$0), this.val$param.image, GameUserInfoBtnManager.access$100(this.this$0).getMiniGameInfo());
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            TTLog.e("GameGlobalView", "getUserInfo imageButtonDrawable == null");
            return;
          }
        }
      }
      localObject2 = new UserInfoButton(GameUserInfoBtnManager.access$100(this.this$0), GameUserInfoBtnManager.access$000(this.this$0), this.val$param);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.height = this.val$param.style.height;
      localLayoutParams.width = this.val$param.style.width;
      localLayoutParams.leftMargin = this.val$param.style.left;
      localLayoutParams.topMargin = this.val$param.style.top;
      if (((UserInfoButton)localObject2).getButton() == null) {
        break;
      }
      GameUserInfoBtnManager.access$200(this.this$0).addView(((UserInfoButton)localObject2).getButton(), localLayoutParams);
      GameUserInfoBtnManager.access$300(this.this$0).put(Long.valueOf(this.val$param.address), localObject2);
      ((UserInfoButton)localObject2).setOnClickListener(new GameUserInfoBtnManager.1.1(this));
    } while (!"image".equals(this.val$param.type));
    ((UserInfoButton)localObject2).setImageDrawable(localObject1);
    return;
    TTLog.e("GameGlobalView", "createUserInfoButton userInfoButton.getButton() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.views.GameUserInfoBtnManager.1
 * JD-Core Version:    0.7.0.1
 */