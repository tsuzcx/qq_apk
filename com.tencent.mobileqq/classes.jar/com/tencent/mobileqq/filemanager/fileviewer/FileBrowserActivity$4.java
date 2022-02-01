package com.tencent.mobileqq.filemanager.fileviewer;

import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import atha;

class FileBrowserActivity$4
  implements Runnable
{
  FileBrowserActivity$4(FileBrowserActivity paramFileBrowserActivity, String paramString) {}
  
  public void run()
  {
    int i = FileBrowserActivity.a(this.this$0).getMeasuredWidth();
    String str2 = (String)TextUtils.ellipsize(this.a, FileBrowserActivity.a(this.this$0).getPaint(), i - 15, TextUtils.TruncateAt.END);
    String str1 = str2;
    if (str2.length() > 2)
    {
      str1 = str2;
      if (str2.substring(str2.length() - 1).equals(atha.b)) {
        str1 = str2.substring(0, str2.length() - 1) + atha.a;
      }
    }
    FileBrowserActivity.a(this.this$0).setText(str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.4
 * JD-Core Version:    0.7.0.1
 */