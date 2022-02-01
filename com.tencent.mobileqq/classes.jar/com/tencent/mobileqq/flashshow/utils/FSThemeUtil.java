package com.tencent.mobileqq.flashshow.utils;

import android.content.Context;
import android.content.res.Resources;
import cooperation.qqcircle.utils.QCircleCommonUtil;

public class FSThemeUtil
{
  public static int a()
  {
    return a(QCircleCommonUtil.isInNightMode());
  }
  
  public static int a(int paramInt)
  {
    return paramInt;
  }
  
  public static int a(boolean paramBoolean)
  {
    int j = FSTransUtils.f().getResources().getColor(2131166091);
    int i = j;
    if (paramBoolean) {
      i = a(j);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSThemeUtil
 * JD-Core Version:    0.7.0.1
 */