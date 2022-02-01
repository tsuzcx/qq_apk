package com.tencent.mobileqq.flashshow.utils;

import com.tencent.mobileqq.flashshow.inject.FSToast;

public class FSToastUtil
{
  public static int a = -1;
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  
  public static void a(int paramInt1, String paramString, int paramInt2)
  {
    FSToast.a(paramInt1, paramString, paramInt2);
  }
  
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramLong != 10022L) && (paramLong != 10023L) && (paramLong != 10028L)) {
      FSToast.a(paramInt1, paramString, paramInt2);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    FSToast.a(b, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSToastUtil
 * JD-Core Version:    0.7.0.1
 */