package com.tencent.mobileqq.winkpublish.part;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class PublishContentPart$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  PublishContentPart$2(PublishContentPart paramPublishContentPart, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    if (PublishContentPart.a(this.b) - i > 150)
    {
      int j = PublishContentPart.a(this.b);
      if (this.b.s != null) {
        ((RelativeLayout.LayoutParams)this.b.s.getLayoutParams()).bottomMargin = (j - i);
      }
      PublishContentPart.b(this.b).requestLayout();
      PublishContentPart.b(this.b).setVisibility(0);
    }
    else if ((i - PublishContentPart.a(this.b) > 150) && (!this.b.m))
    {
      PublishContentPart.b(this.b).setVisibility(8);
    }
    PublishContentPart.a(this.b, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.2
 * JD-Core Version:    0.7.0.1
 */