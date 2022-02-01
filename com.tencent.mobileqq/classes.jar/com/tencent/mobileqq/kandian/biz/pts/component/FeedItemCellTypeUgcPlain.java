package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeUgcPlain
  extends FeedItemCell
{
  public FeedItemCellTypeUgcPlain(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeUgcPlain", 2, "ugc plain create");
    }
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return d(this.g, this.f).t().n().i().p().l();
  }
  
  public FeedItemCell e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeUgcPlain", 2, "ugc plain layout");
    }
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.z != null) {
        localLinearLayout.addView(this.z);
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
    return super.i();
  }
  
  public FeedItemCell q()
  {
    super.q();
    if (this.z != null) {
      this.z.a(this.b);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    return this;
  }
  
  public FeedItemCell r()
  {
    super.r();
    if (this.x != null) {
      this.x.a(this.u);
    }
    if (this.A != null) {
      this.A.a(this.u);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcPlain
 * JD-Core Version:    0.7.0.1
 */