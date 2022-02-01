package com.tencent.mobileqq.portal;

import android.content.Intent;
import android.support.v4.app.QFragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class RedPacketShowerFragment$2
  implements View.OnClickListener
{
  RedPacketShowerFragment$2(RedPacketShowerFragment paramRedPacketShowerFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.a.jdField_a_of_type_JavaUtilMap.containsKey("ext2")) {
          this.a.jdField_a_of_type_JavaUtilMap.remove("ext2");
        }
        if (QLog.isColorLevel()) {
          QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI close", this.a.jdField_a_of_type_JavaUtilMap });
        }
        SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.a.jdField_a_of_type_JavaUtilMap, "close", true);
        this.a.getActivity().finish();
      }
    } while (!this.a.a());
    if (this.a.jdField_a_of_type_JavaUtilMap.containsKey("ext2")) {
      this.a.jdField_a_of_type_JavaUtilMap.remove("ext2");
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPacketShowerFragment", 2, new Object[] { "initUI click", this.a.jdField_a_of_type_JavaUtilMap });
    }
    SpringHbReporter.a(ReportConstant.Event.o, 0, 0, this.a.jdField_a_of_type_JavaUtilMap, "clk", true);
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a.jdField_a_of_type_Int == 1)
    {
      localStringBuilder.append(this.a.e);
      localStringBuilder.append("&from=").append(25);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedPacketShowerFragment", 2, "jumpUrl " + localStringBuilder);
      }
      Intent localIntent = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppQFragmentActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", localStringBuilder.toString());
      this.a.jdField_a_of_type_AndroidSupportV4AppQFragmentActivity.startActivity(localIntent);
      this.a.getActivity().finish();
      break;
      localStringBuilder.append("https://ti.qq.com/hb2021/packresult?_wv=16777219");
      localStringBuilder.append("&pack_id=").append(this.a.f);
      localStringBuilder.append("&business_id=").append(this.a.c);
      localStringBuilder.append("&type=").append(this.a.jdField_a_of_type_Int);
      localStringBuilder.append("&state=").append(this.a.b);
      localStringBuilder.append("&from=").append(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.RedPacketShowerFragment.2
 * JD-Core Version:    0.7.0.1
 */