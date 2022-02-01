package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.uniformdownload.core.UniformDownloadMgr;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

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
    UniformDownloaderGen.b(this.a);
    this.a.c(5);
    if (UniformDownloaderGen.a(this.a) != null) {
      UniformDownloaderGen.a(this.a).a(paramInt, paramString, paramBundle);
    }
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    UniformDownloaderGen.b(this.a);
    this.a.c(4);
    if (FileUtils.fileExists(this.a.f))
    {
      paramString = this.a;
      paramString.f = QQFileManagerUtil.t(paramString.f);
    }
    paramString = UniformDownloaderGen.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.a.h);
    ((StringBuilder)localObject).append("]. >>>Download SUCCESS.  save file to: =");
    ((StringBuilder)localObject).append(this.a.f);
    QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
    long l1;
    long l2;
    int i;
    if (paramBundle != null)
    {
      l1 = paramBundle.getLong("EXT_TRANS_SIZE ");
      l2 = paramBundle.getLong("EXT_TTRANS_SIZE ");
      i = paramBundle.getInt("EXT_AUTOTRY_COUNT");
    }
    else
    {
      l1 = paramLong;
      l2 = l1;
      i = 1;
    }
    if (!FileUtils.renameFile(new File(this.a.g), new File(this.a.f)))
    {
      paramString = UniformDownloaderGen.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.a.h);
      ((StringBuilder)localObject).append("].rename failed.temppath=");
      ((StringBuilder)localObject).append(this.a.g);
      ((StringBuilder)localObject).append(" path=");
      ((StringBuilder)localObject).append(this.a.f);
      QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
      this.a.c(5);
      paramString = UDConstants.a(7);
      localObject = UniformDownloadMgr.a().b();
      if (localObject != null)
      {
        localObject = (BaseQQAppInterface)localObject;
        paramLong = this.a.h;
        long l3 = this.a.p;
        long l4 = 7;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, paramLong, "actFileUfGenDownload", l3, "", "", "", "", l4, paramString, l2, l1, this.a.e, this.a.c, "", 0, paramString, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.a.h, "actFileUfGenDownloadDetail", this.a.p, "", "", "", "", l4, paramString, l2, l1, this.a.e, this.a.c, "", 0, paramString, null);
      }
      else
      {
        localObject = UniformDownloaderGen.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.a.h);
        localStringBuilder.append("].report failed - 5");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      if (UniformDownloaderGen.a(this.a) != null) {
        UniformDownloaderGen.a(this.a).a(7, paramString, paramBundle);
      }
      return;
    }
    UniformDownloadBPTrans.a().a(this.a.c);
    paramString = UniformDownloadMgr.a().b();
    if (paramString != null)
    {
      paramString = (BaseQQAppInterface)paramString;
      QQFileManagerUtil.a(paramString, this.a.h, "actFileUfGenDownload", System.currentTimeMillis() - this.a.p, "", "", "", "", l2, l1, this.a.e, i, null);
      QQFileManagerUtil.a(paramString, this.a.h, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.p, "", "", "", "", l2, l1, this.a.e, i, null);
    }
    else
    {
      paramString = UniformDownloaderGen.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.a.h);
      ((StringBuilder)localObject).append("].report failed - 0");
      QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
    }
    if (UniformDownloaderGen.a(this.a) != null)
    {
      if ((this.a.e > 0L) && (paramLong <= 0L)) {
        paramLong = this.a.e;
      }
      UniformDownloaderGen.a(this.a).a(this.a.f, paramLong, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen.1
 * JD-Core Version:    0.7.0.1
 */