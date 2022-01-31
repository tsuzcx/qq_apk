package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImageItemLoadTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private ImageMemoryCache<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public ImageItemLoadTask(ImageMemoryCache<String, Bitmap> paramImageMemoryCache, List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    this.cache = paramImageMemoryCache;
    this.resourceList = paramList;
    if (this.resourceList == null) {
      this.resourceList = new ArrayList();
    }
    this.dataPath = paramString1;
    this.materialId = paramString2;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    if (this.cache == null) {
      return Boolean.valueOf(false);
    }
    paramVarArgs = null;
    Iterator localIterator = this.resourceList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isCancelled()) {
        return Boolean.valueOf(false);
      }
      Object localObject = this.dataPath + File.separator + str;
      localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, this.sampleSize);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if (!VideoBitmapUtil.isLegal((Bitmap)localObject)) {
          break label161;
        }
        this.cache.put(str, localObject);
        paramVarArgs = (Void[])localObject;
        break;
        str = this.materialId + File.separator + str;
      }
      label161:
      if (VideoBitmapUtil.isLegal(paramVarArgs)) {
        this.cache.put(str, paramVarArgs);
      }
    }
    return Boolean.valueOf(true);
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    super.onCancelled(paramBoolean);
    if (this.cache == null) {
      return;
    }
    Iterator localIterator = this.resourceList.iterator();
    label23:
    label75:
    label104:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramBoolean = (String)localIterator.next();
        if (!TextUtils.isEmpty(this.materialId)) {
          break label75;
        }
      }
      for (;;)
      {
        if (!this.cache.containsKey(paramBoolean)) {
          break label104;
        }
        this.cache.remove(paramBoolean);
        break label23;
        break;
        paramBoolean = this.materialId + File.separator + paramBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageItemLoadTask
 * JD-Core Version:    0.7.0.1
 */