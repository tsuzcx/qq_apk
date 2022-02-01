package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavsticker.utils.ViewUtils;
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
    if (!TextUtils.isEmpty("")) {
      try
      {
        i = Integer.parseInt("");
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Logger.e("VideoThumbProviderManager", "constructor", localNumberFormatException);
        i = j;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxSizeStr:");
    localStringBuilder.append("");
    localStringBuilder.append(",maxSize:");
    localStringBuilder.append(i);
    Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
    this.mLruCache = new VideoThumbProviderManager.VideoThumbLruCache(this, i);
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new VideoThumbProviderManager();
        }
      }
      finally {}
    }
    return sInstance;
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
    while (paramMediaResourceModel.hasNext())
    {
      Object localObject1 = ((MediaClipModel)paramMediaResourceModel.next()).getResource();
      String str = ((VideoResourceModel)localObject1).getPath();
      if (findVideoThumbAssetProviderByAssetPath(str, this.mVideoThumbAssetProviders) == null)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("resetProvider can't find:");
        ((StringBuilder)localObject2).append(str);
        Logger.i("VideoThumbProviderManager", ((StringBuilder)localObject2).toString());
        localObject2 = new VideoThumbAssetProvider(paramString);
        ((VideoThumbAssetProvider)localObject2).init((VideoResourceModel)localObject1, this.mWidth, this.mHeight, this.mLruCache, this.mRunnableHandler);
        ((VideoThumbAssetProvider)localObject2).setThumbListener(this.mSubVideoThumbListener);
        ((VideoThumbAssetProvider)localObject2).setDefaultBitmap(this.mDefaultBitmap);
        this.mVideoThumbAssetProviders.add(localObject2);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("resetProvider find:");
        ((StringBuilder)localObject1).append(str);
        Logger.i("VideoThumbProviderManager", ((StringBuilder)localObject1).toString());
      }
      localArrayList.add(str);
    }
    releaseGroup(this.mVideoThumbAssetProviders, paramString, localArrayList);
  }
  
  private void resetProvider(TAVSource paramTAVSource, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resetProvider start:");
    ((StringBuilder)localObject).append(paramString1);
    Logger.i("VideoThumbProviderManager", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    if (findVideoThumbAssetProviderByAssetPath(paramString1, this.mVideoThumbAssetProviders) != null)
    {
      paramTAVSource = new StringBuilder();
      paramTAVSource.append("resetProvider find:");
      paramTAVSource.append(paramString1);
      Logger.i("VideoThumbProviderManager", paramTAVSource.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetProvider can't find:");
      localStringBuilder.append(paramString1);
      Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
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
    ((ArrayList)localObject).add(paramString1);
    releaseGroup(this.mVideoThumbAssetProviders, paramString2, (List)localObject);
  }
  
  public boolean addProvider(TAVSource paramTAVSource, String paramString)
  {
    Object localObject = findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addProvider:");
    localStringBuilder.append(paramString);
    Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
    boolean bool = false;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addProvider can't find:");
      ((StringBuilder)localObject).append(paramString);
      Logger.i("VideoThumbProviderManager", ((StringBuilder)localObject).toString());
      paramTAVSource = createProvider(paramTAVSource, paramString, "");
      if (paramTAVSource == null)
      {
        Logger.e("VideoThumbProviderManager", "newProvider is null");
        return false;
      }
      bool = true;
      this.mVideoThumbAssetProviders.add(paramTAVSource);
    }
    return bool;
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
    for (long l = 0L; localIterator.hasNext(); l += ((VideoThumbAssetProvider)localIterator.next()).getCache()) {}
    return l;
  }
  
  public void initWidthAndHeight(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mWidth:");
    localStringBuilder.append(this.mWidth);
    localStringBuilder.append("mHeight:");
    localStringBuilder.append(this.mHeight);
    Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release:");
    localStringBuilder.append(paramString);
    Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
  }
  
  public void releaseBitmapCacheByKey(@NonNull BaseVideoThumbAssetCache.LRUKey paramLRUKey)
  {
    LruCache localLruCache = this.mLruCache;
    if (localLruCache != null) {
      localLruCache.remove(paramLRUKey);
    }
  }
  
  public void releaseProviderByAssetPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("releaseProviderByAssetPath:");
    localStringBuilder.append(paramString);
    Logger.i("VideoThumbProviderManager", localStringBuilder.toString());
    paramString = findVideoThumbAssetProviderByAssetPath(paramString, this.mVideoThumbAssetProviders);
    if (paramString != null)
    {
      Logger.i("VideoThumbProviderManager", "releaseProviderByAssetPath success");
      this.mVideoThumbAssetProviders.remove(paramString);
      paramString.release();
    }
  }
  
  public void reset(MediaResourceModel paramMediaResourceModel, String paramString)
  {
    if ((this.mWidth != 0) && (this.mHeight != 0)) {
      resetProvider(paramMediaResourceModel, paramString);
    }
  }
  
  public void reset(TAVSource paramTAVSource, String paramString1, String paramString2)
  {
    if ((this.mWidth != 0) && (this.mHeight != 0)) {
      resetProvider(paramTAVSource, paramString1, paramString2);
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
    paramVideoThumbListener = new StringBuilder();
    paramVideoThumbListener.append("unRegisterListener removeSuccess:");
    paramVideoThumbListener.append(bool);
    Logger.i("VideoThumbProviderManager", paramVideoThumbListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbProviderManager
 * JD-Core Version:    0.7.0.1
 */