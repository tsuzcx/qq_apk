package com.tencent.mobileqq.minigame.manager;

import ajjy;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;

class MiniGameAuthorizeManager$3$1
  implements Runnable
{
  MiniGameAuthorizeManager$3$1(MiniGameAuthorizeManager.3 param3, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (MiniGameAuthorizeManager.access$200(this.this$1.this$0) != null) {
      MiniGameAuthorizeManager.access$200(this.this$1.this$0).show(this.this$1.val$gamePkg.iconUrl, this.this$1.val$gamePkg.apkgName, this.this$1.val$authTitle, this.val$avatarUrl, this.val$nickName, this.this$1.val$authDesc, ajjy.a(2131641054), new MiniGameAuthorizeManager.3.1.1(this), this.this$1.val$rightBtnText, new MiniGameAuthorizeManager.3.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.MiniGameAuthorizeManager.3.1
 * JD-Core Version:    0.7.0.1
 */