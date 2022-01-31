package com.tencent.mobileqq.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDialog;

class MiniGameAuthorizeManager$5
  implements View.OnClickListener
{
  MiniGameAuthorizeManager$5(MiniGameAuthorizeManager paramMiniGameAuthorizeManager) {}
  
  public void onClick(View paramView)
  {
    if (MiniGameAuthorizeManager.access$200(this.this$0) != null)
    {
      MiniGameAuthorizeManager.access$200(this.this$0).setConfirm(true);
      MiniGameAuthorizeManager.access$200(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.5
 * JD-Core Version:    0.7.0.1
 */