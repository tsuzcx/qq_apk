package com.tencent.mobileqq.studyroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StudyRoomTimeHintDialog$1
  implements View.OnClickListener
{
  StudyRoomTimeHintDialog$1(StudyRoomTimeHintDialog paramStudyRoomTimeHintDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.ui.StudyRoomTimeHintDialog.1
 * JD-Core Version:    0.7.0.1
 */