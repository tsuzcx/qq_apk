package com.tencent.mobileqq.uniformdownload.core;

import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.SucDownloadInfo;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadNfn$DownloaderNfnHandler
  extends Handler
  implements IUniformDownloaderListener
{
  Notification a;
  final Bundle b;
  final int c;
  final long d;
  int e = 0;
  int f = 0;
  
  public UniformDownloadNfn$DownloaderNfnHandler(UniformDownloadNfn paramUniformDownloadNfn, Looper paramLooper, int paramInt, Bundle paramBundle, long paramLong)
  {
    super(paramLooper);
    this.c = paramInt;
    this.b = ((Bundle)paramBundle.clone());
    this.d = paramLong;
    this.b.putInt("_notify_param_Id", this.c);
    if (this.b != null)
    {
      this.a = paramUniformDownloadNfn.a(paramBundle);
      return;
    }
    paramUniformDownloadNfn = UniformDownloadNfn.a;
    paramLooper = new StringBuilder();
    paramLooper.append("[UniformDL][");
    paramLooper.append(paramLong);
    paramLooper.append("]. notify runable, param is null");
    QLog.e(paramUniformDownloadNfn, 1, paramLooper.toString());
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = UniformDownloadNfn.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]. onDownloadStart, NF");
    QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    paramBundle = Message.obtain();
    paramBundle.what = 1;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("_FILE_PROGRESS_", paramInt);
    ((Bundle)localObject).putInt("_START_WAITING_", 0);
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramBundle = UniformDownloadNfn.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]. onDownloadStart, sendMessage failed, NF");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject = UniformDownloadNfn.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL][");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]. onDownloadFailed, NF --> ");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("_CB_USERDATA");
      if ((paramBundle != null) && (paramBundle.getBoolean("tbs_new_report", false))) {
        ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_failed");
      }
    }
    paramBundle = Message.obtain();
    paramBundle.what = 5;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("_FILE_ERR_CODE_", paramInt);
    ((Bundle)localObject).putString("_FILE_ERR_STRING_", paramString);
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramString = UniformDownloadNfn.a;
      paramBundle = new StringBuilder();
      paramBundle.append("[UniformDL][");
      paramBundle.append(this.d);
      paramBundle.append("]. onDownloadFailed, sendMessage failed, NF");
      QLog.e(paramString, 1, paramBundle.toString());
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    int i = UniformDownloadNfn.a(this.g);
    String str1 = UniformDownloadUtil.c(paramString);
    if (str1 != null)
    {
      localObject = new SucDownloadInfo(str1, i);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("_CB_USERDATA");
        if (paramBundle != null)
        {
          ((SucDownloadInfo)localObject).c = paramBundle.getString("_open_with_qq_browser_", "");
          String str2 = paramBundle.getString("params_open_with_yyb", "");
          if (!TextUtils.isEmpty(str2))
          {
            ((SucDownloadInfo)localObject).d.putString("params_open_with_yyb", str2);
            ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).reportAppStoreDownloadSuc();
          }
          boolean bool = paramBundle.getBoolean("tbs_new_report", false);
          ((SucDownloadInfo)localObject).d.putBoolean("tbs_new_report", bool);
          if (bool) {
            ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).reportQQBrowserDownloadEvent("stat_download_success");
          }
          UniformDownloadNfn.a(this.g, paramBundle);
        }
      }
      UniformDownloadMgr.a().c().b((SucDownloadInfo)localObject);
    }
    paramBundle = UniformDownloadNfn.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]. onDownloadSucess, NF");
    QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    paramBundle = Message.obtain();
    paramBundle.what = 4;
    localObject = new Bundle();
    ((Bundle)localObject).putString("_FILE_PATH_", paramString);
    ((Bundle)localObject).putLong("_FILE_SIZE_", paramLong);
    ((Bundle)localObject).putInt("_NEW_N_ID_", i);
    if (str1 != null) {
      ((Bundle)localObject).putString("_PKG_NAME_", str1);
    }
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramString = UniformDownloadNfn.a;
      paramBundle = new StringBuilder();
      paramBundle.append("[UniformDL][");
      paramBundle.append(this.d);
      paramBundle.append("]. onDownloadSucess, sendMessage failed, NF");
      QLog.e(paramString, 1, paramBundle.toString());
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    paramBundle = Message.obtain();
    paramBundle.what = 2;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramBundle = UniformDownloadNfn.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]. onDownloadProgress, sendMessage failed, NF");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    paramBundle = UniformDownloadNfn.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]. onDownloadPause, NF");
    QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    paramBundle = Message.obtain();
    paramBundle.what = 3;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramBundle = UniformDownloadNfn.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]. onDownloadPause, sendMessage failed, NF");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    paramBundle = UniformDownloadNfn.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]. onDownloadResume progress=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", NF ");
    QLog.i(paramBundle, 1, ((StringBuilder)localObject).toString());
    paramBundle = Message.obtain();
    paramBundle.what = 7;
    localObject = new Bundle();
    ((Bundle)localObject).putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle))
    {
      paramBundle = UniformDownloadNfn.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]. onDownloadResume, sendMessage failed, NF");
      QLog.e(paramBundle, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = paramMessage.getData();
    Object localObject2;
    Object localObject3;
    switch (paramMessage.what)
    {
    default: 
      break;
    case 7: 
      localObject2 = UniformDownloadNfn.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.d);
      ((StringBuilder)localObject3).append("]. NF_RESUME, NF. NId = ");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append(" url:");
      ((StringBuilder)localObject3).append(this.b.getString("_notify_param_Url"));
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      this.g.e(this.c, this.a, this.b, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"), this.b.getString("_notify_param_Filename"), this.b.getString("_notify_param_ContentTitle", ""), this.b.getLong("_notify_param_Filesize"), this.b.getBundle("_notify_param_userdata"), this.c, true);
      this.f = 7;
      break;
    case 6: 
      localObject1 = UniformDownloadNfn.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append("]. NF_CLR, NF. NId = ");
      ((StringBuilder)localObject2).append(this.c);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      this.g.a(this.c);
      UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"));
      break;
    case 5: 
      this.g.d(this.c, this.a, this.b, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"));
      this.f = 5;
      break;
    case 4: 
      localObject2 = UniformDownloadNfn.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.d);
      ((StringBuilder)localObject3).append("]. NF_SUC, NF. NId = ");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append(" url:");
      ((StringBuilder)localObject3).append(this.b.getString("_notify_param_Url"));
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      this.g.a(this.c, this.b, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"));
      this.f = 4;
      break;
    case 3: 
      localObject2 = UniformDownloadNfn.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.d);
      ((StringBuilder)localObject3).append("]. NF_PAUSE, NF. NId = ");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append(" url:");
      ((StringBuilder)localObject3).append(this.b.getString("_notify_param_Url"));
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      this.g.c(this.c, this.a, this.b, (Bundle)localObject1);
      UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"));
      this.f = 3;
      break;
    case 2: 
      this.g.b(this.c, this.a, this.b, (Bundle)localObject1);
      if (2 != this.f) {
        UniformDownloadMgr.a().d().a(this.b.getString("_notify_param_Url"), this.b.getString("_notify_param_Filename"), this.b.getString("_notify_param_ContentTitle", ""), this.b.getLong("_notify_param_Filesize"), this.b.getBundle("_notify_param_userdata"), this.c, false);
      }
      this.f = 2;
      break;
    case 1: 
      localObject2 = UniformDownloadNfn.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[UniformDL][");
      ((StringBuilder)localObject3).append(this.d);
      ((StringBuilder)localObject3).append("]. NF_START, NF. NId = ");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append(" url:");
      ((StringBuilder)localObject3).append(this.b.getString("_notify_param_Url"));
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      this.g.a(this.c, this.a, this.b, (Bundle)localObject1);
      int i = ((Bundle)localObject1).getInt("_START_WAITING_");
      localObject1 = UniformDownloadMgr.a().d();
      localObject2 = this.b.getString("_notify_param_Url");
      localObject3 = this.b.getString("_notify_param_Filename");
      String str = this.b.getString("_notify_param_ContentTitle", "");
      long l = this.b.getLong("_notify_param_Filesize");
      Bundle localBundle = this.b.getBundle("_notify_param_userdata");
      int j = this.c;
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ((DownloadingRbResmeInfoMgr)localObject1).a((String)localObject2, (String)localObject3, str, l, localBundle, j, bool);
      this.f = 1;
    }
    this.e = paramMessage.what;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn.DownloaderNfnHandler
 * JD-Core Version:    0.7.0.1
 */