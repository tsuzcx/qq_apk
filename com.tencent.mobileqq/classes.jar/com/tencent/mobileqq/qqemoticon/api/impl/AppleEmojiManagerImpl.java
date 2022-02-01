package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.qqemoticon.api.IAppleEmojiManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AppleEmojiManagerImpl
  implements IAppleEmojiManager
{
  public String getAppleEmojiSpName()
  {
    return new AppleEmojiData().getSharedPreferencesName();
  }
  
  public void reDownloadAppleEmoji()
  {
    try
    {
      Object localObject = (EarlyDownloadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
      if (localObject != null)
      {
        localObject = (AppleEmojiHandler)((EarlyDownloadManager)localObject).a("qq.android.appleemoji");
        if (localObject != null) {
          ((AppleEmojiHandler)localObject).a(true);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppleEmojiManager", 2, "clear sharePreference info,zipfile path is null restartDownload");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AppleEmojiManager", 2, "reDownloadAppleEmoji e=" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.AppleEmojiManagerImpl
 * JD-Core Version:    0.7.0.1
 */