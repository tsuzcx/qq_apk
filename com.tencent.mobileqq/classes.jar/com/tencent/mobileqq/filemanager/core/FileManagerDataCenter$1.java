package com.tencent.mobileqq.filemanager.core;

import android.content.IntentFilter;
import aoza;
import aozb;
import apti;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class FileManagerDataCenter$1
  implements Runnable
{
  public FileManagerDataCenter$1(aoza paramaoza) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.getApp() != null))
    {
      if (aoza.a(this.this$0) != null) {
        this.this$0.a.getApp().unregisterReceiver(aoza.a(this.this$0));
      }
      if (aoza.a(this.this$0) == null) {
        aoza.a(this.this$0, new aozb(this));
      }
      IntentFilter localIntentFilter = new IntentFilter("com.opensdk.downloadmanager.renameFilename");
      this.this$0.a.getApp().registerReceiver(aoza.a(this.this$0), localIntentFilter);
      apti.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerDataCenter.1
 * JD-Core Version:    0.7.0.1
 */