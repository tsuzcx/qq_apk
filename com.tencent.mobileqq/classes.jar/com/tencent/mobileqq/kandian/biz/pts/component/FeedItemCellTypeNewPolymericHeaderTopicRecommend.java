package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.LinearLayout;

public class FeedItemCellTypeNewPolymericHeaderTopicRecommend
  extends FeedItemCellTypeNewPolymericBaseHeader
{
  protected FeedItemCell A()
  {
    if (this.E != null) {
      this.E.a(this.b);
    }
    return this;
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    if (this.E != null) {
      paramLinearLayout.addView(this.E);
    }
  }
  
  protected FeedItemCell z()
  {
    return f(this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNewPolymericHeaderTopicRecommend
 * JD-Core Version:    0.7.0.1
 */