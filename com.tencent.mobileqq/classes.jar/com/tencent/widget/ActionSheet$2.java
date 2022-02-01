package com.tencent.widget;

import android.os.Handler;
import android.widget.TextView;

class ActionSheet$2
  implements ActionSheet.OnTextImageFetchedListener
{
  ActionSheet$2(ActionSheet paramActionSheet, TextView paramTextView) {}
  
  public void onFetched(CharSequence paramCharSequence)
  {
    ActionSheet.access$000(this.this$0).post(new ActionSheet.2.1(this, paramCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */