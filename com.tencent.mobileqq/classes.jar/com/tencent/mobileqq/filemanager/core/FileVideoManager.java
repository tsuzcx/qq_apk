package com.tencent.mobileqq.filemanager.core;

import acvu;
import acvv;
import acvw;
import acvx;
import acvy;
import acvz;
import acwa;
import acwb;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FileVideoManager
{
  public static FileVideoManager a;
  static boolean jdField_a_of_type_Boolean;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  public static FileVideoManager.VideoControl a(long paramLong)
  {
    try
    {
      Looper localLooper = Looper.getMainLooper();
      if ((Thread.currentThread() != localLooper.getThread()) && (QLog.isDevelopLevel()))
      {
        FileManagerUtil.a();
        throw new NullPointerException("getVideoControl not in UI Thread");
      }
    }
    finally {}
    if (!jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      localVideoControl = new FileVideoManager.VideoControl();
      localVideoControl.jdField_b_of_type_Boolean = false;
      FileVideoManager.VideoControl.a(localVideoControl, paramLong);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]new VcControl");
      }
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localVideoControl);
    }
    if (((FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
      FileVideoManager.VideoControl.a((FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)), paramLong);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]get old VcControl");
    }
    FileVideoManager.VideoControl localVideoControl = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    return localVideoControl;
  }
  
  public static void a()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "Release FileVideoManager!");
      }
      if ((jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.size() == 0))
      {
        if (!QLog.isDevelopLevel()) {
          return;
        }
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
        return;
      }
      Iterator localIterator = jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        localObject = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
        if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isDevelopLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Release, stop playID[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]Release, stop DownloadId[" + ((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int + "]");
          }
          if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int);
          }
          if (((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int);
          }
          if (((FileVideoManager.VideoControl)localObject).d > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).d);
          }
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]free VideoCtrl bDownloading = false");
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setCallBackListener(20160714, null);
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
          ((FileVideoManager.VideoControl)localObject).jdField_b_of_type_Boolean = false;
        }
        localIterator.remove();
      }
      if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break label400;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap = null;
    label400:
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "release all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  public static void a(int paramInt)
  {
    Looper localLooper = Looper.getMainLooper();
    if (localLooper.getThread() != Thread.currentThread())
    {
      new Handler(localLooper).post(new acvw(paramInt));
      return;
    }
    c(paramInt);
  }
  
  public static void a(long paramLong)
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new acvx(paramLong));
    }
    do
    {
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]FreeVideoControl");
        }
        if ((jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager != null) && (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap != null) && (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]queue is zero return");
      return;
      localObject = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ((FileVideoManager.VideoControl)localObject).a();
      a((FileVideoManager.VideoControl)localObject);
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    } while (!QLog.isDevelopLevel());
    QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]removed");
  }
  
  public static void a(Context paramContext, FileVideoManager.FileVideoManagerInitCallback paramFileVideoManagerInitCallback)
  {
    Looper localLooper = Looper.getMainLooper();
    Handler localHandler = new Handler(localLooper);
    if (localLooper.getThread() != Thread.currentThread())
    {
      localHandler.post(new acvz(paramContext, paramFileVideoManagerInitCallback));
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager = new FileVideoManager();
    }
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.b(paramContext, paramFileVideoManagerInitCallback);
  }
  
  public static void a(FileVideoManager.VideoControl paramVideoControl)
  {
    Object localObject = Looper.getMainLooper();
    if ((Thread.currentThread() != ((Looper)localObject).getThread()) && (QLog.isDevelopLevel()))
    {
      FileManagerUtil.a();
      throw new NullPointerException("DownloadNext not in UI Thread");
    }
    if ((jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "download queue is zero, DeinitDownloadManager");
      }
      if ((paramVideoControl != null) && (paramVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        paramVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.DownloadDeinit(20160714);
        paramVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr = null;
      }
    }
    FileVideoManager.VideoControl localVideoControl;
    for (;;)
    {
      return;
      localObject = jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        long l = ((Long)((Iterator)localObject).next()).longValue();
        localVideoControl = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l));
        if (localVideoControl != paramVideoControl) {
          break label220;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FileVideoManager<FileAssistant>", 1, "[" + localVideoControl.hashCode() + "]find vc[" + l + "] continue");
        }
      }
    }
    label220:
    localVideoControl.a(localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, false);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.status == 16)
    {
      a(paramFileManagerEntity.nSessionId);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new acvu(paramFileManagerEntity));
  }
  
  public static void b(long paramLong)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acvy(paramLong));
      return;
    }
    d(paramLong);
  }
  
  private void b(Context paramContext, FileVideoManager.FileVideoManagerInitCallback paramFileVideoManagerInitCallback)
  {
    int i = 1;
    if (!jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(paramContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(paramContext))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Installed!");
      }
      paramFileVideoManagerInitCallback.b();
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("FileVideoManager<FileAssistant>", 1, "TVK_SDKMgr Not Installed!");
    }
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
    while (i != 0)
    {
      c(paramContext, paramFileVideoManagerInitCallback);
      QQToast.a(paramContext, paramContext.getResources().getString(2131430809), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131558448));
      return;
      i = 0;
    }
    try
    {
      DialogUtil.a(paramContext, 232, null, paramContext.getResources().getString(2131430807), new acwa(this, paramContext, paramFileVideoManagerInitCallback), new acwb(this, paramFileVideoManagerInitCallback)).show();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private static void c(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "onNeworkChanged!");
    }
    if ((jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "No download return!");
      }
      return;
    }
    Iterator localIterator = jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localObject = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(((Map.Entry)localObject).getKey());
      if ((((FileVideoManager.VideoControl)localObject).jdField_b_of_type_JavaLangString != null) || (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null))
      {
        ((FileVideoManager.VideoControl)localObject).b();
        if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null)
        {
          if (QLog.isDevelopLevel())
          {
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onNetworkChange, stop playID[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int + "]");
            QLog.i("FileVideoManager<FileAssistant>", 4, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onNetworkChange, stop DownloadId[" + ((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int + "]");
          }
          if (((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).jdField_a_of_type_Int);
          }
          if (((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).jdField_c_of_type_Int);
          }
          if (((FileVideoManager.VideoControl)localObject).d > 0) {
            ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.stopPreLoad(((FileVideoManager.VideoControl)localObject).d);
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("FileVideoManager<FileAssistant>", 1, "[" + ((FileVideoManager.VideoControl)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]##########NetWorkChange########### bDownloading = false");
          }
          ((FileVideoManager.VideoControl)localObject).jdField_b_of_type_Boolean = false;
        }
        localIterator.remove();
      }
    }
    if (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.size() == 0) {
      jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "process all");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).a().a(true, 3, null);
  }
  
  private void c(Context paramContext, FileVideoManager.FileVideoManagerInitCallback paramFileVideoManagerInitCallback)
  {
    TVK_SDKMgr.installPlugin(paramContext, new acvv(this, System.currentTimeMillis(), paramFileVideoManagerInitCallback));
  }
  
  private static void d(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]DestroyMediaPlay");
    }
    if ((jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager == null) || (jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap == null) || (!jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))) {
      if (QLog.isDevelopLevel()) {
        QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]not in map return");
      }
    }
    for (;;)
    {
      return;
      FileVideoManager.VideoControl localVideoControl = (FileVideoManager.VideoControl)jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileVideoManager.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      if (localVideoControl.jdField_c_of_type_Boolean)
      {
        localVideoControl.a();
        if (QLog.isDevelopLevel()) {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]download success return");
        }
      }
      else
      {
        if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
        {
          localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
          localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        }
        if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
          if (localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16)
          {
            localVideoControl.a(localVideoControl.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, false);
            if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr != null) {
              localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr.setPlayerState(20160714, localVideoControl.jdField_c_of_type_Int, 6);
            }
          }
        }
        while (QLog.isDevelopLevel())
        {
          QLog.i("FileVideoManager<FileAssistant>", 1, "[" + paramLong + "]DestroyMediaPlay,vc.bDownloading[" + localVideoControl.jdField_b_of_type_Boolean + "]");
          return;
          a(paramLong);
          continue;
          if (localVideoControl.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IDownloadMgr == null) {
            a(paramLong);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileVideoManager
 * JD-Core Version:    0.7.0.1
 */