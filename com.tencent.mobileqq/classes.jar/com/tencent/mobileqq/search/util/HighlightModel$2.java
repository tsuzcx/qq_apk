package com.tencent.mobileqq.search.util;

import java.util.Comparator;

class HighlightModel$2
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString2.length() - paramString1.length();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.HighlightModel.2
 * JD-Core Version:    0.7.0.1
 */