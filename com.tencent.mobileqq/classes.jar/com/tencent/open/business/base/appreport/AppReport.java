package com.tencent.open.business.base.appreport;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppReport
{
  protected static Lock a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putLong("app_last_fullReport_success_time", SystemClock.currentThreadTimeMillis());
    localEditor.putBoolean("is_app_last_fullReport_success", true);
    localEditor.putBoolean("is_incremental_report_overflow", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  protected static void a(Context paramContext, String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    LogUtility.b("AppReport", "save package <" + paramString + " : " + paramInt + "> to local");
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = localObject4;
    Object localObject3 = localObject5;
    localObject1 = localObject6;
    try
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = localObject6;
      paramContext = paramContext.openFileOutput("appcenter_app_report_storage_file.txt", 32768);
      localObject2 = paramContext;
      localObject3 = paramContext;
      localObject1 = paramContext;
      paramContext.write((paramString + ":" + paramInt + ",").getBytes());
      if (paramContext != null) {}
      try
      {
        paramContext.close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        throw paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      localObject1 = localObject2;
      paramContext.printStackTrace();
      if (localObject2 != null) {}
      try
      {
        ((FileOutputStream)localObject2).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    catch (IOException paramContext)
    {
      localObject1 = localObject3;
      paramContext.printStackTrace();
      if (localObject3 != null) {}
      try
      {
        ((FileOutputStream)localObject3).close();
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        return;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, WebView paramWebView, String paramString3) {}
  
  public static void a(Context paramContext, String paramString1, WebView paramWebView, String paramString2, boolean paramBoolean) {}
  
  public static void b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("appcenter_app_report", 0).edit();
    localEditor.putBoolean("is_app_last_fullReport_success", false);
    localEditor.commit();
    if (new File(paramContext.getFilesDir() + File.separator + "appcenter_app_report_storage_file.txt").exists())
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      paramContext.deleteFile("appcenter_app_report_storage_file.txt");
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.base.appreport.AppReport
 * JD-Core Version:    0.7.0.1
 */