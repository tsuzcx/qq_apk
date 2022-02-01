package com.tencent.mobileqq.filemanager.settings;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;

class FMSettings$5$1$1
  implements FMSettingInterface.MoveFileCallback
{
  FMSettings$5$1$1(FMSettings.5.1 param1) {}
  
  public void a()
  {
    this.a.a.a.runOnUiThread(new FMSettings.5.1.1.3(this));
    FMSettings.a(this.a.a.this$0);
    FileManagerReporter.a("0X8005BE2");
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.this$0.b = false;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.a.a.a.runOnUiThread(new FMSettings.5.1.1.2(this));
    FMSettings.a(this.a.a.this$0);
    synchronized (BaseApplicationImpl.getContext())
    {
      this.a.a.this$0.b = false;
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.a.a.a.runOnUiThread(new FMSettings.5.1.1.1(this, paramLong1, paramLong2));
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.5.1.1
 * JD-Core Version:    0.7.0.1
 */