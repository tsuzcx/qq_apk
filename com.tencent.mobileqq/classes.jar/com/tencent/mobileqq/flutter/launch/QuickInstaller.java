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
    boolean bool3 = true;
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new QFlutterEngineData();
    String str = QFlutterInstaller.a((XmlData)localObject1).getString(((QFlutterEngineData)localObject1).getStrResName(), "(null)");
    boolean bool4 = a((XmlData)localObject1);
    localObject1 = "(null)";
    Object localObject2;
    if (bool4)
    {
      localObject2 = new QFlutterAppData();
      localObject1 = QFlutterInstaller.a((XmlData)localObject2).getString(((QFlutterAppData)localObject2).getStrResName(), "(null)");
    }
    for (boolean bool1 = a((XmlData)localObject2);; bool1 = false)
    {
      localObject2 = new Bundle();
      boolean bool2;
      if ((bool4) && (bool1))
      {
        bool2 = true;
        ((Bundle)localObject2).putBoolean("KEY_INSTALL_RESULT", bool2);
        ((Bundle)localObject2).putString("KEY_INSTALL_DIR", QFlutterInstaller.b());
        ((Bundle)localObject2).putBoolean("KEY_IS_APP_EXIST", bool1);
        ((Bundle)localObject2).putBoolean("KEY_IS_ENGINE_EXIST", bool4);
        ((Bundle)localObject2).putString("KEY_QFLUTTER_VERSION", str + ";" + (String)localObject1);
        ((Bundle)localObject2).putBoolean("KEY_FROM_QUICK_INSTALL", true);
        QLog.d("QFlutter.QuickInstaller", 1, String.format("doQuickInstall exist=[%b,%b] version=[%s,%s] cost=%d", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), str, localObject1, Long.valueOf(SystemClock.uptimeMillis() - l) }));
        localObject1 = this.a;
        if (localObject1 != null) {
          if ((!bool4) || (!bool1)) {
            break label272;
          }
        }
      }
      label272:
      for (bool1 = bool3;; bool1 = false)
      {
        ((QuickInstaller.OnQuickInstallResult)localObject1).a(bool1, (Bundle)localObject2);
        return;
        bool2 = false;
        break;
      }
    }
  }
  
  private boolean a(XmlData paramXmlData)
  {
    if (!(paramXmlData instanceof FilesListHolder))
    {
      QLog.e("QFlutter.QuickInstaller", 1, "checkPackageValid data is null or data is not a FilesListHolder!");
      return false;
    }
    String str1 = paramXmlData.getStrResName();
    String[] arrayOfString = ((FilesListHolder)paramXmlData).filesList();
    paramXmlData = QFlutterInstaller.a(paramXmlData);
    SharedPreferences.Editor localEditor = paramXmlData.edit();
    boolean bool2 = true;
    int j = arrayOfString.length;
    int i = 0;
    boolean bool1 = bool2;
    String str2;
    String str3;
    if (i < j)
    {
      str2 = arrayOfString[i];
      str3 = QFlutterInstaller.a(str2);
      if (!FileUtil.a(str3))
      {
        bool1 = false;
        QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid [%s] %s is not exist", new Object[] { str1, str3 }));
      }
    }
    else
    {
      label114:
      localEditor.commit();
      return bool1;
    }
    String str6 = QFlutterInstaller.a(str2, true);
    String str4 = QFlutterInstaller.a(str2, false);
    long l1 = paramXmlData.getLong(str4, 0L);
    long l2 = QFlutterInstaller.a(str3);
    if ((l1 > 0L) && (l1 == l2)) {
      QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid lastModifiedTs suc [%s], ts=%s path = %s", new Object[] { str2, TimeFormatterUtils.b(l2), str3 }));
    }
    for (;;)
    {
      i += 1;
      break;
      String str5 = PortalUtils.a(str3);
      str6 = paramXmlData.getString(str6, "");
      if ((TextUtils.isEmpty(str6)) || (!str6.equalsIgnoreCase(str5)))
      {
        bool1 = false;
        QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid md5 fail [%s] %s md5Sp: %s fileMD5: %s", new Object[] { str1, str3, str6, str5 }));
        break label114;
      }
      localEditor.putLong(str4, l2);
      QLog.d("QFlutter.QuickInstaller", 1, String.format("checkPackageValid md5 ok [%s], path = %s", new Object[] { str2, str3 }));
    }
  }
  
  public void a(QuickInstaller.OnQuickInstallResult paramOnQuickInstallResult)
  {
    this.a = paramOnQuickInstallResult;
    ThreadManager.postImmediately(new QuickInstaller.1(this), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.QuickInstaller
 * JD-Core Version:    0.7.0.1
 */