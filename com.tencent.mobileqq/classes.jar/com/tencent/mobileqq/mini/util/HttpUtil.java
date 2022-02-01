package com.tencent.mobileqq.mini.util;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class HttpUtil
{
  public static int getNetWorkType()
  {
    boolean bool = AppNetConnInfo.isNetSupport();
    int j = 0;
    if (!bool) {
      return 0;
    }
    if (AppNetConnInfo.isWifiConn()) {
      return 1;
    }
    int i = j;
    if (AppNetConnInfo.isMobileConn())
    {
      int k = AppNetConnInfo.getMobileInfo();
      i = j;
      if (k != -1)
      {
        j = 2;
        i = j;
        if (k != 0)
        {
          i = j;
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3) {
                return -1;
              }
              return 4;
            }
            return 3;
          }
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */