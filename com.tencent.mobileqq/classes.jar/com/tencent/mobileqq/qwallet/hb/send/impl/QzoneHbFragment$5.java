package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

class QzoneHbFragment$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QzoneHbFragment$5(QzoneHbFragment paramQzoneHbFragment, Activity paramActivity) {}
  
  public void onGlobalLayout()
  {
    Button localButton;
    if (this.a.getWindowManager().getDefaultDisplay().getWidth() <= 480) {
      localButton = QzoneHbFragment.f(this.b);
    } else {
      localButton = QzoneHbFragment.b(this.b);
    }
    Object localObject = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int k = this.a.getWindow().getDecorView().getRootView().getHeight();
    int j = k - ((Rect)localObject).bottom;
    int i = j;
    if (j - this.b.a(this.a) == 0) {
      i = 0;
    }
    j = this.b.f.getWindow().getDecorView().getScrollY();
    if ((localButton != null) && (i != 0))
    {
      localObject = new int[2];
      localButton.getLocationOnScreen((int[])localObject);
      i = i + (localObject[1] + localButton.getMeasuredHeight()) - k - j;
      if (i > 0) {
        this.b.f.getWindow().getDecorView().scrollBy(0, i + 5);
      }
      QzoneHbFragment.a(this.b, true);
      return;
    }
    if (i == 0)
    {
      this.b.f.getWindow().getDecorView().scrollBy(0, -j);
      QzoneHbFragment.a(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.QzoneHbFragment.5
 * JD-Core Version:    0.7.0.1
 */