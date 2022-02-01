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
    if (FileUtils.fileExists(this.a.d))
    {
      paramString = this.a;
      paramString.d = QQFileManagerUtil.f(paramString.d);
    }
    paramString = UniformDownloaderGen.g;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[UniformDL][");
    ((StringBuilder)localObject).append(this.a.c);
    ((StringBuilder)localObject).append("]. >>>Download SUCCESS.  save file to: =");
    ((StringBuilder)localObject).append(this.a.d);
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
    if (!FileUtils.renameFile(new File(this.a.e), new File(this.a.d)))
    {
      paramString = UniformDownloaderGen.g;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append("].rename failed.temppath=");
      ((StringBuilder)localObject).append(this.a.e);
      ((StringBuilder)localObject).append(" path=");
      ((StringBuilder)localObject).append(this.a.d);
      QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
      this.a.c(5);
      paramString = UDConstants.a(7);
      localObject = UniformDownloadMgr.a().a();
      if (localObject != null)
      {
        localObject = (BaseQQAppInterface)localObject;
        paramLong = this.a.c;
        long l3 = this.a.a;
        long l4 = 7;
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, paramLong, "actFileUfGenDownload", l3, "", "", "", "", l4, paramString, l2, l1, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
        QQFileManagerUtil.a((BaseQQAppInterface)localObject, this.a.c, "actFileUfGenDownloadDetail", this.a.a, "", "", "", "", l4, paramString, l2, l1, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, "", 0, paramString, null);
      }
      else
      {
        localObject = UniformDownloaderGen.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(this.a.c);
        localStringBuilder.append("].report failed - 5");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      if (UniformDownloaderGen.a(this.a) != null) {
        UniformDownloaderGen.a(this.a).a(7, paramString, paramBundle);
      }
      return;
    }
    UniformDownloadBPTrans.a().a(this.a.jdField_b_of_type_JavaLangString);
    paramString = UniformDownloadMgr.a().a();
    if (paramString != null)
    {
      paramString = (BaseQQAppInterface)paramString;
      QQFileManagerUtil.a(paramString, this.a.c, "actFileUfGenDownload", System.currentTimeMillis() - this.a.a, "", "", "", "", l2, l1, this.a.jdField_b_of_type_Long, i, null);
      QQFileManagerUtil.a(paramString, this.a.c, "actFileUfGenDownloadDetail", System.currentTimeMillis() - this.a.a, "", "", "", "", l2, l1, this.a.jdField_b_of_type_Long, i, null);
    }
    else
    {
      paramString = UniformDownloaderGen.g;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[UniformDL][");
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append("].report failed - 0");
      QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
    }
    if (UniformDownloaderGen.a(this.a) != null)
    {
      if ((this.a.jdField_b_of_type_Long > 0L) && (paramLong <= 0L)) {
        paramLong = this.a.jdField_b_of_type_Long;
      }
      UniformDownloaderGen.a(this.a).a(this.a.d, paramLong, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderGen.1
 * JD-Core Version:    0.7.0.1
 */