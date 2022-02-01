package com.tencent.mobileqq.extendfriend.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ProfileGuideDialogUtils$2
  implements View.OnClickListener
{
  ProfileGuideDialogUtils$2(Context paramContext, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/extend-friend/?_wv=536870912");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DE", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils.2
 * JD-Core Version:    0.7.0.1
 */