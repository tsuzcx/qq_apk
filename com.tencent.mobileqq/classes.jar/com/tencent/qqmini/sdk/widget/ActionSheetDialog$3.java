package com.tencent.qqmini.sdk.widget;

import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class ActionSheetDialog$3
  implements Runnable
{
  ActionSheetDialog$3(ActionSheetDialog paramActionSheetDialog) {}
  
  public void run()
  {
    ActionSheetDialog.access$202(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheetDialog.access$000(this.this$0).getHeight()));
    ActionSheetDialog.access$200(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(ActionSheetDialog.access$300(this.this$0), 17432582));
    ActionSheetDialog.access$200(this.this$0).setDuration(200L);
    ActionSheetDialog.access$200(this.this$0).setFillAfter(true);
    ActionSheetDialog.access$000(this.this$0).startAnimation(ActionSheetDialog.access$200(this.this$0));
    ActionSheetDialog.access$200(this.this$0).setAnimationListener(new ActionSheetDialog.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.ActionSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */