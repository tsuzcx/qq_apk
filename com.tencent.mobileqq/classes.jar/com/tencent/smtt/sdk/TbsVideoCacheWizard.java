package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

class TbsVideoCacheWizard
{
  private static final String TBS_VIDEO_CACHE_CLASS_NAME = "com.tencent.tbs.cache.TbsVideoCacheTaskProxy";
  private DexLoader mDexLoader = null;
  private Object mTbsCacheWorker = null;
  
  public TbsVideoCacheWizard(DexLoader paramDexLoader)
  {
    this.mDexLoader = paramDexLoader;
  }
  
  public Object createTbsVideoCacheWorker(Context paramContext, Object paramObject, Bundle paramBundle)
  {
    if (this.mDexLoader != null) {
      this.mTbsCacheWorker = this.mDexLoader.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[] { Context.class, Object.class, Bundle.class }, new Object[] { paramContext, paramObject, paramBundle });
    }
    return this.mTbsCacheWorker;
  }
  
  public long getContentLength()
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
      if ((localObject instanceof Long)) {
        return ((Long)localObject).longValue();
      }
    }
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
      if ((localObject instanceof Integer)) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0;
  }
  
  public int getProgress()
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
      if ((localObject instanceof Integer)) {
        return ((Integer)localObject).intValue();
      }
    }
    return 0;
  }
  
  public void pauseTask()
  {
    if (this.mDexLoader != null) {
      this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
    }
  }
  
  public void removeTask(boolean paramBoolean)
  {
    if (this.mDexLoader != null) {
      this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void resumeTask()
  {
    if (this.mDexLoader != null) {
      this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
    }
  }
  
  public void stopTask()
  {
    if (this.mDexLoader != null) {
      this.mDexLoader.invokeMethod(this.mTbsCacheWorker, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheWizard
 * JD-Core Version:    0.7.0.1
 */