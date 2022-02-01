package com.tencent.mobileqq.studyroom.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.studyroom.utils.StudyRoomUtils;

class StudyRoomDebugSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  StudyRoomDebugSettingFragment$1(StudyRoomDebugSettingFragment paramStudyRoomDebugSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!StudyRoomUtils.a(paramBoolean))
    {
      paramCompoundButton.setOnCheckedChangeListener(null);
      paramCompoundButton.setChecked(paramBoolean ^ true);
      paramCompoundButton.setOnCheckedChangeListener(this);
      return;
    }
    StudyRoomDebugSettingFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */