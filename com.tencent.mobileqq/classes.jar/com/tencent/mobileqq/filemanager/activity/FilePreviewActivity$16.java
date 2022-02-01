package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.FileWebView.JSInterface;
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
    if (paramInt2 == 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label56;
      }
      this.a.a(bool, paramInt2, paramString);
    }
    for (;;)
    {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "js call loadFinish process Over");
      this.a.jdField_g_of_type_Boolean = true;
      this.a.a(1000);
      return;
      bool = false;
      break;
      label56:
      if (paramInt1 == 1) {
        this.a.b(bool, paramInt2, paramString);
      }
    }
  }
  
  public void loadFinish(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt2 == 0)
    {
      bool1 = true;
      this.a.runOnUiThread(new FilePreviewActivity.16.2(this, paramInt1, bool1, paramInt2, paramString));
      paramString = this.a;
      if (paramBoolean) {
        break label67;
      }
    }
    label67:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramString.jdField_g_of_type_Boolean = paramBoolean;
      this.a.a(1000);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void openFile(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    Object localObject1;
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
    if (TextUtils.isEmpty(this.a.j)) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = (IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "");
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("_filename_from_dlg", paramString1);
      localBundle1.putLong("_filesize_from_dlg", paramLong);
      localBundle1.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_file_preview");
      localBundle1.putString("big_brother_source_key", "biz_src_file_preview");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("FILE_TMP_SERVER_PATH", (String)localObject1);
      localBundle2.putInt("FILE_FROM", 190);
      if (!TextUtils.isEmpty(this.a.f)) {
        localBundle2.putString("COOKIE", this.a.f);
      }
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, "set cookies:" + this.a.f);
      }
      localBundle1.putBundle("_user_data", localBundle2);
      DialogUtil.a(this.a, 233, this.a.getString(2131718687), "是否下载文件:\n" + paramString1 + "(" + FileUtil.a(paramLong) + ")", new FilePreviewActivity.16.3(this, paramString2, (IUniformDownloadMgr)localObject2, localBundle1), new FilePreviewActivity.16.4(this)).show();
      return;
      localObject1 = MD5.toMD5(this.a.j + paramString2 + paramString1);
      localObject2 = this.a.app.getFileManagerDataCenter().b((String)localObject1);
      if (localObject2 != null) {
        if (FileUtil.b(((FileManagerEntity)localObject2).getFilePath()))
        {
          paramString1 = new FileManagerReporter.FileAssistantReportData();
          paramString1.jdField_b_of_type_JavaLangString = "file_viewer_in";
          paramString1.jdField_a_of_type_Int = 73;
          paramString1.c = FileUtil.a(((FileManagerEntity)localObject2).fileName);
          paramString1.jdField_a_of_type_Long = ((FileManagerEntity)localObject2).fileSize;
          FileManagerReporter.a(this.a.app.getCurrentAccountUin(), paramString1);
          FileManagerReporter.a("0X8004AE4");
          paramString1 = new ForwardFileInfo();
          paramString1.d(((FileManagerEntity)localObject2).getCloudType());
          paramString1.b(10000);
          paramString1.b(((FileManagerEntity)localObject2).nSessionId);
          paramString1.c(((FileManagerEntity)localObject2).uniseq);
          paramString1.d(((FileManagerEntity)localObject2).fileName);
          paramString1.d(((FileManagerEntity)localObject2).fileSize);
          paramString1.b(((FileManagerEntity)localObject2).Uuid);
          paramString1.a(((FileManagerEntity)localObject2).getFilePath());
          paramString2 = new ArrayList();
          try
          {
            paramString2.add(new FileInfo(((FileManagerEntity)localObject2).getFilePath()));
            if ((((FileManagerEntity)localObject2).nFileType == 0) || (((FileManagerEntity)localObject2).nFileType == 1)) {
              FMDataCache.a(paramString2);
            }
            paramString2 = new Intent(this.a.getActivity(), FileBrowserActivity.class);
            paramString2.putExtra("fileinfo", paramString1);
            this.a.getActivity().startActivityForResult(paramString2, 102);
            FileManagerReporter.a("0X80052CD");
            return;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            for (;;)
            {
              localFileNotFoundException.printStackTrace();
            }
          }
        }
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16
 * JD-Core Version:    0.7.0.1
 */