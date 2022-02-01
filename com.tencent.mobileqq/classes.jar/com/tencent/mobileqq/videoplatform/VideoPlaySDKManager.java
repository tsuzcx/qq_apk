package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlaySDKManager
{
  public static final int BIZID = 20160518;
  public static final int ERR_CODE_FILE_EXPIRED = 14011001;
  public static final int ERR_VIDEO_FILE_DAMAGED = 11022003;
  private static final int PLATFORM_ID = 170303;
  private static final String TAG = "[VideoPlatForm]VideoPlaySDKManager";
  private static volatile VideoPlaySDKManager mInstance;
  private boolean mIsSoLoadSuc;
  private CopyOnWriteArraySet<SDKInitListener> mSDKInstalledListenerSet = new CopyOnWriteArraySet();
  private AtomicInteger mState = new AtomicInteger(0);
  
  private ITPModuleLoader buildLoader()
  {
    return new VideoPlaySDKManager.3(this);
  }
  
  private SuperPlayerSDKMgr.ILogListener buildLogListener()
  {
    return new VideoPlaySDKManager.2(this);
  }
  
  public static VideoPlaySDKManager getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new VideoPlaySDKManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private void initSDK(Context paramContext, SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SuperPlayerSDKMgr.setLibLoader(buildLoader());
    }
    catch (Exception localException)
    {
      LogUtil.e("[VideoPlatForm]VideoPlaySDKManager", 1, "setLibLoader err.", localException);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getApplicationContext().getExternalCacheDir());
    localStringBuilder.append("/superplayer");
    SuperPlayerSDKMgr.initSDK(paramContext, 170303, localStringBuilder.toString(), paramSuperPlayerSdkOption);
    SuperPlayerSDKMgr.setOnLogListener(buildLogListener());
  }
  
  public void addSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    if (paramSDKInitListener != null) {
      this.mSDKInstalledListenerSet.add(paramSDKInitListener);
    }
  }
  
  public void initSDKAsync(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    try
    {
      initSDKAsync(paramContext, SuperPlayerSdkOption.option(), paramSDKInitListener);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void initSDKAsync(Context paramContext, SuperPlayerSdkOption paramSuperPlayerSdkOption, SDKInitListener paramSDKInitListener)
  {
    try
    {
      addSDKInstalledListener(paramSDKInitListener);
      if ((this.mState.get() != 1) && ((this.mState.get() != 2) || (!isSoLoadSuc())))
      {
        this.mState.set(1);
        LoadSoUtil.loadSo(new VideoPlaySDKManager.1(this, paramContext, paramSuperPlayerSdkOption));
        return;
      }
      if (LogUtil.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("initSDKAsync, mState.get() = ");
        paramContext.append(this.mState.get());
        paramContext.append(" , sdk is initing or has succeed ,return.");
        LogUtil.d("[VideoPlatForm]VideoPlaySDKManager", 2, paramContext.toString());
      }
      return;
    }
    finally {}
  }
  
  public boolean isSDKReady()
  {
    try
    {
      int i = this.mState.get();
      boolean bool;
      if (i == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSoLoadSuc()
  {
    return this.mIsSoLoadSuc;
  }
  
  public void removeSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    this.mSDKInstalledListenerSet.remove(paramSDKInitListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */