package com.tencent.mobileqq.studymode;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class StudyModeSwitchDialog$initView$1
  implements View.OnClickListener
{
  StudyModeSwitchDialog$initView$1(StudyModeSwitchDialog paramStudyModeSwitchDialog) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    ReportController.b((AppRuntime)StudyModeSwitchDialog.a(this.a).app, "dc00898", "", "", "0X800ADD6", "0X800ADD6", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialog.initView.1
 * JD-Core Version:    0.7.0.1
 */