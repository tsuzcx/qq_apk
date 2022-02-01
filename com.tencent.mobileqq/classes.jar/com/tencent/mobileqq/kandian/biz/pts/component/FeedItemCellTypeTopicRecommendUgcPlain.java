package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicRecommendUgcPlain
  extends FeedItemCell
{
  public FeedItemCellTypeTopicRecommendUgcPlain(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return f(this.g, this.f).t().n().p();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.E != null) {
        localLinearLayout.addView(this.E);
      }
      if (this.x != null) {
        localLinearLayout.addView(this.x);
      }
      if (this.r != null) {
        localLinearLayout.addView(this.r);
      }
      if (this.t != null) {
        localLinearLayout.addView(this.t);
      }
      a(localLinearLayout);
      return this;
    }
    throw new Exception("layoutComponent() must after buildComponent()!");
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell q()
  {
    super.q();
    if (this.E != null) {
      this.E.a(this.b);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendUgcPlain
 * JD-Core Version:    0.7.0.1
 */