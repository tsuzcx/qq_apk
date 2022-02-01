package com.tencent.mobileqq.flutter.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.FilesListHolder;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.report.QFlutterReporter;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QFlutterInstaller
{
  public static Handler a = new Handler(Looper.getMainLooper());
  private static String b = QFlutterEngineData.STR_RES_NAME;
  private static String c = QFlutterAppData.STR_RES_NAME;
  private static boolean d = false;
  private static boolean e = false;
  private static ArrayList<InstallCallback> f = new ArrayList();
  private static volatile boolean g = false;
  private static QFlutterInstaller.DownloadStatus h = new QFlutterInstaller.DownloadStatus(null);
  private static QFlutterInstaller.DownloadStatus i = new QFlutterInstaller.DownloadStatus(null);
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(";");
    localStringBuilder.append(c);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    return new File(b(), paramString).getAbsolutePath();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      paramString = "_MD5";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      paramString = "_lastModifiedTs";
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (paramInt == 0) {}
    try
    {
      QFlutterReporter.a(paramBoolean, QFlutterInstaller.DownloadStatus.a(h), QFlutterInstaller.DownloadStatus.b(h), QFlutterInstaller.DownloadStatus.b(i), "engine");
      d = paramBoolean;
      h.a(paramBoolean, false);
      break label89;
      if (paramInt == 1)
      {
        QFlutterReporter.a(paramBoolean, QFlutterInstaller.DownloadStatus.a(i), QFlutterInstaller.DownloadStatus.b(h), QFlutterInstaller.DownloadStatus.b(i), "app");
        e = paramBoolean;
        i.a(paramBoolean, false);
      }
      label89:
      boolean bool2 = i.b();
      boolean bool3 = h.b();
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("onDownloadFinish, type: %s(%s), appFinished: %s, engineFinished: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool3) }));
      if ((bool2) && (bool3))
      {
        paramBoolean = bool1;
        if (i.b)
        {
          paramBoolean = bool1;
          if (h.b) {
            paramBoolean = true;
          }
        }
        long l = Math.max(QFlutterInstaller.DownloadStatus.a(i), QFlutterInstaller.DownloadStatus.a(h));
        a(paramBoolean, QFlutterInstaller.DownloadStatus.b(h), QFlutterInstaller.DownloadStatus.b(i));
        QFlutterReporter.a(paramBoolean, l, QFlutterInstaller.DownloadStatus.b(h), QFlutterInstaller.DownloadStatus.b(i), "all");
      }
      return;
    }
    finally
    {
      label238:
      Object localObject1;
      break label238;
    }
    throw localObject1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, InstallCallback paramInstallCallback)
  {
    for (;;)
    {
      try
      {
        boolean bool2 = a(paramQQAppInterface);
        d = bool2;
        boolean bool3 = b(paramQQAppInterface);
        e = bool3;
        c = XmlData.packageNameOf(paramQQAppInterface, QFlutterAppData.STR_RES_NAME);
        b = XmlData.packageNameOf(paramQQAppInterface, QFlutterEngineData.STR_RES_NAME);
        QFlutterReporter.a(a());
        a(paramInstallCallback);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("install isEngineReady:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(" isAppReady:");
        localStringBuilder.append(bool3);
        localStringBuilder.append(" installCallback:");
        if (paramInstallCallback != null)
        {
          bool1 = true;
          localStringBuilder.append(bool1);
          QLog.i("QFlutter.QFlutterDownloadManager", 1, localStringBuilder.toString());
          if ((bool2) && (bool3))
          {
            a(true, true, true);
            return;
          }
          if (g)
          {
            QLog.d("QFlutter.QFlutterDownloadManager", 1, "install, is downloading...");
            return;
          }
          g = true;
          d(paramQQAppInterface);
          c(paramQQAppInterface);
          return;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  private static void a(InstallCallback paramInstallCallback)
  {
    if (paramInstallCallback != null) {}
    try
    {
      if (!f.contains(paramInstallCallback)) {
        f.add(paramInstallCallback);
      }
    }
    finally {}
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("notifyResult, isSuccess: %s, engine=%s, app=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
      j = 0;
    }
    finally
    {
      for (;;)
      {
        int j;
        InstallCallback localInstallCallback;
        for (;;)
        {
          throw localObject;
        }
        j += 1;
      }
    }
    if (j < f.size())
    {
      localInstallCallback = (InstallCallback)f.get(j);
      if (paramBoolean1) {
        localInstallCallback.onResult(true, b(), paramBoolean2, paramBoolean3);
      } else {
        localInstallCallback.onResult(false, null, paramBoolean2, paramBoolean3);
      }
    }
    else
    {
      f.clear();
      g = false;
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(QFlutterEngineData.STR_RES_NAME);
    boolean bool2 = a(paramQQAppInterface);
    boolean bool1;
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.r()) && (d((QFlutterEngineData)paramQQAppInterface.h()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isEngineConfigReady : %s, isEngineInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    return bool1;
  }
  
  private static boolean a(EarlyHandler paramEarlyHandler)
  {
    if (paramEarlyHandler == null) {
      return false;
    }
    paramEarlyHandler = paramEarlyHandler.h();
    if (paramEarlyHandler == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "isEarlyDownloadConfigReady, data == null");
      return false;
    }
    if ((!TextUtils.isEmpty(paramEarlyHandler.strPkgName)) && (!TextUtils.isEmpty(paramEarlyHandler.strResURL_big))) {
      return true;
    }
    QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("isEarlyDownloadConfigReady, strPkgName: %s, strResURL_big: %s", new Object[] { paramEarlyHandler.strPkgName, paramEarlyHandler.strResURL_big }));
    return false;
  }
  
  public static boolean a(XmlData paramXmlData)
  {
    if (!d(paramXmlData))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkInstalledPackage check fail! pkg: ");
      localStringBuilder.append(paramXmlData.strPkgName);
      QLog.d("QFlutter.QFlutterDownloadManager", 1, localStringBuilder.toString());
      e(paramXmlData);
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, XmlData paramXmlData)
  {
    boolean bool1 = false;
    if (paramXmlData == null)
    {
      QLog.e("QFlutter.QFlutterDownloadManager", 1, "installPackage| data == null");
      return false;
    }
    try
    {
      boolean bool2 = a(paramXmlData);
      if (!bool2)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("installPackage| strPkgName: ");
        localStringBuilder1.append(paramXmlData.strPkgName);
        QLog.d("QFlutter.QFlutterDownloadManager", 1, localStringBuilder1.toString());
        FileUtils.uncompressZip(paramString, b(), false);
        bool2 = a(paramXmlData);
        bool1 = bool2;
      }
      else
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "installPackage| local check successful!");
        bool1 = bool2;
      }
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("installPackage fail: ");
      localStringBuilder3.append(paramString);
      QLog.e("QFlutter.QFlutterDownloadManager", 1, localStringBuilder3.toString(), localIOException);
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("installPackage| strPkgName: ");
    localStringBuilder2.append(paramXmlData.strPkgName);
    localStringBuilder2.append(", srcPath: ");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(", result: ");
    localStringBuilder2.append(bool1);
    QLog.d("QFlutter.QFlutterDownloadManager", 1, localStringBuilder2.toString());
    return bool1;
  }
  
  public static long b(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        long l = paramString.lastModified();
        return l;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFlutter.QFlutterDownloadManager", 2, paramString.getMessage(), paramString);
      }
    }
    return 0L;
  }
  
  public static String b()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qflutter");
    return localStringBuilder.toString();
  }
  
  public static void b(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearPackageVerifyInfoSp ");
    localStringBuilder.append(paramXmlData.strPkgName);
    QLog.d("QFlutter.QFlutterDownloadManager", 1, localStringBuilder.toString());
    c(paramXmlData).edit().clear().commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(QFlutterAppData.STR_RES_NAME);
    boolean bool2 = a(paramQQAppInterface);
    boolean bool1;
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.r()) && (d((QFlutterAppData)paramQQAppInterface.h()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isAppConfigReady: %s, isAppInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
    }
    return bool1;
  }
  
  public static SharedPreferences c(XmlData paramXmlData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramXmlData.getSharedPreferencesName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramXmlData.getStrResName());
    localStringBuilder.append("_verifyInfo");
    paramXmlData = localStringBuilder.toString();
    return BaseApplication.getContext().getSharedPreferences(paramXmlData, 4);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (!e)
    {
      i.a();
      paramQQAppInterface = paramQQAppInterface.getEarlyHandler(QFlutterAppData.STR_RES_NAME);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(true);
      }
    }
    else
    {
      i.a(true, true);
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IEarlyDownloadService)paramQQAppInterface.getRuntimeService(IEarlyDownloadService.class, "");
    if (!d)
    {
      h.a();
      paramQQAppInterface = paramQQAppInterface.getEarlyHandler(QFlutterEngineData.STR_RES_NAME);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(true);
      }
    }
    else
    {
      h.a(true, true);
    }
  }
  
  private static boolean d(XmlData paramXmlData)
  {
    boolean bool2 = paramXmlData instanceof FilesListHolder;
    boolean bool1 = false;
    if (!bool2)
    {
      QLog.e("QFlutter.QFlutterDownloadManager", 1, "download data is null or data is not a FilesListHolder!");
      return false;
    }
    long l1 = System.currentTimeMillis();
    String str1 = paramXmlData.strPkgName;
    SharedPreferences.Editor localEditor = c(paramXmlData).edit();
    Iterator localIterator = ((FilesListHolder)paramXmlData).filesValidateMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str2 = (String)((Map.Entry)localObject).getKey();
      String str3 = a(str2);
      if (!FileUtil.d(str3))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("[%s] checkFiles, %s is not exist", new Object[] { str1, str3 }));
        break label265;
      }
      String str4 = PortalUtils.a(str3);
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase(str4)))
      {
        l2 = b(str3);
        localEditor.putString(a(str2, true), (String)localObject);
        localEditor.putLong(a(str2, false), l2);
      }
      else
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("[%s] checkFiles, %s md5 check fail, md5: %s fileMD5: %s", new Object[] { str1, str3, localObject, str4 }));
        break label265;
      }
    }
    bool1 = true;
    label265:
    if (bool1) {
      localEditor.putString(paramXmlData.getStrResName(), paramXmlData.strPkgName).commit();
    }
    long l2 = System.currentTimeMillis();
    paramXmlData = new StringBuilder();
    paramXmlData.append("[");
    paramXmlData.append(str1);
    paramXmlData.append("] checkDownloadData... result: ");
    paramXmlData.append(bool1);
    paramXmlData.append(", ");
    paramXmlData.append(l2 - l1);
    paramXmlData.append("ms");
    QLog.d("QFlutter.QFlutterDownloadManager", 1, paramXmlData.toString());
    return bool1;
  }
  
  private static void e(XmlData paramXmlData)
  {
    if (!(paramXmlData instanceof FilesListHolder)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uninstallPackage... ");
    ((StringBuilder)localObject).append(paramXmlData.strPkgName);
    QLog.d("QFlutter.QFlutterDownloadManager", 1, ((StringBuilder)localObject).toString());
    localObject = c(paramXmlData).edit();
    String[] arrayOfString = ((FilesListHolder)paramXmlData).filesList();
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      ((SharedPreferences.Editor)localObject).putString(a(str, true), null);
      ((SharedPreferences.Editor)localObject).putLong(a(str, false), 0L);
      FileUtils.deleteFile(a(str));
      j += 1;
    }
    ((SharedPreferences.Editor)localObject).putString(paramXmlData.getStrResName(), null).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterInstaller
 * JD-Core Version:    0.7.0.1
 */