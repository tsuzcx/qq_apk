package com.tencent.mobileqq.theme;

import aioc;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class ThemeDownloader
{
  public long a;
  public Bundle a;
  public Handler a;
  public ThemeDownloader.ThemeDownloadListener a;
  ThemeDownloader.ThemeUnzipListener jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener;
  ThemeUtil.ThemeInfo jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo;
  public VasQuickUpdateManager.CallBacker a;
  String jdField_a_of_type_JavaLangString;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public long b;
  public String b;
  
  public ThemeDownloader(AppRuntime paramAppRuntime, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aioc(this);
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      QLog.e("ThemeDownloader", 1, "ThemeDownloader app == null!!");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if ("1000".equals(paramString1)) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      if (paramInt < 1)
      {
        QLog.e("ThemeDownloader", 1, "isThemeFilesExist Error inFileNum=" + paramInt + ", themeId:" + paramString1 + ",version:" + paramString2 + ", fileNum:" + paramInt + ",from:" + paramString3);
        return false;
      }
      if (paramContext == null)
      {
        QLog.e("ThemeDownloader", 1, "isThemeFilesExist Error null == context,themeId:" + paramString1 + ",version:" + paramString2 + ", fileNum:" + paramInt + ",from:" + paramString3);
        return false;
      }
      paramContext = ThemeUtil.getThemeResourcePath(paramContext, paramString1, paramString2);
      if (TextUtils.isEmpty(paramContext))
      {
        QLog.e("ThemeDownloader", 1, "isThemeFilesExist Error ,themeId:" + paramString1 + ",version:" + paramString2 + ", fileNum:" + paramInt + ",from:" + paramString3);
        return false;
      }
      paramContext = new File(paramContext);
      bool1 = bool2;
      if (paramContext.exists())
      {
        bool1 = bool2;
        if (paramContext.isDirectory())
        {
          int i = ThemeUtil.getFileNumInFile(paramContext);
          bool2 = bool3;
          if (i > 0)
          {
            bool2 = bool3;
            if (i >= paramInt) {
              bool2 = true;
            }
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ThemeDownloader", 1, "isThemeFilesExist,themeId:" + paramString1 + ",version:" + paramString2 + ", inFileNum:" + paramInt + ",from:" + paramString3 + ", ret=" + bool2);
            bool1 = bool2;
          }
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDownloader", 1, "isThemeFilesExist return false ,themeId:" + paramString1 + ",version:" + paramString2 + ", themeInfo.fileNum:" + paramInt + ",from:" + paramString3 + ", ret=" + bool1);
    return bool1;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (("1000".equals(paramString1)) || ("999".equals(paramString1))) {}
    do
    {
      return true;
      paramContext = new File(ThemeUtil.getThemeDownloadFilePath(paramContext, paramString1, paramString2));
      if ((!paramContext.exists()) || (!paramContext.isFile())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "themeZipFile exists:" + paramString1 + ", version:" + paramString2 + ", from:" + paramString3 + ", lenth:" + paramContext.length());
      }
      if (paramContext.length() <= 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDownloader", 2, "themeZipFile themeid:" + paramString1 + ", version:" + paramString2 + ", Filesize:" + paramContext.length() + " already exists.from:" + paramString3);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloader", 2, "themeZipFile themeid:" + paramString1 + ", version:" + paramString2 + ", size" + paramLong + " not exists.from:" + paramString3);
    }
    return false;
  }
  
  public int a(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeDownloadListener paramThemeDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = paramThemeDownloadListener;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if ((paramContext == null) || (paramBundle == null))
    {
      paramThemeDownloadListener = new StringBuilder().append("downloadTheme input data Error1:");
      if (paramContext == null)
      {
        bool = true;
        paramContext = paramThemeDownloadListener.append(bool);
        if (paramBundle != null) {
          break label125;
        }
      }
      label125:
      for (bool = true;; bool = false)
      {
        QLog.e("ThemeDownloader", 1, bool + ", from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -8, 0, 0);
        ThemeReporter.a(this.jdField_a_of_type_MqqAppAppRuntime, "theme_detail", this.jdField_a_of_type_JavaLangString, 153, -1, -8, "", "", ThemeReporter.jdField_a_of_type_JavaLangString, "0");
        return -8;
        bool = false;
        break;
      }
    }
    paramThemeDownloadListener = paramBundle.getString("url");
    String str1 = paramBundle.getString("themeId");
    String str2 = paramBundle.getString("version");
    long l1 = paramBundle.getLong("size", 0L);
    boolean bool = paramBundle.getBoolean("isVoiceTheme", false);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloader", 2, "downloadTheme themeId=" + str1 + ",ver=" + str2 + ",size=" + l1 + ",isSound=" + bool + ", url=" + paramThemeDownloadListener + ", from:" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(str1))
    {
      QLog.e("ThemeDownloader", 1, "downloadTheme input data Error2: id == null, from:" + this.jdField_a_of_type_JavaLangString);
      a(paramBundle, -8, 0, 0);
      ThemeReporter.a(this.jdField_a_of_type_MqqAppAppRuntime, "theme_detail", this.jdField_a_of_type_JavaLangString, 153, -1, -8, "", "", ThemeReporter.jdField_a_of_type_JavaLangString, "1");
      return -8;
    }
    ThemeReporter.a(this.jdField_a_of_type_MqqAppAppRuntime, "theme_detail", this.jdField_a_of_type_JavaLangString, 153, -1, 7, str1, str2, ThemeReporter.jdField_a_of_type_JavaLangString, "");
    int i = 0;
    paramThemeDownloadListener = ThemeUtil.getThemeInfo(paramContext, str1);
    int k;
    label441:
    int j;
    if (paramThemeDownloadListener == null)
    {
      i = 1;
      paramThemeDownloadListener = new ThemeUtil.ThemeInfo();
      paramThemeDownloadListener.themeId = str1;
      paramThemeDownloadListener.version = str2;
      bool = a(paramContext, str1, paramThemeDownloadListener.version, paramThemeDownloadListener.fileNum, "207");
      if ((!"999".equals(str1)) && (!a(paramContext, str1, "20000000", 0L, "ThemeDownloader.downloadTheme"))) {
        break label657;
      }
      k = 1;
      if ((!bool) || (k == 0)) {
        break label1345;
      }
      j = 0;
    }
    label657:
    label663:
    label673:
    label1334:
    try
    {
      int m = Integer.parseInt(paramThemeDownloadListener.version);
      j = m;
    }
    catch (Exception localException)
    {
      label467:
      break label467;
    }
    if (j < paramThemeDownloadListener.zipVer)
    {
      str2 = String.valueOf(paramThemeDownloadListener.zipVer);
      paramThemeDownloadListener.version = str2;
      paramBundle.putString("version", str2);
      j = 1;
      bool = false;
    }
    for (;;)
    {
      i = j;
      if (k != 0)
      {
        i = j;
        if (paramThemeDownloadListener.zipVer < 200) {
          if (!"999".equals(str1)) {
            break label663;
          }
        }
      }
      for (paramThemeDownloadListener.zipVer = 20000000;; paramThemeDownloadListener.zipVer = 200)
      {
        i = 1;
        j = i;
        if (k == 0)
        {
          j = i;
          if (paramThemeDownloadListener.zipVer > 0)
          {
            paramThemeDownloadListener.zipVer = 0;
            j = 1;
          }
        }
        if (!bool) {
          break label673;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme isFileExists=true , from:" + this.jdField_a_of_type_JavaLangString);
        }
        if (j != 0)
        {
          paramThemeDownloadListener.status = "5";
          ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
        }
        a(paramBundle, 3, 0, 0);
        return 3;
        paramBundle.putString("version", paramThemeDownloadListener.version);
        break;
        k = 0;
        break label441;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "downloadTheme isFileExists=false , from:" + this.jdField_a_of_type_JavaLangString);
      }
      if (k != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme isZipExist=true , from:" + this.jdField_a_of_type_JavaLangString);
        }
        if (j != 0)
        {
          paramThemeDownloadListener.status = "3";
          ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
        }
        a(paramBundle, 2, 0, 0);
        return 2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "downloadTheme isThemeZipExist=false , from:" + this.jdField_a_of_type_JavaLangString);
      }
      if (!Utils.a())
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme haveSDCard not available., from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -11, 0, 0);
        return -11;
      }
      bool = VipFunCallManager.a(paramContext, "ThemeDownloader", false);
      if ((QLog.isColorLevel()) || (!bool)) {
        QLog.d("ThemeDownloader", 2, "downloadTheme Err haveSDCard:" + bool + ", from:" + this.jdField_a_of_type_JavaLangString);
      }
      long l2 = Utils.b();
      if (l2 < 5242880 + l1)
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme Insufficient SDCard space, required:" + l1 + "| reserved:" + 5242880 + "|available:" + l2 + " from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -12, 0, 0);
        return -12;
      }
      if (!NetworkUtil.d(paramContext))
      {
        QLog.e("ThemeDownloader", 1, "downloadTheme I No network access., from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -13, 0, 0);
        return -13;
      }
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = paramThemeDownloadListener;
      this.jdField_a_of_type_AndroidOsBundle.putInt("srcType", 4);
      i = paramBundle.getInt("net_type", 2);
      k = NetworkUtil.a(paramContext);
      switch (i)
      {
      default: 
        if (j != 0) {
          ThemeUtil.setThemeInfo(paramContext, paramThemeDownloadListener);
        }
        this.b = ThemeUtil.getThemeConfigID(str1);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramContext = VasQuickUpdateManager.a(this.jdField_a_of_type_MqqAppAppRuntime, 3L, this.b, ThemeUtil.getThemeDownloadFilePath(paramContext, str1, "20000000"), true, this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder().append("downloadTheme start, from:").append(this.jdField_a_of_type_JavaLangString).append(",zipFile=");
          if (paramContext != null) {
            break label1334;
          }
        }
        break;
      }
      for (bool = true;; bool = false)
      {
        QLog.d("ThemeDownloader", 2, bool);
        return 4;
        if (2 != k) {
          break;
        }
        a(paramBundle, -41, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme NET_TYPE_WITHOUT_G2 return net not match, from:" + this.jdField_a_of_type_JavaLangString);
        }
        return -41;
        if (1 == k) {
          break;
        }
        a(paramBundle, -41, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "downloadTheme NET_TYPE_ONLY_WIFI return net not match, from:" + this.jdField_a_of_type_JavaLangString);
        }
        return -41;
      }
      label1345:
      j = i;
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof BrowserAppInterface))) {
      ((VasQuickUpdateManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    }
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeUtil$ThemeInfo = null;
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  void a(Bundle paramBundle, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener.onUnzipCallback(paramBundle, paramInt, this);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "unzipCallback stateCode:" + paramInt + ", from:" + this.jdField_a_of_type_JavaLangString);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ThemeDownloader", 2, "ThemeDownloader unzipCallback outSideListener == null;");
  }
  
  public void a(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener.onDownloadCallback(paramBundle, paramInt1, paramInt2, paramInt3, this);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "onDownCallback stateCode:" + paramInt1 + ", from:" + this.jdField_a_of_type_JavaLangString);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ThemeDownloader", 2, "ThemeDownloader onDownCallback outSideListener == null;");
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeDownloadListener paramThemeDownloadListener)
  {
    paramThemeDownloadListener = paramBundle;
    if (paramBundle == null) {
      paramThemeDownloadListener = this.jdField_a_of_type_AndroidOsBundle;
    }
    if ((paramContext == null) || (paramThemeDownloadListener == null))
    {
      paramBundle = new StringBuilder().append("stopDownladTheme input data Error1:");
      if (paramContext != null) {
        break label71;
      }
      bool = true;
      paramContext = paramBundle.append(bool);
      if (paramThemeDownloadListener != null) {
        break label77;
      }
    }
    label71:
    label77:
    for (boolean bool = true;; bool = false)
    {
      QLog.e("ThemeDownloader", 1, bool);
      return false;
      bool = false;
      break;
    }
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, ThemeDownloader.ThemeUnzipListener paramThemeUnzipListener)
  {
    boolean bool1;
    label53:
    Object localObject;
    String str1;
    long l;
    boolean bool2;
    label239:
    String str2;
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeUnzipListener = paramThemeUnzipListener;
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if ((paramContext == null) || (paramBundle == null))
      {
        paramThemeUnzipListener = new StringBuilder().append("ThemeDownloader.unzipTheme input data Error1:");
        if (paramContext != null) {
          break label1465;
        }
        bool1 = true;
        paramContext = paramThemeUnzipListener.append(bool1);
        if (paramBundle != null) {
          break label1471;
        }
        bool1 = true;
        QLog.e("ThemeDownloader", 1, bool1 + ",from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -8);
        return false;
      }
      localObject = paramBundle.getString("url");
      str1 = paramBundle.getString("themeId");
      paramThemeUnzipListener = paramBundle.getString("version");
      l = paramBundle.getLong("size", 0L);
      bool2 = paramBundle.getBoolean("isVoiceTheme", false);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 2, "ThemeDownloader.unzipTheme 0 themeId=" + str1 + ",ver=" + paramThemeUnzipListener + ",size=" + l + ",isSound=" + bool2 + ", url=" + (String)localObject + ", from:" + this.jdField_a_of_type_JavaLangString);
      }
      paramThemeUnzipListener = ThemeUtil.getThemeInfo(paramContext, str1);
      if (paramThemeUnzipListener != null) {
        break label1462;
      }
      paramThemeUnzipListener = new ThemeUtil.ThemeInfo();
      paramThemeUnzipListener.themeId = str1;
      if (paramThemeUnzipListener.zipVer < 200) {
        if (!"999".equals(str1)) {
          break label443;
        }
      }
      label443:
      for (paramThemeUnzipListener.zipVer = 20000000;; paramThemeUnzipListener.zipVer = 200)
      {
        str2 = String.valueOf(paramThemeUnzipListener.zipVer);
        paramBundle.putString("version", str2);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "ThemeDownloader.unzipTheme themeId=" + str1 + ",ver=" + str2 + ",size=" + l + ",isSound=" + bool2 + ", url=" + (String)localObject + ",from:" + this.jdField_a_of_type_JavaLangString);
        }
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          break;
        }
        QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme input data Error2:" + TextUtils.isEmpty(str1) + TextUtils.isEmpty(str2) + ",from:" + this.jdField_a_of_type_JavaLangString);
        a(paramBundle, -8);
        return false;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QLog.e("ThemeDownloader", 1, "unzipTheme", paramContext);
    }
    label464:
    if ("1000".equals(str1))
    {
      QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme input data Error3: ThemeUtil.DEFAULT_THEME_ID,from:" + this.jdField_a_of_type_JavaLangString);
      a(paramBundle, 1);
      return true;
    }
    String str3 = ThemeUtil.getThemeDownloadFilePath(paramContext, str1, "20000000");
    String str4 = ThemeUtil.getThemeResourcePath(paramContext, str1, str2);
    label549:
    int m;
    int i;
    int k;
    int j;
    if (str3 != null)
    {
      localObject = new File(str3);
      m = 0;
      i = 0;
      k = 0;
      if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile()) && (((File)localObject).length() > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 2, "ThemeDownloader.unzipTheme themeZipFile.exists(), themeZipFile.length()=" + ((File)localObject).length());
        }
        j = m;
      }
    }
    else
    {
      try
      {
        com.tencent.mobileqq.utils.FileUtils.a(str3, str4, false);
        j = m;
        localObject = new File(str4);
        j = m;
        if (((File)localObject).exists())
        {
          j = m;
          i = ThemeUtil.getFileNumInFile((File)localObject);
        }
        if (i <= 0) {
          break label1145;
        }
        j = 1;
        label683:
        k = j;
        j = i;
        i = k;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          File localFile;
          label759:
          QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme FileUtils.uncompressZip IOException:" + localIOException.getMessage());
          label817:
          i = 0;
        }
      }
      if (i != 0) {
        break label1456;
      }
      localObject = new File(str4);
      localFile = new File(str3);
      QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme DownloaderFactory.unzipResource, themeZipPath:" + str3);
      bool1 = DownloaderFactory.a(localFile, (File)localObject, false);
      if ((i != 0) || (bool1)) {
        break label1441;
      }
      com.tencent.mobileqq.utils.FileUtils.d(str3);
      QLog.e("ThemeDownloader", 1, "Theme.ThemeHandler  DownloaderFactory.unzipResource error, themeResPath" + str4);
      k = i;
      i = j;
      j = k;
      break label1477;
      localObject = new File(str4);
      if (!((File)localObject).exists()) {
        break label1307;
      }
      j = i;
      if (i <= 0) {
        j = ThemeUtil.getFileNumInFile((File)localObject);
      }
      k = j;
      if (j > 0) {
        break label1494;
      }
      QLog.e("ThemeDownloader", 1, "ThemeDownloader.unZipRet fileNum == 0 ,from:" + this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (j > 0)
      {
        paramThemeUnzipListener.status = "5";
        paramThemeUnzipListener.fileNum = j;
        paramThemeUnzipListener.downsize = l;
        paramThemeUnzipListener.size = l;
        paramThemeUnzipListener.themeId = str1;
        paramThemeUnzipListener.version = str2;
        paramThemeUnzipListener.isVoiceTheme = bool2;
        l = System.currentTimeMillis();
        bool1 = ThemeUtil.setThemeInfo(paramContext, paramThemeUnzipListener).booleanValue();
        ThemeReporter.a(null, "theme_sp_speed", "204", 153, -1, 1, String.valueOf(System.currentTimeMillis() - l), "6656", "write", "");
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme ok, saveThemeInfo:" + bool1 + ", fileNum:" + j + ", themeZipPath:" + str3 + ",from:" + this.jdField_a_of_type_JavaLangString);
        }
        if (!bool1) {
          QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme error, saveThemeInfo:" + bool1 + ", fileNum:" + j + ", themeZipPath:" + str3);
        }
        a(paramBundle, 1);
        ThemeReporter.a(this.jdField_a_of_type_MqqAppAppRuntime, "theme_detail", "201", 153, 1, 9, str1, str2, ThemeReporter.jdField_a_of_type_JavaLangString, "");
        return true;
        localObject = null;
        break label549;
        label1145:
        j = i;
        QLog.e("ThemeDownloader", 1, "ThemeDownloader.unzipTheme fileNum == 0 ,from:" + this.jdField_a_of_type_JavaLangString);
        j = k;
        break label683;
        if ("999".equals(str1))
        {
          l = 10L;
          com.tencent.open.base.FileUtils.a(paramContext, "999_540", str4);
          QLog.d("ThemeDownloader", 1, "ThemeDownloader themeZip id is DIY_THEME_ID");
          bool1 = true;
          i = 0;
          j = 1;
          break label1477;
        }
        QLog.e("ThemeDownloader", 1, "ThemeDownloader themeZip not exist themeZipPath=" + str3);
        bool1 = false;
        i = 0;
        j = 0;
        break label1477;
        label1307:
        QLog.e("ThemeDownloader", 1, "Theme.ThemeHandler error, unZipRet error, themeZipPath:" + str3);
        com.tencent.mobileqq.utils.FileUtils.d(str3);
        k = i;
        break label1494;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloader", 1, "ThemeDownloader.unzipTheme false fileNum:" + j + ", themeZipPath:" + str3 + ",from:" + this.jdField_a_of_type_JavaLangString);
      }
      ThemeReporter.a(this.jdField_a_of_type_MqqAppAppRuntime, "theme_detail", "201", 154, 1, 135, str1, str2, ThemeReporter.jdField_a_of_type_JavaLangString, "");
      a(paramBundle, -30);
      break label464;
      label1441:
      k = i;
      i = j;
      j = k;
      break label1477;
      label1456:
      bool1 = false;
      break label759;
      label1462:
      break label239;
      label1465:
      bool1 = false;
      break;
      label1471:
      bool1 = false;
      break label53;
      label1477:
      if (j != 0) {
        break label817;
      }
      k = i;
      if (bool1) {
        break label817;
      }
      label1494:
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeDownloader
 * JD-Core Version:    0.7.0.1
 */