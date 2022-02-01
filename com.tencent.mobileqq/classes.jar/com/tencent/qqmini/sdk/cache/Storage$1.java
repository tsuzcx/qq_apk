package com.tencent.qqmini.sdk.cache;

import android.util.LruCache;

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
    if (paramString1 == null) {
      i = 0;
    } else {
      i = paramString1.length();
    }
    if (paramString2 != null) {
      j = paramString2.length();
    }
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.Storage.1
 * JD-Core Version:    0.7.0.1
 */