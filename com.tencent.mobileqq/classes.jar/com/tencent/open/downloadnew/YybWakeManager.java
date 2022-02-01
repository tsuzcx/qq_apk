package com.tencent.open.downloadnew;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;

public class YybWakeManager
{
  private static volatile YybWakeManager a;
  private Context b = CommonDataAdapter.a().b();
  private boolean c = false;
  private Handler d = new YybWakeManager.1(this);
  private BroadcastReceiver e = new YybWakeManager.2(this);
  
  public static YybWakeManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new YybWakeManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    try
    {
      if (this.b == null) {
        return;
      }
      if (this.c) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.android.qqdownloader.action.CONNECT_PC_STATE");
      this.b.registerReceiver(this.e, localIntentFilter);
      this.c = true;
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerYybReceiver:");
      localStringBuilder.append(localException.getMessage());
      LogUtility.e("TAMST_WAKE", localStringBuilder.toString());
    }
  }
  
  private void d()
  {
    if (this.b == null) {
      return;
    }
    if (!ControlPolicyUtil.n()) {
      return;
    }
    try
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("from", this.b.getPackageName());
      ((Bundle)localObject).putString("via", "CALL_LIVE_QQ");
      boolean bool = CommonDataAdapter.a().b().startInstrumentation(new ComponentName("com.tencent.android.qqdownloader", "com.live.watermelon.Instrumentation"), null, (Bundle)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("拉活结果=");
      ((StringBuilder)localObject).append(bool);
      LogUtility.c("YybWakeManager", ((StringBuilder)localObject).toString());
      ControlPolicyUtil.v();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startYybByInstrumentation:");
      localStringBuilder.append(localException.getMessage());
      LogUtility.e("TAMST_WAKE", localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    if (this.b == null) {
      return;
    }
    c();
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.android.qqdownloader.action.QUERY_CONNECT_STATE");
    ((Intent)localObject).putExtra("is_from_mq", true);
    ((Intent)localObject).setPackage("com.tencent.android.qqdownloader");
    this.b.sendBroadcast((Intent)localObject);
    localObject = Message.obtain();
    ((Message)localObject).what = 100;
    ((Message)localObject).arg1 = 101;
    this.d.sendMessageDelayed((Message)localObject, 5000L);
    LogUtility.c("YybWakeManager", "tryInstrumentWake");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybWakeManager
 * JD-Core Version:    0.7.0.1
 */