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
    LiteCopyPromptHelper.c(this.b).removeCallbacks(LiteCopyPromptHelper.b(this.b));
    LiteCopyPromptHelper.b(this.b).run();
    int i = LiteCopyPromptHelper.e(this.b).getSelectionStart();
    Editable localEditable = LiteCopyPromptHelper.e(this.b).getEditableText();
    if ((i >= 0) && (i < localEditable.length())) {
      localEditable.insert(i, this.a);
    } else {
      localEditable.append(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.3
 * JD-Core Version:    0.7.0.1
 */