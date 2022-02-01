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
    CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper).removeCallbacks(CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper));
    CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper).run();
    int i = CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper).a.getSelectionStart();
    Editable localEditable = CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper).a.getEditableText();
    if ((i >= 0) && (i < localEditable.length())) {
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    } else {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    ReportController.b(CopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptCopyPromptHelper).a(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.3
 * JD-Core Version:    0.7.0.1
 */