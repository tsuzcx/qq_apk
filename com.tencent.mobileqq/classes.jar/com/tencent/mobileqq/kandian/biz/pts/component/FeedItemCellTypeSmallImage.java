package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeSmallImage
  extends FeedItemCell
{
  public FeedItemCellTypeSmallImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return b();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderSpecialTopic != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderSpecialTopic);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderFriendRecommend);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298830)));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setId(1);
        ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
        localRelativeLayout.addView((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).getId());
        localLayoutParams.topMargin = AIOUtils.b(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setId(2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
        localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo != null)
        {
          localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localLayoutParams.addRule(9);
          localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).getId());
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo.setId(3);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo.setLayoutParams(localLayoutParams);
          localRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentInfo);
        }
        localLinearLayout.addView(localRelativeLayout);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentJump);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentComment);
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
  
  public FeedItemCell e()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (CmpCtxt.d((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.getLayoutParams();
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
    }
    else if (!CmpCtxt.j((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.getLayoutParams();
      localLayoutParams.addRule(15, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
    }
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeSmallImage
 * JD-Core Version:    0.7.0.1
 */