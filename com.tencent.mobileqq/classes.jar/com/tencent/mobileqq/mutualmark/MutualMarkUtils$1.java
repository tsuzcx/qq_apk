package com.tencent.mobileqq.mutualmark;

import java.util.Comparator;

final class MutualMarkUtils$1
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if (paramString1.length() > paramString2.length()) {
      return -1;
    }
    if (paramString1.length() < paramString2.length()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkUtils.1
 * JD-Core Version:    0.7.0.1
 */