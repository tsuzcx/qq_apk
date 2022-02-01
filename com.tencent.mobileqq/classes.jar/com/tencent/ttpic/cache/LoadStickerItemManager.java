package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.BitmapLoadCache;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoadStickerItemManager
  implements LoadItemManager
{
  private static final int CAPACITY = 2;
  public static final Comparator<String> mPngComperator = new LoadStickerItemManager.1();
  private final String TAG;
  private String dataPath;
  private StickerItem item;
  private LoadItemManager.LOAD_TYPE loadType;
  private BitmapLoadCache mBitmapLazyLoad;
  private Map<String, Bitmap> mCache;
  private AsyncTask<Void, Integer, Boolean> mImageTask;
  private PreLoader mPreLoader;
  private int sampleSize;
  
  public LoadStickerItemManager(Map<String, Bitmap> paramMap, String paramString, StickerItem paramStickerItem, LoadItemManager.LOAD_TYPE paramLOAD_TYPE, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadStickerItemManager|");
    localStringBuilder.append(hashCode());
    this.TAG = localStringBuilder.toString();
    this.dataPath = paramString;
    this.item = paramStickerItem;
    this.mCache = paramMap;
    this.sampleSize = paramInt;
    if (this.item.lazyLoad == 2)
    {
      this.loadType = LoadItemManager.LOAD_TYPE.LOAD_LAZY;
      return;
    }
    if (paramStickerItem.markMode != 0)
    {
      this.loadType = LoadItemManager.LOAD_TYPE.LOAD_ALL;
      return;
    }
    this.loadType = paramLOAD_TYPE;
  }
  
  public void clear()
  {
    Object localObject = this.mImageTask;
    if (localObject != null) {
      ((AsyncTask)localObject).cancel(true);
    }
    localObject = this.mPreLoader;
    if (localObject != null) {
      ((PreLoader)localObject).clear();
    }
    localObject = this.mBitmapLazyLoad;
    if (localObject != null) {
      ((BitmapLoadCache)localObject).releaseBitmap();
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
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_LAZY)
    {
      localObject = this.mBitmapLazyLoad;
      if (localObject != null) {
        return ((BitmapLoadCache)localObject).getBitmapFromCache(paramInt);
      }
    }
    Object localObject = this.mPreLoader;
    if (localObject != null) {
      ((PreLoader)localObject).updateIndex(paramInt);
    }
    localObject = new StringBuilder();
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
    Object localObject2;
    int i;
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_ALL)
    {
      if (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) {
        return;
      }
      localObject2 = new HashSet();
      ArrayList localArrayList = new ArrayList(this.item.frames);
      if (this.item.markMode != 0)
      {
        i = 0;
        while (i <= 10)
        {
          int j = 0;
          while (j < this.item.frames)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.item.id);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append("_");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(".png");
            localArrayList.add(((StringBuilder)localObject3).toString());
            j += 1;
          }
          i += 1;
        }
        i = 0;
        while (i < this.item.frames)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.item.id);
          ((StringBuilder)localObject3).append("_");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("_x.png");
          localArrayList.add(((StringBuilder)localObject3).toString());
          i += 1;
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.dataPath);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(this.item.subFolder);
      ((Set)localObject2).addAll(VideoFilterUtil.getAllPngFileNames(((StringBuilder)localObject3).toString()));
      i = 0;
      while (i < this.item.frames)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.item.id);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(".png");
        ((Set)localObject2).add(((StringBuilder)localObject3).toString());
        i += 1;
      }
      localArrayList.addAll((Collection)localObject2);
      Collections.sort(localArrayList, mPngComperator);
      localObject3 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ALL LOAD:Load name:");
      localStringBuilder.append(this.item.id);
      localStringBuilder.append(",nums:");
      localStringBuilder.append(((Set)localObject2).size());
      Log.i((String)localObject3, localStringBuilder.toString());
      localObject2 = this.mCache;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.dataPath);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(this.item.subFolder);
      this.mImageTask = new LoadImageTask((Map)localObject2, localArrayList, ((StringBuilder)localObject3).toString(), VideoMaterial.getMaterialId(this.dataPath), this.sampleSize);
      try
      {
        this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      catch (Exception localException)
      {
        LogUtils.e(localException);
        return;
      }
    }
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_LAZY)
    {
      Object localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("LOAD_LAZY:Load name:");
      ((StringBuilder)localObject2).append(this.item.id);
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
      if (this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.IMAGE)
      {
        i = this.item.frames;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.dataPath);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.item.subFolder);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.item.id);
        ((StringBuilder)localObject1).append("_");
        this.mBitmapLazyLoad = new BitmapLoadCache(i, ((StringBuilder)localObject1).toString(), 2);
        this.mBitmapLazyLoad.preLoadImages();
      }
    }
    else if (this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.IMAGE)
    {
      this.mPreLoader = new ImagePreLoader(this.mCache, this.dataPath, this.item, 2);
      this.mPreLoader.prepare();
    }
  }
  
  public void recycleBitmap(Bitmap paramBitmap)
  {
    BitmapLoadCache localBitmapLoadCache = this.mBitmapLazyLoad;
    if (localBitmapLoadCache != null) {
      localBitmapLoadCache.resycleBitmap(paramBitmap);
    }
  }
  
  public void reset()
  {
    Object localObject = this.mPreLoader;
    if (localObject != null) {
      ((PreLoader)localObject).reset();
    }
    localObject = this.mBitmapLazyLoad;
    if (localObject != null) {
      ((BitmapLoadCache)localObject).reset();
    }
  }
  
  public void updateCache(String paramString)
  {
    Object localObject1 = this.mCache;
    if (localObject1 != null) {
      ((Map)localObject1).clear();
    }
    localObject1 = this.mImageTask;
    if ((localObject1 != null) && (!((AsyncTask)localObject1).isCancelled())) {
      this.mImageTask.cancel(true);
    }
    localObject1 = this.mBitmapLazyLoad;
    if (localObject1 != null)
    {
      ((BitmapLoadCache)localObject1).reset();
      this.mBitmapLazyLoad.releaseBitmap();
    }
    localObject1 = this.mPreLoader;
    if (localObject1 != null) {
      ((PreLoader)localObject1).reset();
    }
    Object localObject2;
    int i;
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_ALL)
    {
      if (this.item.sourceType != VideoMaterial.ITEM_SOURCE_TYPE.IMAGE) {
        return;
      }
      localObject2 = new HashSet();
      localObject1 = new ArrayList(this.item.frames);
      if (this.item.markMode != 0)
      {
        i = 0;
        while (i <= 10)
        {
          int j = 0;
          while (j < this.item.frames)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(".png");
            ((List)localObject1).add(((StringBuilder)localObject3).toString());
            j += 1;
          }
          i += 1;
        }
        i = 0;
        while (i < this.item.frames)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.item.id);
          ((StringBuilder)localObject3).append("_");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("_x.png");
          ((List)localObject1).add(((StringBuilder)localObject3).toString());
          i += 1;
        }
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(this.item.subFolder);
      ((Set)localObject2).addAll(VideoFilterUtil.getAllPngFileNames(((StringBuilder)localObject3).toString()));
      i = 0;
      while (i < this.item.frames)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.item.id);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(".png");
        ((Set)localObject2).add(((StringBuilder)localObject3).toString());
        i += 1;
      }
      ((List)localObject1).addAll((Collection)localObject2);
      Collections.sort((List)localObject1, mPngComperator);
      localObject3 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCache ALL LOAD:Load name:");
      localStringBuilder.append(this.item.id);
      localStringBuilder.append(",nums:");
      localStringBuilder.append(((Set)localObject2).size());
      Log.i((String)localObject3, localStringBuilder.toString());
      localObject2 = this.mCache;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(this.item.subFolder);
      this.mImageTask = new LoadImageTask((Map)localObject2, (List)localObject1, ((StringBuilder)localObject3).toString(), VideoMaterial.getMaterialId(this.dataPath), this.sampleSize);
      try
      {
        this.mImageTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
      catch (Exception paramString)
      {
        LogUtils.e(paramString);
        return;
      }
    }
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_LAZY)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateCache LOAD_LAZY:Load name:");
      ((StringBuilder)localObject2).append(this.item.id);
      Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
      if (this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.IMAGE)
      {
        i = this.item.frames;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.item.subFolder);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.item.id);
        ((StringBuilder)localObject1).append("_");
        this.mBitmapLazyLoad = new BitmapLoadCache(i, ((StringBuilder)localObject1).toString(), 2);
        this.mBitmapLazyLoad.preLoadImages();
      }
    }
    else if (this.item.sourceType == VideoMaterial.ITEM_SOURCE_TYPE.IMAGE)
    {
      this.mPreLoader = new ImagePreLoader(this.mCache, paramString, this.item, 2);
      ((ImagePreLoader)this.mPreLoader).setDIYMaterialId(VideoMaterial.getMaterialId(this.dataPath));
      this.mPreLoader.prepare();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager
 * JD-Core Version:    0.7.0.1
 */