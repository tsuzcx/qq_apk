package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class FeedItemCellTypeRecommendFollow<T extends View>
  extends FeedItemCell
{
  private Class<T> G;
  
  public FeedItemCellTypeRecommendFollow(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Class<T> paramClass)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    this.G = paramClass;
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return i().n().p();
  }
  
  public FeedItemCell e()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.l != null) && (this.l.getClass().equals(this.G))) {
      localLinearLayout.addView((View)this.l);
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
  
  public FeedItemCell f()
  {
    return this;
  }
  
  public FeedItemCell i()
  {
    try
    {
      this.l = ((ComponentView)this.G.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.e }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public FeedItemCell q()
  {
    super.q();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeRecommendFollow
 * JD-Core Version:    0.7.0.1
 */