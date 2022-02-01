package com.tencent.mobileqq.copyprompt;

import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class LiteCopyPromptHelper$3
  implements View.OnClickListener
{
  LiteCopyPromptHelper$3(LiteCopyPromptHelper paramLiteCopyPromptHelper, String paramString) {}
  
  public void onClick(View paramView)
  {
    LiteCopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper).removeCallbacks(LiteCopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper));
    LiteCopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper).run();
    int i = LiteCopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper).getSelectionStart();
    Editable localEditable = LiteCopyPromptHelper.a(this.jdField_a_of_type_ComTencentMobileqqCopypromptLiteCopyPromptHelper).getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.3
 * JD-Core Version:    0.7.0.1
 */