package com.tencent.mobileqq.kandian.glue.viola;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;

class CommonSuspensionGestureLayout$4
  implements Runnable
{
  CommonSuspensionGestureLayout$4(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void run()
  {
    ((ViewGroup)CommonSuspensionGestureLayout.a(this.this$0).getParent()).removeView(CommonSuspensionGestureLayout.a(this.this$0));
    Object localObject = this.this$0;
    ((CommonSuspensionGestureLayout)localObject).addView(CommonSuspensionGestureLayout.a((CommonSuspensionGestureLayout)localObject));
    localObject = (FrameLayout.LayoutParams)CommonSuspensionGestureLayout.a(this.this$0).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = CommonSuspensionGestureLayout.a(CommonSuspensionGestureLayout.a(this.this$0));
    CommonSuspensionGestureLayout.a(this.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.this$0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.4
 * JD-Core Version:    0.7.0.1
 */