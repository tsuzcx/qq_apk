package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

class FeedItemCellTypeBigSocial$1
  implements View.OnClickListener
{
  FeedItemCellTypeBigSocial$1(FeedItemCellTypeBigSocial paramFeedItemCellTypeBigSocial, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, LinearLayout paramLinearLayout3) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyHelper.f(ReadInJoyUtils.a(), this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop() + this.b.getTop() + this.c.getTop());
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCellTypeBigSocial.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a().a();
    if (paramView != null) {
      paramView.a(null, ((IReadInJoyModel)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentFeedItemCellTypeBigSocial.jdField_a_of_type_JavaLangObject).a(), 2);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("firstlayout top");
      paramView.append(this.jdField_a_of_type_AndroidWidgetLinearLayout.getTop());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
      paramView = new StringBuilder();
      paramView.append("firstlayout width");
      paramView.append(this.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
      paramView = new StringBuilder();
      paramView.append("thirdlayout top");
      paramView.append(this.b.getTop());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
      paramView = new StringBuilder();
      paramView.append("thirdlayout width");
      paramView.append(this.b.getWidth());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
      paramView = new StringBuilder();
      paramView.append("secondlayout top");
      paramView.append(this.c.getTop());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
      paramView = new StringBuilder();
      paramView.append("secondlayout width");
      paramView.append(this.c.getWidth());
      QLog.d("Q.readinjoy.videoanimation", 2, new Object[] { "position show", paramView.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCellTypeBigSocial.1
 * JD-Core Version:    0.7.0.1
 */