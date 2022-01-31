package com.tencent.mobileqq.minigame.manager;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDialog;

class MiniGameAuthorizeManager$3$1$2
  implements View.OnClickListener
{
  MiniGameAuthorizeManager$3$1$2(MiniGameAuthorizeManager.3.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (MiniGameAuthorizeManager.access$200(this.this$2.this$1.this$0) != null)
    {
      MiniGameAuthorizeManager.access$200(this.this$2.this$1.this$0).setConfirm(true);
      MiniGameAuthorizeManager.access$200(this.this$2.this$1.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.3.1.2
 * JD-Core Version:    0.7.0.1
 */