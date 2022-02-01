package com.tencent.mobileqq.qqfloatingwindow.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.qphone.base.util.QLog;

public class QQFloatingWindowBroadcastImpl
  implements IQQFloatingWindowBroadcast
{
  private static final String TAG = "QQFloatingWindowBroadcastImpl";
  
  @Deprecated
  public void sendWindowClosedBroadcast(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void sendWindowClosedBroadcast(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void sendWindowClosedBroadcast(Context paramContext, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, "sendWindowClosedBroadcast");
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    localIntent.putExtra("param_curr_window_status", 104);
    localIntent.putExtra("param_busitype", paramInt1);
    paramContext.sendBroadcast(localIntent);
  }
  
  @Deprecated
  public void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    int i;
    if (paramBoolean) {
      i = 103;
    } else {
      i = 102;
    }
    localIntent.putExtra("param_curr_window_status", i);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    int i;
    if (paramBoolean) {
      i = 103;
    } else {
      i = 102;
    }
    localIntent.putExtra("param_curr_window_status", i);
    localIntent.putExtra("param_busitype", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void sendWindowVisibleBroadcast(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQFloatingWindowBroadcastImpl", 2, new Object[] { "sendWindowVisibleBroadcast:", Boolean.valueOf(paramBoolean), " ,busiType:", Integer.valueOf(paramInt1) });
    }
    Intent localIntent = new Intent("tencent.mobileqq.floatingscreen.statuschange");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("param_concern_floating_type", paramInt2);
    if (paramBoolean) {
      paramInt2 = 103;
    } else {
      paramInt2 = 102;
    }
    localIntent.putExtra("param_curr_window_status", paramInt2);
    localIntent.putExtra("param_busitype", paramInt1);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqfloatingwindow.impl.QQFloatingWindowBroadcastImpl
 * JD-Core Version:    0.7.0.1
 */