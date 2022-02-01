package com.tencent.mobileqq.studyroom.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyRoomDebugSettingFragment$2
  implements View.OnClickListener
{
  StudyRoomDebugSettingFragment$2(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment) {}
  
  public void onClick(View paramView)
  {
    String str = ((EditText)StudyRoomDebugSettingFragment.a(this.a).findViewById(2131378621)).getText().toString();
    if (TextUtils.isEmpty(str)) {
      QQToast.a(this.a.getActivity(), "分支名不能为空。", 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StudyRoomDebugSettingFragment.a(this.a, "studyroom_plugin_name", str);
      StudyRoomDebugSettingFragment.a(this.a, "/data/local/tmp/StudyRoom.zip");
      StudyRoomDebugSettingFragment.a(this.a, "/data/local/tmp/StudyRoomPluginManager.apk");
      QQToast.a(this.a.getActivity(), "重置成功，返回打开自习室吧。", 2).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */