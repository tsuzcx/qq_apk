package com.tencent.mobileqq.qqemoticon.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
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
      Object localObject = (IEarlyDownloadService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IEarlyDownloadService.class, "");
      if (localObject != null)
      {
        localObject = (AppleEmojiHandler)((IEarlyDownloadService)localObject).getEarlyHandler("qq.android.appleemoji");
        if (localObject != null) {
          ((AppleEmojiHandler)localObject).a(true);
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.d("AppleEmojiManager", 2, "clear sharePreference info,zipfile path is null restartDownload");
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reDownloadAppleEmoji e=");
        localStringBuilder.append(localException);
        QLog.d("AppleEmojiManager", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.AppleEmojiManagerImpl
 * JD-Core Version:    0.7.0.1
 */