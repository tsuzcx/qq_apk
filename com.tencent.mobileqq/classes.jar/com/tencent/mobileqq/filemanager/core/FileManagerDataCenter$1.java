package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import atlf;
import atlg;
import audf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(atlf paramatlf) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (atlf.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(atlf.a(this.this$0));
      }
      if (atlf.a(this.this$0) == null) {
        atlf.a(this.this$0, new atlg(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(atlf.a(this.this$0), localIntentFilter);
      audf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */