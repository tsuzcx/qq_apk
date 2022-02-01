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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("runningPool:");
    localStringBuilder.append(this.mRunningCodecPool);
    localStringBuilder.append(" keepPool:");
    localStringBuilder.append(this.mKeepCodecPool);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper paramFormatWrapper)
  {
    paramFormatWrapper = this.mKeepCodecPool.obtain(paramFormatWrapper);
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("obtainCodecWrapper codecWrapper:");
      localStringBuilder.append(paramFormatWrapper);
      LogUtils.d("CodecWrapperManager", localStringBuilder.toString());
    }
    return paramFormatWrapper;
  }
  
  public void removeFromRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeFromRunning codecWrapper:");
      localStringBuilder.append(paramReuseCodecWrapper);
      LogUtils.d("CodecWrapperManager", localStringBuilder.toString());
    }
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
  }
  
  public void transToRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transToRunning codecWrapper:");
      localStringBuilder.append(paramReuseCodecWrapper);
      LogUtils.d("CodecWrapperManager", localStringBuilder.toString());
    }
    this.mKeepCodecPool.remove(paramReuseCodecWrapper);
    this.mRunningCodecPool.put(paramReuseCodecWrapper);
    ThreadManager.postOnSubThread(new CodecWrapperManager.1(this, paramReuseCodecWrapper));
  }
  
  public void transTokeep(@NonNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    if (LogUtils.isLogEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transTokeep codecWrapper:");
      localStringBuilder.append(paramReuseCodecWrapper);
      LogUtils.d("CodecWrapperManager", localStringBuilder.toString());
    }
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
    this.mKeepCodecPool.put(paramReuseCodecWrapper);
    paramReuseCodecWrapper = paramReuseCodecWrapper.getCallback();
    if (paramReuseCodecWrapper != null) {
      paramReuseCodecWrapper.onTransToKeepPool();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager
 * JD-Core Version:    0.7.0.1
 */