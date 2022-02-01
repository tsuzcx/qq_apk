package com.tencent.mobileqq.qrscan.ipc;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoLoader;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelLoader;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelsDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoLoader;
import com.tencent.mobileqq.qrscan.earlydown.QBarModelDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.QBarModelLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QRScanResDownloadManager
{
  public static Handler a = new Handler(Looper.getMainLooper());
  private static ArrayList<QRScanResDownloadManager.DownloadCallback> b = new ArrayList(2);
  
  private static IEarlyDownloadService a(AppInterface paramAppInterface)
  {
    Object localObject;
    if ((paramAppInterface != null) && (paramAppInterface.isLogin()))
    {
      try
      {
        paramAppInterface = (IEarlyDownloadService)paramAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
        return paramAppInterface;
      }
      catch (Exception paramAppInterface)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getEarlyDownloadService() ex. ");
        ((StringBuilder)localObject).append(paramAppInterface.getMessage());
        QLog.d("MiniRecog.ResDownloadManager", 1, ((StringBuilder)localObject).toString(), paramAppInterface);
      }
    }
    else if (QLog.isColorLevel())
    {
      if (paramAppInterface == null) {
        localObject = "null";
      } else {
        localObject = Boolean.valueOf(paramAppInterface.isLogin());
      }
      QLog.d("MiniRecog.ResDownloadManager", 2, String.format("getEarlyDownloadService() err app=%s app.isLogin=%s", new Object[] { paramAppInterface, localObject }));
    }
    return null;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    try
    {
      Object[] arrayOfObject = b.toArray();
      if (arrayOfObject != null)
      {
        if (arrayOfObject.length <= 0) {
          return;
        }
        int i = 0;
        while (i < arrayOfObject.length)
        {
          QRScanResDownloadManager.DownloadCallback localDownloadCallback = (QRScanResDownloadManager.DownloadCallback)arrayOfObject[i];
          a.post(new QRScanResDownloadManager.1(localDownloadCallback, paramInt1, paramInt2));
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(int paramInt, AppInterface paramAppInterface)
  {
    IEarlyDownloadService localIEarlyDownloadService = a(paramAppInterface);
    if (localIEarlyDownloadService == null) {
      return;
    }
    Object localObject = null;
    boolean bool3 = b(paramInt, paramAppInterface);
    boolean bool1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            bool1 = false;
            paramAppInterface = localObject;
          }
          else
          {
            paramAppInterface = localIEarlyDownloadService.getEarlyHandler("qq.android.qbarnative.model_v8.6.0");
            bool1 = QBarModelLoader.c();
          }
        }
        else
        {
          paramAppInterface = localIEarlyDownloadService.getEarlyHandler("qq.android.minidetect.model_v8.6.0");
          bool1 = MiniScanDetectModelLoader.c();
        }
      }
      else
      {
        paramAppInterface = localIEarlyDownloadService.getEarlyHandler("qq.android.minidetect.so_v8.6.0");
        bool1 = MiniScanDetectSoLoader.b();
      }
    }
    else
    {
      paramAppInterface = localIEarlyDownloadService.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
      bool1 = MiniScanDecodeSoLoader.b();
    }
    if (paramAppInterface != null)
    {
      int i = paramAppInterface.f();
      boolean bool2;
      if ((bool3) && (bool1) && (paramAppInterface.r()) && (i > 1)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      QLog.d("MiniRecog.ResDownloadManager", 1, String.format("downloadMiniRes resType=%d needDownload=%b bConfigReady=%b bResExits=%b isEarlySuc=%b version=%d", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(paramAppInterface.r()), Integer.valueOf(i) }));
      if (bool2) {
        paramAppInterface.a(true);
      }
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      Object[] arrayOfObject = b.toArray();
      if (arrayOfObject != null)
      {
        if (arrayOfObject.length <= 0) {
          return;
        }
        int i = 0;
        while (i < arrayOfObject.length)
        {
          QRScanResDownloadManager.DownloadCallback localDownloadCallback = (QRScanResDownloadManager.DownloadCallback)arrayOfObject[i];
          a.post(new QRScanResDownloadManager.2(localDownloadCallback, paramInt, paramBoolean));
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(QRScanResDownloadManager.DownloadCallback paramDownloadCallback)
  {
    if (paramDownloadCallback != null) {
      try
      {
        if (!b.contains(paramDownloadCallback))
        {
          if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.ResDownloadManager", 2, "addDownloadCallback");
          }
          b.add(paramDownloadCallback);
        }
      }
      finally {}
    }
  }
  
  private static boolean a(EarlyHandler paramEarlyHandler)
  {
    if (paramEarlyHandler == null) {
      return false;
    }
    paramEarlyHandler = paramEarlyHandler.h();
    if (paramEarlyHandler == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramEarlyHandler.strPkgName)) && (!TextUtils.isEmpty(paramEarlyHandler.strResURL_big))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("strPkgName is empty:");
      localStringBuilder.append(TextUtils.isEmpty(paramEarlyHandler.strPkgName));
      localStringBuilder.append(" strResURL_big is empty:");
      localStringBuilder.append(TextUtils.isEmpty(paramEarlyHandler.strResURL_big));
      localStringBuilder.append(" loadState :");
      localStringBuilder.append(paramEarlyHandler.loadState);
      QLog.d("MiniRecog.ResDownloadManager", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public static boolean b(int paramInt, AppInterface paramAppInterface)
  {
    boolean bool = d(paramInt, paramAppInterface);
    if (!bool) {
      c(paramInt, paramAppInterface);
    }
    return bool;
  }
  
  public static void c(int paramInt, AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          paramAppInterface = (QBarModelDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.qbarnative.model_v8.6.0");
          if ((paramAppInterface != null) && (paramAppInterface.r()) && (!QBarModelLoader.c()))
          {
            paramAppInterface.w();
            if (QLog.isColorLevel()) {
              QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", new Object[] { Integer.valueOf(paramInt) }));
            }
          }
        }
        else
        {
          paramAppInterface = (MiniScanDetectModelsDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidetect.model_v8.6.0");
          if ((paramAppInterface != null) && (paramAppInterface.r()) && (!MiniScanDetectModelLoader.c()))
          {
            paramAppInterface.w();
            if (QLog.isColorLevel()) {
              QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", new Object[] { Integer.valueOf(paramInt) }));
            }
          }
        }
      }
      else
      {
        paramAppInterface = (MiniScanDetectSoDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidetect.so_v8.6.0");
        if ((paramAppInterface != null) && (paramAppInterface.r()) && (!MiniScanDetectSoLoader.b()))
        {
          paramAppInterface.x();
          if (QLog.isColorLevel()) {
            QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", new Object[] { Integer.valueOf(paramInt) }));
          }
        }
      }
    }
    else
    {
      paramAppInterface = (MiniScanDecodeSoDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
      if ((paramAppInterface != null) && (paramAppInterface.r()) && (!MiniScanDecodeSoLoader.b()))
      {
        paramAppInterface.x();
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.ResDownloadManager", 2, String.format("resetResDownloadState resType=%d download state", new Object[] { Integer.valueOf(paramInt) }));
        }
      }
    }
  }
  
  public static boolean d(int paramInt, AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return false;
    }
    boolean bool1;
    boolean bool2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            bool1 = false;
          }
          else
          {
            paramAppInterface = (QBarModelDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.qbarnative.model_v8.6.0");
            bool2 = a(paramAppInterface);
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (paramAppInterface != null)
              {
                bool1 = bool2;
                if (paramAppInterface.r())
                {
                  bool1 = bool2;
                  if (!QBarModelLoader.c()) {}
                }
              }
            }
          }
        }
        else {
          for (;;)
          {
            bool1 = true;
            break;
            paramAppInterface = (MiniScanDetectModelsDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidetect.model_v8.6.0");
            bool2 = a(paramAppInterface);
            bool1 = bool2;
            if (bool2) {
              break;
            }
            bool1 = bool2;
            if (paramAppInterface == null) {
              break;
            }
            bool1 = bool2;
            if (!paramAppInterface.r()) {
              break;
            }
            bool1 = bool2;
            if (!MiniScanDetectModelLoader.c()) {
              break;
            }
          }
        }
      }
      else
      {
        paramAppInterface = (MiniScanDetectSoDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidetect.so_v8.6.0");
        bool1 = a(paramAppInterface);
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (paramAppInterface != null)
          {
            bool2 = bool1;
            if (paramAppInterface.r())
            {
              bool2 = bool1;
              if (MiniScanDetectSoLoader.b()) {
                bool2 = true;
              }
            }
          }
        }
        bool1 = bool2;
        if (bool2)
        {
          paramAppInterface.w();
          bool1 = bool2;
        }
      }
    }
    else
    {
      paramAppInterface = (MiniScanDecodeSoDownloadHandler)paramAppInterface.getEarlyHandler("qq.android.minidecode.so_v8.8.5");
      bool1 = a(paramAppInterface);
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramAppInterface != null)
        {
          bool2 = bool1;
          if (paramAppInterface.r())
          {
            bool2 = bool1;
            if (MiniScanDecodeSoLoader.b()) {
              bool2 = true;
            }
          }
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        paramAppInterface.w();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.ResDownloadManager", 2, String.format("isResConfigReady exist [resType=%d] = [%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1) }));
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.ipc.QRScanResDownloadManager
 * JD-Core Version:    0.7.0.1
 */