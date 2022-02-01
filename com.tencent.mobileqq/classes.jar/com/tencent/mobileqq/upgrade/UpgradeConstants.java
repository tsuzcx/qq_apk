package com.tencent.mobileqq.upgrade;

import com.tencent.biz.common.util.HttpUtil;

public final class UpgradeConstants
{
  public static String a()
  {
    switch ()
    {
    default: 
      return "X";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    case 4: 
      return "4g";
    }
    return "wifi";
  }
  
  public static String b()
  {
    int i = 4;
    switch (HttpUtil.getNetWorkType())
    {
    }
    for (;;)
    {
      return String.valueOf(i);
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeConstants
 * JD-Core Version:    0.7.0.1
 */