package com.tencent.mobileqq.webview.swift;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class SwiftFloatViewUI$4
  implements View.OnLayoutChangeListener
{
  SwiftFloatViewUI$4(SwiftFloatViewUI paramSwiftFloatViewUI, View paramView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.a.getWindowVisibleDisplayFrame(this.b.o);
    paramInt2 = this.b.o.right - this.b.o.left;
    paramInt4 = this.b.o.bottom - this.b.o.top;
    if ((this.b.p != paramInt2) || (this.b.q != paramInt4))
    {
      ThreadManager.getUIHandler().post(this.b.r);
      paramView = this.b;
      paramView.p = paramInt2;
      paramView.q = paramInt4;
    }
    paramInt1 = paramInt3 - paramInt1;
    if (paramInt1 != paramInt7 - paramInt5)
    {
      paramView = (FrameLayout.LayoutParams)this.b.c.getLayoutParams();
      if ((paramView.leftMargin > paramInt1 / 2) && (this.b.c != null) && (8 == this.b.e.getVisibility()))
      {
        paramView.leftMargin = (paramInt1 - this.b.c.getWidth());
        this.b.c.setLayoutParams(paramView);
      }
    }
    this.b.m = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI.4
 * JD-Core Version:    0.7.0.1
 */