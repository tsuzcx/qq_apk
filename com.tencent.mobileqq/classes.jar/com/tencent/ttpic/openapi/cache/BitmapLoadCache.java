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
  private final String TAG = "BitmapLoadCache|" + hashCode();
  protected BitmapFactory.Options mBitmapOptions;
  protected Vector<Bitmap> mCanUseBitmaps;
  protected int mCurIndex = -1;
  protected Handler mHandler;
  protected boolean[] mIsNotExit;
  private HashMap<Integer, Bitmap> mLoadedCache;
  private boolean mNoBitmaps = true;
  protected String[] mPaths;
  private String mPreShiftPath;
  protected BitmapLoadCache.PreloadRunnable mPreloadRunnable;
  protected Resources mResources;
  public ArrayList<Bitmap> mTotalCache;
  private int mTotalFrames = 0;
  
  public BitmapLoadCache(int paramInt1, String paramString, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 > paramInt1) {
      i = paramInt1;
    }
    this.CAPACITY = i;
    if ((paramInt1 == 0) || (paramString == null))
    {
      this.mNoBitmaps = true;
      Log.i(this.TAG, "BitmapLoadCache.return...");
    }
    for (;;)
    {
      return;
      this.mTotalFrames = paramInt1;
      this.mPreShiftPath = paramString;
      this.mCanUseBitmaps = new Vector(this.CAPACITY);
      this.mTotalCache = new ArrayList();
      this.mLoadedCache = new HashMap();
      initOptions();
      this.mNoBitmaps = false;
      this.mPreloadRunnable = new BitmapLoadCache.PreloadRunnable(this, null);
      Log.i(this.TAG, "BitmapLoadCache init.");
      this.mIsNotExit = new boolean[this.mTotalFrames];
      this.mPaths = new String[this.mTotalFrames];
      paramInt1 = j;
      while (paramInt1 < this.mIsNotExit.length)
      {
        this.mIsNotExit[paramInt1] = true;
        this.mPaths[paramInt1] = (this.mPreShiftPath + paramInt1 + ".png");
        paramInt1 += 1;
      }
    }
  }
  
  private Bitmap decodeBitmapFromTemp(String paramString, Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    if (paramString == null)
    {
      paramOptions = localBitmap;
      return paramOptions;
    }
    if (paramBitmap != null) {
      paramOptions.inBitmap = paramBitmap;
    }
    for (;;)
    {
      localBitmap = BitmapUtils.decodeSampleBitmapFromOption(AEModule.getContext(), paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT, paramOptions);
      paramOptions = localBitmap;
      if (paramBitmap == null) {
        break;
      }
      paramOptions = localBitmap;
      if (this.mTotalCache.contains(paramBitmap)) {
        break;
      }
      this.mTotalCache.add(paramBitmap);
      Log.i(this.TAG, "new Bitmap path:" + paramString + ",hashcode:" + paramBitmap.hashCode());
      return localBitmap;
      paramOptions.inBitmap = null;
      Log.i(this.TAG, "can not UseInBitmap, add to release bitmap list:" + paramString);
    }
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
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private String getPathFromIndex(int paramInt)
  {
    if (paramInt < this.mPaths.length) {}
    for (String str = this.mPaths[paramInt];; str = this.mPreShiftPath + paramInt + ".png")
    {
      if ((str == null) && (this.mIsNotExit.length > paramInt)) {
        this.mIsNotExit[paramInt] = false;
      }
      return str;
    }
  }
  
  private Bitmap getTempBitmap()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mCanUseBitmaps != null)
    {
      localObject1 = localObject2;
      if (this.mCanUseBitmaps.size() > 0) {
        localObject1 = (Bitmap)this.mCanUseBitmaps.remove(0);
      }
    }
    return localObject1;
  }
  
  private Bitmap getTmpBitmapFromLoadCaches()
  {
    int j;
    int i;
    label119:
    Bitmap localBitmap;
    boolean bool;
    if ((this.mLoadedCache != null) && (this.mLoadedCache.entrySet() != null))
    {
      Object localObject = this.mLoadedCache.entrySet().iterator();
      int k = this.mCurIndex;
      int m = this.mCurIndex;
      int n = this.CAPACITY;
      if ((localObject == null) || (!((Iterator)localObject).hasNext()))
      {
        Log.i(this.TAG, "NO LOADCACHE COULD PROVIDE.");
        return null;
      }
      if (((Iterator)localObject).hasNext())
      {
        j = ((Integer)((Map.Entry)((Iterator)localObject).next()).getKey()).intValue();
        if (j < k)
        {
          i = this.mTotalFrames + j;
          if ((i > k) && (i <= m + n)) {
            break label229;
          }
          localBitmap = (Bitmap)this.mLoadedCache.get(Integer.valueOf(j));
          ((Iterator)localObject).remove();
          localObject = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder().append("loadCache.tempBitmap:");
          if (localBitmap == null)
          {
            bool = true;
            label185:
            Log.i((String)localObject, bool + ",loadCache size:" + this.mLoadedCache.size());
          }
        }
      }
    }
    for (;;)
    {
      return localBitmap;
      bool = false;
      break label185;
      i = j;
      break label119;
      label229:
      break;
      localBitmap = null;
    }
  }
  
  private void initOptions()
  {
    this.mBitmapOptions = new BitmapFactory.Options();
    this.mBitmapOptions.inSampleSize = 1;
    if (this.mResources == null) {
      initResource();
    }
    if ((this.mResources != null) && (this.mResources.getDisplayMetrics() != null)) {
      this.mBitmapOptions.inDensity = this.mResources.getDisplayMetrics().densityDpi;
    }
    this.mBitmapOptions.inMutable = true;
    this.mBitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
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
          Log.i(this.TAG, j + " --recycleBitmap:" + localObject2.hashCode());
          this.mCanUseBitmaps.add(localObject2);
        }
        ((Iterator)localObject1).remove();
      }
    }
    i = 1;
    label236:
    if (i <= this.CAPACITY)
    {
      j = (paramInt + i) % this.mTotalFrames;
      if (!this.mLoadedCache.containsKey(Integer.valueOf(j))) {
        break label276;
      }
    }
    for (;;)
    {
      i += 1;
      break label236;
      break;
      label276:
      if (this.mIsNotExit[j] != 0)
      {
        localObject1 = null;
        if (!paramBoolean)
        {
          localObject2 = getTempBitmap();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = getTmpBitmapFromLoadCaches();
            if (localObject1 == null) {
              break;
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
    }
  }
  
  protected boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool = true;
    if (paramBitmap.isRecycled()) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (Build.VERSION.SDK_INT < 19) {
          break;
        }
      } while (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount());
      return false;
    } while ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1));
    return false;
  }
  
  public Bitmap getBitmapFromCache(int paramInt)
  {
    Object localObject2 = null;
    int j = 1;
    if ((this.mNoBitmaps) || ((this.mIsNotExit.length > paramInt) && (this.mIsNotExit[paramInt] == 0))) {
      return null;
    }
    Object localObject1 = localObject2;
    if (this.mLoadedCache != null)
    {
      localObject1 = localObject2;
      if (this.mLoadedCache.get(Integer.valueOf(paramInt)) != null) {
        localObject1 = (Bitmap)this.mLoadedCache.get(Integer.valueOf(paramInt));
      }
    }
    localObject2 = localObject1;
    int i;
    if (localObject1 == null)
    {
      localObject1 = getTempBitmap();
      if (localObject1 != null) {
        break label262;
      }
      if (this.mTotalCache == null) {
        break label252;
      }
      i = 1;
      if (this.mTotalCache.size() <= 0) {
        break label257;
      }
      label116:
      if ((i & j) == 0) {
        break label262;
      }
      localObject1 = (Bitmap)this.mTotalCache.get(0);
    }
    label257:
    label262:
    for (;;)
    {
      localObject1 = decodeBitmapFromTemp(getPathFromIndex(paramInt), (Bitmap)localObject1, getBitmapOption());
      if ((localObject1 == null) && (this.mIsNotExit.length > paramInt)) {
        this.mIsNotExit[paramInt] = false;
      }
      Log.i(this.TAG, "没命中：loadBitmapByNameIndex:" + paramInt);
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.mHandler != null)
        {
          this.mHandler.post(new BitmapLoadCache.2(this, paramInt, (Bitmap)localObject1));
          localObject2 = localObject1;
        }
      }
      this.mCurIndex = paramInt;
      return localObject2;
      label252:
      i = 0;
      break;
      j = 0;
      break label116;
    }
  }
  
  public void preLoadImages()
  {
    if (this.mNoBitmaps) {
      Log.e(this.TAG, "no bitmaps");
    }
    do
    {
      return;
      this.mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(this.TAG).getLooper());
    } while (this.mHandler == null);
    this.mHandler.post(new BitmapLoadCache.1(this));
  }
  
  public void releaseBitmap()
  {
    this.mNoBitmaps = true;
    if (this.mHandler != null) {
      this.mHandler.post(new BitmapLoadCache.3(this));
    }
  }
  
  public void reset()
  {
    if ((!this.mNoBitmaps) && (this.mTotalFrames > this.CAPACITY) && (this.mHandler != null))
    {
      this.mHandler.removeCallbacks(this.mPreloadRunnable);
      this.mPreloadRunnable.setCurIndex(-1);
      this.mHandler.post(this.mPreloadRunnable);
    }
  }
  
  public void resycleBitmap(Bitmap paramBitmap)
  {
    if (this.mNoBitmaps) {}
    do
    {
      do
      {
        return;
      } while (paramBitmap == null);
      this.mCanUseBitmaps.add(paramBitmap);
    } while ((this.mTotalFrames <= this.CAPACITY) || (this.mHandler == null));
    this.mHandler.removeCallbacks(this.mPreloadRunnable);
    this.mPreloadRunnable.setCurIndex(this.mCurIndex);
    this.mHandler.post(this.mPreloadRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.BitmapLoadCache
 * JD-Core Version:    0.7.0.1
 */