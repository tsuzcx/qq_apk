package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicSocial
  extends FeedItemCellTypeBigImage
{
  public FeedItemCellTypeTopicSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell b()
  {
    this.h = true;
    return a(this.g, this.f).g().i().j().t().n().p();
  }
  
  public FeedItemCell e()
  {
    if (this.h)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.v != null) {
        localLinearLayout.addView(this.v);
      }
      if ((this.l != null) && ((this.l instanceof ComponentContentBig)) && (this.m != null))
      {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.e);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, this.e.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, this.e.getResources());
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(13.0F, this.e.getResources());
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(150.0F, this.e.getResources()));
        ((ComponentContentBig)this.l).setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new ImageView(this.e);
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(150.0F, this.e.getResources())));
        ((ImageView)localObject).setBackgroundColor(Color.parseColor("#66000000"));
        localRelativeLayout.addView((ComponentContentBig)this.l);
        localRelativeLayout.addView((View)localObject);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout.addView(this.m);
        localRelativeLayout.setOnClickListener(new FeedItemCellTypeTopicSocial.1(this));
        localLinearLayout.addView(localRelativeLayout);
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
  
  public FeedItemCell j()
  {
    this.m = new ComponentCenterTopicTitle(this.e);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicSocial
 * JD-Core Version:    0.7.0.1
 */