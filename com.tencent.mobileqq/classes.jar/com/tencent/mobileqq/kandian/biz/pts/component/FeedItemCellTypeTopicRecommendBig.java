package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicRecommendBig
  extends FeedItemCell
{
  public FeedItemCellTypeTopicRecommendBig(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return f(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).q().l().n().h().g();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend != null) {
        localLinearLayout1.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentBig)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localRelativeLayout1.setPadding(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
        LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout2.setOrientation(1);
        localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localLinearLayout2.addView((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localRelativeLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localLinearLayout2.addView(localRelativeLayout2);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(15);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localRelativeLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        localLinearLayout2.setBackgroundResource(2130842999);
        localLinearLayout2.setOnClickListener(new FeedItemCellTypeTopicRecommendBig.1(this));
        localRelativeLayout1.addView(localLinearLayout2);
        localLinearLayout1.addView(localRelativeLayout1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
        localLinearLayout1.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
        localLinearLayout1.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
        localLinearLayout1.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead);
      }
      a(localLinearLayout1);
      return this;
    }
    throw new Exception("buildComponent() must after buildComponent()!");
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderTopicRecommend.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendBig
 * JD-Core Version:    0.7.0.1
 */