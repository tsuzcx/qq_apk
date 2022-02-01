package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.view.View.OnClickListener;

class BaseTabbar$3
  implements View.OnClickListener
{
  long a = 0L;
  
  BaseTabbar$3(BaseTabbar paramBaseTabbar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a < 300L)
    {
      this.a = 0L;
      if (this.c.a != null) {
        this.c.a.a(this.b);
      }
    }
    else
    {
      this.a = l;
      this.c.setSelectedTab(this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.BaseTabbar.3
 * JD-Core Version:    0.7.0.1
 */