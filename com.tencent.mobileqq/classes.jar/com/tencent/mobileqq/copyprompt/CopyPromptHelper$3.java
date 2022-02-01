package com.tencent.mobileqq.copyprompt;

import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class CopyPromptHelper$3
  implements View.OnClickListener
{
  CopyPromptHelper$3(CopyPromptHelper paramCopyPromptHelper, String paramString) {}
  
  public void onClick(View paramView)
  {
    CopyPromptHelper.b(this.b).removeCallbacks(CopyPromptHelper.a(this.b));
    CopyPromptHelper.a(this.b).run();
    int i = CopyPromptHelper.d(this.b).Y.getSelectionStart();
    Editable localEditable = CopyPromptHelper.d(this.b).Y.getEditableText();
    if ((i >= 0) && (i < localEditable.length())) {
      localEditable.insert(i, this.a);
    } else {
      localEditable.append(this.a);
    }
    ReportController.b(CopyPromptHelper.d(this.b).i(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.3
 * JD-Core Version:    0.7.0.1
 */