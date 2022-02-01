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
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).f().g().h().q().l().n();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentBig)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((LinearLayout.LayoutParams)localObject).gravity = 1;
        localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        ((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        ((ImageView)localObject).setBackgroundColor(Color.parseColor("#66000000"));
        localRelativeLayout.addView((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        localRelativeLayout.addView((View)localObject);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        localRelativeLayout.setOnClickListener(new FeedItemCellTypeTopicSocial.1(this));
        localLinearLayout.addView(localRelativeLayout);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead);
      }
      a(localLinearLayout);
      return this;
    }
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle = new ComponentCenterTopicTitle(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(localIReadInJoyModel.c(), localIReadInJoyModel.a().mArticleID));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public FeedItemCell p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicSocial
 * JD-Core Version:    0.7.0.1
 */