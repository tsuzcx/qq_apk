package com.tencent.qqprotect.qsec;

import android.util.Pair;

final class GGMM$1
  implements GGMM.LineSeperator
{
  public Pair<String, String> a(String paramString)
  {
    paramString = paramString.split(":", 2);
    if ((paramString == null) || (paramString.length < 2)) {
      return null;
    }
    return new Pair(paramString[0].trim(), paramString[1].trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.GGMM.1
 * JD-Core Version:    0.7.0.1
 */