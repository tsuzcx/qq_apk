package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeUgcVideo
  extends FeedItemCellTypeUgcImage
{
  public FeedItemCellTypeUgcVideo(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return d(this.g, this.f).t().i().n().l().p();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.e);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.z != null) {
        localLinearLayout1.addView(this.z);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBigImageVideo)))
      {
        LinearLayout localLinearLayout2 = new LinearLayout(this.e);
        localLinearLayout2.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()));
        localLinearLayout2.setLayoutParams(localLayoutParams);
        localLinearLayout2.addView((ComponentContentBigImageVideo)this.l);
        if (this.m != null) {
          localLinearLayout2.addView(this.m);
        }
        ((ComponentContentBigImageVideo)this.l).setOnClickListener(new FeedItemCellTypeUgcVideo.1(this));
        localLinearLayout1.addView(localLinearLayout2);
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
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentUgcVideo(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcVideo
 * JD-Core Version:    0.7.0.1
 */