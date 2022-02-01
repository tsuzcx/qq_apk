package com.tencent.mobileqq.widget.dialog;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout;

class SlideBottomDialog$6
  implements Runnable
{
  SlideBottomDialog$6(SlideBottomDialog paramSlideBottomDialog, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    int j = SlideBottomDialog.b(this.this$0);
    i = Math.max(0, SlideBottomDialog.a(this.this$0).getHeight() - (i + j));
    ViewGroup.LayoutParams localLayoutParams = SlideBottomDialog.c(this.this$0).getLayoutParams();
    localLayoutParams.height = i;
    SlideBottomDialog.c(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.dialog.SlideBottomDialog.6
 * JD-Core Version:    0.7.0.1
 */