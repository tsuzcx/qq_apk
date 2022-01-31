package com.tencent.mobileqq.microapp.a;

import android.support.v4.util.LruCache;

final class e
  extends LruCache
{
  e(d paramd, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    int j = 0;
    int i;
    if (paramString1 == null)
    {
      i = 0;
      if (paramString2 != null) {
        break label26;
      }
    }
    for (;;)
    {
      return j + i;
      i = paramString1.length();
      break;
      label26:
      j = paramString2.length();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a.e
 * JD-Core Version:    0.7.0.1
 */