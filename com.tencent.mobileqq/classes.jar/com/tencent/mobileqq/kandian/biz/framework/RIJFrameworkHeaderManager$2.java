package com.tencent.mobileqq.kandian.biz.framework;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.qphone.base.util.QLog;

class RIJFrameworkHeaderManager$2
  implements Runnable
{
  RIJFrameworkHeaderManager$2(RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager, View paramView1, int paramInt1, int paramInt2, View paramView2, ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    RIJFrameworkHeaderManager.a(this.this$0).i();
    if ((ChannelModeConfigHandler.b()) && (ChannelModeConfigHandler.a())) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    StringBuilder localStringBuilder;
    if ((j != this.jdField_a_of_type_Int) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=");
      localStringBuilder.append(j);
      localStringBuilder.append(",heightDef =");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
    }
    if (ChannelModeConfigHandler.a())
    {
      int k = this.jdField_b_of_type_Int;
      int i;
      if (j <= k * 3)
      {
        i = j;
        if (j >= k) {}
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("hideWithAnimation");
        localStringBuilder.append(j);
        AIOUtils.a("RIJFrameworkReportManager", "", new IllegalStateException(localStringBuilder.toString()));
        i = this.jdField_b_of_type_Int;
      }
      this.jdField_b_of_type_AndroidViewView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setPadding(0, i, 0, 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=");
        localStringBuilder.append(i);
        localStringBuilder.append(",heightDef =");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
      }
      if (i <= this.jdField_b_of_type_Int) {
        RIJFrameworkHeaderManager.a(this.this$0).i();
      }
    }
    else if (j > this.jdField_a_of_type_Int)
    {
      this.jdField_b_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setPadding(0, j, 0, 0);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI 看点 mListView.setPadding statusLineHeight=");
        localStringBuilder.append(j);
        QLog.d("RIJFrameworkReportManager", 2, localStringBuilder.toString());
      }
      RIJFrameworkHeaderManager.a(this.this$0).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJFrameworkHeaderManager.2
 * JD-Core Version:    0.7.0.1
 */