package com.tencent.mtt.hippy.adapter.image;

import android.util.SparseArray;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import java.lang.ref.WeakReference;

public abstract class HippyImageLoader
  implements IImageLoaderAdapter<HippyImageLoader.Callback>
{
  private SparseArray<WeakReference<HippyDrawable>> mWeakImageCache = new SparseArray();
  
  public void destroyIfNeed() {}
  
  public HippyDrawable getImage(String paramString, Object paramObject)
  {
    if ((paramString.startsWith("data:")) || (paramString.startsWith("assets://"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.hashCode();
      if (i != 0)
      {
        paramObject = (WeakReference)this.mWeakImageCache.get(j);
        if (paramObject != null)
        {
          localHippyDrawable = (HippyDrawable)paramObject.get();
          paramObject = localHippyDrawable;
          if (localHippyDrawable != null) {
            break label116;
          }
          this.mWeakImageCache.delete(j);
        }
      }
      HippyDrawable localHippyDrawable = new HippyDrawable();
      localHippyDrawable.setData(paramString);
      paramObject = localHippyDrawable;
      if (i != 0)
      {
        this.mWeakImageCache.put(j, new WeakReference(localHippyDrawable));
        paramObject = localHippyDrawable;
      }
      label116:
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.image.HippyImageLoader
 * JD-Core Version:    0.7.0.1
 */