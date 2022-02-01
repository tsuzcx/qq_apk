package com.tencent.mobileqq.mutualmark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class MutualMarkManger
  implements Manager
{
  private static final String[] c = { "data.json", "icon_close.png" };
  QQAppInterface a;
  ZipResourcesDownloader b;
  
  public MutualMarkManger(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new ZipResourcesDownloader();
  }
  
  public static MutualMarkManger a(QQAppInterface paramQQAppInterface)
  {
    return (MutualMarkManger)paramQQAppInterface.getManager(QQManagerFactory.MUTUAL_MARK_MANAGER);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (b(paramString1, paramString2)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkDownloadCartoonResource download url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" md5:");
      localStringBuilder.append(paramString2);
      QLog.d("MutualMarkManger", 2, localStringBuilder.toString());
    }
    this.b.a(this.a, 10089, "prd", paramString1, paramString2, c, null);
  }
  
  public void a(String paramString1, String paramString2, ZipResourcesDownloader.OnZipResourcesDownloadCallback paramOnZipResourcesDownloadCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareCartoonResources url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" md5:");
      localStringBuilder.append(paramString2);
      QLog.d("MutualMarkManger", 2, localStringBuilder.toString());
    }
    this.b.a(this.a, 10089, "prd", paramString1, paramString2, c, paramOnZipResourcesDownloadCallback);
  }
  
  public boolean b(String paramString1, String paramString2)
  {
    boolean bool = ZipResourcesDownloader.a(paramString1, paramString2, c);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCartoonResourceReady url:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" md5:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" res:");
      localStringBuilder.append(bool);
      QLog.d("MutualMarkManger", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public String c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ZipResourcesDownloader.a(paramString1, paramString2));
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public void onDestroy()
  {
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkManger
 * JD-Core Version:    0.7.0.1
 */