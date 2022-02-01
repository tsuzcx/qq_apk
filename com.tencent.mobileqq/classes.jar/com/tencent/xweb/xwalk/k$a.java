package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkView;

class k$a
  extends XWalkView
{
  public k$a(k paramk, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChangedDelegate(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a.a != null) {
      this.a.a.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.a
 * JD-Core Version:    0.7.0.1
 */