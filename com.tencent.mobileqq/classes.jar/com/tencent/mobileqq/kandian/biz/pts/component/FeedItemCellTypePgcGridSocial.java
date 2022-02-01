package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class FeedItemCellTypePgcGridSocial
  extends FeedItemCell
{
  private ComponentContentGridImage.Model G;
  
  public FeedItemCellTypePgcGridSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).g().i().t().n().p().l();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.e);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.v != null) {
        localLinearLayout1.addView(this.v);
      }
      LinearLayout localLinearLayout2 = new LinearLayout(this.e);
      localLinearLayout2.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      localLinearLayout2.setLayoutParams(localLayoutParams);
      ApiCompatibilityUtils.a(localLinearLayout2, this.e.getResources().getDrawable(2130842691));
      if (this.k != null) {
        localLinearLayout2.addView(this.k);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentGridImage)))
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()));
        ((ComponentContentGridImage)this.l).setLayoutParams(localLayoutParams);
        ((ComponentContentGridImage)this.l).setDuplicateParentStateEnabled(true);
        ApiCompatibilityUtils.a((ComponentContentGridImage)this.l, this.e.getResources().getDrawable(2130842691));
        ((ComponentContentGridImage)this.l).setOnNoItemClickListener(new FeedItemCellTypePgcGridSocial.1(this));
        localLinearLayout2.addView((ComponentContentGridImage)this.l);
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypePgcGridSocial.2(this));
      if (this.o != null) {
        localLinearLayout2.addView(this.o);
      }
      if (localLinearLayout2.getChildCount() > 0) {
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
    if ((this.G != null) && (this.l != null) && ((this.l instanceof ComponentContentGridImage)))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((((ComponentContentGridImage)this.l).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.l).getLayoutParams();
      } else {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      if ((this.G.a() != null) && (this.G.a().size() != 0)) {
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()));
      } else {
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), 0, AIOUtils.b(12.0F, this.e.getResources()), 0);
      }
      ((ComponentContentGridImage)this.l).setLayoutParams(localLayoutParams);
    }
    return this;
  }
  
  public FeedItemCell g()
  {
    super.g();
    this.k.c = true;
    return this;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentGridImage(this.e);
    return this;
  }
  
  public FeedItemCell q()
  {
    if (this.v != null)
    {
      this.v.a(this.b);
      if ((this.b instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.b;
        if (localIReadInJoyModel.k() != null) {
          this.v.setReadedStatus(this.g.b(localIReadInJoyModel.m(), localIReadInJoyModel.k().mArticleID));
        }
      }
    }
    if (this.k != null) {
      this.k.a(this.b);
    }
    if (this.l != null)
    {
      if ((this.l instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.l).setMIReadInJoyModel(this.b);
      }
      this.G = ComponentContentGridImage.a(this.b, 0);
      this.l.a(this.G);
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
    if (this.o != null) {
      this.o.a(this.b);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcGridSocial
 * JD-Core Version:    0.7.0.1
 */