package com.tencent.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavsticker.utils.ViewUtils;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoThumbProviderManager
  implements IVideoThumbProviderManager
{
  public static final float DEFAULT_HEIGHT = 53.0F;
  public static final float DEFAULT_WIDTH = 40.0F;
  private static int MAX_SIZE = 4096;
  private static final String TAG = "VideoThumbProviderManager";
  private static volatile VideoThumbProviderManager sInstance;
  private Bitmap mDefaultBitmap;
  private Handler mHandler;
  private int mHeight = ViewUtils.dip2px(53.0F);
  private LruCache<BaseVideoThumbAssetCache.LRUKey, Integer> mLruCache;
  private RunnableHandler mRunnableHandler = new VideoThumbProviderManager.2(this);
  private VideoThumbListener mSubVideoThumbListener = new VideoThumbProviderManager.1(this);
  private ArrayList<VideoThumbAssetProvider> mVideoThumbAssetProviders = new ArrayList();
  private ArrayList<VideoThumbListener> mVideoThumbListeners = new ArrayList();
  private int mWidth = ViewUtils.dip2px(40.0F);
  
  private VideoThumbProviderManager()
  {
    HandlerThread localHandlerThread = new HandlerThread("VideoThumbProviderManager", 0);
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    int j = MAX_SIZE;
    int i = j;
    if (!TextUtils.isEmpty("")) {}
    try
    {
      i = Integer.parseInt("");
      Logger.i("VideoThumbProviderManager", "maxSizeStr:" + "" + ",maxSize:" + i);
      this.mLruCache = new VideoThumbProviderManager.VideoThumbLruCache(this, i);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Logger.e("VideoThumbProviderManager", "constructor", localNumberFormatException);
        i = j;
      }
    }
  }
  
  private VideoThumbAssetProvider createProvider(TAVSource paramTAVSource, String paramString1, String paramString2)
  {
    if (paramTAVSource == null)
    {
      Logger.e("VideoThumbProviderManager", "assetPath is null");
      return null;
    }
    paramString2 = new VideoThumbAssetProvider(paramString2);
    paramString2.init(paramTAVSource, paramString1, this.mWidth, this.mHeight, this.mLruCache, this.mRunnableHandler);
    paramString2.setThumbListener(this.mSubVideoThumbListener);
    paramString2.setDefaultBitmap(this.mDefaultBitmap);
    return paramString2;
  }
  
  private VideoThumbAssetProvider findVideoThumbAssetProviderByAssetPath(String paramString, ArrayList<VideoThumbAssetProvider> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      VideoThumbAssetProvider localVideoThumbAssetProvider = (VideoThumbAssetProvider)paramArrayList.next();
      if (TextUtils.equals(paramString, localVideoThumbAssetProvider.getAssetId())) {
        return localVideoThumbAssetProvider;
      }
    }
    return null;
  }
  
  public static VideoThumbProviderManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new VideoThumbProviderManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void initLruCacheSize(int paramInt)
  {
    MAX_SIZE = paramInt;
  }
  
  private void releaseGroup(ArrayList<VideoThumbAssetProvider> paramArrayList, String paramString, List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      VideoThumbAssetProvider localVideoThumbAssetProvider = (VideoThumbAssetProvider)localIterator.next();
      if ((TextUtils.equals(localVideoThumbAssetProvider.getGroupId(), paramString)) && (!paramList.contains(localVideoThumbAssetProvider.getAssetId()))) {
        localArrayList.add(localVideoThumbAssetProvider);
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      paramList = (VideoThumbAssetProvider)paramString.next();
      paramArrayList.remove(paramList);
      paramList.release();
    }
  }
  
  private void resetProvider(TAVSource paramTAVSource, String paramString1, String paramString2)
  {
    Logger.i("VideoThumbProviderManager", "resetProvider start:" + paramString1);
    ArrayList localArrayList = new ArrayList();
    if (findVideoThumbAssetProviderByAssetPath(paramString1, this.mVideoThumbAssetProviders) != null) {
      Logger.i("VideoThumbProviderManager", "resetProvider find:" + paramString1);
    }
    for (;;)
    {
      localArrayList.add(paramString1);
      releaseGroup(this.mVideoThumbAssetProviders, paramString2, localArrayList);
      return;
      Logger.i("VideoThumbProviderManager", "resetProvider can't find:" + paramString1);
      if (paramTAVSource == null)
      {
        Logger.e("VideoThumbProviderManager", "assetPath is null");
        return;
      }
      paramTAVSource = createProvider(paramTAVSource, paramString1, paramString2);
      if (paramTAVSource == null)
      {
        Logger.e("VideoThumbProviderManager", "newProvider is null");
        return;
      }
      this.mVideoThumbAssetProviders.add(paramTAVSource);
    }
  }
  
  private void resetProvider(MediaResourceModel paramMediaResourceModel, String paramString)
  {
    if (paramMediaResourceModel == null)
    {
      Logger.e("VideoThumbProviderManager", "mediaResourceModel is null");
      return;
    }
    Logger.i("VideoThumbProviderManager", "resetProvider start");
    ArrayList localArrayList = new ArrayList();
    paramMediaResourceModel = paramMediaResourceModel.getVideos().iterator();
    if (paramMediaResourceModel.hasNext())
    {
      VideoResourceModel localVideoResourceModel = ((MediaClipModel)paramMediaResourceModel.next()).getResource();
      String str = localVideoResourceModel.getPath();
      if (findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders) == null)
      {
        Logger.i("VideoThumbProviderManager", "resetProvider can't find:" + str);
        VideoThumbAssetProvider localVideoThumbAssetProvider = new VideoThumbAssetProvider(paramString);
        localVideoThumbAssetProvider.init(localVideoResourceModel, this.mWidth, this.mHeight, this.mLruCache, this.mRunnableHandler);
        localVideoThumbAssetProvider.setThumbListener(this.mSubVideoThumbListener);
        localVideoThumbAssetProvider.setDefaultBitmap(this.mDefaultBitmap);
        this.mVideoThumbAssetProviders.add(localVideoThumbAssetProvider);
      }
      for (;;)
      {
        localArrayList.add(str);
        break;
        Logger.i("VideoThumbProviderManager", "resetProvider find:" + str);
      }
    }
    releaseGroup(this.mVideoThumbAssetProviders, paramString, localArrayList);
  }
  
  public boolean addProvider(TAVSource paramTAVSource, String paramString)
  {
    VideoThumbAssetProvider localVideoThumbAssetProvider = findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders);
    Logger.i("VideoThumbProviderManager", "addProvider:" + paramString);
    if (localVideoThumbAssetProvider == null)
    {
      Logger.i("VideoThumbProviderManager", "addProvider can't find:" + paramString);
      paramTAVSource = createProvider(paramTAVSource, paramString, "");
      if (paramTAVSource == null) {
        Logger.e("VideoThumbProviderManager", "newProvider is null");
      }
    }
    else
    {
      return false;
    }
    this.mVideoThumbAssetProviders.add(paramTAVSource);
    return true;
  }
  
  public boolean checkProviderIsExist(String paramString)
  {
    return findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders) != null;
  }
  
  public Bitmap getBitmapByTime(long paramLong, Object paramObject, String paramString)
  {
    if ((this.mHeight == 0) && (this.mWidth == 0)) {
      return this.mDefaultBitmap;
    }
    if (this.mVideoThumbAssetProviders.isEmpty()) {
      return this.mDefaultBitmap;
    }
    paramString = findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders);
    if (paramString == null) {
      return this.mDefaultBitmap;
    }
    return paramString.getAbsoluteBitmapByTime(paramLong, paramObject);
  }
  
  public long getCacheSize()
  {
    Iterator localIterator = this.mVideoThumbAssetProviders.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((VideoThumbAssetProvider)localIterator.next()).getCache() + l) {}
    return l;
  }
  
  public void initWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    Logger.i("VideoThumbProviderManager", "mWidth:" + this.mWidth + "mHeight:" + this.mHeight);
  }
  
  public void pause()
  {
    Iterator localIterator = this.mVideoThumbAssetProviders.iterator();
    while (localIterator.hasNext()) {
      ((VideoThumbAssetProvider)localIterator.next()).pause();
    }
    Logger.i("VideoThumbProviderManager", "pause");
  }
  
  public void registerListener(VideoThumbListener paramVideoThumbListener)
  {
    if (!this.mVideoThumbListeners.contains(paramVideoThumbListener))
    {
      this.mVideoThumbListeners.add(paramVideoThumbListener);
      Logger.i("VideoThumbProviderManager", "registerListener addSuccess");
    }
  }
  
  public void release(String paramString)
  {
    releaseGroup(this.mVideoThumbAssetProviders, paramString, new ArrayList());
    Logger.i("VideoThumbProviderManager", "release:" + paramString);
  }
  
  public void releaseBitmapCacheByKey(@NonNull BaseVideoThumbAssetCache.LRUKey paramLRUKey)
  {
    if (this.mLruCache != null) {
      this.mLruCache.remove(paramLRUKey);
    }
  }
  
  public void releaseProviderByAssetPath(String paramString)
  {
    Logger.i("VideoThumbProviderManager", "releaseProviderByAssetPath:" + paramString);
    paramString = findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders);
    if (paramString != null)
    {
      Logger.i("VideoThumbProviderManager", "releaseProviderByAssetPath success");
      this.mVideoThumbAssetProviders.remove(paramString);
      paramString.release();
    }
  }
  
  public void reset(TAVSource paramTAVSource, String paramString1, String paramString2)
  {
    if ((this.mWidth != 0) && (this.mHeight != 0)) {
      resetProvider(paramTAVSource, paramString1, paramString2);
    }
  }
  
  public void reset(MediaResourceModel paramMediaResourceModel, String paramString)
  {
    if ((this.mWidth != 0) && (this.mHeight != 0)) {
      resetProvider(paramMediaResourceModel, paramString);
    }
  }
  
  public void resume()
  {
    Iterator localIterator = this.mVideoThumbAssetProviders.iterator();
    while (localIterator.hasNext()) {
      ((VideoThumbAssetProvider)localIterator.next()).resume();
    }
    Logger.i("VideoThumbProviderManager", "resume");
  }
  
  public void setDefaultBitmap(Bitmap paramBitmap)
  {
    this.mDefaultBitmap = paramBitmap;
    Iterator localIterator = this.mVideoThumbAssetProviders.iterator();
    while (localIterator.hasNext()) {
      ((VideoThumbAssetProvider)localIterator.next()).setDefaultBitmap(paramBitmap);
    }
  }
  
  public void unRegisterListener(VideoThumbListener paramVideoThumbListener)
  {
    boolean bool = this.mVideoThumbListeners.remove(paramVideoThumbListener);
    Logger.i("VideoThumbProviderManager", "unRegisterListener removeSuccess:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager
 * JD-Core Version:    0.7.0.1
 */