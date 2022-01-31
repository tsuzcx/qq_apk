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
  static final String TAG = "TbsVideoCacheTask";
  Context mContext = null;
  private String mCurrentTaskID;
  private String mCurrentTaskUrl;
  private Object mDownloadWorker = null;
  private boolean mHasInit = false;
  private TbsVideoCacheWizard mWizard = null;
  TbsVideoCacheListener taskListener = null;
  
  public TbsVideoCacheTask(Context paramContext, Bundle paramBundle, TbsVideoCacheListener paramTbsVideoCacheListener)
  {
    this.mContext = paramContext;
    this.taskListener = paramTbsVideoCacheListener;
    if (paramBundle != null)
    {
      this.mCurrentTaskID = paramBundle.getString("taskId");
      this.mCurrentTaskUrl = paramBundle.getString("url");
    }
    initWizard(paramBundle);
  }
  
  private void initWizard(Bundle paramBundle)
  {
    Object localObject;
    if (this.mWizard == null)
    {
      SDKEngine.getInstance(true).init(this.mContext, false, false, null);
      localObject = SDKEngine.getInstance(true).wizard();
      if (localObject != null)
      {
        localObject = ((TbsWizard)localObject).dexLoader();
        if (localObject == null) {
          break label119;
        }
        this.mWizard = new TbsVideoCacheWizard((DexLoader)localObject);
      }
    }
    else
    {
      label54:
      if (this.mWizard == null) {
        break label136;
      }
      this.mDownloadWorker = this.mWizard.createTbsVideoCacheWorker(this.mContext, this, paramBundle);
      if (this.mDownloadWorker == null) {
        this.taskListener.onVideoDownloadError(this, -1, "init task error!", null);
      }
    }
    label119:
    while (this.taskListener == null)
    {
      return;
      this.taskListener.onVideoDownloadError(this, -1, "init engine error!", null);
      localObject = null;
      break;
      this.taskListener.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
      break label54;
    }
    label136:
    this.taskListener.onVideoDownloadError(this, -1, "init error!", null);
  }
  
  public long getContentLength()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      return this.mWizard.getContentLength();
    }
    if (this.taskListener != null) {
      this.taskListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      return this.mWizard.getDownloadedSize();
    }
    if (this.taskListener != null) {
      this.taskListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public int getProgress()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      return this.mWizard.getProgress();
    }
    if (this.taskListener != null) {
      this.taskListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
    }
    return 0;
  }
  
  public String getTaskID()
  {
    return this.mCurrentTaskID;
  }
  
  public String getTaskUrl()
  {
    return this.mCurrentTaskUrl;
  }
  
  void onCacheComplete(Bundle paramBundle)
  {
    if ((this.taskListener != null) && (paramBundle != null))
    {
      long l1 = paramBundle.getLong("loadedBytes");
      long l2 = paramBundle.getLong("totalBytes");
      paramBundle = paramBundle.getString("taskFileName");
      Bundle localBundle = new Bundle();
      localBundle.putString("taskId", getTaskID());
      localBundle.putString("taskFileName", paramBundle);
      this.taskListener.onVideoDownloadCompletion(this, l1, l2, localBundle);
    }
  }
  
  void onCacheError(Bundle paramBundle)
  {
    if ((this.taskListener != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("errorCode");
      String str = paramBundle.getString("msg");
      Bundle localBundle = paramBundle.getBundle("extra");
      paramBundle = localBundle;
      if (localBundle == null) {
        paramBundle = new Bundle();
      }
      paramBundle.putString("taskId", getTaskID());
      this.taskListener.onVideoDownloadError(this, i, str, paramBundle);
    }
  }
  
  void onCacheInit(Bundle paramBundle)
  {
    if ((this.taskListener != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("errorCode");
      String str = paramBundle.getString("msg");
      Bundle localBundle = paramBundle.getBundle("extra");
      paramBundle = localBundle;
      if (localBundle == null) {
        paramBundle = new Bundle();
      }
      paramBundle.putString("taskId", getTaskID());
      this.taskListener.onVideoDownloadInit(this, i, str, paramBundle);
      this.mHasInit = true;
    }
  }
  
  void onCacheProgress(Bundle paramBundle)
  {
    if ((this.mHasInit) && (this.taskListener != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("percent");
      long l = paramBundle.getLong("downloadedSize");
      int j = paramBundle.getInt("bufferPercent");
      Bundle localBundle = paramBundle.getBundle("extra");
      paramBundle = localBundle;
      if (localBundle == null) {
        paramBundle = new Bundle();
      }
      paramBundle.putString("taskId", getTaskID());
      this.taskListener.onVideoDownloadProgress(this, i, l, j, paramBundle);
    }
  }
  
  void onCacheStart(Bundle paramBundle)
  {
    if ((this.taskListener != null) && (paramBundle != null))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putString("taskId", getTaskID());
      this.taskListener.onVideoDownloadStart(this, localBundle);
    }
  }
  
  public void pauseTask()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      this.mWizard.pauseTask();
    }
    while (this.taskListener == null) {
      return;
    }
    this.taskListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
  }
  
  public void removeTask(boolean paramBoolean)
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      this.mWizard.removeTask(paramBoolean);
    }
    while (this.taskListener == null) {
      return;
    }
    this.taskListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
  }
  
  public void resumeTask()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      this.mWizard.resumeTask();
    }
    while (this.taskListener == null) {
      return;
    }
    this.taskListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
  }
  
  public void stopTask()
  {
    if ((this.mWizard != null) && (this.mDownloadWorker != null)) {
      this.mWizard.stopTask();
    }
    while (this.taskListener == null) {
      return;
    }
    this.taskListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheTask
 * JD-Core Version:    0.7.0.1
 */