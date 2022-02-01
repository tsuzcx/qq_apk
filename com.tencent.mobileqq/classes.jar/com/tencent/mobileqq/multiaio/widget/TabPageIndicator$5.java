package com.tencent.mobileqq.multiaio.widget;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class TabPageIndicator$5
  implements Runnable
{
  TabPageIndicator$5(TabPageIndicator paramTabPageIndicator, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft() - TabPageIndicator.f(this.this$0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollPos : ");
      localStringBuilder.append(i);
      localStringBuilder.append(", tabView.getLeft()");
      localStringBuilder.append(this.a.getLeft());
      QLog.d("TabPageIndicator", 2, localStringBuilder.toString());
    }
    this.this$0.smoothScrollTo(i, 0);
    TabPageIndicator.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.TabPageIndicator.5
 * JD-Core Version:    0.7.0.1
 */