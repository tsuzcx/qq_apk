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
    int i = this.a.getMeasuredWidth();
    CharSequence localCharSequence = TextUtils.ellipsize(this.b, this.a.getPaint(), i - 15, TextUtils.TruncateAt.END);
    this.a.setText(localCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */