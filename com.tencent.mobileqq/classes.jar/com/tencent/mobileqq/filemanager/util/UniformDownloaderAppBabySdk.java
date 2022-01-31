package com.tencent.mobileqq.filemanager.util;

import adqp;
import adqq;
import adqr;
import adqs;
import adqx;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UniformDownloaderAppBabySdk
{
  private static UniformDownloaderAppBabySdk jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBabySdk;
  public static String a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new adqs(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniformDownloaderAppBabySdk<FileAssistant>";
  }
  
  private int a(String paramString, adqx paramadqx)
  {
    if ((paramadqx == null) || (paramString == null)) {
      return -1;
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        return -2;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString, paramadqx);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramadqx.jdField_a_of_type_Long + "] addDownloadCtx...total:[" + this.jdField_a_of_type_JavaUtilMap.size() + "] add it. url:[ " + paramString + "]");
    return 0;
  }
  
  private adqx a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (adqx)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public static UniformDownloaderAppBabySdk a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBabySdk == null) {
        jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBabySdk = new UniformDownloaderAppBabySdk();
      }
      UniformDownloaderAppBabySdk localUniformDownloaderAppBabySdk = jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBabySdk;
      return localUniformDownloaderAppBabySdk;
    }
    finally {}
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (0L == paramLong) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("flowstat", 2, "fileType:" + 5 + ",busiType:" + 0);
    }
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL]. reportFlow failed.APP=null");
      return;
    }
    localQQAppInterface.sendAppDataIncerment(localQQAppInterface.getAccount(), false, paramInt, 5, 0, paramLong);
  }
  
  private void a(adqx paramadqx, int paramInt, String paramString)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>handleDownloadSDKTaskStateFailed. errCode:" + paramInt + " errStr" + paramString);
    int i = 5;
    UniformDownloader.a(5);
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      paramInt = 2;
      paramString = UniformDownloader.a(paramInt);
      if (paramadqx != null)
      {
        a(paramadqx.b(), paramadqx.jdField_b_of_type_Int);
        paramadqx.b(0L);
        if (paramadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null)
        {
          Bundle localBundle = new UniformDownloaderAppBabySdk.RParam(paramadqx.a(), paramadqx.a()).a();
          paramadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(paramInt, paramString, localBundle);
        }
      }
      return;
    }
    if (601 == paramInt)
    {
      i = 38;
      label132:
      if (!SystemUtil.a()) {
        break label453;
      }
    }
    label453:
    for (long l = SystemUtil.a() * 1024L;; l = SystemUtil.b() * 1024L)
    {
      paramInt = i;
      if (paramadqx == null) {
        break;
      }
      paramInt = i;
      if (l >= paramadqx.jdField_b_of_type_Long - paramadqx.a()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + paramadqx.jdField_a_of_type_Long + "] write file failed.  space is no enough:[" + paramadqx.jdField_b_of_type_Long + " " + paramadqx.a() + " " + l + "]");
      paramInt = 9;
      break;
      if (702 == paramInt)
      {
        i = 23;
        break label132;
      }
      if (600 == paramInt)
      {
        i = 24;
        break label132;
      }
      if (paramInt == 0)
      {
        i = 25;
        break label132;
      }
      if (704 == paramInt)
      {
        i = 26;
        break label132;
      }
      if (706 == paramInt)
      {
        i = 27;
        break label132;
      }
      if (709 == paramInt)
      {
        i = 28;
        break label132;
      }
      if (701 == paramInt)
      {
        i = 29;
        break label132;
      }
      if (707 == paramInt)
      {
        i = 30;
        break label132;
      }
      if (602 == paramInt)
      {
        i = 31;
        break label132;
      }
      if (705 == paramInt)
      {
        i = 32;
        break label132;
      }
      if (604 == paramInt)
      {
        i = 39;
        break label132;
      }
      if (603 == paramInt)
      {
        i = 34;
        break label132;
      }
      if (708 == paramInt)
      {
        i = 35;
        break label132;
      }
      if (700 == paramInt)
      {
        i = 36;
        break label132;
      }
      if (703 != paramInt) {
        break label132;
      }
      i = 37;
      break label132;
    }
  }
  
  private void a(String paramString)
  {
    e();
    Object localObject2 = a(paramString);
    if (localObject2 == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. not found ctx.url:" + paramString);
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.client = null");
        if (((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null)
        {
          paramString = new UniformDownloaderAppBabySdk.RParam(0L, ((adqx)localObject2).a()).a();
          ((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(41, UniformDownloader.a(41), paramString);
        }
      }
      else
      {
        Object localObject1 = AppNetConnInfo.getRecentNetworkInfo();
        if (localObject1 != null) {
          ((adqx)localObject2).jdField_b_of_type_Int = ((NetworkInfo)localObject1).getType();
        }
        int i;
        int j;
        try
        {
          localObject1 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
          if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 2))
          {
            QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.but it is downloading.url = " + paramString);
            return;
          }
        }
        catch (Exception localException1)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1;
          for (;;)
          {
            localException1.printStackTrace();
            localTMAssistantDownloadTaskInfo1 = null;
          }
          i = 0;
          try
          {
            j = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString, "application/vnd.android.package-archive");
            i = j;
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.startDownloadTask. url = " + paramString);
            if (j != 0) {
              break label420;
            }
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload success.. url = " + paramString);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              try
              {
                localTMAssistantDownloadTaskInfo1 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
                if ((localObject2 == null) || (localTMAssistantDownloadTaskInfo1 == null)) {
                  break;
                }
                long l = localTMAssistantDownloadTaskInfo1.mReceiveDataLen;
                ((adqx)localObject2).a(l);
                QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload success. rSize:" + l + " url = " + paramString);
                return;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
              localException2 = localException2;
              localException2.printStackTrace();
              j = i;
            }
          }
        }
        if (localObject2 != null)
        {
          a(((adqx)localObject2).b(), ((adqx)localObject2).jdField_b_of_type_Int);
          ((adqx)localObject2).b(0L);
          if (((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null)
          {
            paramString = new UniformDownloaderAppBabySdk.RParam(0L, ((adqx)localObject2).a()).a();
            ((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(20, UniformDownloader.a(20), paramString);
            return;
            label420:
            Bundle localBundle;
            if (4 == j)
            {
              QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. file existed. sucess dricetly. url = " + paramString);
              ((adqx)localObject2).a(2);
              for (;;)
              {
                TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
                try
                {
                  localTMAssistantDownloadTaskInfo2 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
                  d(paramString);
                  if (localObject2 == null) {
                    break;
                  }
                  ((adqx)localObject2).a(((adqx)localObject2).jdField_b_of_type_Long);
                  if (((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null) {
                    break;
                  }
                  localBundle = new UniformDownloaderAppBabySdk.RParam(0L, ((adqx)localObject2).a()).a();
                  localObject2 = ((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener;
                  if (localTMAssistantDownloadTaskInfo2 != null) {
                    break label614;
                  }
                  paramString = null;
                  ((UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener)localObject2).a(paramString, localBundle);
                  return;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
                if (localObject2 == null) {
                  break;
                }
                a(((adqx)localObject2).b(), ((adqx)localObject2).jdField_b_of_type_Int);
                ((adqx)localObject2).b(0L);
                if (((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null) {
                  break;
                }
                paramString = new UniformDownloaderAppBabySdk.RParam(0L, ((adqx)localObject2).a()).a();
                ((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(20, UniformDownloader.a(20), paramString);
                return;
                label614:
                paramString = localTMAssistantDownloadTaskInfo2.mSavePath;
              }
            }
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload. task failed. result:" + j + ". url = " + paramString);
            ((adqx)localObject2).a(2);
            i = 15;
            paramString = "start failed";
            if (5 == j)
            {
              i = 16;
              paramString = "busy";
            }
            while ((localObject2 != null) && (((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null))
            {
              localBundle = new UniformDownloaderAppBabySdk.RParam(0L, ((adqx)localObject2).a()).a();
              ((adqx)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(i, paramString, localBundle);
              return;
              if (1 == j)
              {
                i = 17;
                paramString = "net broken";
              }
              else if (2 == j)
              {
                i = 18;
                paramString = "set only for wifi";
              }
              else if (3 == j)
              {
                i = 19;
                paramString = "param err";
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPRunABSdkDownloadCmd.cmd:" + paramInt + " url = " + paramString);
    switch (paramInt)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPRunABSdkDownloadCmd, errcmd: " + paramInt);
      return;
    case 1: 
      a(paramString);
      return;
    case 2: 
      b(paramString);
      return;
    }
    c(paramString);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    adqx localadqx = a(paramString1);
    if (localadqx == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged. not found ctx.  state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  unkown state:[" + paramInt1 + "]errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
              return;
            case 1: 
              QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[WAITING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
            }
          } while ((localadqx == null) || (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null));
          localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.c(null);
          return;
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[DOWNLOADING] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        } while ((localadqx == null) || (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null));
        localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(null);
        return;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[FAILED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        localadqx.a(2);
        a(localadqx.b(), localadqx.jdField_b_of_type_Int);
        localadqx.b(0L);
        a(localadqx, paramInt2, paramString2);
        return;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[SUCCEED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
        localadqx.a(2);
        a(localadqx.b(), localadqx.jdField_b_of_type_Int);
        localadqx.b(0L);
        d(paramString1);
      } while ((localadqx == null) || (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null));
      paramString1 = new UniformDownloaderAppBabySdk.RParam(localadqx.a(), localadqx.a()).a();
      localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(paramString3, paramString1);
      return;
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateChanged  state:[PAUSED] errcode:[" + paramInt2 + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
      localadqx.a(2);
      a(localadqx.b(), localadqx.jdField_b_of_type_Int);
      localadqx.b(0L);
    } while ((localadqx == null) || (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null));
    localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.b(null);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>inPPDwonloadSDKErr errcode:" + paramInt + " errStr:" + paramString2 + " url:" + paramString1);
    adqx localadqx = a(paramString1);
    if (localadqx == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskStateFailed. not found ctx.  errcode:[" + paramInt + "] errStr:[" + paramString2 + "] url:[" + paramString1 + "]");
    }
    do
    {
      return;
      localadqx.a(2);
      a(localadqx.b(), localadqx.jdField_b_of_type_Int);
      localadqx.b(0L);
    } while (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null);
    paramString1 = new UniformDownloaderAppBabySdk.RParam(localadqx.a(), localadqx.a()).a();
    localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(paramInt, paramString2, paramString1);
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    adqx localadqx = a(paramString);
    if (localadqx != null)
    {
      localadqx.b(paramLong1 - localadqx.a() + localadqx.b());
      localadqx.a(paramLong1);
      if (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null) {
        localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(i, null);
      }
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPDownloadSDKTaskProgressChanged. not found ctx, url: " + paramString);
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DL_ABSdkThread");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>start thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(String paramString)
  {
    e();
    adqx localadqx = a(paramString);
    if (localadqx == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload. not found ctx.url:" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload.client = null");
      if ((localadqx != null) && (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null))
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(0L, localadqx.a()).a();
        localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(41, UniformDownloader.a(41), paramString);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
          if (localTMAssistantDownloadTaskInfo != null)
          {
            try
            {
              this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
              return;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
            }
            if (localadqx == null) {
              continue;
            }
            a(localadqx.b(), localadqx.jdField_b_of_type_Int);
            localadqx.b(0L);
            if (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null) {
              continue;
            }
            paramString = new UniformDownloaderAppBabySdk.RParam(localadqx.a(), localadqx.a()).a();
            localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(21, UniformDownloader.a(21), paramString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (localadqx != null)
            {
              a(localadqx.b(), localadqx.jdField_b_of_type_Int);
              localadqx.b(0L);
              if (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null)
              {
                localBundle = new UniformDownloaderAppBabySdk.RParam(localadqx.a(), localadqx.a()).a();
                localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(20, UniformDownloader.a(20), localBundle);
              }
            }
            Bundle localBundle = null;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload. no run load");
        }
      }
    } while ((localadqx == null) || (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener == null));
    localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.b(null);
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_a_of_type_AndroidOsHandler = null;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>stop thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString)
  {
    e();
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload.client = null");
      return;
    }
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if (localTMAssistantDownloadTaskInfo == null) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.cancelDownloadTask(paramString);
          d(paramString);
          return;
          localException1 = localException1;
          localException1.printStackTrace();
          Object localObject = null;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload. no run load");
      }
    }
  }
  
  private int d(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      adqx localadqx = (adqx)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL][" + localadqx.jdField_a_of_type_Long + "] delDownloadCtx...total:[" + i + "] add it. url:[ " + paramString + "]");
      return i;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i == 0)
      {
        c();
        a();
      }
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>create ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("UF_DL_CLIENT");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    }
  }
  
  private void f()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>inPDwonloadSDKServiceInvalid service invalid ");
    a();
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      localObject3 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      if (((Iterator)localObject3).hasNext()) {
        localArrayList.add((adqx)((Iterator)localObject3).next());
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    ??? = localObject2.iterator();
    while (((Iterator)???).hasNext())
    {
      adqx localadqx = (adqx)((Iterator)???).next();
      if (localadqx != null)
      {
        a(localadqx.b(), localadqx.jdField_b_of_type_Int);
        localadqx.b(0L);
        if (localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener != null)
        {
          localObject3 = new UniformDownloaderAppBabySdk.RParam(localadqx.a(), localadqx.a()).a();
          localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener.a(10, UniformDownloader.a(10), (Bundle)localObject3);
        }
      }
    }
  }
  
  public int a(long paramLong1, String paramString, long paramLong2, UniformDownloaderAppBaby.IUniformDownloaderAppBabyListener paramIUniformDownloaderAppBabyListener)
  {
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] [" + paramLong1 + "] initADownload, url = null");
      return -1;
    }
    adqx localadqx = new adqx(this, paramLong1, paramString, paramLong2);
    localadqx.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloaderAppBaby$IUniformDownloaderAppBabyListener = paramIUniformDownloaderAppBabyListener;
    int i = a(paramString, localadqx);
    if (i != 0)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL]  [" + paramLong1 + "] initADownload failed:" + i);
      return -2;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload, url = null");
      return -1;
    }
    adqx localadqx = a(paramString);
    if (localadqx == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload, not exsit download,url = " + paramString);
      return -2;
    }
    localadqx.a(1);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new adqp(this, paramString)))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload.post failed url = " + paramString);
      localadqx.a(2);
      return -3;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>release ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = null;
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).releaseDownloadSDKClient("UF_DL_CLIENT");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] releaseABSdkClient. client had be stoped");
  }
  
  public boolean a(String paramString)
  {
    return a(paramString) != null;
  }
  
  public int b(String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload, url = null");
      return -1;
    }
    adqx localadqx = a(paramString);
    if (localadqx == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload, not exsit download,url = " + paramString);
      return -2;
    }
    localadqx.a(2);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new adqq(this, paramString)))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload.post failed url = " + paramString);
      return -3;
    }
    return 0;
  }
  
  public int c(String paramString)
  {
    int i = 0;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload.url = " + paramString);
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, url = null");
      i = -1;
    }
    do
    {
      return i;
      adqx localadqx = a(paramString);
      if (localadqx == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, not exsit download,url = " + paramString);
        return 0;
      }
      localadqx.a(2);
      b();
    } while (this.jdField_a_of_type_AndroidOsHandler.post(new adqr(this, paramString)));
    d(paramString);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, post failed,url = " + paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloaderAppBabySdk
 * JD-Core Version:    0.7.0.1
 */