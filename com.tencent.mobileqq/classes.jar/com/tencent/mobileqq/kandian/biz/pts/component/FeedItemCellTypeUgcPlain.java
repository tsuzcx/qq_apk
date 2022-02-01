package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeUgcPlain
  extends FeedItemCell
{
  public FeedItemCellTypeUgcPlain(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeUgcPlain", 2, "ugc plain create");
    }
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return d(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).q().l().g().n().j();
  }
  
  public FeedItemCell d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellTypeUgcPlain", 2, "ugc plain layout");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc);
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
    return super.g();
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentHeaderUgc.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public FeedItemCell p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentSocialOperation.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentContentUgcOriginalHeader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCell$CellListener);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeUgcPlain
 * JD-Core Version:    0.7.0.1
 */