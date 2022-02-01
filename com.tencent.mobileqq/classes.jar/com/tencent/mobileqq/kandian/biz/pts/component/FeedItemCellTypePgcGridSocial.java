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
import java.util.List;

public class FeedItemCellTypePgcGridSocial
  extends FeedItemCell
{
  private ComponentContentGridImage.Model a;
  
  public FeedItemCellTypePgcGridSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).f().g().q().l().n().j();
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
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
      localLinearLayout2.setLayoutParams(localLayoutParams);
      ApiCompatibilityUtils.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841774));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary != null) {
        localLinearLayout2.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGridImage)))
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
        ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setDuplicateParentStateEnabled(true);
        ApiCompatibilityUtils.a((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841774));
        ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setOnNoItemClickListener(new FeedItemCellTypePgcGridSocial.1(this));
        localLinearLayout2.addView((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
      }
      localLinearLayout2.setOnClickListener(new FeedItemCellTypePgcGridSocial.2(this));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Model != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGridImage)))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).getLayoutParams() instanceof LinearLayout.LayoutParams)) {
        localLayoutParams = (LinearLayout.LayoutParams)((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).getLayoutParams();
      } else {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Model.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Model.a().size() != 0)) {
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      } else {
        localLayoutParams.setMargins(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      }
      ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setLayoutParams(localLayoutParams);
    }
    return this;
  }
  
  public FeedItemCell f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentGridImage(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
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
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentAccountSummary.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Model = ComponentContentGridImage.a(this.jdField_a_of_type_JavaLangObject, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentGridImage$Model);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    try
    {
      e();
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePgcGridSocial
 * JD-Core Version:    0.7.0.1
 */