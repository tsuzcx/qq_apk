package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePgcGrid
  extends FeedItemCell
{
  private ComponentContentGridImage.Model G;
  
  public FeedItemCellTypePgcGrid(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return c(this.g, this.f).i().t().n().p().l();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    super.c(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    this.y.i = true;
    return this;
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
      if ((this.l != null) && ((this.l instanceof ComponentContentGridImage)))
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        ((ComponentContentGridImage)this.l).setLayoutParams(localLayoutParams);
        ((ComponentContentGridImage)this.l).setOnNoItemClickListener(new FeedItemCellTypePgcGrid.1(this));
        localLinearLayout.addView((ComponentContentGridImage)this.l);
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
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentGridImage(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    if (this.y != null) {
      this.y.a(this.b);
    }
    if (this.l != null)
    {
      if ((this.l instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.l).setMIReadInJoyModel(this.b);
      }
      this.G = ComponentContentGridImage.a(this.b, 0);
      this.l.a(this.G);
    }
    if (this.o != null) {
      this.o.a(this.b);
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
    try
    {
      f();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcGrid
 * JD-Core Version:    0.7.0.1
 */