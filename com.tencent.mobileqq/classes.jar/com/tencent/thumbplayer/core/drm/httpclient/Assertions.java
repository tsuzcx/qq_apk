package com.tencent.thumbplayer.core.drm.httpclient;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class Assertions
{
  private static final boolean ASSERTIONS_ENABLED = true;
  
  public static <T> T castNonNull(@Nullable T paramT)
  {
    return paramT;
  }
  
  public static void checkArgument(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static int checkIndex(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= paramInt2) && (paramInt1 < paramInt3)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public static void checkMainThread()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return;
    }
    throw new IllegalStateException("Not in applications main thread");
  }
  
  public static String checkNotEmpty(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException();
  }
  
  public static String checkNotEmpty(@Nullable String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static <T> T checkNotNull(@Nullable T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  public static <T> T checkNotNull(@Nullable T paramT, Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.Assertions
 * JD-Core Version:    0.7.0.1
 */