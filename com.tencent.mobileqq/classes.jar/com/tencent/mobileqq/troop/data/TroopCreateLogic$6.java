package com.tencent.mobileqq.troop.data;

import java.util.Comparator;

final class TroopCreateLogic$6
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
    catch (Exception localException) {}
    return paramString1.getBytes().length - paramString2.getBytes().length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.6
 * JD-Core Version:    0.7.0.1
 */