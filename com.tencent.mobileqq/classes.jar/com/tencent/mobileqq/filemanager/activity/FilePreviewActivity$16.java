package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class FilePreviewActivity$16
  implements FileWebView.JSInterface
{
  FilePreviewActivity$16(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void loadFinish(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramInt1 == 0) {
      this.a.a(bool, paramInt2, paramString);
    } else if (paramInt1 == 1) {
      this.a.b(bool, paramInt2, paramString);
    }
    QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
    paramString = this.a;
    paramString.jdField_g_of_type_Boolean = true;
    paramString.a(1000);
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    boolean bool;
    if (paramInt2 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.a.runOnUiThread(new FilePreviewActivity.16.2(this, paramInt1, bool, paramInt2, paramString));
    paramString = this.a;
    paramString.jdField_g_of_type_Boolean = (paramBoolean ^ true);
    paramString.a(1000);
  }
  
  public void openFile(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = new Intent(this.a, FilePreviewActivity.class);
      ((Intent)localObject1).putExtra("offline_file_type", 1);
      ((Intent)localObject1).putExtra("offline_file_name", this.a.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_url", this.a.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_bZip", this.a.jdField_a_of_type_Boolean);
      ((Intent)localObject1).putExtra("offline_file_domain", this.a.jdField_g_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("offline_file_port", this.a.h);
      ((Intent)localObject1).putExtra("offline_file_domain_key", this.a.e);
      ((Intent)localObject1).putExtra("offline_file_type_key", this.a.jdField_b_of_type_Int);
      ((Intent)localObject1).putExtra("OfflinePreZipPath", paramString2);
      ((Intent)localObject1).putExtra("OfflinePreZipDirName", paramString1);
      ((Intent)localObject1).putExtra("OfflinePreZipUUID", this.a.j);
      if (!TextUtils.isEmpty(this.a.f)) {
        ((Intent)localObject1).putExtra("COOKIE", this.a.f);
      }
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "open zip dic,open new activity");
      this.a.startActivityForResult((Intent)localObject1, 0);
      return;
    }
    Object localObject1 = null;
    if (!TextUtils.isEmpty(this.a.j))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.j);
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(paramString1);
      localObject3 = MD5.toMD5(((StringBuilder)localObject1).toString());
      localObject4 = this.a.app.getFileManagerDataCenter().b((String)localObject3);
      localObject1 = localObject3;
      if (localObject4 != null) {
        if (!FileUtil.a(((FileManagerEntity)localObject4).getFilePath()))
        {
          localObject1 = localObject3;
        }
        else
        {
          paramString1 = new FileManagerReporter.FileAssistantReportData();
          paramString1.jdField_b_of_type_JavaLangString = "file_viewer_in";
          paramString1.jdField_a_of_type_Int = 73;
          paramString1.c = FileUtil.a(((FileManagerEntity)localObject4).fileName);
          paramString1.jdField_a_of_type_Long = ((FileManagerEntity)localObject4).fileSize;
          FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramString1);
          FileManagerReporter.a("0X8004AE4");
          paramString1 = new ForwardFileInfo();
          paramString1.d(((FileManagerEntity)localObject4).getCloudType());
          paramString1.b(10000);
          paramString1.b(((FileManagerEntity)localObject4).nSessionId);
          paramString1.c(((FileManagerEntity)localObject4).uniseq);
          paramString1.d(((FileManagerEntity)localObject4).fileName);
          paramString1.d(((FileManagerEntity)localObject4).fileSize);
          paramString1.b(((FileManagerEntity)localObject4).Uuid);
          paramString1.a(((FileManagerEntity)localObject4).getFilePath());
          paramString2 = new ArrayList();
          try
          {
            paramString2.add(new FileInfo(((FileManagerEntity)localObject4).getFilePath()));
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            localFileNotFoundException.printStackTrace();
          }
          if ((((FileManagerEntity)localObject4).nFileType == 0) || (((FileManagerEntity)localObject4).nFileType == 1)) {
            ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).addFileViewerLocalFiles(paramString2);
          }
          paramString2 = new Intent(this.a.getActivity(), FileBrowserActivity.class);
          paramString2.putExtra("fileinfo", paramString1);
          this.a.getActivity().startActivityForResult(paramString2, 102);
          FileManagerReporter.a("0X80052CD");
          return;
        }
      }
    }
    Object localObject3 = (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
    Object localObject4 = new Bundle();
    ((Bundle)localObject4).putString("_filename_from_dlg", paramString1);
    ((Bundle)localObject4).putLong("_filesize_from_dlg", paramLong);
    ((Bundle)localObject4).putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_file_preview");
    ((Bundle)localObject4).putString("big_brother_source_key", "biz_src_file_preview");
    Object localObject5 = new Bundle();
    ((Bundle)localObject5).putString("FILE_TMP_SERVER_PATH", localFileNotFoundException);
    ((Bundle)localObject5).putInt("FILE_FROM", 190);
    if (!TextUtils.isEmpty(this.a.f)) {
      ((Bundle)localObject5).putString("COOKIE", this.a.f);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("set cookies:");
      ((StringBuilder)localObject2).append(this.a.f);
      QLog.i("<FileAssistant>FilePreviewActivity", 1, ((StringBuilder)localObject2).toString());
    }
    ((Bundle)localObject4).putBundle("_user_data", (Bundle)localObject5);
    Object localObject2 = this.a;
    localObject5 = ((FilePreviewActivity)localObject2).getString(2131718405);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("是否下载文件:\n");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("(");
    localStringBuilder.append(FileUtil.a(paramLong));
    localStringBuilder.append(")");
    DialogUtil.a((Context)localObject2, 233, (String)localObject5, localStringBuilder.toString(), new FilePreviewActivity.16.3(this, paramString2, (IUniformDownloadMgr)localObject3, (Bundle)localObject4), new FilePreviewActivity.16.4(this)).show();
  }
  
  public void updatePage(int paramInt1, int paramInt2)
  {
    this.a.runOnUiThread(new FilePreviewActivity.16.1(this, paramInt1, paramInt2));
  }
  
  public void webLog(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity_interfacePage", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16
 * JD-Core Version:    0.7.0.1
 */