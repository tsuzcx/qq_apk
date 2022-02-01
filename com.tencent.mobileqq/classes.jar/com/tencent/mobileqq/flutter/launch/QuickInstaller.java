package com.tencent.mobileqq.flutter.launch;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.FilesListHolder;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

class QuickInstaller
{
  QuickInstaller.OnQuickInstallResult a = null;
  
  private void a()
  {
    long l = SystemClock.uptimeMillis();
    Object localObject3 = new QFlutterEngineData();
    Object localObject2 = QFlutterInstaller.c((XmlData)localObject3);
    Object localObject4 = ((QFlutterEngineData)localObject3).getStrResName();
    Object localObject1 = "(null)";
    localObject2 = ((SharedPreferences)localObject2).getString((String)localObject4, "(null)");
    boolean bool4 = a((XmlData)localObject3);
    boolean bool3 = false;
    boolean bool1;
    if (bool4)
    {
      localObject3 = new QFlutterAppData();
      localObject1 = QFlutterInstaller.c((XmlData)localObject3).getString(((QFlutterAppData)localObject3).getStrResName(), "(null)");
      bool1 = a((XmlData)localObject3);
    }
    else
    {
      bool1 = false;
    }
    localObject3 = new Bundle();
    boolean bool2;
    if ((bool4) && (bool1)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((Bundle)localObject3).putBoolean("KEY_INSTALL_RESULT", bool2);
    ((Bundle)localObject3).putString("KEY_INSTALL_DIR", QFlutterInstaller.b());
    ((Bundle)localObject3).putBoolean("KEY_IS_APP_EXIST", bool1);
    ((Bundle)localObject3).putBoolean("KEY_IS_ENGINE_EXIST", bool4);
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append(";");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((Bundle)localObject3).putString("KEY_QFLUTTER_VERSION", ((StringBuilder)localObject4).toString());
    ((Bundle)localObject3).putBoolean("KEY_FROM_QUICK_INSTALL", true);
    QLog.d("QFlutter.QuickInstaller", 1, String.format("doQuickInstall exist=[%b,%b] version=[%s,%s] cost=%d", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), localObject2, localObject1, Long.valueOf(SystemClock.uptimeMillis() - l) }));
    localObject1 = this.a;
    if (localObject1 != null)
    {
      bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool1) {
          bool2 = true;
        }
      }
      ((QuickInstaller.OnQuickInstallResult)localObject1).a(bool2, (Bundle)localObject3);
    }
  }
  
  private boolean a(XmlData paramXmlData)
  {
    boolean bool2 = paramXmlData instanceof FilesListHolder;
    boolean bool1 = false;
    if (!bool2)
    {
      QLog.e("QFlutter.QuickInstaller", 1, "checkPackageValid data is null or data is not a FilesListHolder!");
      return false;
    }
    String str1 = paramXmlData.getStrResName();
    String[] arrayOfString = ((FilesListHolder)paramXmlData).filesList();
    paramXmlData = QFlutterInstaller.c(paramXmlData);
    SharedPreferences.Editor localEditor = paramXmlData.edit();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      String str3 = QFlutterInstaller.a(str2);
      if (!FileUtil.d(str3))
      {
        QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid [%s] %s is not exist", new Object[] { str1, str3 }));
        break label324;
      }
      String str6 = QFlutterInstaller.a(str2, true);
      String str4 = QFlutterInstaller.a(str2, false);
      long l1 = paramXmlData.getLong(str4, 0L);
      long l2 = QFlutterInstaller.b(str3);
      String str5;
      if ((l1 > 0L) && (l1 == l2))
      {
        QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid lastModifiedTs suc [%s], ts=%s path = %s", new Object[] { str2, TimeFormatterUtils.f(l2), str3 }));
      }
      else
      {
        str5 = PortalUtils.a(str3);
        str6 = paramXmlData.getString(str6, "");
        if ((TextUtils.isEmpty(str6)) || (!str6.equalsIgnoreCase(str5))) {
          break label283;
        }
        localEditor.putLong(str4, l2);
        QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid md5 ok [%s], path = %s", new Object[] { str2, str3 }));
      }
      i += 1;
      continue;
      label283:
      QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid md5 fail [%s] %s md5Sp: %s fileMD5: %s", new Object[] { str1, str3, str6, str5 }));
      break label324;
    }
    bool1 = true;
    label324:
    localEditor.commit();
    return bool1;
  }
  
  public void a(QuickInstaller.OnQuickInstallResult paramOnQuickInstallResult)
  {
    this.a = paramOnQuickInstallResult;
    ThreadManager.postImmediately(new QuickInstaller.1(this), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QuickInstaller
 * JD-Core Version:    0.7.0.1
 */