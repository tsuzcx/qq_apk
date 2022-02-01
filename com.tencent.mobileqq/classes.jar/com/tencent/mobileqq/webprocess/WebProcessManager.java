package com.tencent.mobileqq.webprocess;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

@Deprecated
public class WebProcessManager
  implements Manager
{
  protected QQAppInterface a;
  private boolean b = false;
  private final BroadcastReceiver c = new WebProcessManager.1(this);
  private final BabyQObserver d = new WebProcessManager.2(this);
  
  public WebProcessManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    a();
  }
  
  @Deprecated
  private void a()
  {
    if (!this.b) {
      this.b = true;
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.babyq.add");
      BaseApplicationImpl.getContext().registerReceiver(this.c, localIntentFilter);
      this.a.addObserver(this.d);
      return;
    }
    catch (Exception localException) {}
  }
  
  @Deprecated
  private void b()
  {
    if (this.b) {}
    try
    {
      this.b = false;
      BaseApplicationImpl.getContext().unregisterReceiver(this.c);
      this.a.removeObserver(this.d);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onDestroy()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessManager
 * JD-Core Version:    0.7.0.1
 */