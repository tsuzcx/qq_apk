package com.tencent.mobileqq.kandian.base.view.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class ReadinjoySlidingIndicator$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadinjoySlidingIndicator$3(ReadinjoySlidingIndicator paramReadinjoySlidingIndicator) {}
  
  @SuppressLint({"NewApi"})
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    Object localObject = this.a;
    ReadinjoySlidingIndicator.a((ReadinjoySlidingIndicator)localObject, ReadinjoySlidingIndicator.a((ReadinjoySlidingIndicator)localObject));
    localObject = ReadinjoySlidingIndicator.a(this.a).getChildAt(ReadinjoySlidingIndicator.a(this.a));
    ReadinjoySlidingIndicator.a(this.a, ((View)localObject).getLeft());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoySlidingIndicator.3
 * JD-Core Version:    0.7.0.1
 */