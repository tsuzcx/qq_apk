package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.LinearLayout;

public class FeedItemCellTypeNewPolymericHeaderPgc
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected FeedItemCell A()
  {
    if (this.y != null) {
      this.y.a(this.b);
    }
    return this;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.y != null) {
      paramLinearLayout.addView(this.y);
    }
  }
  
  protected FeedItemCell z()
  {
    return c(this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericHeaderPgc
 * JD-Core Version:    0.7.0.1
 */