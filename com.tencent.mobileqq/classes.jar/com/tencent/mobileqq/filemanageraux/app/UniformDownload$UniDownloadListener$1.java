package com.tencent.mobileqq.filemanageraux.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webdownload.DownloadURLCheck.RspDownloadUrlCheckRecmd;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

class UniformDownload$UniDownloadListener$1
  implements BusinessObserver
{
  UniformDownload$UniDownloadListener$1(UniformDownload.UniDownloadListener paramUniDownloadListener, String paramString, long paramLong, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCheck, success: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", canceled: ");
      localStringBuilder.append(UniformDownload.UniDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener));
      QLog.d("UniformDownloadMgr<FileAssistant>", 2, localStringBuilder.toString());
    }
    Activity localActivity = (Activity)UniformDownload.UniDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener).get();
    Intent localIntent;
    DownloadURLCheck.RspDownloadUrlCheckRecmd localRspDownloadUrlCheckRecmd;
    if ((!UniformDownload.UniDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener)) && (localActivity != null))
    {
      if (localActivity.isFinishing()) {
        return;
      }
      localIntent = new Intent();
      localIntent.putExtra("param_url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("_filesize", this.jdField_a_of_type_Long);
      localIntent.putExtra("big_brother_source_key", localActivity.getIntent().getStringExtra("big_brother_source_key"));
      if (paramBoolean)
      {
        paramBundle = paramBundle.getByteArray("extra_data");
        if (paramBundle != null) {
          localRspDownloadUrlCheckRecmd = new DownloadURLCheck.RspDownloadUrlCheckRecmd();
        }
      }
    }
    for (;;)
    {
      try
      {
        localRspDownloadUrlCheckRecmd.mergeFrom(paramBundle);
        if (localRspDownloadUrlCheckRecmd.err_code.has())
        {
          if (localRspDownloadUrlCheckRecmd.err_code.get() != 0) {
            break label429;
          }
          paramInt = 1;
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("handleCheck, code: ");
            paramBundle.append(localRspDownloadUrlCheckRecmd.err_code.get());
            QLog.d("UniformDownloadMgr<FileAssistant>", 2, paramBundle.toString());
          }
          if (paramInt != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("UniformDownloadMgr<FileAssistant>", 2, "start download from yyb");
            }
            if ((!localRspDownloadUrlCheckRecmd.is_white_url.has()) || (!localRspDownloadUrlCheckRecmd.is_white_url.get())) {
              break label434;
            }
            paramBoolean = true;
            localIntent.putExtra("param_in_white_list", paramBoolean);
            paramBoolean = localRspDownloadUrlCheckRecmd.pkg_name.has();
            localStringBuilder = null;
            if (!paramBoolean) {
              break label439;
            }
            paramBundle = localRspDownloadUrlCheckRecmd.pkg_name.get();
            localIntent.putExtra("param_pkg_name", paramBundle);
            paramBundle = localStringBuilder;
            if (localRspDownloadUrlCheckRecmd.extra_info.has()) {
              paramBundle = localRspDownloadUrlCheckRecmd.extra_info.get();
            }
            localIntent.putExtra("param_ext_info", paramBundle);
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        QLog.e("UniformDownloadMgr<FileAssistant>", 1, paramBundle, new Object[0]);
      }
      PublicFragmentActivity.Launcher.a(localActivity, localIntent, PublicFragmentActivity.class, ApkFileDownloadFragment.class);
      if (this.jdField_a_of_type_Boolean)
      {
        localActivity.finish();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxAppUniformDownload$UniDownloadListener.a.sendEmptyMessage(2);
      return;
      label429:
      paramInt = 0;
      continue;
      label434:
      paramBoolean = false;
      continue;
      label439:
      paramBundle = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.app.UniformDownload.UniDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */