package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask
{
  public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
  public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
  public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
  public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
  Context a = null;
  TbsVideoCacheListener b = null;
  private boolean c = false;
  private r d = null;
  private String e;
  private String f;
  private Object g = null;
  
  public TbsVideoCacheTask(Context paramContext, Bundle paramBundle, TbsVideoCacheListener paramTbsVideoCacheListener)
  {
    this.a = paramContext;
    this.b = paramTbsVideoCacheListener;
    if (paramBundle != null)
    {
      this.e = paramBundle.getString("taskId");
      this.f = paramBundle.getString("url");
    }
    a(paramBundle);
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.d == null)
    {
      f.a(true).a(this.a, false, false, null);
      localObject = f.a(true).a();
      if (localObject != null)
      {
        localObject = ((v)localObject).b();
      }
      else
      {
        this.b.onVideoDownloadError(this, -1, "init engine error!", null);
        localObject = null;
      }
      if (localObject != null) {
        this.d = new r((DexLoader)localObject);
      } else {
        this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
      }
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      this.g = ((r)localObject).a(this.a, this, paramBundle);
      if (this.g != null) {
        return;
      }
      localObject = this.b;
      paramBundle = "init task error!";
    }
    else
    {
      localObject = this.b;
      if (localObject == null) {
        return;
      }
      paramBundle = "init error!";
    }
    ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, paramBundle, null);
  }
  
  public long getContentLength()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null)) {
      return ((r)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null)) {
      return ((r)localObject).e();
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public int getProgress()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null)) {
      return ((r)localObject).f();
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public String getTaskID()
  {
    return this.e;
  }
  
  public String getTaskUrl()
  {
    return this.f;
  }
  
  public void pauseTask()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null))
    {
      ((r)localObject).a();
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
    }
  }
  
  public void removeTask(boolean paramBoolean)
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null))
    {
      ((r)localObject).a(paramBoolean);
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
    }
  }
  
  public void resumeTask()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null))
    {
      ((r)localObject).b();
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
    }
  }
  
  public void stopTask()
  {
    Object localObject = this.d;
    if ((localObject != null) && (this.g != null))
    {
      ((r)localObject).c();
      return;
    }
    localObject = this.b;
    if (localObject != null) {
      ((TbsVideoCacheListener)localObject).onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheTask
 * JD-Core Version:    0.7.0.1
 */