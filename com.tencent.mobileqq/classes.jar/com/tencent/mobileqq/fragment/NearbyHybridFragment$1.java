package com.tencent.mobileqq.fragment;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;

class NearbyHybridFragment$1
  implements TouchWebView.OnScrollChangedListener
{
  NearbyHybridFragment$1(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (paramInt4 > paramInt2)
    {
      if (paramInt2 == 0) {
        this.a.d.c();
      }
    }
    else if ((paramInt4 < paramInt2) && (paramInt2 >= this.a.u.getHeight())) {
      this.a.d.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.1
 * JD-Core Version:    0.7.0.1
 */