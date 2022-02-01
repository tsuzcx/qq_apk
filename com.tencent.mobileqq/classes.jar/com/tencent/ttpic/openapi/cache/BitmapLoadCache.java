package com.tencent.ttpic.openapi.cache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public class BitmapLoadCache
{
  private final int CAPACITY;
  private final String TAG;
  protected BitmapFactory.Options mBitmapOptions;
  protected Vector<Bitmap> mCanUseBitmaps;
  protected int mCurIndex;
  protected Handler mHandler;
  protected boolean[] mIsNotExit;
  private HashMap<Integer, Bitmap> mLoadedCache;
  private boolean mNoBitmaps;
  protected String[] mPaths;
  private String mPreShiftPath;
  protected BitmapLoadCache.PreloadRunnable mPreloadRunnable;
  protected Resources mResources;
  public ArrayList<Bitmap> mTotalCache;
  private int mTotalFrames;
  
  public BitmapLoadCache(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BitmapLoadCache|");
    localStringBuilder.append(hashCode());
    this.TAG = localStringBuilder.toString();
    int j = 0;
    this.mTotalFrames = 0;
    this.mNoBitmaps = true;
    this.mCurIndex = -1;
    int i = paramInt2;
    if (paramInt2 > paramInt1) {
      i = paramInt1;
    }
    this.CAPACITY = i;
    if ((paramInt1 != 0) && (paramString != null))
    {
      this.mTotalFrames = paramInt1;
      this.mPreShiftPath = paramString;
      this.mCanUseBitmaps = new Vector(this.CAPACITY);
      this.mTotalCache = new ArrayList();
      this.mLoadedCache = new HashMap();
      initOptions();
      this.mNoBitmaps = false;
      this.mPreloadRunnable = new BitmapLoadCache.PreloadRunnable(this, null);
      Log.i(this.TAG, "BitmapLoadCache init.");
      paramInt1 = this.mTotalFrames;
      this.mIsNotExit = new boolean[paramInt1];
      this.mPaths = new String[paramInt1];
      paramInt1 = j;
      for (;;)
      {
        paramString = this.mIsNotExit;
        if (paramInt1 >= paramString.length) {
          break;
        }
        paramString[paramInt1] = 1;
        paramString = this.mPaths;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mPreShiftPath);
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".png");
        paramString[paramInt1] = localStringBuilder.toString();
        paramInt1 += 1;
      }
      return;
    }
    this.mNoBitmaps = true;
    Log.i(this.TAG, "BitmapLoadCache.return...");
  }
  
  private Bitmap decodeBitmapFromTemp(String paramString, Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    if (paramString == null) {
      return null;
    }
    String str;
    StringBuilder localStringBuilder;
    if (paramBitmap != null)
    {
      paramOptions.inBitmap = paramBitmap;
    }
    else
    {
      paramOptions.inBitmap = null;
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("can not UseInBitmap, add to release bitmap list:");
      localStringBuilder.append(paramString);
      Log.i(str, localStringBuilder.toString());
    }
    paramOptions = BitmapUtils.decodeSampleBitmapFromOption(AEModule.getContext(), paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT, paramOptions);
    if ((paramBitmap != null) && (!this.mTotalCache.contains(paramBitmap)))
    {
      this.mTotalCache.add(paramBitmap);
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("new Bitmap path:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",hashcode:");
      localStringBuilder.append(paramBitmap.hashCode());
      Log.i(str, localStringBuilder.toString());
    }
    return paramOptions;
  }
  
  private BitmapFactory.Options getBitmapOption()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = this.mBitmapOptions.inDensity;
    localOptions.inSampleSize = this.mBitmapOptions.inSampleSize;
    localOptions.inPreferredConfig = this.mBitmapOptions.inPreferredConfig;
    localOptions.inMutable = true;
    return localOptions;
  }
  
  private int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  private String getPathFromIndex(int paramInt)
  {
    Object localObject = this.mPaths;
    if (paramInt < localObject.length)
    {
      localObject = localObject[paramInt];
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mPreShiftPath);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
    }
    if (localObject == null)
    {
      boolean[] arrayOfBoolean = this.mIsNotExit;
      if (arrayOfBoolean.length > paramInt) {
        arrayOfBoolean[paramInt] = false;
      }
    }
    return localObject;
  }
  
  private Bitmap getTempBitmap()
  {
    Object localObject = this.mCanUseBitmaps;
    if ((localObject != null) && (((Vector)localObject).size() > 0)) {
      try
      {
        localObject = (Bitmap)this.mCanUseBitmaps.remove(0);
        return localObject;
      }
      catch (Exception localException)
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTempBitmap() exception:");
        localStringBuilder.append(localException.getMessage());
        LogUtils.e(str, localStringBuilder.toString());
        return null;
      }
    }
    return null;
  }
  
  private Bitmap getTmpBitmapFromLoadCaches()
  {
    Object localObject1 = this.mLoadedCache;
    if ((localObject1 != null) && (((HashMap)localObject1).entrySet() != null))
    {
      Object localObject2 = this.mLoadedCache.entrySet().iterator();
      int k = this.mCurIndex;
      int m = this.CAPACITY;
      if ((localObject2 != null) && (((Iterator)localObject2).hasNext())) {}
      while (((Iterator)localObject2).hasNext())
      {
        int j = ((Integer)((Map.Entry)((Iterator)localObject2).next()).getKey()).intValue();
        int i;
        if (j < k) {
          i = this.mTotalFrames + j;
        } else {
          i = j;
        }
        if ((i <= k) || (i > m + k))
        {
          localObject1 = (Bitmap)this.mLoadedCache.get(Integer.valueOf(j));
          ((Iterator)localObject2).remove();
          localObject2 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadCache.tempBitmap:");
          boolean bool;
          if (localObject1 == null) {
            bool = true;
          } else {
            bool = false;
          }
          localStringBuilder.append(bool);
          localStringBuilder.append(",loadCache size:");
          localStringBuilder.append(this.mLoadedCache.size());
          Log.i((String)localObject2, localStringBuilder.toString());
          return localObject1;
          Log.i(this.TAG, "NO LOADCACHE COULD PROVIDE.");
        }
      }
    }
    return null;
  }
  
  private void initOptions()
  {
    this.mBitmapOptions = new BitmapFactory.Options();
    this.mBitmapOptions.inSampleSize = 1;
    if (this.mResources == null) {
      initResource();
    }
    Object localObject = this.mResources;
    if ((localObject != null) && (((Resources)localObject).getDisplayMetrics() != null)) {
      this.mBitmapOptions.inDensity = this.mResources.getDisplayMetrics().densityDpi;
    }
    localObject = this.mBitmapOptions;
    ((BitmapFactory.Options)localObject).inMutable = true;
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
  }
  
  private void initResource()
  {
    if ((AEModule.getContext() != null) && (AEModule.getContext().getResources() != null)) {
      this.mResources = AEModule.getContext().getResources();
    }
  }
  
  private void preLoad(int paramInt, boolean paramBoolean)
  {
    if (this.mTotalFrames <= 0) {
      return;
    }
    Object localObject1 = (Bitmap)this.mLoadedCache.remove(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      this.mCanUseBitmaps.add(localObject1);
    }
    int i = (this.CAPACITY + paramInt) % this.mTotalFrames;
    localObject1 = this.mLoadedCache.entrySet().iterator();
    Object localObject2;
    int j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
      localObject2 = (Bitmap)((Map.Entry)localObject2).getValue();
      if (((paramInt < i) && ((j < paramInt) || (j > i))) || ((paramInt > i) && (paramInt > j) && (i < j)) || (this.mCanUseBitmaps.contains(localObject2)))
      {
        if ((localObject2 != null) && (!this.mCanUseBitmaps.contains(localObject2)))
        {
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(j);
          localStringBuilder.append(" --recycleBitmap:");
          localStringBuilder.append(localObject2.hashCode());
          Log.i(str, localStringBuilder.toString());
          this.mCanUseBitmaps.add(localObject2);
        }
        ((Iterator)localObject1).remove();
      }
    }
    i = 1;
    while (i <= this.CAPACITY)
    {
      j = (paramInt + i) % this.mTotalFrames;
      if ((!this.mLoadedCache.containsKey(Integer.valueOf(j))) && (this.mIsNotExit[j] != 0))
      {
        localObject1 = null;
        if (!paramBoolean)
        {
          localObject2 = getTempBitmap();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = getTmpBitmapFromLoadCaches();
            localObject1 = localObject2;
            if (localObject2 == null) {
              return;
            }
          }
        }
        localObject1 = decodeBitmapFromTemp(getPathFromIndex(j), (Bitmap)localObject1, getBitmapOption());
        if (localObject1 == null) {
          this.mIsNotExit[j] = false;
        } else {
          this.mLoadedCache.put(Integer.valueOf(j), localObject1);
        }
      }
      i += 1;
    }
  }
  
  protected boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool3 = paramBitmap.isRecycled();
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramBitmap.getWidth() == paramOptions.outWidth)
    {
      bool1 = bool2;
      if (paramBitmap.getHeight() == paramOptions.outHeight)
      {
        bool1 = bool2;
        if (paramOptions.inSampleSize == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Bitmap getBitmapFromCache(int paramInt)
  {
    boolean bool = this.mNoBitmaps;
    Bitmap localBitmap = null;
    if (!bool)
    {
      Object localObject1 = this.mIsNotExit;
      if ((localObject1.length > paramInt) && (localObject1[paramInt] == 0)) {
        return null;
      }
      Object localObject2 = this.mLoadedCache;
      localObject1 = localBitmap;
      if (localObject2 != null)
      {
        localObject1 = localBitmap;
        if (((HashMap)localObject2).get(Integer.valueOf(paramInt)) != null) {
          localObject1 = (Bitmap)this.mLoadedCache.get(Integer.valueOf(paramInt));
        }
      }
      if (localObject1 == null)
      {
        localBitmap = getTempBitmap();
        localObject1 = localBitmap;
        if (localBitmap == null)
        {
          localObject1 = this.mTotalCache;
          int j = 1;
          int i;
          if (localObject1 != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (this.mTotalCache.size() <= 0) {
            j = 0;
          }
          localObject1 = localBitmap;
          if ((i & j) != 0) {
            localObject1 = (Bitmap)this.mTotalCache.get(0);
          }
        }
        localBitmap = decodeBitmapFromTemp(getPathFromIndex(paramInt), (Bitmap)localObject1, getBitmapOption());
        if (localBitmap == null)
        {
          localObject1 = this.mIsNotExit;
          if (localObject1.length > paramInt) {
            localObject1[paramInt] = 0;
          }
        }
        localObject1 = this.TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("没命中：loadBitmapByNameIndex:");
        ((StringBuilder)localObject2).append(paramInt);
        Log.i((String)localObject1, ((StringBuilder)localObject2).toString());
        localObject1 = localBitmap;
        if (localBitmap != null)
        {
          localObject2 = this.mHandler;
          localObject1 = localBitmap;
          if (localObject2 != null)
          {
            ((Handler)localObject2).post(new BitmapLoadCache.2(this, paramInt, localBitmap));
            localObject1 = localBitmap;
          }
        }
      }
      this.mCurIndex = paramInt;
      return localObject1;
    }
    return null;
  }
  
  public void preLoadImages()
  {
    if (this.mNoBitmaps)
    {
      Log.e(this.TAG, "no bitmaps");
      return;
    }
    this.mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(this.TAG).getLooper());
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(new BitmapLoadCache.1(this));
    }
  }
  
  public void releaseBitmap()
  {
    this.mNoBitmaps = true;
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(new BitmapLoadCache.3(this));
    }
  }
  
  public void reset()
  {
    if ((!this.mNoBitmaps) && (this.mTotalFrames > this.CAPACITY))
    {
      Handler localHandler = this.mHandler;
      if (localHandler != null)
      {
        localHandler.removeCallbacks(this.mPreloadRunnable);
        this.mPreloadRunnable.setCurIndex(-1);
        this.mHandler.post(this.mPreloadRunnable);
      }
    }
  }
  
  public void resycleBitmap(Bitmap paramBitmap)
  {
    if (this.mNoBitmaps) {
      return;
    }
    if (paramBitmap != null)
    {
      this.mCanUseBitmaps.add(paramBitmap);
      if (this.mTotalFrames > this.CAPACITY)
      {
        paramBitmap = this.mHandler;
        if (paramBitmap != null)
        {
          paramBitmap.removeCallbacks(this.mPreloadRunnable);
          this.mPreloadRunnable.setCurIndex(this.mCurIndex);
          this.mHandler.post(this.mPreloadRunnable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.BitmapLoadCache
 * JD-Core Version:    0.7.0.1
 */