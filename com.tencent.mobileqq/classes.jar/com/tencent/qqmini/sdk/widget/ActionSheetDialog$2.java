package com.tencent.qqmini.sdk.widget;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

class ActionSheetDialog$2
  implements Runnable
{
  ActionSheetDialog$2(ActionSheetDialog paramActionSheetDialog) {}
  
  public void run()
  {
    ActionSheetDialog.access$000(this.this$0).setVisibility(0);
    ActionSheetDialog.access$100(this.this$0).setVisibility(0);
    Object localObject = this.this$0;
    ActionSheetDialog.access$202((ActionSheetDialog)localObject, new TranslateAnimation(0.0F, 0.0F, ActionSheetDialog.access$000((ActionSheetDialog)localObject).getHeight(), 0.0F));
    ActionSheetDialog.access$200(this.this$0).setFillEnabled(true);
    ActionSheetDialog.access$200(this.this$0).setInterpolator(AnimationUtils.loadInterpolator(ActionSheetDialog.access$300(this.this$0), 17432582));
    ActionSheetDialog.access$200(this.this$0).setDuration(400L);
    ActionSheetDialog.access$000(this.this$0).startAnimation(ActionSheetDialog.access$200(this.this$0));
    localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setFillEnabled(true);
    ((AlphaAnimation)localObject).setDuration(200L);
    ActionSheetDialog.access$100(this.this$0).startAnimation((Animation)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.ActionSheetDialog.2
 * JD-Core Version:    0.7.0.1
 */