package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginDownloader.OnPluginDownLoadListener;

class ExpandManager$6
  implements PluginDownloader.OnPluginDownLoadListener
{
  int a = 0;
  
  ExpandManager$6(ExpandManager paramExpandManager) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadExpandPlugin: onDownloadProgress ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramInt2);
      QLog.d("ExtendFriendManager", 4, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      int i = paramInt1 * 100 / paramInt2;
      if ((i > this.a + 10) || (paramInt1 == paramInt2))
      {
        this.a = Math.min(100, i / 10 + 10);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("preDownloadExpandPlugin: onDownloadProgress ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramInt2);
        QLog.d("ExtendFriendManager", 4, localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preDownloadExpandPlugin: onDownloadCheckInvalid ");
    localStringBuilder.append(paramString);
    QLog.e("ExtendFriendManager", 1, localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadExpandPlugin: recordPluginStartupTime ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLong);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadExpandPlugin: onDownloadFinish ");
      localStringBuilder.append(paramString);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
  
  public void b(String paramString)
  {
    this.a = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadExpandPlugin: onDownloadBegin ");
      localStringBuilder.append(paramString);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownloadExpandPlugin: onDownloadCancel ");
      localStringBuilder.append(paramString);
      QLog.d("ExtendFriendManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.6
 * JD-Core Version:    0.7.0.1
 */