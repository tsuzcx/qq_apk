package com.tencent.mobileqq.kandian.glue.viola;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout.LayoutParams;

class CommonSuspensionGestureLayout$2
  implements View.OnLayoutChangeListener
{
  CommonSuspensionGestureLayout$2(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((CommonSuspensionGestureLayout.a(this.a) != null) && ((CommonSuspensionGestureLayout.a(this.a).getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      paramView = (FrameLayout.LayoutParams)CommonSuspensionGestureLayout.a(this.a).getLayoutParams();
      CommonSuspensionGestureLayout localCommonSuspensionGestureLayout = this.a;
      CommonSuspensionGestureLayout.a(localCommonSuspensionGestureLayout, CommonSuspensionGestureLayout.a(CommonSuspensionGestureLayout.a(localCommonSuspensionGestureLayout)));
      if (paramView.bottomMargin != CommonSuspensionGestureLayout.a(this.a))
      {
        paramView.gravity = 80;
        paramView.bottomMargin = CommonSuspensionGestureLayout.a(CommonSuspensionGestureLayout.a(this.a));
        CommonSuspensionGestureLayout.a(this.a).setLayoutParams(paramView);
      }
      this.a.c();
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.2
 * JD-Core Version:    0.7.0.1
 */