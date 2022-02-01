package com.tencent.mobileqq.studymode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class StudyModeSwitchDialog$initView$2
  implements View.OnClickListener
{
  StudyModeSwitchDialog$initView$2(StudyModeSwitchDialog paramStudyModeSwitchDialog) {}
  
  public final void onClick(View paramView)
  {
    StudyModeSwitchDialog.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialog.initView.2
 * JD-Core Version:    0.7.0.1
 */