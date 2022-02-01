package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ImageCache
{
  private CustomLruCache<String, Drawable> a;
  private final HashMap<String, WeakReference<Drawable>> b = new HashMap();
  
  public ImageCache(int paramInt)
  {
    paramInt = Math.max(paramInt, 5);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Memory cache size = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("MB");
      QLog.d("ImageCache", 2, localStringBuilder.toString());
    }
    this.a = new ImageCache.1(this, paramInt * 1024 * 1024);
  }
  
  public void a()
  {
    this.a.evictAll();
    this.b.clear();
  }
  
  public void a(String paramString, Drawable paramDrawable)
  {
    CustomLruCache localCustomLruCache = this.a;
    if ((localCustomLruCache != null) && (localCustomLruCache.get(paramString) == null))
    {
      this.a.put(paramString, paramDrawable);
      this.b.put(paramString, new WeakReference(paramDrawable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageCache
 * JD-Core Version:    0.7.0.1
 */