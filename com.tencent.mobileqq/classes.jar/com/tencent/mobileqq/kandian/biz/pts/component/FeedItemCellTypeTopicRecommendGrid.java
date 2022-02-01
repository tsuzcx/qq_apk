package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicRecommendGrid
  extends FeedItemCell
{
  private ComponentContentGridImage.Model G;
  
  public FeedItemCellTypeTopicRecommendGrid(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return f(this.g, this.f).t().n().j().i();
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
      if ((this.l != null) && ((this.l instanceof ComponentContentGridImage)))
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        ((ComponentContentGridImage)this.l).setLayoutParams(localLayoutParams);
        ((ComponentContentGridImage)this.l).setOnNoItemClickListener(new FeedItemCellTypeTopicRecommendGrid.1(this));
        localLinearLayout.addView((ComponentContentGridImage)this.l);
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
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentGridImage(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    if (this.E != null) {
      this.E.a(this.b);
    }
    if (this.l != null)
    {
      if ((this.l instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.l).setMIReadInJoyModel(this.b);
      }
      this.G = ComponentContentGridImage.a(this.b, 0);
      this.l.a(this.G);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    if (this.r != null) {
      this.r.a(this.b);
    }
    if (this.t != null) {
      this.t.a(this.b);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendGrid
 * JD-Core Version:    0.7.0.1
 */