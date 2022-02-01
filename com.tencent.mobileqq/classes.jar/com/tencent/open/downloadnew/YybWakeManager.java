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
  private static volatile YybWakeManager jdField_a_of_type_ComTencentOpenDownloadnewYybWakeManager;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new YybWakeManager.2(this);
  private Context jdField_a_of_type_AndroidContentContext = CommonDataAdapter.a().a();
  private Handler jdField_a_of_type_AndroidOsHandler = new YybWakeManager.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  public static YybWakeManager a()
  {
    if (jdField_a_of_type_ComTencentOpenDownloadnewYybWakeManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentOpenDownloadnewYybWakeManager == null) {
          jdField_a_of_type_ComTencentOpenDownloadnewYybWakeManager = new YybWakeManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentOpenDownloadnewYybWakeManager;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.android.qqdownloader.action.CONNECT_PC_STATE");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_Boolean = true;
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
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    if (!ControlPolicyUtil.j()) {
      return;
    }
    try
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("from", this.jdField_a_of_type_AndroidContentContext.getPackageName());
      ((Bundle)localObject).putString("via", "CALL_LIVE_QQ");
      boolean bool = CommonDataAdapter.a().a().startInstrumentation(new ComponentName("com.tencent.android.qqdownloader", "com.live.watermelon.Instrumentation"), null, (Bundle)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("拉活结果=");
      ((StringBuilder)localObject).append(bool);
      LogUtility.c("YybWakeManager", ((StringBuilder)localObject).toString());
      ControlPolicyUtil.c();
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
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    b();
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.android.qqdownloader.action.QUERY_CONNECT_STATE");
    ((Intent)localObject).putExtra("is_from_mq", true);
    ((Intent)localObject).setPackage("com.tencent.android.qqdownloader");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject);
    localObject = Message.obtain();
    ((Message)localObject).what = 100;
    ((Message)localObject).arg1 = 101;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 5000L);
    LogUtility.c("YybWakeManager", "tryInstrumentWake");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybWakeManager
 * JD-Core Version:    0.7.0.1
 */