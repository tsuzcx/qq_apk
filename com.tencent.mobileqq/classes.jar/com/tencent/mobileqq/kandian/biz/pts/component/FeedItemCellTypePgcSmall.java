package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePgcSmall
  extends FeedItemCell
{
  public FeedItemCellTypePgcSmall(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return c(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).q().l().n().h().g().j();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        RelativeLayout localRelativeLayout1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localRelativeLayout1.setPadding(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
        RelativeLayout localRelativeLayout2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localRelativeLayout2.setBackgroundResource(2130842999);
        localRelativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(79.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(104.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -1);
        localLayoutParams.addRule(11);
        ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
        ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setId(1);
        localRelativeLayout2.addView((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).getId());
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
        localRelativeLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        localRelativeLayout1.addView(localRelativeLayout2);
        localRelativeLayout2.setOnClickListener(new FeedItemCellTypePgcSmall.1(this));
        localLinearLayout.addView(localRelativeLayout1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource);
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
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderPublish.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcSmall
 * JD-Core Version:    0.7.0.1
 */