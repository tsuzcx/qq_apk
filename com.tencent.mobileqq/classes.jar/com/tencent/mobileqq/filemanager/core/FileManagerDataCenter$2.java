package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.qphone.base.util.BaseApplication;

class FileManagerDataCenter$2
  implements Runnable
{
  FileManagerDataCenter$2(FileManagerDataCenter paramFileManagerDataCenter) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (FileManagerDataCenter.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(FileManagerDataCenter.a(this.this$0));
      }
      if (FileManagerDataCenter.a(this.this$0) == null) {
        FileManagerDataCenter.a(this.this$0, new FileManagerDataCenter.2.1(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(FileManagerDataCenter.a(this.this$0), localIntentFilter);
      FMSettings.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.2
 * JD-Core Version:    0.7.0.1
 */