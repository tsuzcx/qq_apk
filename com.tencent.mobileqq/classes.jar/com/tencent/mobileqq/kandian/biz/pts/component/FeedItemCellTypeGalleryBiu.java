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
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).h().f().g().q().l().n().j();
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
      Object localObject = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      localLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary != null) {
        localLinearLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGalleryBiu)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null))
      {
        localObject = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        ((LinearLayout)localObject).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.gravity = 1;
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setId(1);
        ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setId(2);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setLayoutParams(localLayoutParams);
        ((LinearLayout)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.setOnClickListener(new FeedItemCellTypeGalleryBiu.1(this));
        ((LinearLayout)localObject).setOnClickListener(new FeedItemCellTypeGalleryBiu.2(this));
        ((LinearLayout)localObject).setDuplicateParentStateEnabled(true);
        ((LinearLayout)localObject).setOnTouchListener(new FeedItemCellTypeGalleryBiu.3(this, (LinearLayout)localObject));
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeGalleryBiu.4(this, (LinearLayout)localObject));
        ApiCompatibilityUtils.a((View)localObject, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842991));
        localLinearLayout2.addView((View)localObject);
        localLinearLayout2.setDuplicateParentStateEnabled(true);
        localLinearLayout2.setOnTouchListener(new FeedItemCellTypeGalleryBiu.5(this, localLinearLayout2));
        localLinearLayout1.setOnTouchListener(new FeedItemCellTypeGalleryBiu.6(this, localLinearLayout2, (LinearLayout)localObject));
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypeGalleryBiu.7(this));
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
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell f()
  {
    super.f();
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentGalleryBiu(this.jdField_a_of_type_AndroidContentContext);
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setPosition(this.jdField_a_of_type_Int);
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeGalleryBiu
 * JD-Core Version:    0.7.0.1
 */