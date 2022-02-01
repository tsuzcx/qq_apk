package com.tencent.xweb.xwalk;

import org.xwalk.core.XWalkView.OverScrolledListener;

class k$6
  implements XWalkView.OverScrolledListener
{
  k$6(k paramk) {}
  
  public void onOverScrolled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      k.a(this.a, true);
      return;
    }
    k.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.6
 * JD-Core Version:    0.7.0.1
 */