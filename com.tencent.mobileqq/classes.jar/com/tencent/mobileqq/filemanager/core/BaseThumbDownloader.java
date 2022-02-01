package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class BaseThumbDownloader
  implements ThumbHttpDownloader.WhatHappen
{
  protected QQAppInterface a;
  protected LinkedHashMap<Long, BaseThumbDownloader.Session> a;
  
  public BaseThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected int a(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if (".mp4".equalsIgnoreCase(paramString)) {
      return 17;
    }
    if (".rmvb".equalsIgnoreCase(paramString)) {
      return 18;
    }
    if (".avi".equalsIgnoreCase(paramString)) {
      return 19;
    }
    if (".wmv".equalsIgnoreCase(paramString)) {
      return 20;
    }
    if (".flv".equalsIgnoreCase(paramString)) {
      return 21;
    }
    if (".3gp".equalsIgnoreCase(paramString)) {
      return 22;
    }
    if (".mkv".equalsIgnoreCase(paramString)) {
      return 23;
    }
    if (".asf".equalsIgnoreCase(paramString)) {
      return 26;
    }
    if (".vob".equalsIgnoreCase(paramString)) {
      return 27;
    }
    if (".m4v".equalsIgnoreCase(paramString)) {
      return 28;
    }
    if (".f4v".equalsIgnoreCase(paramString)) {
      return 29;
    }
    if (".mov".equalsIgnoreCase(paramString)) {
      return 30;
    }
    if (".mpeg".equalsIgnoreCase(paramString)) {
      return 31;
    }
    if (".mpg".equalsIgnoreCase(paramString)) {
      return 32;
    }
    if (".rm".equalsIgnoreCase(paramString)) {
      return 33;
    }
    if (".webm".equalsIgnoreCase(paramString)) {
      return 34;
    }
    return -1;
  }
  
  protected final BaseThumbDownloader.Session a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      BaseThumbDownloader.Session localSession = (BaseThumbDownloader.Session)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
      return localSession;
    }
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "64*64";
    case 0: 
      return "16*16";
    case 1: 
      return "32*32";
    case 2: 
      return "64*64";
    case 3: 
      return "128*128";
    case 4: 
      return "320*320";
    case 5: 
      return "384*384";
    case 6: 
      return "640*640";
    case 7: 
      return "750*750";
    }
    return "1024*1024";
  }
  
  protected String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      str = "x-video-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-video-";
      continue;
      str = "minni-video-";
      continue;
      str = "small-video-";
      continue;
      str = "middle-video-";
      continue;
      str = "large-video-";
      continue;
      str = "xlarge-video-";
      continue;
      str = "screen-video-";
    }
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    return null;
  }
  
  protected void a()
  {
    File localFile = new File(FMSettings.a().d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  protected final void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] removeSession");
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call removeSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void a(long paramLong, HttpMsg paramHttpMsg) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted suc:" + paramBoolean + " retCode[" + paramInt + "] thumbPath:" + paramString);
    a(paramLong);
  }
  
  protected final void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlResult suc:" + paramBoolean1 + " strDomain:" + paramString1 + " port:" + paramInt + " urlParam:" + paramString2 + " cookie:" + paramString4);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramLong, paramBoolean1, paramString1, paramInt, paramString2, paramString3, paramString4, paramBoolean2, paramString5, paramShort, paramString6, null);
  }
  
  protected final void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6, Bundle paramBundle)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlResult suc:" + paramBoolean1 + " strDomain:" + paramString1 + " port:" + paramInt + " urlParam:" + paramString2 + " cookie:" + paramString4);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramLong, paramBoolean1, paramString1, paramInt, paramString2, paramString3, paramString4, paramBoolean2, paramString5, paramShort, paramString6, paramBundle);
  }
  
  protected final void a(BaseThumbDownloader.Session paramSession)
  {
    if (paramSession == null)
    {
      QLog.e("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb] addSession = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramSession.jdField_a_of_type_Long + "] addSession");
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramSession.jdField_a_of_type_Long), paramSession);
      if (QLog.isDevelopLevel())
      {
        paramSession = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (paramSession.hasNext())
        {
          long l = ((Long)paramSession.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call addSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
  }
  
  protected void a(BaseThumbDownloader.Session paramSession, String paramString)
  {
    if ((paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext != null) && ((paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext instanceof String)) && ("igonFlow".equalsIgnoreCase((String)paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext))) {
      paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = null;
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb()) && (FileManagerUtil.a()))
      {
        QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] size(wh)[" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]autoDownload Thumb switch is off!");
        return;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(paramString, this);
      if (l == -1L)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] size(wh)[" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "] thumb is Downloading,waiting please!");
        return;
      }
      paramString = paramSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      i = paramString.mThumbRetryCount;
      paramString.mThumbRetryCount = (i + 1);
      if (i > 10)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "thumb retry over 10 count, igon!");
        return;
      }
      paramSession.jdField_a_of_type_Long = l;
      a(paramSession);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
      return;
    }
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    return false;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.BaseThumbDownloader
 * JD-Core Version:    0.7.0.1
 */