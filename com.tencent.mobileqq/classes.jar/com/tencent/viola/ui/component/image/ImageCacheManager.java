package com.tencent.viola.ui.component.image;

import android.graphics.drawable.Drawable;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.view.image.VImageView2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImageCacheManager
{
  private Map<ImageCacheManager.ImageCacheKey, WeakReference<Drawable>> downloadedDrawable = new HashMap();
  private Map<ImageCacheManager.ImageCacheKey, List<WeakReference<VImageView2>>> requestingCallbackMap = new HashMap();
  private Set<ImageCacheManager.ImageCacheKey> requestingSet = new HashSet();
  
  public void clear()
  {
    if (!this.downloadedDrawable.isEmpty()) {
      this.downloadedDrawable.clear();
    }
    if (!this.requestingCallbackMap.isEmpty()) {
      this.requestingCallbackMap.clear();
    }
    if (!this.requestingSet.isEmpty()) {
      this.requestingSet.clear();
    }
  }
  
  public void onGetDrawable(ImageCacheManager.ImageCacheKey paramImageCacheKey, Drawable paramDrawable)
  {
    if (paramImageCacheKey == null) {
      return;
    }
    this.downloadedDrawable.put(paramImageCacheKey, new WeakReference(paramDrawable));
    this.requestingSet.remove(paramImageCacheKey);
    Object localObject = (List)this.requestingCallbackMap.get(paramImageCacheKey);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VImageView2 localVImageView2 = (VImageView2)((WeakReference)((Iterator)localObject).next()).get();
        if (localVImageView2 != null) {
          localVImageView2.trySetImage(paramDrawable);
        }
      }
      this.requestingCallbackMap.remove(paramImageCacheKey);
    }
  }
  
  public boolean recordRequest(VImageView2 paramVImageView2, String paramString, int paramInt1, int paramInt2, int paramInt3, Style paramStyle)
  {
    ImageCacheManager.ImageCacheKey localImageCacheKey = new ImageCacheManager.ImageCacheKey(paramString, paramInt1, paramInt2, paramInt3, paramStyle);
    paramVImageView2.setCacheKey(localImageCacheKey);
    if (this.downloadedDrawable.containsKey(localImageCacheKey))
    {
      paramString = (Drawable)((WeakReference)this.downloadedDrawable.get(localImageCacheKey)).get();
      removeCache(localImageCacheKey);
      if (paramString != null)
      {
        paramVImageView2.trySetImage(paramString);
        return true;
      }
      return false;
    }
    if (this.requestingSet.contains(localImageCacheKey))
    {
      paramStyle = (List)this.requestingCallbackMap.get(localImageCacheKey);
      paramString = paramStyle;
      if (paramStyle == null)
      {
        paramString = new ArrayList();
        this.requestingCallbackMap.put(localImageCacheKey, paramString);
      }
      paramString.add(new WeakReference(paramVImageView2));
      return true;
    }
    this.requestingSet.add(localImageCacheKey);
    return false;
  }
  
  public void removeCache(ImageCacheManager.ImageCacheKey paramImageCacheKey)
  {
    if (paramImageCacheKey == null) {
      return;
    }
    this.requestingSet.remove(paramImageCacheKey);
    this.downloadedDrawable.remove(paramImageCacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.ImageCacheManager
 * JD-Core Version:    0.7.0.1
 */