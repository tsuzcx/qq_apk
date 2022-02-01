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
  private static int a = BaseApplication.getContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(BaseApplication.getContext(), 5.0F);
  private static Map<Integer, Long> b = new HashMap();
  private static Map<String, Long> c = new HashMap();
  
  public static void a(int paramInt)
  {
    try
    {
      if (QQFileManagerUtilImpl.m().isBackgroundPause) {
        return;
      }
      if (!e(paramInt)) {
        return;
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new QQFMToastUtil.1(paramInt));
        return;
      }
      QQToast.makeText(BaseApplication.getContext(), 0, paramInt, 0).show(a);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramInt2)) {
      return;
    }
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new QQFMToastUtil.10(paramInt2));
      return;
    }
    localObject = new QQToast(BaseApplication.getContext());
    ((QQToast)localObject).setToastIcon(2130839752);
    ((QQToast)localObject).setDuration(3000);
    ((QQToast)localObject).setToastMsg(paramInt2);
    ((QQToast)localObject).show(a);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.8(paramInt1, paramString, paramInt2));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), paramInt1, paramString, paramInt2).show(a);
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
    if (QQFileManagerUtilImpl.m().isBackgroundPause) {
      return;
    }
    if (!e(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.2(paramString));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 0, paramString, 0).show(a);
  }
  
  public static void b(int paramInt)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.3(paramInt));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2, paramInt, 0).show(a);
  }
  
  public static void b(String paramString)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.4(paramString));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2, paramString, 0).show(a);
  }
  
  public static void c(int paramInt)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.7(paramInt));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 0, paramInt, 0).show(a);
  }
  
  public static void c(String paramString)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.5(paramString));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2, paramString, 1).show(a);
  }
  
  public static void d(int paramInt)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    if (!e(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.9(paramInt));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), -1, paramInt, 0).show(a);
  }
  
  public static void d(String paramString)
  {
    if (QQFileManagerUtilImpl.l().isBackgroundPause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new QQFMToastUtil.6(paramString));
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 0, paramString, 0).show(a);
  }
  
  private static boolean e(int paramInt)
  {
    if (b.containsKey(Integer.valueOf(paramInt)))
    {
      long l1 = ((Long)b.get(Integer.valueOf(paramInt))).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        b.put(Integer.valueOf(paramInt), Long.valueOf(l2));
        return true;
      }
      return false;
    }
    b.clear();
    b.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
    return true;
  }
  
  private static boolean e(String paramString)
  {
    if (c.containsKey(paramString))
    {
      long l1 = ((Long)c.get(paramString)).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        c.put(paramString, Long.valueOf(l2));
        return true;
      }
      return false;
    }
    c.clear();
    c.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFMToastUtil
 * JD-Core Version:    0.7.0.1
 */