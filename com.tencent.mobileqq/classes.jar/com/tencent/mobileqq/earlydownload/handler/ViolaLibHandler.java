package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.xmldata.ViolaLibData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ViolaLibHandler
  extends EarlyHandler
{
  public static final String[] a = { "libgnustl_shared.so", "libicu_common.so", "libjsc.so", "libkd_render.so" };
  
  public ViolaLibHandler(QQAppInterface paramQQAppInterface)
  {
    super("android.qq.readinjoy.viola", paramQQAppInterface);
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (EarlyDownloadManager)((QQAppInterface)localObject).getManager(76);
      if (localObject != null)
      {
        localObject = (ViolaLibHandler)((EarlyDownloadManager)localObject).a("android.qq.readinjoy.viola");
        if (localObject != null)
        {
          ((ViolaLibHandler)localObject).a(true);
          QLog.i("viola.ViolaLibHandler", 1, "restartDownloadLib");
        }
      }
    }
  }
  
  public static boolean c()
  {
    String str = ReadInjoyWebRenderSoLoader.a();
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
    return 10071;
  }
  
  public Class a()
  {
    return ViolaLibData.class;
  }
  
  public String a()
  {
    return "viola.ViolaLibHandler";
  }
  
  public void a(String paramString)
  {
    QLog.i("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess]:" + paramString);
    XmlData localXmlData = a();
    if (localXmlData != null) {
      QLog.i("viola.ViolaLibHandler", 1, "version:" + localXmlData.Version);
    }
    if (new File(paramString).exists())
    {
      if (!ReadInjoyWebRenderSoLoader.a(paramString))
      {
        if (localXmlData != null)
        {
          localXmlData.loadState = 0;
          localXmlData.Version = 0;
          EarlyDataFactory.a(localXmlData, new String[] { "loadState", "Version" });
        }
        QLog.e("viola.ViolaLibHandler", 1, "[doOnDownloadSuccess],unzip readinjoy_viola lib failed!");
      }
    }
    else {
      return;
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
    if (paramString != null) {
      paramString.edit().putString("res_name", "android.qq.readinjoy.viola").commit();
    }
    ReadInJoyWebRenderEngine.a("doOnDownloadSuccess");
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
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler
 * JD-Core Version:    0.7.0.1
 */