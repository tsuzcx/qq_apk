package com.tencent.mobileqq.mini.cache;

import android.support.v4.util.LruCache;

class Storage$1
  extends LruCache<String, String>
{
  Storage$1(Storage paramStorage, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Storage.1
 * JD-Core Version:    0.7.0.1
 */