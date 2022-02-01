package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.filemanager.FileManagerUtil;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

class UniformDownloaderGen$1
  implements UniformDownloaderGen.IUniformDownloaderGenListener
{
  UniformDownloaderGen$1(UniformDownloaderGen paramUniformDownloaderGen) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if ((UniformDownloaderGen.a(this.a) != null) && (paramInt - this.a.g() > 0))
    {
      this.a.a(paramInt);
      UniformDownloaderGen.a(this.a).b(paramInt, paramBundle);
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    UniformDownloaderGen.a(this.a);
    this.a.c(5);
    if (UniformDownloaderGen.a(this.a) != null) {
      UniformDownloaderGen.a(this.a).a(paramInt, paramString, paramBundle);
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    UniformDownloaderGen.a(this.a);
    this.a.c(4);
    if (FileUtils.a(this.a.d)) {
      this.a.d = FileManagerUtil.a(this.a.d);
    }
    QLog.i(UniformDownloaderGen.g, 1, "[UniformDL][" + this.a.c + "]. >>>Download SUCCESS.  save file to: =" + this.a.d);
    int i = 1;
    long l2;
    long l1;
    if (paramBundle != null)
    {
      l2 = paramBundle.getLong("EXT_TRANS_SIZE ");
      l1 = paramBundle.getLong("EXT_TTRANS_SIZE ");
      i = paramBundle.getInt("EXT_AUTOTRY_COUNT");
    }
    for (;;)
    {
      if (!FileUtils.b(new File(this.a.e), new File(this.a.d)))
      {
        QLog.e(UniformDownloaderGen.g, 1, "[UniformDL][" + this.a.c + "].rename failed.temppath=" + this.a.e + " path=" + this.a.d);
        this.a.c(5);
        paramString = UDConstants.a(7);
        AppRuntime localAppRuntime = UniformDownloadMgr.a().a();
        if (localAppRuntime != null)
        {
          FileManagerUtil.a(localAppRuntime, this.a.c, "actFileUfGenDownload", this.a.a, "", "", "", "", 7, paramString, l1, l2, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
          FileManagerUtil.a(localAppRuntime, this.a.c, "actFileUfGenDownloadDetail", this.a.a, "", "", "", "", 7, paramString, l1, l2, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
          if (UniformDownloaderGen.a(this.a) != null) {
            UniformDownloaderGen.a(this.a).a(7, paramString, paramBundle);
          }
        }
      }
      for (;;)
      {
        return;
        QLog.w(UniformDownloaderGen.g, 1, "[UniformDL][" + this.a.c + "].report failed - 5");
        break;
        UniformDownloadBPTrans.a().a(this.a.jdField_b_of_type_JavaLangString);
        paramString = UniformDownloadMgr.a().a();
        if (paramString != null)
        {
          FileManagerUtil.a(paramString, this.a.c, "actFileUfGenDownload", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.jdField_b_of_type_Long, i, null);
          FileManagerUtil.a(paramString, this.a.c, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.jdField_b_of_type_Long, i, null);
        }
        while (UniformDownloaderGen.a(this.a) != null)
        {
          l1 = paramLong;
          if (this.a.jdField_b_of_type_Long > 0L)
          {
            l1 = paramLong;
            if (paramLong <= 0L) {
              l1 = this.a.jdField_b_of_type_Long;
            }
          }
          UniformDownloaderGen.a(this.a).a(this.a.d, l1, paramBundle);
          return;
          QLog.i(UniformDownloaderGen.g, 1, "[UniformDL][" + this.a.c + "].report failed - 0");
        }
      }
      l1 = paramLong;
      l2 = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen.1
 * JD-Core Version:    0.7.0.1
 */