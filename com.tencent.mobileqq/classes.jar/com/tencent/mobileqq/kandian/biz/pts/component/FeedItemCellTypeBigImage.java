package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeBigImage
  extends FeedItemCell
{
  public FeedItemCellTypeBigImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return c();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.i != null) {
        localLinearLayout.addView(this.i);
      }
      if (this.j != null) {
        localLinearLayout.addView(this.j);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.l);
      }
      if (this.m != null) {
        localLinearLayout.addView(this.m);
      }
      if (this.n != null) {
        localLinearLayout.addView(this.n);
      }
      if (this.q != null) {
        localLinearLayout.addView(this.q);
      }
      if (this.p != null) {
        localLinearLayout.addView(this.p);
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
    this.l = new ComponentContentBig(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeBigImage
 * JD-Core Version:    0.7.0.1
 */