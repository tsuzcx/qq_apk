package com.tencent.trackrecordlib.d.a;

import android.support.annotation.NonNull;
import java.util.WeakHashMap;

class f
{
  private static final WeakHashMap<Object, b> a = new WeakHashMap();
  
  static b a(@NonNull Object paramObject)
  {
    return (b)a.get(paramObject);
  }
  
  static void a(@NonNull Object paramObject, b paramb)
  {
    a.put(paramObject, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a.f
 * JD-Core Version:    0.7.0.1
 */