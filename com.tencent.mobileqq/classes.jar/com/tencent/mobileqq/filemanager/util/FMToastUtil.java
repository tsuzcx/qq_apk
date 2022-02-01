package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IFMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class FMToastUtil
{
  public static IFMToastUtil a()
  {
    return (IFMToastUtil)QRoute.api(IFMToastUtil.class);
  }
  
  public static void a(int paramInt)
  {
    a().toastError(paramInt);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a().toast(paramContext, paramInt1, paramInt2);
  }
  
  public static void a(String paramString)
  {
    a().toastError(paramString);
  }
  
  public static void b(int paramInt)
  {
    a().toastSuc(paramInt);
  }
  
  public static void b(String paramString)
  {
    a().toastSuc(paramString);
  }
  
  public static void c(int paramInt)
  {
    a().toastDefault(paramInt);
  }
  
  public static void c(String paramString)
  {
    a().toastSucLong(paramString);
  }
  
  public static void d(String paramString)
  {
    a().toastDefault(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FMToastUtil
 * JD-Core Version:    0.7.0.1
 */