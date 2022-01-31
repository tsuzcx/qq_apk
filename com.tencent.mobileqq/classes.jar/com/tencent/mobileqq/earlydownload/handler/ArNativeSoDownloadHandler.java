package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.ArNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ArNativeSoDownloadHandler
  extends EarlyHandler
{
  public ArNativeSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.native.so_v7.6.5.1", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10024;
  }
  
  public Class a()
  {
    return ArNativeSoData.class;
  }
  
  public String a()
  {
    return "ArConfig_NativeSoDownloadHandler";
  }
  
  public void a(XmlData paramXmlData)
  {
    int i = 0;
    try
    {
      Object localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("ArNativeSoDownloadHandler", 4);
      if (((SharedPreferences)localObject1).getBoolean("qq.android.ar.native.so_v7.6.5.1", true))
      {
        ((SharedPreferences)localObject1).edit().putBoolean("qq.android.ar.native.so_v7.6.5.1", false).commit();
        localObject1 = new File(ArNativeSoLoader.a() + File.separator).listFiles();
        int j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, "File name=" + localObject2.getAbsolutePath());
          }
          if ((localObject2.isFile()) && (localObject2.getName().startsWith("libArMapEngine")) && (!localObject2.getName().contains("ArMapEngine7651")))
          {
            localObject2.delete();
            if (QLog.isColorLevel()) {
              QLog.d("ArConfig_NativeSoDownloadHandler", 2, "delete f=" + localObject2.getName());
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "exception =" + localException.getMessage());
        localException.printStackTrace();
      }
      super.a(paramXmlData);
    }
  }
  
  public void a(String paramString)
  {
    int i = ArNativeSoLoader.b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, "download success: " + paramString + ",result=" + i);
    }
    if (i == 0) {
      BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", b()).commit();
    }
    for (;;)
    {
      try
      {
        str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_ArMapEngine7651", "");
        if (!TextUtils.isEmpty(str))
        {
          QQAppInterface localQQAppInterface = this.a;
          i = a().Version;
          if (!TextUtils.isEmpty(str)) {
            continue;
          }
          localObject = "0";
          ReportController.b(localQQAppInterface, "dc01440", "", "", "0X8007A3D", "0X8007A3D", 0, 0, "", String.valueOf(i), (String)localObject, "qq.android.ar.native.so_v7.6.5.1");
          localObject = new HashMap();
          ((HashMap)localObject).put("config_version", String.valueOf(a().Version));
          ((HashMap)localObject).put("md5", str);
          ((HashMap)localObject).put("res_name", "qq.android.ar.native.so_v7.6.5.1");
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.getCurrentAccountUin(), "armap_so_update_rate", true, 0L, 0L, (HashMap)localObject, "", false);
        }
      }
      catch (Exception localException)
      {
        String str;
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localException.printStackTrace();
        continue;
      }
      super.a(paramString);
      return;
      a().loadState = 0;
      a().Version = 0;
      EarlyDataFactory.a(a(), new String[0]);
      continue;
      localObject = str;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(false, paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      super.a(paramBoolean2);
    }
    do
    {
      return;
      if ((a() == null) || (a().loadState != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownloadForce is in downloading");
    return;
    super.a(paramBoolean2);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */