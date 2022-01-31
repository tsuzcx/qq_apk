package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aoig;
import aoih;
import apbo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(aoig paramaoig) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (aoig.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(aoig.a(this.this$0));
      }
      if (aoig.a(this.this$0) == null) {
        aoig.a(this.this$0, new aoih(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(aoig.a(this.this$0), localIntentFilter);
      apbo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */