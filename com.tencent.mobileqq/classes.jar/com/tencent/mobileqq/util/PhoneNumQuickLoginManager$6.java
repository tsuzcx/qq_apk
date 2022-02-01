package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.registerGuideLogin.TouchControllerFrameLayout;

final class PhoneNumQuickLoginManager$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PhoneNumQuickLoginManager$6(View paramView, TouchControllerFrameLayout paramTouchControllerFrameLayout, Dialog paramDialog) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      this.b.setMaxScrollHeight(Utils.a(50.0F, this.c.getContext().getResources()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.6
 * JD-Core Version:    0.7.0.1
 */