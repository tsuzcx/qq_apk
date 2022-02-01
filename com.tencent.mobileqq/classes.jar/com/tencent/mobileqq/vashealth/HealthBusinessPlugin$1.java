package com.tencent.mobileqq.vashealth;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class HealthBusinessPlugin$1
  implements TouchWebView.OnScrollChangedListener
{
  HealthBusinessPlugin$1(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.a.a != null) {
      this.a.a.scrollBy(0, paramInt2 - paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.1
 * JD-Core Version:    0.7.0.1
 */