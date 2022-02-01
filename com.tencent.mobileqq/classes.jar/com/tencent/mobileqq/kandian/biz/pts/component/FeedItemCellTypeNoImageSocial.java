package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeNoImageSocial
  extends FeedItemCellTypeNoImage
{
  public FeedItemCellTypeNoImageSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).g().j().t().n().p().l();
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
      ApiCompatibilityUtils.a(localLinearLayout2, this.e.getResources().getDrawable(2130842691));
      if (this.k != null) {
        localLinearLayout2.addView(this.k);
      }
      if (this.m != null)
      {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
        Object localObject = new LinearLayout.LayoutParams(-1, AIOUtils.b(79.0F, this.e.getResources()));
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, this.e.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, this.e.getResources());
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(13.0F, this.e.getResources());
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        ((RelativeLayout.LayoutParams)localObject).addRule(9);
        this.m.setId(1);
        this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout.addView(this.m);
        localRelativeLayout.setOnClickListener(new FeedItemCellTypeNoImageSocial.1(this));
        localRelativeLayout.setDuplicateParentStateEnabled(true);
        localRelativeLayout.setOnTouchListener(new FeedItemCellTypeNoImageSocial.2(this, localRelativeLayout));
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeNoImageSocial.3(this, localRelativeLayout));
        ApiCompatibilityUtils.a(localRelativeLayout, this.e.getResources().getDrawable(2130843947));
        localLinearLayout2.addView(localRelativeLayout);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeNoImageSocial.4(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeNoImageSocial.5(this, localLinearLayout2, localRelativeLayout));
      }
      if (this.o != null) {
        localLinearLayout2.addView(this.o);
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeNoImageSocial.6(this));
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
        this.v.setReadedStatus(this.g.b(localIReadInJoyModel.m(), localIReadInJoyModel.k().mArticleID));
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNoImageSocial
 * JD-Core Version:    0.7.0.1
 */