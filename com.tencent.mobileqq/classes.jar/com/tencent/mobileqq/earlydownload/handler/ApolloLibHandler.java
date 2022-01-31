package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.utils.ApolloSoLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.ApolloLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.SOPreLoader;
import java.io.File;

public class ApolloLibHandler
  extends EarlyHandler
{
  public static final String[] a = { "libjsc.so" };
  
  public ApolloLibHandler(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.apollo.js.765g2", paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (EarlyDownloadManager)((QQAppInterface)localObject).getManager(76);
      if (localObject != null)
      {
        localObject = (ApolloLibHandler)((EarlyDownloadManager)localObject).a("android.qq.apollo.js.765g2");
        if (localObject != null)
        {
          ((ApolloLibHandler)localObject).a(true);
          QLog.i("ApolloSoLoader_libHandler", 1, "restartDownload savaLib");
        }
      }
    }
  }
  
  public static boolean b()
  {
    String str = SOPreLoader.a();
    int i = 0;
    while (i < a.length)
    {
      File localFile = new File(str, a[i]);
      if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int a()
  {
    return 10038;
  }
  
  public Class a()
  {
    return ApolloLibData.class;
  }
  
  public String a()
  {
    return "ApolloSoLoader_libHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess] sava:" + paramString);
    Object localObject = a();
    if (localObject != null) {
      QLog.i("ApolloSoLoader_libHandler", 1, "version:" + ((XmlData)localObject).Version);
    }
    if (new File(paramString).exists())
    {
      if (SOPreLoader.a(paramString, 1)) {
        break label130;
      }
      if (localObject != null)
      {
        ((XmlData)localObject).loadState = 0;
        ((XmlData)localObject).Version = 0;
        EarlyDataFactory.a((XmlData)localObject, new String[] { "loadState", "Version" });
      }
      QLog.e("ApolloSoLoader_libHandler", 1, "[doOnDownloadSuccess],unzip apollo lib failed!");
    }
    for (;;)
    {
      super.a(paramString);
      return;
      label130:
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString("res_name", "android.qq.apollo.js.765g2").commit();
      }
      ApolloSoLoader.a("after_ApolloSo_downloaded");
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ApolloLibHandler
 * JD-Core Version:    0.7.0.1
 */