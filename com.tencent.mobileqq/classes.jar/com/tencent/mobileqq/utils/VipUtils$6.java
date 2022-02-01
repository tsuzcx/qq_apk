package com.tencent.mobileqq.utils;

import java.util.Comparator;

final class VipUtils$6
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString1.length() > paramString2.length()) {
        return -1;
      }
      if (paramString1.length() < paramString2.length()) {
        return 1;
      }
    }
    else
    {
      if (paramString1 != null) {
        return -1;
      }
      if (paramString2 != null) {
        return 1;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.6
 * JD-Core Version:    0.7.0.1
 */