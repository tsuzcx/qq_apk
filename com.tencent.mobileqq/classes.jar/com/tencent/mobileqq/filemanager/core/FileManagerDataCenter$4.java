package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class FileManagerDataCenter$4
  implements Runnable
{
  FileManagerDataCenter$4(FileManagerDataCenter paramFileManagerDataCenter) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null) && (FileManagerDataCenter.a(this.this$0) != null)) {
      this.this$0.a.getApp().unregisterReceiver(FileManagerDataCenter.a(this.this$0));
    }
    FileManagerDataCenter.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.4
 * JD-Core Version:    0.7.0.1
 */