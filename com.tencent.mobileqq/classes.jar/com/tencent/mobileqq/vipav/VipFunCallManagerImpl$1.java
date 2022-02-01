package com.tencent.mobileqq.vipav;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class VipFunCallManagerImpl$1
  extends DownloadListener
{
  VipFunCallManagerImpl$1(VipFunCallManagerImpl paramVipFunCallManagerImpl, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDone, status=");
      ((StringBuilder)localObject1).append(paramDownloadTask.e());
      ((StringBuilder)localObject1).append(", task.errCode:");
      ((StringBuilder)localObject1).append(paramDownloadTask.c);
      ((StringBuilder)localObject1).append(", key=");
      ((StringBuilder)localObject1).append(paramDownloadTask.b);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramDownloadTask.b();
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mDownloadListener onDone Err0, key:");
      ((StringBuilder)localObject1).append(paramDownloadTask.b);
      QLog.e("VipFunCallManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    boolean bool = VipFunCallManagerImpl.a(this.a, paramDownloadTask);
    if (((Bundle)localObject1).getInt("dealType") == 0) {
      return;
    }
    int i = ((Bundle)localObject1).getInt("callId");
    int j = ((Bundle)localObject1).getInt("resourceType");
    Object localObject2 = ((Bundle)localObject1).getString("path");
    StringBuilder localStringBuilder;
    if (!((Bundle)localObject1).getBoolean("isExists", false))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(".tmp");
      bool = FileUtils.rename(localStringBuilder.toString(), (String)localObject2);
    }
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mDownloadListener onDone rename failure. path:");
      localStringBuilder.append((String)localObject2);
      QLog.e("VipFunCallManager", 1, localStringBuilder.toString());
    }
    if ((((Bundle)localObject1).getBoolean("isIPC")) && (VipFunCallManagerImpl.a(this.a) != null))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("fcStatus", 3);
      ((Bundle)localObject2).putInt("callId", i);
      ((Bundle)localObject2).putInt("srcType", ((Bundle)localObject1).getInt("srcType"));
      ((Bundle)localObject2).putBoolean("result_boo", bool);
      ((Bundle)localObject2).putInt("resourceType", j);
      VipFunCallManagerImpl.a(this.a).a(i, paramDownloadTask.e(), (Bundle)localObject2);
    }
    if (9 == VipFunCallUtil.c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipFunCallManager", 2, "sendBroadcast :tencent.video.q2v.AnnimateDownloadFinish");
      }
      paramDownloadTask = new Intent("tencent.video.q2v.AnnimateDownloadFinish");
      paramDownloadTask.putExtra("fun_call_id", i);
      paramDownloadTask.setPackage(this.a.a.getApp().getPackageName());
      this.a.a.getApp().sendBroadcast(paramDownloadTask);
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProgress, loaded=");
      ((StringBuilder)localObject).append(paramDownloadTask.k);
      ((StringBuilder)localObject).append("percent=");
      ((StringBuilder)localObject).append(paramDownloadTask.l);
      ((StringBuilder)localObject).append(", key=");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramDownloadTask.b();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mDownloadListener onProgress Err0, key:");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      QLog.e("VipFunCallManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (((Bundle)localObject).getInt("dealType") == 0) {
      return;
    }
    if ((paramDownloadTask.b().getBoolean("isIPC")) && (VipFunCallManagerImpl.a(this.a) != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("fcStatus", 2);
      localBundle.putInt("callId", ((Bundle)localObject).getInt("callId"));
      localBundle.putInt("srcType", ((Bundle)localObject).getInt("srcType"));
      localBundle.putInt("progress", (int)paramDownloadTask.l);
      localBundle.putInt("resourceType", ((Bundle)localObject).getInt("resourceType"));
      VipFunCallManagerImpl.a(this.a).a(localBundle);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    Object localObject = paramDownloadTask.b();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mDownloadListener onStart Err0, key:");
      ((StringBuilder)localObject).append(paramDownloadTask.b);
      QLog.e("VipFunCallManager", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    if (((Bundle)localObject).getInt("dealType") == 0) {
      return true;
    }
    int i = ((Bundle)localObject).getInt("resourceType");
    boolean bool = ((Bundle)localObject).getBoolean("isIPC");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStart, loaded=");
      localStringBuilder.append(paramDownloadTask.k);
      localStringBuilder.append(", percent=");
      localStringBuilder.append(paramDownloadTask.l);
      localStringBuilder.append(", resType=");
      localStringBuilder.append(i);
      localStringBuilder.append(", isIPC=");
      localStringBuilder.append(bool);
      QLog.d("VipFunCallManager", 2, localStringBuilder.toString());
    }
    if ((bool) && (VipFunCallManagerImpl.a(this.a) != null))
    {
      paramDownloadTask = new Bundle();
      paramDownloadTask.putInt("fcStatus", 1);
      paramDownloadTask.putInt("callId", ((Bundle)localObject).getInt("callId"));
      paramDownloadTask.putInt("srcType", ((Bundle)localObject).getInt("srcType"));
      paramDownloadTask.putInt("resourceType", i);
      VipFunCallManagerImpl.a(this.a).a(paramDownloadTask);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */