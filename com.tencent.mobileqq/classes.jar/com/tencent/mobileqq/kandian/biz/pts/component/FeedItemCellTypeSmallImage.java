package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeSmallImage
  extends FeedItemCell
{
  public FeedItemCellTypeSmallImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
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
      if ((this.l != null) && ((this.l instanceof ComponentContentSmall)) && (this.m != null))
      {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
        localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.e.getResources().getDimensionPixelSize(2131299547)));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        ((ComponentContentSmall)this.l).setId(1);
        ((ComponentContentSmall)this.l).setLayoutParams(localLayoutParams);
        localRelativeLayout.addView((ComponentContentSmall)this.l);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.l).getId());
        localLayoutParams.topMargin = AIOUtils.b(-5.0F, this.e.getResources());
        this.m.setId(2);
        this.m.setLayoutParams(localLayoutParams);
        localRelativeLayout.addView(this.m);
        if (this.n != null)
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(0, ((ComponentContentSmall)this.l).getId());
          this.n.setId(3);
          this.n.setLayoutParams(localLayoutParams);
          localRelativeLayout.addView(this.n);
        }
        localLinearLayout.addView(localRelativeLayout);
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
    RelativeLayout.LayoutParams localLayoutParams;
    if (CmpCtxt.e((IReadInJoyModel)this.b))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localLayoutParams.addRule(15);
      this.m.setLayoutParams(localLayoutParams);
    }
    else if (!CmpCtxt.k((IReadInJoyModel)this.b))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localLayoutParams.addRule(15, 0);
      this.m.setLayoutParams(localLayoutParams);
    }
    return null;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentSmall(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeSmallImage
 * JD-Core Version:    0.7.0.1
 */