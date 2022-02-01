package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQFMToastUtil
{
  private static int jdField_a_of_type_Int = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
  private static Map<Integer, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Map<String, Long> b = new HashMap();
  
  public static void a(int paramInt)
  {
    try
    {
      if (QQFileManagerUtilImpl.a().isBackgroundPause) {
        return;
      }
      if (!a(paramInt)) {
        return;
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new QQFMToastUtil.1(paramInt));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramInt2)) {
      return;
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new QQFMToastUtil.10(paramInt2));
      return;
    }
    localObject = new QQToast(BaseApplication.getContext());
    ((QQToast)localObject).a(2130839548);
    ((QQToast)localObject).d(3000);
    ((QQToast)localObject).c(paramInt2);
    ((QQToast)localObject).b(jdField_a_of_type_Int);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.8(paramInt1, paramString, paramInt2));
      return;
    }
    QQToast.a(BaseApplication.getContext(), paramInt1, paramString, paramInt2).b(jdField_a_of_type_Int);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQFMToastUtil.11(paramContext, paramInt1, paramInt2));
  }
  
  public static void a(String paramString)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.2(paramString));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
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
      return false;
    }
    jdField_a_of_type_JavaUtilMap.clear();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
    return true;
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
      return false;
    }
    b.clear();
    b.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    return true;
  }
  
  public static void b(int paramInt)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.3(paramInt));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void b(String paramString)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.4(paramString));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2, paramString, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(int paramInt)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.7(paramInt));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 0, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void c(String paramString)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.5(paramString));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2, paramString, 1).b(jdField_a_of_type_Int);
  }
  
  public static void d(int paramInt)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    if (!a(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.9(paramInt));
      return;
    }
    QQToast.a(BaseApplication.getContext(), -1, paramInt, 0).b(jdField_a_of_type_Int);
  }
  
  public static void d(String paramString)
  {
    if (QQFileManagerUtilImpl.a().isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.6(paramString));
      return;
    }
    QQToast.a(BaseApplication.getContext(), 0, paramString, 0).b(jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil
 * JD-Core Version:    0.7.0.1
 */