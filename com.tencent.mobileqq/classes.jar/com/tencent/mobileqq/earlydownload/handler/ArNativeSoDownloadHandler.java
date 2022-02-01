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
import mqq.app.AppRuntime;

public class ArNativeSoDownloadHandler
  extends EarlyHandler
{
  public ArNativeSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.native.so_v8.3.6", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10024;
  }
  
  public Class<? extends XmlData> a()
  {
    return ArNativeSoData.class;
  }
  
  public String a()
  {
    return "ArConfig_NativeSoDownloadHandler";
  }
  
  public void a(XmlData paramXmlData)
  {
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getSharedPreferences("ArNativeSoDownloadHandler", 4);
      StringBuilder localStringBuilder1;
      if (((SharedPreferences)localObject).getBoolean("qq.android.ar.native.so_v8.3.6", true))
      {
        localObject = ((SharedPreferences)localObject).edit();
        int i = 0;
        ((SharedPreferences.Editor)localObject).putBoolean("qq.android.ar.native.so_v8.3.6", false).commit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ArNativeSoLoader.a());
        ((StringBuilder)localObject).append(File.separator);
        localObject = new File(((StringBuilder)localObject).toString()).listFiles();
        int j = localObject.length;
        while (i < j)
        {
          localStringBuilder1 = localObject[i];
          StringBuilder localStringBuilder2;
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("File name=");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.d("ArConfig_NativeSoDownloadHandler", 2, localStringBuilder2.toString());
          }
          if ((localStringBuilder1.isFile()) && (localStringBuilder1.getName().startsWith("libArMapEngine")) && (!localStringBuilder1.getName().contains("ArMapEngine836")))
          {
            localStringBuilder1.delete();
            if (QLog.isColorLevel())
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("delete f=");
              localStringBuilder2.append(localStringBuilder1.getName());
              QLog.d("ArConfig_NativeSoDownloadHandler", 2, localStringBuilder2.toString());
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
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("exception =");
        localStringBuilder1.append(localException.getMessage());
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, localStringBuilder1.toString());
        localException.printStackTrace();
      }
      super.a(paramXmlData);
    }
  }
  
  public void a(String paramString)
  {
    int i = ArNativeSoLoader.b(paramString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("download success: ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",result=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == 0)
    {
      BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit().putInt("ar_native_so_version", b()).commit();
    }
    else
    {
      a().loadState = 0;
      a().Version = 0;
      EarlyDataFactory.a(a(), new String[0]);
    }
    for (;;)
    {
      String str;
      try
      {
        str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_ArMapEngine836", "");
        if (!TextUtils.isEmpty(str))
        {
          AppRuntime localAppRuntime = this.a;
          i = a().Version;
          if (!TextUtils.isEmpty(str)) {
            break label293;
          }
          localObject1 = "0";
          ReportController.b(localAppRuntime, "dc01440", "", "", "0X8007A3D", "0X8007A3D", 0, 0, "", String.valueOf(i), (String)localObject1, "qq.android.ar.native.so_v8.3.6");
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("config_version", String.valueOf(a().Version));
          ((HashMap)localObject1).put("md5", str);
          ((HashMap)localObject1).put("res_name", "qq.android.ar.native.so_v8.3.6");
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.a.getCurrentAccountUin(), "armap_so_update_rate", true, 0L, 0L, (HashMap)localObject1, "", false);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
      super.a(paramString);
      return;
      label293:
      Object localObject2 = str;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(false, paramBoolean);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartDownload ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ArConfig_NativeSoDownloadHandler", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      super.a(paramBoolean2);
      return;
    }
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_NativeSoDownloadHandler", 2, "restartDownloadForce is in downloading");
      }
    }
    else {
      super.a(paramBoolean2);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */