package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadNfnReceiver
  extends BroadcastReceiver
{
  public static String a = "UniformDownloadNfnReceiver<FileAssistant>";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramContext = paramIntent.getBundleExtra("_PARAM_EXTRA");
    if (str != null)
    {
      if (!str.equals("com.tencent.mobileqq.UniformDownloadNfn.PAUSE")) {
        break label100;
      }
      if (paramContext == null) {
        break label90;
      }
      i = paramContext.getInt("_notify_param_Id");
      paramIntent = paramContext.getString("_notify_param_Url");
      QLog.i(a, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: id:" + i + " url:" + paramIntent);
      UniformDownloadMgr.a().c(paramIntent, paramContext);
    }
    label90:
    label100:
    do
    {
      return;
      QLog.e(a, 1, "[UniformDL] onReceive. PAUSE_DOWNLOAD: param = null");
      return;
      if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.DO_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(a, 1, "[UniformDL] onReceive. DO_DOWNLOAD:id:" + i + " url:" + paramIntent);
          UniformDownloadMgr.a().d(paramIntent, paramContext);
          return;
        }
        QLog.e(a, 1, "[UniformDL] onReceive. DO_DOWNLOAD: param = null");
        return;
      }
      if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.TRY_DOWNLOAD"))
      {
        if (paramContext != null)
        {
          i = paramContext.getInt("_notify_param_Id");
          paramIntent = paramContext.getString("_notify_param_Url");
          QLog.i(a, 1, "[UniformDL] onReceive. TRY_DOWNLOAD:id:" + i + " url:" + paramIntent);
          UniformDownloadMgr.a().e(paramIntent, paramContext);
          return;
        }
        QLog.e(a, 1, "[UniformDL] onReceive. TRY_DOWNLOAD: param = null");
        return;
      }
      if (!str.equals("com.tencent.mobileqq.UniformDownloadNfn.INSTALL")) {
        break;
      }
      paramContext = paramIntent.getStringExtra("_PARAM_FILEPATH");
      str = paramIntent.getStringExtra("_PARAM_PKGNAME");
      QLog.i(a, 1, "[UniformDL] onReceive. DO_INSTALL: PH:" + paramContext + "PKGN:" + str);
      UniformDownloadMgr.a().b(paramContext);
    } while (str == null);
    int i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
    UniformDownloadMgr.a().a(str, i);
    return;
    if (str.equals("com.tencent.mobileqq.UniformDownloadNfn.BEDEL"))
    {
      if (paramContext != null)
      {
        i = paramContext.getInt("_notify_param_Id");
        str = paramContext.getString("_notify_param_Url");
        QLog.i(a, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: id:" + i + " url:" + str);
        UniformDownloadMgr.a().f(str, paramContext);
      }
      for (;;)
      {
        paramContext = paramIntent.getStringExtra("_PARAM_PKGNAME");
        if (paramContext == null) {
          break;
        }
        i = paramIntent.getIntExtra("_PARAM_DL_SUC_NEW_NID", 0);
        QLog.i(a, 1, "[UniformDL] onReceive. download suc. NOTIFICATION_BE_DEL: id:" + i);
        UniformDownloadMgr.a().a(paramContext, i);
        return;
        QLog.w(a, 1, "[UniformDL] onReceive. NOTIFICATION_BE_DEL: param = null. may not be clean info except download succ");
      }
    }
    QLog.e(a, 1, "[UniformDL] onReceive. unkown action:" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.UniformDownloadNfnReceiver
 * JD-Core Version:    0.7.0.1
 */