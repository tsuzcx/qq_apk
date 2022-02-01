package com.tencent.xweb.xwalk;

import android.widget.AbsoluteLayout;
import com.tencent.xweb.x;
import org.xwalk.core.XWalkView.ScrollChangedListener;

class k$5
  implements XWalkView.ScrollChangedListener
{
  k$5(k paramk) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.d.scrollTo(paramInt1, paramInt2);
    if (this.a.j != null) {
      this.a.j.a(paramInt1, paramInt2, paramInt3, paramInt4, this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.5
 * JD-Core Version:    0.7.0.1
 */