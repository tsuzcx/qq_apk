package com.tencent.mobileqq.uniformdownload.core;

import android.app.Notification;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.uniformdownload.data.DownloadingRbResmeInfoMgr;
import com.tencent.mobileqq.uniformdownload.data.SucDownloadInfoMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.LocalTbsViewManager;
import com.tencent.mobileqq.uniformdownload.filemanager.QFileAppStorePromoteManager;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.SucDownloadInfo;
import com.tencent.mobileqq.uniformdownload.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;

class UniformDownloadNfn$DownloaderNfnHandler
  extends Handler
  implements IUniformDownloaderListener
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  Notification jdField_a_of_type_AndroidAppNotification;
  final Bundle jdField_a_of_type_AndroidOsBundle;
  int b = 0;
  int c = 0;
  
  public UniformDownloadNfn$DownloaderNfnHandler(UniformDownloadNfn paramUniformDownloadNfn, Looper paramLooper, int paramInt, Bundle paramBundle, long paramLong)
  {
    super(paramLooper);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = ((Bundle)paramBundle.clone());
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidOsBundle.putInt("_notify_param_Id", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_a_of_type_AndroidAppNotification = paramUniformDownloadNfn.a(paramBundle);
      return;
    }
    QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + paramLong + "]. notify runable, param is null");
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadStart, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    localBundle.putInt("_START_WAITING_", 0);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadStart, sendMessage failed, NF");
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadFailed, NF --> " + paramString);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("_CB_USERDATA");
      if ((paramBundle != null) && (paramBundle.getBoolean("tbs_new_report", false))) {
        LocalTbsViewManager.a().a("stat_download_failed");
      }
    }
    paramBundle = Message.obtain();
    paramBundle.what = 5;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_ERR_CODE_", paramInt);
    localBundle.putString("_FILE_ERR_STRING_", paramString);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadFailed, sendMessage failed, NF");
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    int i = UniformDownloadNfn.a(this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn);
    String str1 = UniformDownloadUtil.a(paramString);
    if (str1 != null)
    {
      localObject = new SucDownloadInfo(str1, i);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("_CB_USERDATA");
        if (paramBundle != null)
        {
          ((SucDownloadInfo)localObject).b = paramBundle.getString("_open_with_qq_browser_", "");
          String str2 = paramBundle.getString("params_open_with_yyb", "");
          if (!TextUtils.isEmpty(str2))
          {
            ((SucDownloadInfo)localObject).jdField_a_of_type_AndroidOsBundle.putString("params_open_with_yyb", str2);
            QFileAppStorePromoteManager.a();
          }
          boolean bool = paramBundle.getBoolean("tbs_new_report", false);
          ((SucDownloadInfo)localObject).jdField_a_of_type_AndroidOsBundle.putBoolean("tbs_new_report", bool);
          if (bool) {
            LocalTbsViewManager.a().a("stat_download_success");
          }
          UniformDownloadNfn.a(this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn, paramBundle);
        }
      }
      UniformDownloadMgr.a().a().a((SucDownloadInfo)localObject);
    }
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadSucess, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 4;
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("_FILE_PATH_", paramString);
    ((Bundle)localObject).putLong("_FILE_SIZE_", paramLong);
    ((Bundle)localObject).putInt("_NEW_N_ID_", i);
    if (str1 != null) {
      ((Bundle)localObject).putString("_PKG_NAME_", str1);
    }
    paramBundle.setData((Bundle)localObject);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadSucess, sendMessage failed, NF");
    }
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    paramBundle = Message.obtain();
    paramBundle.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadProgress, sendMessage failed, NF");
    }
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadPause, NF");
    paramBundle = Message.obtain();
    paramBundle.what = 3;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadPause, sendMessage failed, NF");
    }
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadResume progress=" + paramInt + ", NF ");
    paramBundle = Message.obtain();
    paramBundle.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putInt("_FILE_PROGRESS_", paramInt);
    paramBundle.setData(localBundle);
    if (!sendMessage(paramBundle)) {
      QLog.e(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. onDownloadResume, sendMessage failed, NF");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    super.handleMessage(paramMessage);
    Object localObject = paramMessage.getData();
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      this.b = paramMessage.what;
      return;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_START, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      int i = ((Bundle)localObject).getInt("_START_WAITING_");
      localObject = UniformDownloadMgr.a().a();
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename");
      String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_ContentTitle", "");
      long l = this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize");
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle.getBundle("_notify_param_userdata");
      int j = this.jdField_a_of_type_Int;
      if (i == 1) {
        bool = true;
      }
      ((DownloadingRbResmeInfoMgr)localObject).a(str1, str2, str3, l, localBundle, j, bool);
      this.c = 1;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.b(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      if (2 != this.c) {
        UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_ContentTitle", ""), this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize"), this.jdField_a_of_type_AndroidOsBundle.getBundle("_notify_param_userdata"), this.jdField_a_of_type_Int, false);
      }
      this.c = 2;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_PAUSE, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.c(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 3;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_SUC, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 4;
      continue;
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.d(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.c = 5;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_RESUME, NF. NId = " + this.jdField_a_of_type_Int + " url:" + this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.e(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidAppNotification, this.jdField_a_of_type_AndroidOsBundle, (Bundle)localObject);
      UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Filename"), this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_ContentTitle", ""), this.jdField_a_of_type_AndroidOsBundle.getLong("_notify_param_Filesize"), this.jdField_a_of_type_AndroidOsBundle.getBundle("_notify_param_userdata"), this.jdField_a_of_type_Int, true);
      this.c = 7;
      continue;
      QLog.i(UniformDownloadNfn.a, 1, "[UniformDL][" + this.jdField_a_of_type_Long + "]. NF_CLR, NF. NId = " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadCoreUniformDownloadNfn.a(this.jdField_a_of_type_Int);
      UniformDownloadMgr.a().a().a(this.jdField_a_of_type_AndroidOsBundle.getString("_notify_param_Url"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.UniformDownloadNfn.DownloaderNfnHandler
 * JD-Core Version:    0.7.0.1
 */