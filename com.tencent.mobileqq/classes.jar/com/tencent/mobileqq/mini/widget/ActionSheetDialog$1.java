package com.tencent.mobileqq.mini.widget;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class ActionSheetDialog$1
  implements Runnable
{
  ActionSheetDialog$1(ActionSheetDialog paramActionSheetDialog) {}
  
  public void run()
  {
    ActionSheetDialog.access$000(this.this$0).setVisibility(0);
    ActionSheetDialog.access$100(this.this$0).setVisibility(0);
    ActionSheetDialog.access$202(this.this$0, new TranslateAnimation(0.0F, 0.0F, ActionSheetDialog.access$000(this.this$0).getHeight(), 0.0F));
    ActionSheetDialog.access$200(this.this$0).setFillEnabled(true);
    ActionSheetDialog.access$200(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(ActionSheetDialog.access$300(this.this$0), 17432582));
    ActionSheetDialog.access$200(this.this$0).setDuration(400L);
    ActionSheetDialog.access$000(this.this$0).startAnimation(ActionSheetDialog.access$200(this.this$0));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setFillEnabled(true);
    localAlphaAnimation.setDuration(200L);
    ActionSheetDialog.access$100(this.this$0).startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.ActionSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */