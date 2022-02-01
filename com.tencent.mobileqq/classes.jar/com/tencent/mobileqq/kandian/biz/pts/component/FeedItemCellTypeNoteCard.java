package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyLifeCycleLinearLayout;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeNoteCard
  extends FeedItemCell
{
  public FeedItemCellTypeNoteCard(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public void b()
  {
    super.b();
    ((ComponentContentNoteCard)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView).d();
  }
  
  public FeedItemCell d()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentView = new ComponentContentNoteCard(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeNoteCard
 * JD-Core Version:    0.7.0.1
 */