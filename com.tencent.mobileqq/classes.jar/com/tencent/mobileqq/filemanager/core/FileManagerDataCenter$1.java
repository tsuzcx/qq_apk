package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aqsc;
import aqsd;
import armo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(aqsc paramaqsc) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (aqsc.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(aqsc.a(this.this$0));
      }
      if (aqsc.a(this.this$0) == null) {
        aqsc.a(this.this$0, new aqsd(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(aqsc.a(this.this$0), localIntentFilter);
      armo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */