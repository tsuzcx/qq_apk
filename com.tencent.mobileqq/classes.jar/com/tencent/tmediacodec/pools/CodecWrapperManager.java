package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.ThreadManager;

public final class CodecWrapperManager
  implements CodecWrapperTransformation
{
  public static final String TAG = "CodecWrapperManager";
  private final CodecWrapperPool mKeepCodecPool = new CodecWrapperPool(2, "keep");
  private final CodecWrapperPool mRunningCodecPool = new CodecWrapperPool(2147483647, "running");
  
  public CodecWrapperManager()
  {
    this.mKeepCodecPool.setActionCallback(new CodecWrapperManager.2(this));
  }
  
  public void clearAndReleaseAll()
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.i("CodecWrapperManager", "clearAndReleaseAll");
    }
    this.mRunningCodecPool.clear();
    this.mKeepCodecPool.clear();
  }
  
  @NonNull
  public final String getDumpInfo()
  {
    return "runningPool:" + this.mRunningCodecPool + " keepPool:" + this.mKeepCodecPool;
  }
  
  @Nullable
  public ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper paramFormatWrapper)
  {
    paramFormatWrapper = this.mKeepCodecPool.obtain(paramFormatWrapper);
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperManager", "obtainCodecWrapper codecWrapper:" + paramFormatWrapper);
    }
    return paramFormatWrapper;
  }
  
  public void removeFromRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperManager", "removeFromRunning codecWrapper:" + paramReuseCodecWrapper);
    }
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
  }
  
  public void transToRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperManager", "transToRunning codecWrapper:" + paramReuseCodecWrapper);
    }
    this.mKeepCodecPool.remove(paramReuseCodecWrapper);
    this.mRunningCodecPool.put(paramReuseCodecWrapper);
    ThreadManager.postOnSubThread(new CodecWrapperManager.1(this, paramReuseCodecWrapper));
  }
  
  public void transTokeep(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable()) {
      LogUtils.d("CodecWrapperManager", "transTokeep codecWrapper:" + paramReuseCodecWrapper);
    }
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
    this.mKeepCodecPool.put(paramReuseCodecWrapper);
    paramReuseCodecWrapper = paramReuseCodecWrapper.getCallback();
    if (paramReuseCodecWrapper != null) {
      paramReuseCodecWrapper.onTransToKeepPool();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager
 * JD-Core Version:    0.7.0.1
 */