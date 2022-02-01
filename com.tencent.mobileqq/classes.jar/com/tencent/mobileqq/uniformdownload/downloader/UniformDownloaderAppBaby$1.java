package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.filemanager.FileUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderAppBabyListener;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class UniformDownloaderAppBaby$1
  implements IUniformDownloaderAppBabyListener
{
  UniformDownloaderAppBaby$1(UniformDownloaderAppBaby paramUniformDownloaderAppBaby) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if (UniformDownloaderAppBaby.a(this.a) != null)
    {
      if (paramInt <= 100) {
        break label45;
      }
      UniformDownloaderAppBaby.a(this.a).b(this.a.h(), paramBundle);
    }
    label45:
    while (paramInt - this.a.g() <= 0) {
      return;
    }
    this.a.a(paramInt);
    UniformDownloaderAppBaby.a(this.a).b(paramInt, paramBundle);
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.c(5);
    AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
    if (localAppRuntime != null)
    {
      long l1 = -1L;
      long l2 = -1L;
      UniformDownloaderAppBabySdk.RParam localRParam = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
      if (localRParam != null)
      {
        l1 = localRParam.a;
        l2 = localRParam.jdField_b_of_type_Long;
      }
      FileManagerUtil.a(localAppRuntime, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", this.a.a, "", "", "", "", paramInt, paramString, l1, l2, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
      FileManagerUtil.a(localAppRuntime, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", this.a.a, "", "", "", "", paramInt, paramString, l1, l2, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
    }
    for (;;)
    {
      if (UniformDownloaderAppBaby.a(this.a) != null) {
        UniformDownloaderAppBaby.a(this.a).a(paramInt, paramString, paramBundle);
      }
      return;
      QLog.w(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 6");
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).a(this.a.h(), null);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    QLog.i(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "] >>>>>>Download SUCCESS. sdk download path=" + paramString);
    this.a.c(4);
    if (paramString == null)
    {
      QLog.e(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. download success, but filepath = null");
      a(40, UDConstants.a(40), paramBundle);
    }
    label805:
    for (;;)
    {
      return;
      if (FileUtils.a(this.a.d)) {
        this.a.d = FileManagerUtil.a(this.a.d);
      }
      QLog.i(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. try to rename file to path:" + this.a.d);
      Object localObject;
      if (!FileUtils.b(new File(paramString), new File(this.a.d)))
      {
        QLog.e(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].rename failed. temppath=" + paramString + " save path=" + this.a.d);
        localObject = FileUtil.b(paramString);
        if (!FileManagerUtil.a().equalsIgnoreCase((String)localObject))
        {
          String str = (String)localObject + this.a.jdField_c_of_type_JavaLangString;
          localObject = str;
          if (FileUtils.a(str)) {
            localObject = FileManagerUtil.a(str);
          }
          QLog.i(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try to save file to path: " + (String)localObject);
          if (!FileUtils.b(new File(paramString), new File((String)localObject)))
          {
            QLog.e(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed, try failed save path: " + (String)localObject);
            a(7, UDConstants.a(7), paramBundle);
            return;
          }
          this.a.d = ((String)localObject);
        }
      }
      else
      {
        QLog.i(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename file success. path:" + this.a.d);
        paramString = UniformDownloadMgr.a().a();
        if (paramString == null) {
          break label767;
        }
        long l1 = -1L;
        long l2 = -1L;
        localObject = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
        if (localObject == null) {
          break label727;
        }
        l1 = ((UniformDownloaderAppBabySdk.RParam)localObject).a;
        l2 = ((UniformDownloaderAppBabySdk.RParam)localObject).jdField_b_of_type_Long;
        FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.jdField_b_of_type_Long, 0, null);
        FileManagerUtil.a(paramString, this.a.jdField_c_of_type_Long, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.jdField_b_of_type_Long, 0, null);
      }
      for (;;)
      {
        if (UniformDownloaderAppBaby.a(this.a) == null) {
          break label805;
        }
        UniformDownloaderAppBaby.a(this.a).a(this.a.d, this.a.jdField_b_of_type_Long, paramBundle);
        return;
        QLog.e(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "]. rename failed 2, try failed save path: " + paramString);
        a(7, UDConstants.a(7), paramBundle);
        return;
        label727:
        QLog.w(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report may failed - 0");
        break;
        label767:
        QLog.i(UniformDownloaderAssinfo.a, 1, "[UniformDL][" + this.a.jdField_c_of_type_Long + "].report failed - 7");
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    this.a.c(3);
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).c(this.a.h(), null);
    }
  }
  
  public void c(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBaby.1
 * JD-Core Version:    0.7.0.1
 */