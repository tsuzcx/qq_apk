package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.LinearLayout;

public class FeedItemCellTypeNewPolymericHeaderUgc
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected FeedItemCell A()
  {
    if (this.z != null) {
      this.z.a(this.b);
    }
    return this;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.z != null) {
      paramLinearLayout.addView(this.z);
    }
  }
  
  protected FeedItemCell z()
  {
    return d(this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericHeaderUgc
 * JD-Core Version:    0.7.0.1
 */