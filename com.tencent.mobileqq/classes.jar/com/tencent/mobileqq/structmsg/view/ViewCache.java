package com.tencent.mobileqq.structmsg.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;

public class ViewCache
{
  private static ViewCache a;
  
  private ViewCache()
  {
    a = this;
  }
  
  public static ViewCache a()
  {
    if (a == null) {
      a = new ViewCache();
    }
    return a;
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    Object localObject = GlobalImageCache.a.get(String.valueOf(paramInt));
    if ((localObject != null) && ((localObject instanceof Drawable))) {
      return (Drawable)localObject;
    }
    localObject = null;
    try
    {
      paramResources = paramResources.getDrawable(paramInt);
      if (paramResources != null) {
        GlobalImageCache.a.put(String.valueOf(paramInt), paramResources);
      }
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        paramResources = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.ViewCache
 * JD-Core Version:    0.7.0.1
 */