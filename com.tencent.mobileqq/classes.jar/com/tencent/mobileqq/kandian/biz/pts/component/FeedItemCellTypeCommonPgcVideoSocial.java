package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeCommonPgcVideoSocial
  extends FeedItemCellTypeBigSocial
{
  public FeedItemCellTypeCommonPgcVideoSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
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
      localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      if (this.k != null) {
        localLinearLayout2.addView(this.k);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig)))
      {
        LinearLayout localLinearLayout3 = new LinearLayout(this.e);
        localLinearLayout3.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(0.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()), AIOUtils.b(12.0F, this.e.getResources()));
        localLinearLayout3.setLayoutParams(localLayoutParams);
        localLinearLayout3.addView((View)this.l);
        if ((this.l instanceof ComponentContentBigImageVideo)) {
          localLinearLayout3.setOnClickListener(new FeedItemCellTypeCommonPgcVideoSocial.1(this));
        }
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeCommonPgcVideoSocial.2(this, localLinearLayout3));
        ApiCompatibilityUtils.a(localLinearLayout3, this.e.getResources().getDrawable(2130844109));
        localLinearLayout2.addView(localLinearLayout3);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeCommonPgcVideoSocial.3(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeCommonPgcVideoSocial.4(this, localLinearLayout2, localLinearLayout3));
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeCommonPgcVideoSocial.5(this));
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
  
  public FeedItemCell i()
  {
    this.l = new ComponentContentPgcVideo(this.e);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeCommonPgcVideoSocial
 * JD-Core Version:    0.7.0.1
 */