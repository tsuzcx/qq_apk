package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoadFaceItemManager
  implements LoadItemManager
{
  private final String dataPath;
  private final FaceItem item;
  private final Map<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mFaceImageTask;
  private final Map<FaceOffUtil.FeatureType, Bitmap> mGrayCache;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask2;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask3;
  private AsyncTask<Void, Integer, Boolean> mGrayImageTask4;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private final int sampleSize;
  
  public LoadFaceItemManager(Map<String, Bitmap> paramMap, Map<FaceOffUtil.FeatureType, Bitmap> paramMap1, String paramString, FaceItem paramFaceItem, int paramInt)
  {
    this.dataPath = paramString;
    this.item = paramFaceItem;
    this.mCache = paramMap;
    this.mGrayCache = paramMap1;
    this.sampleSize = paramInt;
  }
  
  public void clear()
  {
    AsyncTask localAsyncTask = this.mImageTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    localAsyncTask = this.mGrayImageTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    localAsyncTask = this.mGrayImageTask2;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    localAsyncTask = this.mGrayImageTask3;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    localAsyncTask = this.mGrayImageTask4;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
    localAsyncTask = this.mFaceImageTask;
    if (localAsyncTask != null) {
      localAsyncTask.cancel(true);
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    return null;
  }
  
  public int loadImage(int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return -1;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VideoMaterial.getMaterialId(this.dataPath));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(this.item.id);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".png");
    localObject = ((StringBuilder)localObject).toString();
    return (Bitmap)this.mCache.get(localObject);
  }
  
  public Bitmap loadImage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoMaterial.getMaterialId(this.dataPath));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return (Bitmap)this.mCache.get(paramString);
  }
  
  public void prepareImages()
  {
    for (;;)
    {
      int i;
      try
      {
        this.mGrayImageTask = new LoadGrayImageTask(this.mGrayCache, this.item.featureType, this.sampleSize);
        if (this.mGrayImageTask.getStatus() != AsyncTask.Status.RUNNING) {
          this.mGrayImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this.mGrayImageTask2 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FeatureType.MASK, this.sampleSize);
        if (this.mGrayImageTask2.getStatus() != AsyncTask.Status.RUNNING) {
          this.mGrayImageTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this.mGrayImageTask3 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FeatureType.NOSE_MASK, this.sampleSize);
        if (this.mGrayImageTask3.getStatus() != AsyncTask.Status.RUNNING) {
          this.mGrayImageTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        this.mGrayImageTask4 = new LoadGrayImageTask(this.mGrayCache, FaceOffUtil.FeatureType.LIPS_MASK, this.sampleSize);
        if (this.mGrayImageTask4.getStatus() != AsyncTask.Status.RUNNING) {
          this.mGrayImageTask4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.item.lipsStyleMask)) {
          localArrayList.add(this.item.lipsStyleMask);
        }
        if (!TextUtils.isEmpty(this.item.id)) {
          break label534;
        }
        localArrayList.add(this.item.faceExchangeImage);
        if (this.item.blendMode == 14) {
          localArrayList.add(this.item.irisImage);
        }
        this.mFaceImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath, VideoMaterial.getMaterialId(this.dataPath), this.sampleSize);
        this.mFaceImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      catch (Exception localException)
      {
        ArrayList localArrayList;
        StringBuilder localStringBuilder;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("prepareImages():Exception-");
        ((StringBuilder)localObject).append(localException.getMessage());
        LogUtils.e("LoadFaceItemManager", ((StringBuilder)localObject).toString());
        return;
      }
      if (i < this.item.frames)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.item.id);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(".png");
        localArrayList.add(((StringBuilder)localObject).toString());
        i += 1;
      }
      else
      {
        localObject = this.mCache;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.dataPath);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(this.item.id);
        this.mImageTask = new LoadImageTask((Map)localObject, localArrayList, localStringBuilder.toString(), VideoMaterial.getMaterialId(this.dataPath), this.sampleSize);
        this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
        label534:
        i = 0;
      }
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadFaceItemManager
 * JD-Core Version:    0.7.0.1
 */