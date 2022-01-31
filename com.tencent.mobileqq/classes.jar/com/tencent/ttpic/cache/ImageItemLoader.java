package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ttpic.QQLogUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.thread.VideoThreadPool;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.Map;

public class ImageItemLoader
{
  private static final int LIMIT = 1;
  private static final String TAG = ImageItemLoader.class.getSimpleName();
  private int capacity;
  private String dataPath;
  private int frontIndex;
  private volatile boolean isRunning;
  public StickerItem item;
  private ImageMemoryCache<String, Bitmap> mCache;
  public int mCurrentIndex;
  private String materialId;
  private boolean prepared = false;
  private int rearIndex;
  
  public ImageItemLoader(ImageMemoryCache<String, Bitmap> paramImageMemoryCache, String paramString1, String paramString2, StickerItem paramStickerItem, int paramInt)
  {
    this.mCache = paramImageMemoryCache;
    this.materialId = paramString1;
    this.dataPath = paramString2;
    this.item = paramStickerItem;
    this.capacity = paramInt;
  }
  
  public static int getImageIndex(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramString.split("\\.");
      if (localObject.length == 2)
      {
        localObject = localObject[0];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          if (localObject.length > 0)
          {
            localObject = localObject[(localObject.length - 1)];
            try
            {
              int i = Integer.parseInt((String)localObject);
              return i;
            }
            catch (Exception localException)
            {
              Log.e(TAG, "getImageIndex exception name:" + paramString);
            }
          }
        }
      }
    }
    return -1;
  }
  
  public static String getImageName(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(File.separator);
      localObject1 = localObject2;
      if (paramString.length > 0) {
        localObject1 = paramString[(paramString.length - 1)];
      }
    }
    return localObject1;
  }
  
  private void preloadNewImages(int paramInt)
  {
    this.frontIndex = paramInt;
    this.rearIndex = ((this.frontIndex + this.capacity) % this.item.frames);
    paramInt = this.frontIndex;
    Object localObject2;
    if (paramInt != this.rearIndex)
    {
      localObject2 = this.item.id + "_" + paramInt + ".png";
      if (!TextUtils.isEmpty(this.materialId)) {
        break label94;
      }
    }
    label94:
    for (Object localObject1 = localObject2; this.mCache == null; localObject1 = this.materialId + File.separator + (String)localObject2) {
      return;
    }
    if (this.mCache.containsKey(localObject1)) {}
    for (;;)
    {
      paramInt = (paramInt + 1) % this.item.frames;
      break;
      localObject2 = this.dataPath + File.separator + this.item.subFolder + File.separator + (String)localObject2;
      localObject2 = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if ((VideoBitmapUtil.isLegal((Bitmap)localObject2)) && (this.mCache != null) && (!this.mCache.containsKey(localObject1)))
      {
        this.mCache.put(localObject1, localObject2);
        ImageMemoryManager.getInstance().mIdList.put(localObject1, this.item.id);
      }
    }
  }
  
  private void prepareImages()
  {
    this.mCurrentIndex = 0;
    this.frontIndex = 0;
    int i = 0;
    if ((i < this.capacity) && (i < this.item.frames))
    {
      String str = this.item.id + "_" + i + ".png";
      Object localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + str;
      localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if ((VideoBitmapUtil.isLegal((Bitmap)localObject)) && (this.mCache != null) && (!this.mCache.containsKey(str)))
        {
          this.mCache.put(str, localObject);
          ImageMemoryManager.getInstance().mIdList.put(str, this.item.id);
        }
        this.rearIndex = i;
        i += 1;
        break;
        str = this.materialId + File.separator + str;
      }
    }
  }
  
  public Bitmap loadImage(int paramInt)
  {
    if (this.mCache == null) {
      return null;
    }
    updateIndex(paramInt);
    Object localObject2 = this.item.id + "_" + paramInt + ".png";
    if (TextUtils.isEmpty(this.materialId)) {}
    Bitmap localBitmap;
    for (Object localObject1 = localObject2;; localObject1 = this.materialId + File.separator + (String)localObject2)
    {
      localBitmap = (Bitmap)this.mCache.get(localObject1);
      if (VideoBitmapUtil.isLegal(localBitmap)) {
        break;
      }
      long l = System.currentTimeMillis();
      localObject2 = this.dataPath + File.separator + this.item.subFolder + File.separator + (String)localObject2;
      localObject2 = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject2, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
      if ((VideoBitmapUtil.isLegal((Bitmap)localObject2)) && (this.mCache != null) && (!this.mCache.containsKey(localObject1)))
      {
        this.mCache.put(localObject1, localObject2);
        ImageMemoryManager.getInstance().mIdList.put(localObject1, this.item.id);
      }
      float f = (float)(System.currentTimeMillis() - l);
      localObject1 = ImageMemoryManager.getInstance();
      ((ImageMemoryManager)localObject1).mUnHitCount += 1;
      localObject1 = ImageMemoryManager.getInstance();
      ((ImageMemoryManager)localObject1).decodeTime += f;
      return localObject2;
    }
    localObject1 = ImageMemoryManager.getInstance();
    ((ImageMemoryManager)localObject1).mHitCount += 1;
    return localBitmap;
  }
  
  public void prepare()
  {
    reset();
  }
  
  public void reset()
  {
    if (this.prepared) {
      return;
    }
    this.prepared = true;
    VideoThreadPool.getInstance().submit(new Runnable()
    {
      public void run()
      {
        ImageItemLoader.this.prepareImages();
      }
    });
  }
  
  public void updateIndex(final int paramInt)
  {
    this.mCurrentIndex = paramInt;
    if ((paramInt == this.frontIndex) || (this.isRunning))
    {
      QQLogUtils.i(TAG, "update isRunning:" + this.isRunning);
      return;
    }
    this.prepared = false;
    this.isRunning = true;
    VideoThreadPool.getInstance().submit(new Runnable()
    {
      public void run()
      {
        ImageItemLoader.this.preloadNewImages(paramInt);
        ImageItemLoader.access$102(ImageItemLoader.this, false);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.cache.ImageItemLoader
 * JD-Core Version:    0.7.0.1
 */