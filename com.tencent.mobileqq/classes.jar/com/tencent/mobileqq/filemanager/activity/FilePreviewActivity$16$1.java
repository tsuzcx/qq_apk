package com.tencent.mobileqq.filemanager.activity;

import android.widget.TextView;

class FilePreviewActivity$16$1
  implements Runnable
{
  FilePreviewActivity$16$1(FilePreviewActivity.16 param16, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!this.c.a.a()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(this.a));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(String.valueOf(this.b));
    localObject = ((StringBuilder)localObject).toString();
    this.c.a.v.setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.1
 * JD-Core Version:    0.7.0.1
 */