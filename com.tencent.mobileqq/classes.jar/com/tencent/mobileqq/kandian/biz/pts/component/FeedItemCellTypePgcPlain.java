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

public class FeedItemCellTypePgcPlain
  extends FeedItemCell
{
  public FeedItemCellTypePgcPlain(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return c(this.g, this.f).t().n().p().j().l();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.y != null) {
        localLinearLayout.addView(this.y);
      }
      if (this.m != null)
      {
        RelativeLayout localRelativeLayout1 = new RelativeLayout(this.e);
        localRelativeLayout1.setPadding(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        RelativeLayout localRelativeLayout2 = new RelativeLayout(this.e);
        localRelativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.b(86.0F, this.e.getResources())));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(15);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        this.m.setLayoutParams(localLayoutParams);
        localRelativeLayout2.addView(this.m);
        localRelativeLayout2.setBackgroundResource(2130843955);
        localRelativeLayout2.setOnClickListener(new FeedItemCellTypePgcPlain.1(this));
        localRelativeLayout1.addView(localRelativeLayout2);
        localLinearLayout.addView(localRelativeLayout1);
      }
      if (this.o != null) {
        localLinearLayout.addView(this.o);
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
  
  public FeedItemCell q()
  {
    super.q();
    if (this.y != null) {
      this.y.a(this.b);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcPlain
 * JD-Core Version:    0.7.0.1
 */