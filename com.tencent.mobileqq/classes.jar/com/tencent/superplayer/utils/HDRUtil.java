package com.tencent.superplayer.utils;

import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;

public class HDRUtil
{
  private static boolean a = false;
  private static StringBuilder b = new StringBuilder();
  
  public static String a()
  {
    try
    {
      if (a) {
        break label113;
      }
      a = true;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int i;
        label113:
        String str;
        for (;;)
        {
          throw localObject;
        }
        i += 1;
      }
    }
    if (i <= 3)
    {
      if (TPThumbplayerCapabilityHelper.isHDRsupport(i, 0, 0))
      {
        b.append(i);
        b.append(",");
      }
    }
    else
    {
      if ((b.length() > 0) && (b.lastIndexOf(",") == b.length() - 1)) {
        b.deleteCharAt(b.length() - 1);
      } else if (b.length() == 0) {
        b.append("notSupport");
      }
      str = b.toString();
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.utils.HDRUtil
 * JD-Core Version:    0.7.0.1
 */