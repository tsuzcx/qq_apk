package com.tencent.mobileqq.uniformdownload.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadNfnReceiver
  extends BroadcastReceiver
{
  public static String a = "UniformDownloadNfnReceiver";
  private static int b;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getAction();
    paramContext = paramIntent.getBundleExtra("_PARAM_EXTRA");
    if (localObject1 != null)
    {
      int i;
      Object localObject2;
      if (((String)localObject1).equals("com.tencent.mobileqq.UniformDownloadNfn.PAUSE"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL] onReceive. PAUSE_DOWNLOAD: id:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" url:");
          ((StringBuilder)localObject2).append(paramIntent);
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          UniformDownloadMgr.a().e(paramIntent, paramContext);
          return;
        }
        QLog.e(a, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: param = null");
        return;
      }
      if (((String)localObject1).equals("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL] onReceive. DO_DOWNLOAD:id:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" url:");
          ((StringBuilder)localObject2).append(paramIntent);
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          UniformDownloadMgr.a().f(paramIntent, paramContext);
          return;
        }
        QLog.e(a, 1, "[UniformDL] onReceive. DO_DOWNLOAD: param = null");
        return;
      }
      if (((String)localObject1).equals("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          localObject1 = a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL] onReceive. TRY_DOWNLOAD:id:");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(" url:");
          ((StringBuilder)localObject2).append(paramIntent);
          QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
          UniformDownloadMgr.a().g(paramIntent, paramContext);
          return;
        }
        QLog.e(a, 1, "[UniformDL] onReceive. TRY_DOWNLOAD: param = null");
        return;
      }
      Object localObject3;
      if (((String)localObject1).equals("com.tencent.mobileqq.UniformDownloadNfn.INSTALL"))
      {
        paramContext = paramIntent.getStringExtra("_PARAM_FILEPATH");
        localObject1 = paramIntent.getStringExtra("_PARAM_PKGNAME");
        localObject2 = paramIntent.getStringExtra("big_brother_source_key");
        localObject3 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL] onReceive. DO_INSTALL: PH:");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("PKGN:");
        localStringBuilder.append((String)localObject1);
        QLog.i((String)localObject3, 1, localStringBuilder.toString());
        UniformDownloadUtil.c(paramContext, (String)localObject2);
        if (localObject1 != null)
        {
          i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
          UniformDownloadMgr.a().c().a((String)localObject1, i);
        }
      }
      else if (((String)localObject1).equals("com.tencent.mobileqq.UniformDownloadNfn.BEDEL"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          localObject1 = paramContext.getString("_notify_param_Url");
          localObject2 = a;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[UniformDL] onReceive. NOTIFICATION_BE_DEL: id:");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" url:");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
          UniformDownloadMgr.a().d((String)localObject1, paramContext);
        }
        else
        {
          QLog.w(a, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: param = null. may not be clean info except download succ");
        }
        paramContext = paramIntent.getStringExtra("_PARAM_PKGNAME");
        if (paramContext != null)
        {
          i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
          paramIntent = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[UniformDL] onReceive. download suc. NOTIFICATION_BE_DEL: id:");
          ((StringBuilder)localObject1).append(i);
          QLog.i(paramIntent, 1, ((StringBuilder)localObject1).toString());
          UniformDownloadMgr.a().c().a(paramContext, i);
        }
      }
      else
      {
        paramContext = a;
        paramIntent = new StringBuilder();
        paramIntent.append("[UniformDL] onReceive. unkown action:");
        paramIntent.append((String)localObject1);
        QLog.e(paramContext, 1, paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfnReceiver
 * JD-Core Version:    0.7.0.1
 */