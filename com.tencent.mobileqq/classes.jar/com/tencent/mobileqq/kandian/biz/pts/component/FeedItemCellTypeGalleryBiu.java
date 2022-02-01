package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeGalleryBiu
  extends FeedItemCell
{
  public FeedItemCellTypeGalleryBiu(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).j().g().i().t().n().p().l();
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
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      localLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.k != null) {
        localLinearLayout2.addView(this.k);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentGalleryBiu)) && (this.m != null))
      {
        localObject = new LinearLayout(this.e);
        ((LinearLayout)localObject).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = AIOUtils.b(12.0F, this.e.getResources());
        localLayoutParams.rightMargin = AIOUtils.b(12.0F, this.e.getResources());
        localLayoutParams.bottomMargin = AIOUtils.b(13.0F, this.e.getResources());
        localLayoutParams.gravity = 1;
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        ((ComponentContentGalleryBiu)this.l).setId(1);
        ((ComponentContentGalleryBiu)this.l).setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView((ComponentContentGalleryBiu)this.l);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.m.setId(2);
        this.m.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView(this.m);
        this.m.setOnClickListener(new FeedItemCellTypeGalleryBiu.1(this));
        ((LinearLayout)localObject).setOnClickListener(new FeedItemCellTypeGalleryBiu.2(this));
        ((LinearLayout)localObject).setDuplicateParentStateEnabled(true);
        ((LinearLayout)localObject).setOnTouchListener(new FeedItemCellTypeGalleryBiu.3(this, (LinearLayout)localObject));
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeGalleryBiu.4(this, (LinearLayout)localObject));
        ApiCompatibilityUtils.a((View)localObject, this.e.getResources().getDrawable(2130843947));
        localLinearLayout2.addView((View)localObject);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeGalleryBiu.5(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeGalleryBiu.6(this, localLinearLayout2, (LinearLayout)localObject));
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeGalleryBiu.7(this));
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
    return null;
  }
  
  public FeedItemCell g()
  {
    super.g();
    return this;
  }
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentGalleryBiu(this.e);
    return this;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryBiu
 * JD-Core Version:    0.7.0.1
 */