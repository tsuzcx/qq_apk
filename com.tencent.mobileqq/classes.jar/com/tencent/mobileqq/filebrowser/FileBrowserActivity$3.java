package com.tencent.mobileqq.filebrowser;

import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;

class FileBrowserActivity$3
  implements Runnable
{
  FileBrowserActivity$3(FileBrowserActivity paramFileBrowserActivity, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth();
    CharSequence localCharSequence = TextUtils.ellipsize(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), i - 15, TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */