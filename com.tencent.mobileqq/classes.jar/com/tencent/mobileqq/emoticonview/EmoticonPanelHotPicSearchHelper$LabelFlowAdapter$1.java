package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoticonPanelHotPicSearchHelper$LabelFlowAdapter$1
  implements View.OnClickListener
{
  EmoticonPanelHotPicSearchHelper$LabelFlowAdapter$1(EmoticonPanelHotPicSearchHelper.LabelFlowAdapter paramLabelFlowAdapter, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (this.val$tagBtn.getText() != null)
    {
      String str = this.val$tagBtn.getText().toString();
      this.this$1.this$0.startSearch(str);
      ReportController.b(this.this$1.this$0.getApp().getQQAppInterface(), "dc00898", "", "", "0X800AE1F", "0X800AE1F", 0, 0, "2", "", str, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelHotPicSearchHelper.LabelFlowAdapter.1
 * JD-Core Version:    0.7.0.1
 */