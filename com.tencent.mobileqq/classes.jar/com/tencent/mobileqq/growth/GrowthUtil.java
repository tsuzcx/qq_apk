package com.tencent.mobileqq.growth;

import android.support.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/growth/GrowthUtil;", "", "()V", "INVALID_DRAWABLE_ID", "", "getDrawableIdByWns", "wnsPicId", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GrowthUtil
{
  public static final GrowthUtil a = new GrowthUtil();
  
  @JvmStatic
  @DrawableRes
  public static final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1001: 
      return 2130848501;
    case 1002: 
      return 2130848502;
    case 1003: 
      return 2130848503;
    case 1004: 
      return 2130848504;
    }
    return 2130848505;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.growth.GrowthUtil
 * JD-Core Version:    0.7.0.1
 */