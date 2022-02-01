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
  private int b = 0;
  private int c = 0;
  
  public FeedItemCellTypeBigSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).f().g().h().q().l().n().j();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout1.setOrientation(1);
      localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial != null) {
        localLinearLayout1.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial);
      }
      LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout2.setOrientation(1);
      localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary != null) {
        localLinearLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentBig)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        LinearLayout localLinearLayout3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        localLinearLayout3.setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.gravity = 1;
        localLinearLayout3.setLayoutParams(localLayoutParams);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        ((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setId(1);
        ((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
        localLinearLayout3.addView((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setId(2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
        localLinearLayout3.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        localLinearLayout3.setOnClickListener(new FeedItemCellTypeBigSocial.1(this, localLinearLayout1, localLinearLayout3, localLinearLayout2));
        localLinearLayout3.setDuplicateParentStateEnabled(true);
        localLinearLayout3.setOnTouchListener(new FeedItemCellTypeBigSocial.2(this, localLinearLayout3));
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeBigSocial.3(this, localLinearLayout3));
        ApiCompatibilityUtils.a(localLinearLayout3, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842991));
        localLinearLayout2.addView(localLinearLayout3);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeBigSocial.4(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeBigSocial.5(this, localLinearLayout2, localLinearLayout3));
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeBigSocial.6(this));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
        localLinearLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource);
      }
      if (localLinearLayout2.getChildCount() > 0) {
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
    throw new Exception("buildComponent() must after buildComponent()!");
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
        if (localIReadInJoyModel.a() != null) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(localIReadInJoyModel.c(), localIReadInJoyModel.a().mArticleID));
        }
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeBigSocial
 * JD-Core Version:    0.7.0.1
 */