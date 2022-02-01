package com.tencent.mobileqq.widget.container;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class AdaptiveKeyboardLayout$KeyboardLayoutListener
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  int a = 0;
  
  AdaptiveKeyboardLayout$KeyboardLayoutListener(AdaptiveKeyboardLayout paramAdaptiveKeyboardLayout)
  {
    this.a = ImmersiveUtils.getStatusBarHeight(paramAdaptiveKeyboardLayout.getContext());
  }
  
  public void onGlobalLayout()
  {
    if (AdaptiveKeyboardLayout.a(this.b) != null)
    {
      if (!AdaptiveKeyboardLayout.b(this.b)) {
        return;
      }
      Object localObject = new Rect();
      this.b.getWindowVisibleDisplayFrame((Rect)localObject);
      int k = ((Rect)localObject).height();
      int m = AdaptiveKeyboardLayout.a(this.b).getHeight();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout: rootHeight=");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(", visibleHeight=");
      ((StringBuilder)localObject).append(k);
      QLog.d("AdaptiveKeyboardLayout", 1, ((StringBuilder)localObject).toString());
      if ((k == AdaptiveKeyboardLayout.c(this.b)) && (m == AdaptiveKeyboardLayout.d(this.b)))
      {
        QLog.d("AdaptiveKeyboardLayout", 1, "onGlobalLayout: doesn't changed, return.");
        return;
      }
      int j = m - k;
      int i = j;
      if (AdaptiveKeyboardLayout.e(this.b)) {
        i = j - this.a;
      }
      AdaptiveKeyboardLayout.a(this.b, k);
      AdaptiveKeyboardLayout.b(this.b, m);
      if (i > ViewUtils.dip2px(100.0F))
      {
        i = Math.min(i, AdaptiveKeyboardLayout.f(this.b));
        AdaptiveKeyboardLayout.c(this.b, i);
        if (AdaptiveKeyboardLayout.g(this.b) != null) {
          AdaptiveKeyboardLayout.g(this.b).a(true, i);
        }
      }
      else
      {
        AdaptiveKeyboardLayout.c(this.b, 0);
        if (AdaptiveKeyboardLayout.g(this.b) != null) {
          AdaptiveKeyboardLayout.g(this.b).a(false, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.container.AdaptiveKeyboardLayout.KeyboardLayoutListener
 * JD-Core Version:    0.7.0.1
 */