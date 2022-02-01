package com.tencent.mobileqq.flutter.download;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
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
  public static Handler a;
  private static QFlutterInstaller.DownloadStatus jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus = new QFlutterInstaller.DownloadStatus(null);
  private static String jdField_a_of_type_JavaLangString = "qq.android.flutter.engine.v8.5.5_v2";
  private static ArrayList<QFlutterInstaller.InstallCallback> jdField_a_of_type_JavaUtilArrayList;
  private static boolean jdField_a_of_type_Boolean;
  private static QFlutterInstaller.DownloadStatus jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus = new QFlutterInstaller.DownloadStatus(null);
  private static String jdField_b_of_type_JavaLangString = "qq.android.flutter.app.v8.5.5_v2";
  private static boolean jdField_b_of_type_Boolean;
  private static volatile boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    c = false;
  }
  
  public static long a(String paramString)
  {
    long l2 = 0L;
    try
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString.exists()) {
        l1 = paramString.lastModified();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        long l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.i("QFlutter.QFlutterDownloadManager", 2, paramString.getMessage(), paramString);
    }
    return l1;
    return 0L;
  }
  
  public static SharedPreferences a(XmlData paramXmlData)
  {
    paramXmlData = paramXmlData.getSharedPreferencesName() + "_" + paramXmlData.getStrResName() + "_verifyInfo";
    return BaseApplication.getContext().getSharedPreferences(paramXmlData, 4);
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString + ";" + jdField_b_of_type_JavaLangString;
  }
  
  public static String a(String paramString)
  {
    return new File(b(), paramString).getAbsolutePath();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramString + "_MD5";
    }
    return paramString + "_lastModifiedTs";
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        QFlutterReporter.a(paramBoolean, QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), "engine");
        jdField_a_of_type_Boolean = paramBoolean;
        jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a(paramBoolean, false);
        boolean bool1 = jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a();
        boolean bool2 = jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a();
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("onDownloadFinish, type: %s(%s), appFinished: %s, engineFinished: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        if ((bool1) && (bool2))
        {
          if ((!jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.jdField_a_of_type_Boolean) || (!jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.jdField_a_of_type_Boolean)) {
            break label237;
          }
          paramBoolean = true;
          long l = Math.max(QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus));
          a(paramBoolean, QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus));
          QFlutterReporter.a(paramBoolean, l, QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), "all");
        }
        return;
      }
      finally {}
      if (paramInt == 1)
      {
        QFlutterReporter.a(paramBoolean, QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), QFlutterInstaller.DownloadStatus.a(jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus), "app");
        jdField_b_of_type_Boolean = paramBoolean;
        jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a(paramBoolean, false);
        continue;
        label237:
        paramBoolean = false;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (!jdField_b_of_type_Boolean)
    {
      jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a();
      paramQQAppInterface = paramQQAppInterface.a("qq.android.flutter.app.v8.5.5_v2");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(true);
      }
      return;
    }
    jdField_b_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a(true, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QFlutterInstaller.InstallCallback paramInstallCallback)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        boolean bool2 = a(paramQQAppInterface);
        jdField_a_of_type_Boolean = bool2;
        boolean bool3 = b(paramQQAppInterface);
        jdField_b_of_type_Boolean = bool3;
        jdField_b_of_type_JavaLangString = XmlData.packageNameOf(paramQQAppInterface, "qq.android.flutter.app.v8.5.5_v2");
        jdField_a_of_type_JavaLangString = XmlData.packageNameOf(paramQQAppInterface, "qq.android.flutter.engine.v8.5.5_v2");
        QFlutterReporter.a(a());
        a(paramInstallCallback);
        StringBuilder localStringBuilder = new StringBuilder().append("install isEngineReady:").append(bool2).append(" isAppReady:").append(bool3).append(" installCallback:");
        if (paramInstallCallback != null)
        {
          QLog.i("QFlutter.QFlutterDownloadManager", 1, bool1);
          if ((bool2) && (bool3)) {
            a(true, true, true);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        if (c)
        {
          QLog.d("QFlutter.QFlutterDownloadManager", 1, "install, is downloading...");
          continue;
        }
        c = true;
      }
      finally {}
      b(paramQQAppInterface);
      a(paramQQAppInterface);
    }
  }
  
  public static void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    QLog.d("QFlutter.QFlutterDownloadManager", 1, "clearPackageVerifyInfoSp " + paramXmlData.strPkgName);
    a(paramXmlData).edit().clear().commit();
  }
  
  private static void a(QFlutterInstaller.InstallCallback paramInstallCallback)
  {
    if (paramInstallCallback != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramInstallCallback)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramInstallCallback);
      }
      return;
    }
    finally
    {
      paramInstallCallback = finally;
      throw paramInstallCallback;
    }
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      int i;
      try
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("notifyResult, isSuccess: %s, engine=%s, app=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
        i = 0;
        if (i < jdField_a_of_type_JavaUtilArrayList.size())
        {
          QFlutterInstaller.InstallCallback localInstallCallback = (QFlutterInstaller.InstallCallback)jdField_a_of_type_JavaUtilArrayList.get(i);
          if (paramBoolean1) {
            localInstallCallback.a(true, b(), paramBoolean2, paramBoolean3);
          } else {
            localInstallCallback.a(false, null, paramBoolean2, paramBoolean3);
          }
        }
      }
      finally {}
      jdField_a_of_type_JavaUtilArrayList.clear();
      c = false;
      return;
      i += 1;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.flutter.engine.v8.5.5_v2");
    boolean bool2 = a(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (b((QFlutterEngineData)paramQQAppInterface.a()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isEngineConfigReady : %s, isEngineInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
  
  private static boolean a(EarlyHandler paramEarlyHandler)
  {
    if (paramEarlyHandler == null) {
      return false;
    }
    paramEarlyHandler = paramEarlyHandler.a();
    if (paramEarlyHandler == null)
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "isEarlyDownloadConfigReady, data == null");
      return false;
    }
    if ((TextUtils.isEmpty(paramEarlyHandler.strPkgName)) || (TextUtils.isEmpty(paramEarlyHandler.strResURL_big)))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("isEarlyDownloadConfigReady, strPkgName: %s, strResURL_big: %s", new Object[] { paramEarlyHandler.strPkgName, paramEarlyHandler.strResURL_big }));
      return false;
    }
    return true;
  }
  
  public static boolean a(XmlData paramXmlData)
  {
    boolean bool = true;
    if (!b(paramXmlData))
    {
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "checkInstalledPackage check fail! pkg: " + paramXmlData.strPkgName);
      b(paramXmlData);
      bool = false;
    }
    return bool;
  }
  
  public static boolean a(String paramString, XmlData paramXmlData)
  {
    if (paramXmlData == null)
    {
      QLog.e("QFlutter.QFlutterDownloadManager", 1, "installPackage| data == null");
      return false;
    }
    for (;;)
    {
      try
      {
        bool = a(paramXmlData);
        if (bool) {
          continue;
        }
        QLog.d("QFlutter.QFlutterDownloadManager", 1, "installPackage| strPkgName: " + paramXmlData.strPkgName);
        FileUtils.a(paramString, b(), false);
        bool = a(paramXmlData);
      }
      catch (IOException localIOException)
      {
        QLog.e("QFlutter.QFlutterDownloadManager", 1, "installPackage fail: " + paramString, localIOException);
        boolean bool = false;
        continue;
      }
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "installPackage| strPkgName: " + paramXmlData.strPkgName + ", srcPath: " + paramString + ", result: " + bool);
      return bool;
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "installPackage| local check successful!");
    }
  }
  
  public static String b()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    return localFile.getAbsolutePath() + File.separator + "qflutter";
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER);
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a();
      paramQQAppInterface = paramQQAppInterface.a("qq.android.flutter.engine.v8.5.5_v2");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(true);
      }
      return;
    }
    jdField_a_of_type_ComTencentMobileqqFlutterDownloadQFlutterInstaller$DownloadStatus.a(true, true);
  }
  
  private static void b(XmlData paramXmlData)
  {
    if (!(paramXmlData instanceof FilesListHolder)) {
      return;
    }
    QLog.d("QFlutter.QFlutterDownloadManager", 1, "uninstallPackage... " + paramXmlData.strPkgName);
    SharedPreferences.Editor localEditor = a(paramXmlData).edit();
    String[] arrayOfString = ((FilesListHolder)paramXmlData).filesList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localEditor.putString(a(str, true), null);
      localEditor.putLong(a(str, false), 0L);
      FileUtils.e(a(str));
      i += 1;
    }
    localEditor.putString(paramXmlData.getStrResName(), null).commit();
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = ((EarlyDownloadManager)paramQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a("qq.android.flutter.app.v8.5.5_v2");
    boolean bool2 = a(paramQQAppInterface);
    if ((!bool2) && (paramQQAppInterface != null) && (paramQQAppInterface.g()) && (b((QFlutterAppData)paramQQAppInterface.a()))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloadManager", 2, String.format("isAppConfigReady: %s, isAppInstalled: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
    }
  }
  
  private static boolean b(XmlData paramXmlData)
  {
    if (!(paramXmlData instanceof FilesListHolder))
    {
      QLog.e("QFlutter.QFlutterDownloadManager", 1, "download data is null or data is not a FilesListHolder!");
      return false;
    }
    long l1 = System.currentTimeMillis();
    String str1 = paramXmlData.strPkgName;
    SharedPreferences.Editor localEditor = a(paramXmlData).edit();
    Iterator localIterator = ((FilesListHolder)paramXmlData).filesValidateMap().entrySet().iterator();
    Object localObject;
    String str2;
    String str3;
    boolean bool;
    if (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      str2 = (String)((Map.Entry)localObject).getKey();
      str3 = a(str2);
      if (!FileUtil.a(str3))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("[%s] checkFiles, %s is not exist", new Object[] { str1, str3 }));
        bool = false;
      }
    }
    for (;;)
    {
      localEditor.putString(paramXmlData.getStrResName(), paramXmlData.strPkgName).commit();
      long l2 = System.currentTimeMillis();
      QLog.d("QFlutter.QFlutterDownloadManager", 1, "[" + str1 + "] checkDownloadData... result: " + bool + ", " + (l2 - l1) + "ms");
      return bool;
      String str4 = PortalUtils.a(str3);
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase(str4)))
      {
        QLog.d("QFlutter.QFlutterDownloadManager", 1, String.format("[%s] checkFiles, %s md5 check fail, md5: %s fileMD5: %s", new Object[] { str1, str3, localObject, str4 }));
        bool = false;
      }
      else
      {
        l2 = a(str3);
        localEditor.putString(a(str2, true), (String)localObject);
        localEditor.putLong(a(str2, false), l2);
        break;
        bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterInstaller
 * JD-Core Version:    0.7.0.1
 */