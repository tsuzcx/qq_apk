package com.tencent.mtt.hippy.adapter.image;

import android.util.SparseArray;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import java.lang.ref.WeakReference;

public abstract class HippyImageLoader
  implements IImageLoaderAdapter<HippyImageLoader.Callback>
{
  private final SparseArray<WeakReference<HippyDrawable>> mWeakImageCache = new SparseArray();
  
  public void destroyIfNeed() {}
  
  public HippyDrawable getImage(String paramString, Object paramObject)
  {
    int i;
    if ((!paramString.startsWith("data:")) && (!paramString.startsWith("assets://"))) {
      i = 0;
    } else {
      i = 1;
    }
    int j = paramString.hashCode();
    if (i != 0)
    {
      paramObject = (WeakReference)this.mWeakImageCache.get(j);
      if (paramObject != null)
      {
        paramObject = (HippyDrawable)paramObject.get();
        if (paramObject == null) {
          this.mWeakImageCache.delete(j);
        } else {
          return paramObject;
        }
      }
    }
    paramObject = new HippyDrawable();
    paramObject.setData(paramString);
    if (i != 0) {
      this.mWeakImageCache.put(j, new WeakReference(paramObject));
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.image.HippyImageLoader
 * JD-Core Version:    0.7.0.1
 */