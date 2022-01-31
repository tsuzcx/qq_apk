package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;

public class ProfileNowVideoCtrl
  implements AdapterView.OnItemClickListener
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected QQAppInterface a;
  protected ProfileNowVideoAdapter a;
  protected String a;
  
  public void a(ScrollView paramScrollView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 300L);
    }
  }
  
  public void a(String paramString)
  {
    String str = "2";
    if (this.jdField_a_of_type_Int == 2) {
      str = "1";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramString, 0, 0, str, "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNowVideoCtrl", 2, "report: opName=" + paramString + ", mode=" + str);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ProfileNowVideoAdapter.VideoFeeds)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileNowVideoAdapter.getItem(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardProfileNowVideoAdapter.a(paramInt))
    {
      paramAdapterView = this.jdField_a_of_type_JavaLangString;
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramView.putExtra("url", paramAdapterView);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileNowVideoCtrl", 2, "onItemClick: position=" + paramInt + ", moreUrl=" + this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        a("clk_more_myvideo");
        return;
      }
      a("clk_more_video");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNowVideoCtrl", 2, "onItemClick: position=" + paramInt + ", Tnow=" + paramAdapterView.jdField_a_of_type_JavaLangString);
    }
    try
    {
      JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAdapterView.jdField_a_of_type_JavaLangString).b();
      a("clk_video");
      return;
    }
    catch (Exception paramAdapterView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ProfileNowVideoCtrl", 2, "onItemClick exp:" + paramAdapterView.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ProfileNowVideoCtrl
 * JD-Core Version:    0.7.0.1
 */