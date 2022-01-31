package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.BitmapLoadCache;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.util.VideoFilterUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.io.File;
import java.util.ArrayList;
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
  private final String TAG = "LoadStickerItemManager|" + hashCode();
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
    if (this.mImageTask != null) {
      this.mImageTask.cancel(true);
    }
    if (this.mPreLoader != null) {
      this.mPreLoader.clear();
    }
    if (this.mBitmapLazyLoad != null) {
      this.mBitmapLazyLoad.releaseBitmap();
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
    if ((this.loadType == LoadItemManager.LOAD_TYPE.LOAD_LAZY) && (this.mBitmapLazyLoad != null)) {
      return this.mBitmapLazyLoad.getBitmapFromCache(paramInt);
    }
    if (this.mPreLoader != null) {
      this.mPreLoader.updateIndex(paramInt);
    }
    String str = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + this.item.id + "_" + paramInt + ".png";
    return (Bitmap)this.mCache.get(str);
  }
  
  public Bitmap loadImage(String paramString)
  {
    paramString = VideoMaterialUtil.getMaterialId(this.dataPath) + File.separator + paramString;
    return (Bitmap)this.mCache.get(paramString);
  }
  
  public void prepareImages()
  {
    int i = 0;
    int k = 0;
    if (this.loadType == LoadItemManager.LOAD_TYPE.LOAD_ALL) {
      if (this.item.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE)
      {
        HashSet localHashSet = new HashSet();
        ArrayList localArrayList = new ArrayList(this.item.frames);
        if (this.item.markMode != 0)
        {
          i = 0;
          int j;
          for (;;)
          {
            j = k;
            if (i > 10) {
              break;
            }
            j = 0;
            while (j < this.item.frames)
            {
              localArrayList.add(this.item.id + "_" + j + "_" + i + ".png");
              j += 1;
            }
            i += 1;
          }
          while (j < this.item.frames)
          {
            localArrayList.add(this.item.id + "_" + j + "_x.png");
            j += 1;
          }
        }
        localHashSet.addAll(VideoFilterUtil.getAllPngFileNames(this.dataPath + File.separator + this.item.subFolder));
        while (i < this.item.frames)
        {
          localHashSet.add(this.item.id + "_" + i + ".png");
          i += 1;
        }
        localArrayList.addAll(localHashSet);
        Collections.sort(localArrayList, mPngComperator);
        Log.i(this.TAG, "ALL LOAD:Load name:" + this.item.id + ",nums:" + localHashSet.size());
        this.mImageTask = new LoadImageTask(this.mCache, localArrayList, this.dataPath + File.separator + this.item.subFolder, VideoMaterialUtil.getMaterialId(this.dataPath), this.sampleSize);
      }
    }
    do
    {
      do
      {
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
        if (this.loadType != LoadItemManager.LOAD_TYPE.LOAD_LAZY) {
          break;
        }
        Log.i(this.TAG, "LOAD_LAZY:Load name:" + this.item.id);
      } while (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE);
      this.mBitmapLazyLoad = new BitmapLoadCache(this.item.frames, this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_", 2);
      this.mBitmapLazyLoad.preLoadImages();
      return;
    } while (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE);
    this.mPreLoader = new ImagePreLoader(this.mCache, this.dataPath, this.item, 2);
    this.mPreLoader.prepare();
  }
  
  public void recycleBitmap(Bitmap paramBitmap)
  {
    if (this.mBitmapLazyLoad != null) {
      this.mBitmapLazyLoad.resycleBitmap(paramBitmap);
    }
  }
  
  public void reset()
  {
    if (this.mPreLoader != null) {
      this.mPreLoader.reset();
    }
    if (this.mBitmapLazyLoad != null) {
      this.mBitmapLazyLoad.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager
 * JD-Core Version:    0.7.0.1
 */