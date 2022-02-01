package com.tencent.mobileqq.filemanager.fileviewer;

import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.data.FMConstants;

class FileBrowserActivity$4
  implements Runnable
{
  FileBrowserActivity$4(FileBrowserActivity paramFileBrowserActivity, String paramString) {}
  
  public void run()
  {
    int i = FileBrowserActivity.d(this.this$0).getMeasuredWidth();
    String str = (String)TextUtils.ellipsize(this.a, FileBrowserActivity.d(this.this$0).getPaint(), i - 15, TextUtils.TruncateAt.END);
    Object localObject = str;
    if (str.length() > 2)
    {
      localObject = str;
      if (str.substring(str.length() - 1).equals(FMConstants.l))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str.substring(0, str.length() - 1));
        ((StringBuilder)localObject).append(FMConstants.j);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    FileBrowserActivity.d(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity.4
 * JD-Core Version:    0.7.0.1
 */