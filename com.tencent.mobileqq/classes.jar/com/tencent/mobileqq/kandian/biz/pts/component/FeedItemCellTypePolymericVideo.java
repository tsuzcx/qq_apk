package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericVideo
  extends FeedItemCell
{
  public FeedItemCellTypePolymericVideo(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public FeedItemCell d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyModelImpl)) && (RIJFeedsType.h(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).a()))) {
        localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.b(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
      } else {
        localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.b(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTitle);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentBigImageVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypePolymericVideo
 * JD-Core Version:    0.7.0.1
 */