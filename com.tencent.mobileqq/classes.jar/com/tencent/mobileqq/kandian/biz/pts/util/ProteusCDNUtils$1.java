package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class ProteusCDNUtils$1
  implements Runnable
{
  ProteusCDNUtils$1(String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject = new File(this.a);
    if (((File)localObject).exists())
    {
      FileUtils.deleteFile(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadByCDN], bid = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", delete old compressFile, path = ");
      localStringBuilder.append(this.a);
      QLog.i("ProteusCDNUtils", 1, localStringBuilder.toString());
    }
    boolean bool = HttpDownloadUtil.download(null, this.c, (File)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadByCDN], bid = ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", isDownloadSucc = ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("ProteusCDNUtils", 1, ((StringBuilder)localObject).toString());
    if (bool)
    {
      ProteusCDNUtils.a(this.b);
      return;
    }
    ProteusCDNUtils.a("0X800AC00", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ProteusCDNUtils.1
 * JD-Core Version:    0.7.0.1
 */