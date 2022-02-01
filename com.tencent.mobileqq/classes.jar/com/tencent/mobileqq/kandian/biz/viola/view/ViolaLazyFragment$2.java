package com.tencent.mobileqq.kandian.biz.viola.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

final class ViolaLazyFragment$2
  implements View.OnSystemUiVisibilityChangeListener
{
  ViolaLazyFragment$2(Activity paramActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    paramInt = this.a.getWindow().getDecorView().getSystemUiVisibility();
    this.a.getWindow().getDecorView().setSystemUiVisibility(paramInt | 0x2 | 0x400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.view.ViolaLazyFragment.2
 * JD-Core Version:    0.7.0.1
 */