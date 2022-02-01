package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import aqrp;
import com.tencent.qphone.base.util.QLog;

public class SkinnableServiceProcesser
  extends BroadcastReceiver
{
  private final Service jdField_a_of_type_AndroidAppService;
  private final aqrp jdField_a_of_type_Aqrp;
  
  public SkinnableServiceProcesser(Service paramService, aqrp paramaqrp)
  {
    this.jdField_a_of_type_AndroidAppService = paramService;
    this.jdField_a_of_type_Aqrp = paramaqrp;
    try
    {
      this.jdField_a_of_type_AndroidAppService.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramService) {}
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidAppService.unregisterReceiver(this);
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
    if (this.jdField_a_of_type_Aqrp != null) {
      this.jdField_a_of_type_Aqrp.e();
    }
    QLog.d("SkinEngine", 1, "SkinnableActivityProcesser on post theme changed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.SkinnableServiceProcesser
 * JD-Core Version:    0.7.0.1
 */