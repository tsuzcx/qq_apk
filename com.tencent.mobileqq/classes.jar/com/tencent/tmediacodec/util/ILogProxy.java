package com.tencent.tmediacodec.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract interface ILogProxy
{
  public abstract void d(@NonNull String paramString1, @NonNull String paramString2);
  
  public abstract void e(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable);
  
  public abstract void i(@NonNull String paramString1, @NonNull String paramString2);
  
  public abstract void v(@NonNull String paramString1, @NonNull String paramString2);
  
  public abstract void w(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.util.ILogProxy
 * JD-Core Version:    0.7.0.1
 */