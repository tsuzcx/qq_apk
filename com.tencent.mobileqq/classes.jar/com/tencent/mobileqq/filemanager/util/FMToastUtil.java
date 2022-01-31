package com.tencent.mobileqq.filemanager.util;

import acwy;
import acwz;
import acxa;
import acxb;
import acxc;
import acxd;
import acxe;
import acxf;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class FMToastUtil
{
  private static int jdField_a_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448) - (int)DisplayUtils.a(BaseApplicationImpl.getContext(), 5.0F);
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Map b = new HashMap();
  
  public static void a(int paramInt)
  {
    try
    {
      if (BaseApplicationImpl.sApplication.getRuntime().isBackground_Pause) {
        return;
      }
      if (a(paramInt))
      {
        Looper localLooper = Looper.getMainLooper();
        if (Thread.currentThread() != localLooper.getThread())
        {
          new Handler(localLooper).post(new acwy(paramInt));
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxf(paramInt1, paramString, paramInt2));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), paramInt1, paramString, paramInt2).b(jdField_a_of_type_Int);
  }
  
  public static void a(String paramString)
  {
    if (BaseApplicationImpl.sApplication.getRuntime().isBackground_Pause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acwz(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  private static boolean a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      long l1 = ((Long)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    if (b.containsKey(paramString))
    {
      long l1 = ((Long)b.get(paramString)).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        b.put(paramString, Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      b.clear();
      b.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  public static void b(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxa(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void b(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxb(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxe(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxc(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 1).b(jdField_a_of_type_Int);
  }
  
  public static void d(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new acxd(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil
 * JD-Core Version:    0.7.0.1
 */