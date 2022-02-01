package com.tencent.open.agent.datamodel;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;

public class ImageLoader
{
  protected static ImageLoader a;
  protected static byte[] b = new byte[1];
  protected LruCache<String, Bitmap> c = new LruCache(50);
  
  public static ImageLoader a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new ImageLoader();
        }
      }
    }
    return a;
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = MD5Utils.encodeHexStr(???);
    synchronized (b)
    {
      localObject1 = (Bitmap)this.c.get(localObject1);
      return localObject1;
    }
  }
  
  public void a(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    ImageCache.a("app", paramString, new ImageLoader.1(this, paramImageLoadListener, paramString));
  }
  
  public void b(String paramString)
  {
    String str = MD5Utils.encodeHexStr(paramString);
    synchronized (b)
    {
      this.c.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.datamodel.ImageLoader
 * JD-Core Version:    0.7.0.1
 */