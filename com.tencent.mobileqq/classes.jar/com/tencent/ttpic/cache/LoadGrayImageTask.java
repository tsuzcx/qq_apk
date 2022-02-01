package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.Map;

public class LoadGrayImageTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private final FaceOffUtil.FeatureType featureType;
  private final Map<FaceOffUtil.FeatureType, Bitmap> mGrayCache;
  private final int sampleSize;
  
  public LoadGrayImageTask(Map<FaceOffUtil.FeatureType, Bitmap> paramMap, FaceOffUtil.FeatureType paramFeatureType, int paramInt)
  {
    this.mGrayCache = paramMap;
    this.featureType = paramFeatureType;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    boolean bool = isCancelled();
    paramVarArgs = Boolean.valueOf(false);
    if (bool) {
      return paramVarArgs;
    }
    Map localMap = this.mGrayCache;
    if (localMap == null) {
      return paramVarArgs;
    }
    if (!localMap.containsKey(this.featureType))
    {
      paramVarArgs = FaceOffUtil.getGrayBitmap(this.featureType);
      if (BitmapUtils.isLegal(paramVarArgs)) {
        this.mGrayCache.put(this.featureType, paramVarArgs);
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadGrayImageTask
 * JD-Core Version:    0.7.0.1
 */