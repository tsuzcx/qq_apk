package com.tencent.mobileqq.filemanager.core;

import atup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$3
  implements Runnable
{
  public FileManagerDataCenter$3(atup paramatup) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null) && (atup.a(this.this$0) != null)) {
      this.this$0.a.getApp().unregisterReceiver(atup.a(this.this$0));
    }
    atup.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.3
 * JD-Core Version:    0.7.0.1
 */