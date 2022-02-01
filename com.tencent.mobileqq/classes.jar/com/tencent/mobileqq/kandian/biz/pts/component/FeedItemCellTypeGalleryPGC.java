package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeGalleryPGC
  extends FeedItemCell
{
  public FeedItemCellTypeGalleryPGC(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return c(this.g, this.f).n().i().p().t().l().j();
  }
  
  public FeedItemCell c(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    super.c(paramReadInJoyBaseAdapter, paramIFaceDecoder);
    this.y.j = true;
    return this;
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.e);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.y != null) {
        localLinearLayout1.addView(this.y);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentGalleryBiu)))
      {
        ((ComponentContentGalleryBiu)this.l).setIsNeedAddTitle(true);
        LinearLayout localLinearLayout2 = new LinearLayout(this.e);
        localLinearLayout2.setOrientation(1);
        new LinearLayout.LayoutParams(-2, -2);
        localLinearLayout2.addView((ComponentContentGalleryBiu)this.l);
        localLinearLayout2.setPadding(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
        localLinearLayout1.addView(localLinearLayout2);
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
    this.l = new ComponentContentGalleryBiu(this.e);
    return this;
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
    if ((this.l != null) && ((this.l instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.l).setAdapter(this.g);
      ((ComponentContentGalleryBiu)this.l).setPosition(this.a);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryPGC
 * JD-Core Version:    0.7.0.1
 */