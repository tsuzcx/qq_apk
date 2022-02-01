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
    Object localObject;
    if (this.d == null)
    {
      f.a(true).a(this.a, false, false, null);
      localObject = f.a(true).a();
      if (localObject != null)
      {
        localObject = ((v)localObject).b();
        if (localObject == null) {
          break label119;
        }
        this.d = new r((DexLoader)localObject);
      }
    }
    else
    {
      label54:
      if (this.d == null) {
        break label136;
      }
      this.g = this.d.a(this.a, this, paramBundle);
      if (this.g == null) {
        this.b.onVideoDownloadError(this, -1, "init task error!", null);
      }
    }
    label119:
    while (this.b == null)
    {
      return;
      this.b.onVideoDownloadError(this, -1, "init engine error!", null);
      localObject = null;
      break;
      this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
      break label54;
    }
    label136:
    this.b.onVideoDownloadError(this, -1, "init error!", null);
  }
  
  public long getContentLength()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.d();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.e();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public int getProgress()
  {
    if ((this.d != null) && (this.g != null)) {
      return this.d.f();
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
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
    if ((this.d != null) && (this.g != null)) {
      this.d.a();
    }
    while (this.b == null) {
      return;
    }
    this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
  }
  
  public void removeTask(boolean paramBoolean)
  {
    if ((this.d != null) && (this.g != null)) {
      this.d.a(paramBoolean);
    }
    while (this.b == null) {
      return;
    }
    this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
  }
  
  public void resumeTask()
  {
    if ((this.d != null) && (this.g != null)) {
      this.d.b();
    }
    while (this.b == null) {
      return;
    }
    this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
  }
  
  public void stopTask()
  {
    if ((this.d != null) && (this.g != null)) {
      this.d.c();
    }
    while (this.b == null) {
      return;
    }
    this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheTask
 * JD-Core Version:    0.7.0.1
 */