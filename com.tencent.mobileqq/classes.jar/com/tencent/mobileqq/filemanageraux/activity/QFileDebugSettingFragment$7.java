package com.tencent.mobileqq.filemanageraux.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileDebugSettingFragment$7
  implements View.OnClickListener
{
  QFileDebugSettingFragment$7(QFileDebugSettingFragment paramQFileDebugSettingFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.getActivity().app;
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("dataline_msg_transform_" + ((QQAppInterface)localObject).getCurrentUin(), 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("msg_transform_begin_id_0", 0L);
    ((SharedPreferences.Editor)localObject).putLong("msg_transform_begin_id_1", 0L);
    ((SharedPreferences.Editor)localObject).putLong("msg_transform_count_0", 0L);
    ((SharedPreferences.Editor)localObject).putLong("msg_transform_count_1", 0L);
    ((SharedPreferences.Editor)localObject).apply();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.activity.QFileDebugSettingFragment.7
 * JD-Core Version:    0.7.0.1
 */