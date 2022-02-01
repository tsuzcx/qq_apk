package com.tencent.mobileqq.upgrade;

import com.tencent.biz.common.util.HttpUtil;

public final class UpgradeConstants
{
  public static String a()
  {
    int i = HttpUtil.getNetWorkType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "X";
          }
          return "4g";
        }
        return "3g";
      }
      return "2g";
    }
    return "wifi";
  }
  
  public static String b()
  {
    int j = HttpUtil.getNetWorkType();
    int i = 3;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            i = 4;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    else {
      i = 0;
    }
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeConstants
 * JD-Core Version:    0.7.0.1
 */