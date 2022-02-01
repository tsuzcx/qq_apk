package com.tencent.mobileqq.writetogetherui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogether.statemachine.CreatingState;
import com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WriteTogetherEditorFragment$14
  implements View.OnClickListener
{
  WriteTogetherEditorFragment$14(WriteTogetherEditorFragment paramWriteTogetherEditorFragment) {}
  
  public void onClick(View paramView)
  {
    if (WriteTogetherEditorFragment.a(this.a).a() == CreatingState.TEMPLATE_SHOW_ENTRANCE)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B357", "0X800B357", 0, 0, "", "", "", "");
      WriteTogetherEditorFragment.a(this.a).a(CreatingState.TEMPLATE_SHOW_LAYER);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment.14
 * JD-Core Version:    0.7.0.1
 */