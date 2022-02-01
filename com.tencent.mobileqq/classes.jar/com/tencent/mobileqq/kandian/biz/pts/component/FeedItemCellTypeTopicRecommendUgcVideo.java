package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeTopicRecommendUgcVideo
  extends FeedItemCellTypeTopicRecommendUgcImage
{
  public FeedItemCellTypeTopicRecommendUgcVideo(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return f(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).g().q().l().n();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentBigImageVideo)))
      {
        LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout2.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLinearLayout2.setLayoutParams(localLayoutParams);
        localLinearLayout2.addView((ComponentContentBigImageVideo)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null) {
          localLinearLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        }
        localLinearLayout2.setOnClickListener(new FeedItemCellTypeTopicRecommendUgcVideo.1(this));
        localLinearLayout1.addView(localLinearLayout2);
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
    throw new Exception("layoutComponent() must after buildComponent()!");
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentUgcVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeTopicRecommendUgcVideo
 * JD-Core Version:    0.7.0.1
 */