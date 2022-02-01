package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.LinearLayout;

public class FeedItemCellTypeNewPolymericHeaderUgcSocial
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected FeedItemCell A()
  {
    if (this.v != null) {
      this.v.a(this.b);
    }
    return this;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.v != null) {
      paramLinearLayout.addView(this.v);
    }
  }
  
  protected FeedItemCell z()
  {
    return a(this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericHeaderUgcSocial
 * JD-Core Version:    0.7.0.1
 */