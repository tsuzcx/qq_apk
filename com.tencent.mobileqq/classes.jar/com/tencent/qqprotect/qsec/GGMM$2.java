package com.tencent.qqprotect.qsec;

import android.util.Pair;

final class GGMM$2
  implements GGMM.LineSeperator
{
  public Pair<String, String> a(String paramString)
  {
    int i = paramString.indexOf(':');
    if ((i > 0) && (i < paramString.length())) {
      return new Pair(paramString.substring(0, i).trim(), paramString.substring(i + 1).trim());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.GGMM.2
 * JD-Core Version:    0.7.0.1
 */