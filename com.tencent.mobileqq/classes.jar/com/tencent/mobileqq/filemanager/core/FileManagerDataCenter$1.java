package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import asgz;
import asha;
import asyy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(asgz paramasgz) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (asgz.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(asgz.a(this.this$0));
      }
      if (asgz.a(this.this$0) == null) {
        asgz.a(this.this$0, new asha(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(asgz.a(this.this$0), localIntentFilter);
      asyy.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */