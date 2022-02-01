package com.tencent.mobileqq.studyroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyRoomDebugSettingFragment$3
  implements View.OnClickListener
{
  StudyRoomDebugSettingFragment$3(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment) {}
  
  public void onClick(View paramView)
  {
    ((EditText)StudyRoomDebugSettingFragment.b(this.a).findViewById(2131378621)).setText("");
    StudyRoomDebugSettingFragment.a(this.a, "studyroom_plugin_name", "");
    StudyRoomDebugSettingFragment.a(this.a, "/data/local/tmp/StudyRoom.zip");
    StudyRoomDebugSettingFragment.a(this.a, "/data/local/tmp/StudyRoomPluginManager.apk");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */