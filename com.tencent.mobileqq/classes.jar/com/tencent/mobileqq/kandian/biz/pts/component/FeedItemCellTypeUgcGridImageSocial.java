package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class FeedItemCellTypeUgcGridImageSocial
  extends FeedItemCellTypeUgcPlainSocial
{
  public FeedItemCellTypeUgcGridImageSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
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
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a(localIReadInJoyModel.c(), localIReadInJoyModel.a().mArticleID));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentDivider.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentGridImage)) {
        ((ComponentContentGridImage)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).setMIReadInJoyModel(this.jdField_a_of_type_JavaLangObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView.a(ComponentContentGridImage.a(((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject).a()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcGridImageSocial
 * JD-Core Version:    0.7.0.1
 */