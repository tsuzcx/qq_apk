package com.tencent.securemodule.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.securemodule.service.ApkDownLoadListener;

public class SecureModuleService$DownLoadBroadcastReceiver
  extends BroadcastReceiver
{
  private ApkDownLoadListener b;
  
  public SecureModuleService$DownLoadBroadcastReceiver(SecureModuleService paramSecureModuleService, ApkDownLoadListener paramApkDownLoadListener)
  {
    this.b = paramApkDownLoadListener;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("1000024".equals(paramIntent.getAction())) {
      if (this.b != null) {
        this.b.onDownloadStart();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!"1000025".equals(paramIntent.getAction())) {
            break;
          }
        } while (this.b == null);
        paramContext = paramIntent.getBundleExtra("data");
      } while (paramContext == null);
      long l1 = paramContext.getLong("key_total");
      long l2 = paramContext.getLong("key_completed");
      int i = paramContext.getInt("key_progress");
      this.b.onRefreshProgress(i, l2, l1);
      return;
      if ("1000027".equals(paramIntent.getAction()))
      {
        if (this.b != null) {
          this.b.onDownloadSuccess();
        }
        SecureModuleService.access$000(this.a);
        return;
      }
    } while (!"1000026".equals(paramIntent.getAction()));
    if (this.b != null) {
      this.b.onDownLoadError();
    }
    SecureModuleService.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureModuleService.DownLoadBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */