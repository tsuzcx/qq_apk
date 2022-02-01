package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderAppBabyListener;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class UniformDownloaderAppBaby$1
  implements IUniformDownloaderAppBabyListener
{
  UniformDownloaderAppBaby$1(UniformDownloaderAppBaby paramUniformDownloaderAppBaby) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.a.b(paramInt);
    if (UniformDownloaderAppBaby.a(this.a) != null)
    {
      if (paramInt > 100)
      {
        UniformDownloaderAppBaby.a(this.a).b(this.a.h(), paramBundle);
        return;
      }
      if (paramInt - this.a.g() > 0)
      {
        this.a.a(paramInt);
        UniformDownloaderAppBaby.a(this.a).b(paramInt, paramBundle);
      }
    }
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.c(5);
    Object localObject1 = UniformDownloadMgr.a().b();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
      long l1;
      long l2;
      if (localObject2 != null)
      {
        l1 = ((UniformDownloaderAppBabySdk.RParam)localObject2).a;
        l2 = ((UniformDownloaderAppBabySdk.RParam)localObject2).b;
      }
      else
      {
        l1 = -1L;
        l2 = l1;
      }
      localObject1 = (BaseQQAppInterface)localObject1;
      long l3 = this.a.h;
      long l4 = this.a.a;
      long l5 = paramInt;
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, l3, "actFileUfAppBabySdkDownload", l4, "", "", "", "", l5, paramString, l1, l2, this.a.e, this.a.c, "", 0, paramString, null);
      QQFileManagerUtil.a((BaseQQAppInterface)localObject1, this.a.h, "actFileUfAppBabySdkDownloadDetail", this.a.a, "", "", "", "", l5, paramString, l1, l2, this.a.e, this.a.c, "", 0, paramString, null);
    }
    else
    {
      localObject1 = UniformDownloaderAssinfo.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.a.h);
      ((StringBuilder)localObject2).append("].report failed - 6");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).a(paramInt, paramString, paramBundle);
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
    Object localObject1 = UniformDownloaderAssinfo.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.h);
    ((StringBuilder)localObject2).append("] >>>>>>Download SUCCESS. sdk download path=");
    ((StringBuilder)localObject2).append(paramString);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    this.a.c(4);
    if (paramString == null)
    {
      paramString = UniformDownloaderAssinfo.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL][");
      ((StringBuilder)localObject1).append(this.a.h);
      ((StringBuilder)localObject1).append("]. download success, but filepath = null");
      QLog.e(paramString, 1, ((StringBuilder)localObject1).toString());
      a(40, UDConstants.a(40), paramBundle);
      return;
    }
    if (FileUtils.fileExists(this.a.f))
    {
      localObject1 = this.a;
      ((UniformDownloaderAppBaby)localObject1).f = QQFileManagerUtil.t(((UniformDownloaderAppBaby)localObject1).f);
    }
    localObject1 = UniformDownloaderAssinfo.b;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL][");
    ((StringBuilder)localObject2).append(this.a.h);
    ((StringBuilder)localObject2).append("]. try to rename file to path:");
    ((StringBuilder)localObject2).append(this.a.f);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (!FileUtils.renameFile(new File(paramString), new File(this.a.f)))
    {
      localObject1 = UniformDownloaderAssinfo.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL][");
      ((StringBuilder)localObject2).append(this.a.h);
      ((StringBuilder)localObject2).append("].rename failed. temppath=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" save path=");
      ((StringBuilder)localObject2).append(this.a.f);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = FileUtil.c(paramString);
      if (!QQFileManagerUtil.j().equalsIgnoreCase((String)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.a.d);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (FileUtils.fileExists((String)localObject2)) {
          localObject1 = QQFileManagerUtil.t((String)localObject2);
        }
        localObject2 = UniformDownloaderAssinfo.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.a.h);
        localStringBuilder.append("]. rename failed, try to save file to path: ");
        localStringBuilder.append((String)localObject1);
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        if (!FileUtils.renameFile(new File(paramString), new File((String)localObject1)))
        {
          paramString = UniformDownloaderAssinfo.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL][");
          ((StringBuilder)localObject2).append(this.a.h);
          ((StringBuilder)localObject2).append("]. rename failed, try failed save path: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.e(paramString, 1, ((StringBuilder)localObject2).toString());
          a(7, UDConstants.a(7), paramBundle);
          return;
        }
        this.a.f = ((String)localObject1);
      }
      else
      {
        localObject1 = UniformDownloaderAssinfo.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.a.h);
        ((StringBuilder)localObject2).append("]. rename failed 2, try failed save path: ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        a(7, UDConstants.a(7), paramBundle);
        return;
      }
    }
    paramString = UniformDownloaderAssinfo.b;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[UniformDL][");
    ((StringBuilder)localObject1).append(this.a.h);
    ((StringBuilder)localObject1).append("]. rename file success. path:");
    ((StringBuilder)localObject1).append(this.a.f);
    QLog.i(paramString, 1, ((StringBuilder)localObject1).toString());
    paramString = UniformDownloadMgr.a().b();
    if (paramString != null)
    {
      localObject1 = UniformDownloaderAppBabySdk.RParam.a(paramBundle);
      long l1;
      long l2;
      if (localObject1 != null)
      {
        l1 = ((UniformDownloaderAppBabySdk.RParam)localObject1).a;
        l2 = ((UniformDownloaderAppBabySdk.RParam)localObject1).b;
      }
      else
      {
        localObject1 = UniformDownloaderAssinfo.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL][");
        ((StringBuilder)localObject2).append(this.a.h);
        ((StringBuilder)localObject2).append("].report may failed - 0");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        l1 = -1L;
        l2 = l1;
      }
      paramString = (BaseQQAppInterface)paramString;
      QQFileManagerUtil.a(paramString, this.a.h, "actFileUfAppBabySdkDownload", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.e, 0, null);
      QQFileManagerUtil.a(paramString, this.a.h, "actFileUfAppBabySdkDownloadDetail", System.currentTimeMillis() - this.a.a, "", "", "", "", l1, l2, this.a.e, 0, null);
    }
    else
    {
      paramString = UniformDownloaderAssinfo.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL][");
      ((StringBuilder)localObject1).append(this.a.h);
      ((StringBuilder)localObject1).append("].report failed - 7");
      QLog.i(paramString, 1, ((StringBuilder)localObject1).toString());
    }
    if (UniformDownloaderAppBaby.a(this.a) != null) {
      UniformDownloaderAppBaby.a(this.a).a(this.a.f, this.a.e, paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBaby.1
 * JD-Core Version:    0.7.0.1
 */