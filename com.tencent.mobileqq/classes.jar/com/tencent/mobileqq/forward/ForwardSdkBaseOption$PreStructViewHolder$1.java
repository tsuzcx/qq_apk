package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardSdkBaseOption$PreStructViewHolder$1
  implements View.OnClickListener
{
  ForwardSdkBaseOption$PreStructViewHolder$1(ForwardSdkBaseOption.PreStructViewHolder paramPreStructViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.a.a.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "gotoWeb " + str);
      }
      Intent localIntent = new Intent(this.a.a.jdField_a_of_type_AndroidAppActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("reqType", 7);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", str);
      WebAccelerator.a(this.a.a.jdField_a_of_type_AndroidAppActivity, localIntent, str);
      this.a.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.PreStructViewHolder.1
 * JD-Core Version:    0.7.0.1
 */