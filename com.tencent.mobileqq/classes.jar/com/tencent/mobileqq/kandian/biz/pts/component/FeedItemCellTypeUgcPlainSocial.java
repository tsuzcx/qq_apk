package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeUgcPlainSocial
  extends FeedItemCell
{
  public FeedItemCellTypeUgcPlainSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).u().n().i().p().t().l().j();
  }
  
  public FeedItemCell e()
  {
    LinearLayout localLinearLayout1 = new LinearLayout(this.e);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.v != null) {
      localLinearLayout1.addView(this.v);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.e);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(1);
    localLinearLayout2.setPadding(0, 0, 0, AIOUtils.b(1.0F, this.e.getResources()));
    if (this.A != null) {
      localLinearLayout2.addView(this.A);
    }
    if (this.l != null)
    {
      LinearLayout localLinearLayout3 = new LinearLayout(this.e);
      localLinearLayout3.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(11.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()));
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLinearLayout3.addView((View)this.l);
      if ((this.l instanceof ComponentContentBigImageVideo))
      {
        if (this.m != null) {
          localLinearLayout3.addView(this.m);
        }
        ApiCompatibilityUtils.a(localLinearLayout3, this.e.getResources().getDrawable(2130843947));
        localLinearLayout3.setOnClickListener(new FeedItemCellTypeUgcPlainSocial.1(this));
      }
      localLinearLayout2.addView(localLinearLayout3);
    }
    if (this.o != null) {
      localLinearLayout2.addView(this.o);
    }
    ApiCompatibilityUtils.a(localLinearLayout2, this.e.getResources().getDrawable(2130844109));
    localLinearLayout1.addView(localLinearLayout2);
    if (this.x != null) {
      localLinearLayout1.addView(this.x);
    }
    if (this.r != null) {
      localLinearLayout1.addView(this.r);
    }
    if (this.t != null) {
      localLinearLayout1.addView(this.t);
    }
    localLinearLayout2.setOnClickListener(new FeedItemCellTypeUgcPlainSocial.2(this));
    a(localLinearLayout1);
    return this;
  }
  
  public FeedItemCell f()
  {
    return null;
  }
  
  public FeedItemCell q()
  {
    super.q();
    if (this.v != null)
    {
      this.v.a(this.b);
      if ((this.b instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.b;
        this.v.setReadedStatus(this.g.b(localIReadInJoyModel.m(), localIReadInJoyModel.k().mArticleID));
      }
    }
    if (this.A != null) {
      this.A.a(this.b);
    }
    if (this.x != null) {
      this.x.a(this.b);
    }
    return this;
  }
  
  public FeedItemCell r()
  {
    super.r();
    if (this.v != null) {
      this.v.a(this.u);
    }
    if (this.x != null) {
      this.x.a(this.u);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcPlainSocial
 * JD-Core Version:    0.7.0.1
 */