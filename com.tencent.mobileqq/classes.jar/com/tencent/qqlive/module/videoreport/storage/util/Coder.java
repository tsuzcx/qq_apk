package com.tencent.qqlive.module.videoreport.storage.util;

public abstract interface Coder
{
  public abstract <T> T decode(String paramString, Class<T> paramClass);
  
  public abstract String encode(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.util.Coder
 * JD-Core Version:    0.7.0.1
 */