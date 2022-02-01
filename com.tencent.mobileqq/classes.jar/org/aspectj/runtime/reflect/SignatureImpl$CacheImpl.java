package org.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;

final class SignatureImpl$CacheImpl
  implements SignatureImpl.Cache
{
  private SoftReference toStringCacheRef;
  
  public SignatureImpl$CacheImpl()
  {
    makeCache();
  }
  
  private String[] array()
  {
    return (String[])this.toStringCacheRef.get();
  }
  
  private String[] makeCache()
  {
    String[] arrayOfString = new String[3];
    this.toStringCacheRef = new SoftReference(arrayOfString);
    return arrayOfString;
  }
  
  public String get(int paramInt)
  {
    String[] arrayOfString = array();
    if (arrayOfString == null) {
      return null;
    }
    return arrayOfString[paramInt];
  }
  
  public void set(int paramInt, String paramString)
  {
    String[] arrayOfString2 = array();
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = makeCache();
    }
    arrayOfString1[paramInt] = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.SignatureImpl.CacheImpl
 * JD-Core Version:    0.7.0.1
 */