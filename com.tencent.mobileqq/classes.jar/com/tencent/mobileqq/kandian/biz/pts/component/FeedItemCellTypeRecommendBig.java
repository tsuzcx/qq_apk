package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeRecommendBig
  extends FeedItemCell
{
  public FeedItemCellTypeRecommendBig(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return e(this.g, this.f).t().n().p().j().i().l();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.e);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.D != null) {
        localLinearLayout1.addView(this.D);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig)) && (this.m != null))
      {
        RelativeLayout localRelativeLayout1 = new RelativeLayout(this.e);
        localRelativeLayout1.setPadding(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        LinearLayout localLinearLayout2 = new LinearLayout(this.e);
        localLinearLayout2.setOrientation(1);
        localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localLinearLayout2.addView((ComponentContentBig)this.l);
        RelativeLayout localRelativeLayout2 = new RelativeLayout(this.e);
        localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        localLinearLayout2.addView(localRelativeLayout2);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(15);
        this.m.setLayoutParams(localLayoutParams);
        localRelativeLayout2.addView(this.m);
        localLinearLayout2.setBackgroundResource(2130843955);
        localLinearLayout2.setOnClickListener(new FeedItemCellTypeRecommendBig.1(this));
        localRelativeLayout1.addView(localLinearLayout2);
        localLinearLayout1.addView(localRelativeLayout1);
      }
      if (this.o != null) {
        localLinearLayout1.addView(this.o);
      }
      if (this.x != null) {
        localLinearLayout1.addView(this.x);
      }
      if (this.r != null) {
        localLinearLayout1.addView(this.r);
      }
      if (this.t != null) {
        localLinearLayout1.addView(this.t);
      }
      a(localLinearLayout1);
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
    this.l = new ComponentContentBig(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    super.q();
    if (this.D != null) {
      this.D.a(this.b);
    }
    if (this.o != null) {
      this.o.a(this.b);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeRecommendBig
 * JD-Core Version:    0.7.0.1
 */