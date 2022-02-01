package com.tencent.mobileqq.filemanager.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter.ItemHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class FMLocalFileActivity$2
  implements View.OnClickListener
{
  FMLocalFileActivity$2(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a()) {
      if (QLog.isColorLevel()) {
        QLog.i(FMLocalFileActivity.f, 2, "click too fast , wait a minute.");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.e();
      Object localObject = (FileCategoryAdapter.ItemHolder)paramView.getTag();
      if (((FileCategoryAdapter.ItemHolder)localObject).a != 0)
      {
        int i = ((FileCategoryAdapter.ItemHolder)localObject).a;
        localObject = this.a.app.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("last_select_All", true);
        ((SharedPreferences.Editor)localObject).commit();
        FMLocalFileActivity.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity.2
 * JD-Core Version:    0.7.0.1
 */