package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class a
{
  private static final a.b a = new a.c(null);
  private static final a.b b = new a.a(null);
  
  @Nullable
  public static b a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return b(paramObject).a(paramObject);
  }
  
  static void a(@Nullable Object paramObject, @Nullable b paramb)
  {
    if (paramObject == null) {
      return;
    }
    b(paramObject).a(paramObject, paramb);
  }
  
  @NonNull
  private static a.b b(Object paramObject)
  {
    if ((paramObject instanceof View)) {
      return a;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a.a
 * JD-Core Version:    0.7.0.1
 */