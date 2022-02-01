package com.tencent.mobileqq.troop.troopcreate;

import java.util.Comparator;

final class TroopCreateUtils$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    try
    {
      int i = paramString1.getBytes("utf-8").length;
      int j = paramString2.getBytes("utf-8").length;
      return i - j;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    return paramString1.getBytes().length - paramString2.getBytes().length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils.1
 * JD-Core Version:    0.7.0.1
 */