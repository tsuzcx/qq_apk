package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicRecommendSmall
  extends FeedItemCell
{
  public FeedItemCellTypeTopicRecommendSmall(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return f(this.g, this.f).t().n().p().j().i();
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
      if ((this.l != null) && ((this.l instanceof ComponentContentSmall)) && (this.m != null))
      {
        RelativeLayout localRelativeLayout1 = new RelativeLayout(this.e);
        localRelativeLayout1.setPadding(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        RelativeLayout localRelativeLayout2 = new RelativeLayout(this.e);
        localRelativeLayout2.setBackgroundResource(2130843955);
        localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(79.0F, this.e.getResources())));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(104.0F, this.e.getResources()), -1);
        localLayoutParams.addRule(11);
        ((ComponentContentSmall)this.l).setLayoutParams(localLayoutParams);
        ((ComponentContentSmall)this.l).setId(1);
        localRelativeLayout2.addView((ComponentContentSmall)this.l);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.l).getId());
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(20.0F, this.e.getResources()), 0);
        this.m.setLayoutParams(localLayoutParams);
        localRelativeLayout2.addView(this.m);
        localRelativeLayout1.addView(localRelativeLayout2);
        localRelativeLayout2.setOnClickListener(new FeedItemCellTypeTopicRecommendSmall.1(this));
        localLinearLayout.addView(localRelativeLayout1);
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
    this.l = new ComponentContentSmall(this.e);
    return this;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendSmall
 * JD-Core Version:    0.7.0.1
 */