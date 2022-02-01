package com.tencent.mobileqq.search.util;

import java.util.Comparator;

class HighlightModel$1
  implements Comparator<String>
{
  HighlightModel$1(HighlightModel paramHighlightModel) {}
  
  public int a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString2.length() - paramString1.length();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.HighlightModel.1
 * JD-Core Version:    0.7.0.1
 */