package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

public class SkinnableServiceProcesser
  extends BroadcastReceiver
{
  private final Service a;
  private final SkinnableServiceProcesser.Callback b;
  
  public SkinnableServiceProcesser(Service paramService, SkinnableServiceProcesser.Callback paramCallback)
  {
    this.a = paramService;
    this.b = paramCallback;
    try
    {
      this.a.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramService) {}
  }
  
  public void a()
  {
    try
    {
      this.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
      return;
    }
    QLog.d("SkinEngine", 1, "SkinnableActivityProcesser on pre theme changed");
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.g();
    }
    QLog.d("SkinEngine", 1, "SkinnableActivityProcesser on post theme changed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SkinnableServiceProcesser
 * JD-Core Version:    0.7.0.1
 */