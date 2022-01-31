package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aqwl;
import aqwm;
import arqx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(aqwl paramaqwl) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (aqwl.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(aqwl.a(this.this$0));
      }
      if (aqwl.a(this.this$0) == null) {
        aqwl.a(this.this$0, new aqwm(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(aqwl.a(this.this$0), localIntentFilter);
      arqx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */