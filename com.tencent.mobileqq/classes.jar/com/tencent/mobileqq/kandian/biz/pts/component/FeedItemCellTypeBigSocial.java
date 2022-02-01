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

public class FeedItemCellTypeBigSocial
  extends FeedItemCellTypeBigImage
{
  private int G = 0;
  private int H = 0;
  
  public FeedItemCellTypeBigSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).g().i().j().t().n().p().l();
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
      localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      if (this.k != null) {
        localLinearLayout2.addView(this.k);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig)) && (this.m != null))
      {
        LinearLayout localLinearLayout3 = new LinearLayout(this.e);
        localLinearLayout3.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = AIOUtils.b(12.0F, this.e.getResources());
        localLayoutParams.rightMargin = AIOUtils.b(12.0F, this.e.getResources());
        localLayoutParams.bottomMargin = AIOUtils.b(13.0F, this.e.getResources());
        localLayoutParams.gravity = 1;
        localLinearLayout3.setLayoutParams(localLayoutParams);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        ((ComponentContentBig)this.l).setId(1);
        ((ComponentContentBig)this.l).setLayoutParams(localLayoutParams);
        localLinearLayout3.addView((ComponentContentBig)this.l);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.m.setId(2);
        this.m.setLayoutParams(localLayoutParams);
        localLinearLayout3.addView(this.m);
        localLinearLayout3.setOnClickListener(new FeedItemCellTypeBigSocial.1(this, localLinearLayout1, localLinearLayout3, localLinearLayout2));
        localLinearLayout3.setDuplicateParentStateEnabled(true);
        localLinearLayout3.setOnTouchListener(new FeedItemCellTypeBigSocial.2(this, localLinearLayout3));
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeBigSocial.3(this, localLinearLayout3));
        ApiCompatibilityUtils.a(localLinearLayout3, this.e.getResources().getDrawable(2130843947));
        localLinearLayout2.addView(localLinearLayout3);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeBigSocial.4(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeBigSocial.5(this, localLinearLayout2, localLinearLayout3));
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeBigSocial.6(this));
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
  
  public FeedItemCell q()
  {
    super.q();
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeBigSocial
 * JD-Core Version:    0.7.0.1
 */