package com.tencent.mobileqq.multicard;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class MultiCardPageIndicator$4
  implements Runnable
{
  MultiCardPageIndicator$4(MultiCardPageIndicator paramMultiCardPageIndicator, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft() - MultiCardPageIndicator.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("TabPageIndicator", 2, "scrollPos : " + i + ", tabView.getLeft()" + this.a.getLeft());
    }
    this.this$0.smoothScrollTo(i, 0);
    MultiCardPageIndicator.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPageIndicator.4
 * JD-Core Version:    0.7.0.1
 */