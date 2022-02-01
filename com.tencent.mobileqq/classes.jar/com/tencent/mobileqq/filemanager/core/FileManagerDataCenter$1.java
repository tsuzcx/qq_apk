package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import atup;
import atuq;
import aumo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(atup paramatup) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (atup.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(atup.a(this.this$0));
      }
      if (atup.a(this.this$0) == null) {
        atup.a(this.this$0, new atuq(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(atup.a(this.this$0), localIntentFilter);
      aumo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */