package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.LinearLayout;

public class FeedItemCellTypeNewPolymericHeaderRecommend
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected FeedItemCell A()
  {
    if (this.D != null) {
      this.D.a(this.b);
    }
    return this;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.D != null) {
      paramLinearLayout.addView(this.D);
    }
  }
  
  protected FeedItemCell z()
  {
    return e(this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericHeaderRecommend
 * JD-Core Version:    0.7.0.1
 */