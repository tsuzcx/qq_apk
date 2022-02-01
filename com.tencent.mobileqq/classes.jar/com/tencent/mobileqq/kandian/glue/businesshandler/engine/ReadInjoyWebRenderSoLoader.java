package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.LoadLibCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReadInjoyWebRenderSoLoader
{
  public static String a = "_viola_reinstall_delBiz_succ_810";
  public static String b = "_viola_reinstall_delJSC_succ_810";
  private static String c = "";
  private static Object d = new Object();
  private static int e;
  private static String f = "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/android.qq.readinjoy.viola_biz_810.js";
  
  public static String a()
  {
    if (TextUtils.isEmpty(c))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getFilesDir();
        if (TextUtils.isEmpty(c))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject).getParent());
          localStringBuilder.append("/txlib/");
          localStringBuilder.append("readinjoy_viola/");
          c = localStringBuilder.toString();
        }
      }
      else
      {
        QLog.w("viola.ReadInjoyWebRenderSoLoader", 2, "getSoLibPath but context is null");
      }
    }
    return c;
  }
  
  public static boolean a(LoadLibCallback paramLoadLibCallback)
  {
    if (e()) {
      return true;
    }
    ThreadManager.post(new ReadInjoyWebRenderSoLoader.1(paramLoadLibCallback), 8, null, true);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    synchronized (d)
    {
      a();
      boolean bool2 = TextUtils.isEmpty(c);
      boolean bool1 = false;
      if (!bool2) {
        try
        {
          e = 1;
          FileUtils.uncompressZip(paramString, c, false);
          e = 0;
          QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, "succeed to unzip so.");
        }
        catch (Exception paramString)
        {
          e = 2;
          QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, paramString, new Object[0]);
        }
      }
      if (e == 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private static boolean c(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[delAllSo]");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("viola.ReadInjoyWebRenderSoLoader", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      localObject = a();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append(paramString);
      FileUtils.deleteFile(localStringBuilder2.toString());
    }
    catch (Throwable localThrowable)
    {
      QLog.e("viola.ReadInjoyWebRenderSoLoader", 1, localThrowable, new Object[0]);
    }
    try
    {
      if (!new File(a(), paramString).exists())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("reinstallDelSO  ");
        localStringBuilder1.append(paramString);
        localStringBuilder1.append("succ");
        QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, localStringBuilder1.toString());
        return true;
      }
      return false;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private static boolean e()
  {
    Object localObject = RIJSPUtils.a(ReadInJoyUtils.b(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "isReinstallDelSucc  failed");
      return false;
    }
    boolean bool = ((SharedPreferences)localObject).getBoolean(b, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isReinstallDelSucc sp result=");
    ((StringBuilder)localObject).append(bool);
    QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private static void f()
  {
    Object localObject = RIJSPUtils.a(ReadInJoyUtils.b(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    QLog.d("Q.readinjoy.tt_report", 1, "delSoReinstall sp update to true");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(b, true);
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
  
  private static void g()
  {
    Object localObject = RIJSPUtils.a(ReadInJoyUtils.b(), true, true);
    if (localObject == null)
    {
      QLog.d("viola.ReadInjoyWebRenderSoLoader", 1, "delSoReinstall sp failed");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean(a, true);
    RIJSPUtils.a((SharedPreferences.Editor)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader
 * JD-Core Version:    0.7.0.1
 */