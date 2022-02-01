package com.tencent.mobileqq.pic;

import android.support.v4.util.MQLruCache;
import com.tencent.image.api.ICache;
import com.tencent.mobileqq.app.GlobalImageCache;

final class URLDrawableDepWrapInit$1
  implements ICache
{
  public void evictAll()
  {
    GlobalImageCache.a.evictAll();
  }
  
  public Object get(String paramString)
  {
    return GlobalImageCache.a.get(paramString);
  }
  
  public byte getNormalPriority()
  {
    return 1;
  }
  
  public Object put(String paramString, Object paramObject, byte paramByte)
  {
    return GlobalImageCache.a.put(paramString, paramObject, paramByte);
  }
  
  public void remove(String paramString)
  {
    GlobalImageCache.a.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit.1
 * JD-Core Version:    0.7.0.1
 */