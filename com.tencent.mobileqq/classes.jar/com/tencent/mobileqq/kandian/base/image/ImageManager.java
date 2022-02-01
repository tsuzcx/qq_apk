package com.tencent.mobileqq.kandian.base.image;

import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptLinkedBlockingDeque;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.image.imageloader.Utils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class ImageManager
  implements IImageManager
{
  public static final String TAG;
  public static final String TAG_PREFIX = "zimage.";
  private static ImageManager sIns;
  IBitmapCache mBitmapCache;
  ThreadPoolExecutor mExcutor;
  CopyOnWriteArrayList<ImageRequest> mExecutingJobs = new CopyOnWriteArrayList();
  private ConcurrentHashMap<ImageRequest, Boolean> mFinishedPreloadJobs = new ConcurrentHashMap();
  AtomicBoolean mIsPaused = new AtomicBoolean(false);
  ConcurrentHashMap<ImageRequest, RunningJob> mPendingjobs = new ConcurrentHashMap();
  ConcurrentHashMap<ImageRequest, RunningJob> mRunningJobs = new ConcurrentHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(ImageManager.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  private ImageManager()
  {
    Object localObject2;
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      try
      {
        GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evict(0);
      }
      catch (Exception localException)
      {
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ImageManager] e = ");
        localStringBuilder.append(localException);
        QLog.e((String)localObject2, 1, localStringBuilder.toString());
      }
      i = GlobalImageCache.jdField_a_of_type_Int * 2 / 3;
    }
    else
    {
      int j = (int)(MemoryManager.a() / 10L);
      i = 4194304;
      if (j > 4194304) {
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("start memLimit:");
      ((StringBuilder)localObject2).append(i);
      Utils.a((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    this.mBitmapCache = ((IBitmapCache)QRoute.api(IBitmapCache.class));
    Object localObject1 = new ThreadPoolParams();
    ((ThreadPoolParams)localObject1).poolThreadName = "image-manager";
    ((ThreadPoolParams)localObject1).corePoolsize = 4;
    ((ThreadPoolParams)localObject1).maxPooolSize = 8;
    ((ThreadPoolParams)localObject1).priority = 3;
    if (RIJImageOptConfig.INSTANCE.isLifoOn()) {
      ((ThreadPoolParams)localObject1).queue = new RIJImageOptLinkedBlockingDeque(128);
    }
    this.mExcutor = ((ThreadPoolExecutor)ThreadManager.newFreeThreadPool((ThreadPoolParams)localObject1));
  }
  
  public static ImageManager get()
  {
    if (sIns == null) {
      try
      {
        if (sIns == null) {
          sIns = new ImageManager();
        }
      }
      finally {}
    }
    return sIns;
  }
  
  public void cancelRequest(ImageRequest paramImageRequest, String paramString)
  {
    try
    {
      paramString = (RunningJob)this.mRunningJobs.remove(paramImageRequest);
      if (paramString != null)
      {
        paramString.a();
        this.mExcutor.remove(paramString);
      }
      else
      {
        paramImageRequest = (RunningJob)this.mPendingjobs.remove(paramImageRequest);
        if (paramImageRequest != null) {
          paramImageRequest.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void clean()
  {
    try
    {
      if (QLog.isColorLevel()) {
        Utils.a(TAG, "clean");
      }
      this.mBitmapCache.clean();
      Iterator localIterator = this.mRunningJobs.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((RunningJob)((Map.Entry)localIterator.next()).getValue()).a();
      }
      this.mRunningJobs.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public ICloseableBitmap getBitmap(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return null;
    }
    return this.mBitmapCache.getBitmap(paramImageRequest);
  }
  
  public CopyOnWriteArrayList<ImageRequest> getExecutingJobs()
  {
    return this.mExecutingJobs;
  }
  
  public boolean isLocalFileExist(URL paramURL)
  {
    return (paramURL != null) && (AbsDownloader.getFile(paramURL.toString()) != null);
  }
  
  public void loadImage(ImageRequest paramImageRequest, IBitmapCallback paramIBitmapCallback)
  {
    if (paramImageRequest != null) {}
    try
    {
      if (paramImageRequest.a != null)
      {
        Object localObject1 = this.mBitmapCache.getBitmap(paramImageRequest);
        StringBuilder localStringBuilder;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadImage request:");
            localStringBuilder.append(paramImageRequest);
            localStringBuilder.append(", cache bitmap exist! callback:");
            localStringBuilder.append(paramIBitmapCallback);
            Utils.a((String)localObject2, localStringBuilder.toString());
          }
          RIJImageOptReport.b(1, paramImageRequest);
          if (paramIBitmapCallback != null) {
            paramIBitmapCallback.a(paramImageRequest, ((ICloseableBitmap)localObject1).a());
          }
          ((ICloseableBitmap)localObject1).a();
          RIJImageOptReport.a(6, paramImageRequest);
          return;
        }
        if ((paramImageRequest.b) && (this.mFinishedPreloadJobs.containsKey(paramImageRequest)))
        {
          RIJImageOptReport.a(6, paramImageRequest);
          return;
        }
        Object localObject2 = (RunningJob)this.mRunningJobs.get(paramImageRequest);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (this.mIsPaused.get()) {
            localObject1 = (RunningJob)this.mPendingjobs.get(paramImageRequest);
          }
        }
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("loadImage request:");
            localStringBuilder.append(paramImageRequest);
            localStringBuilder.append(" already exist");
            Utils.a((String)localObject2, localStringBuilder.toString(), true);
          }
          ((RunningJob)localObject1).a(paramIBitmapCallback);
          paramImageRequest.e = 0;
          RIJImageOptReport.a(6, paramImageRequest);
        }
        else
        {
          localObject1 = new RunningJob(this, paramImageRequest);
          ((RunningJob)localObject1).a(paramIBitmapCallback);
          if ((this.mIsPaused.get()) && (AbsDownloader.getFile(paramImageRequest.a.toString()) == null))
          {
            this.mPendingjobs.put(paramImageRequest, localObject1);
            if (QLog.isColorLevel())
            {
              paramIBitmapCallback = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("loadImage request:");
              ((StringBuilder)localObject1).append(paramImageRequest);
              ((StringBuilder)localObject1).append(" add to pending queue");
              Utils.a(paramIBitmapCallback, ((StringBuilder)localObject1).toString(), true);
            }
          }
          else
          {
            this.mRunningJobs.put(paramImageRequest, localObject1);
            RIJImageOptReport.a(2, paramImageRequest);
            ThreadManager.post(new ImageManager.1(this, paramImageRequest, (RunningJob)localObject1), 10, null, true);
          }
        }
        return;
      }
      RIJImageOptReport.a(6, paramImageRequest);
      return;
    }
    finally {}
  }
  
  public void pauseDownload()
  {
    if (this.mIsPaused.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      Utils.a(TAG, "pause", true);
    }
    this.mIsPaused.set(true);
  }
  
  public void putExecuteJob(ImageRequest paramImageRequest)
  {
    this.mExecutingJobs.add(paramImageRequest);
  }
  
  public void removeExecuteJob(ImageRequest paramImageRequest)
  {
    this.mExecutingJobs.remove(paramImageRequest);
  }
  
  void removeJob(ImageRequest paramImageRequest)
  {
    try
    {
      if (paramImageRequest.b) {
        this.mFinishedPreloadJobs.put(paramImageRequest, Boolean.valueOf(true));
      }
      this.mRunningJobs.remove(paramImageRequest);
      this.mPendingjobs.remove(paramImageRequest);
      return;
    }
    finally {}
  }
  
  public void resume()
  {
    if (!this.mIsPaused.get()) {
      return;
    }
    if (QLog.isColorLevel()) {
      Utils.a(TAG, "resume", true);
    }
    this.mIsPaused.set(false);
    try
    {
      Iterator localIterator = this.mPendingjobs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.mRunningJobs.put(localEntry.getKey(), localEntry.getValue());
        this.mExcutor.execute((Runnable)localEntry.getValue());
      }
      this.mPendingjobs.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.ImageManager
 * JD-Core Version:    0.7.0.1
 */