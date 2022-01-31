package com.tencent.tmediacodec.pools;

import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import com.tencent.tmediacodec.util.LogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/pools/CodecWrapperManager;", "Lcom/tencent/tmediacodec/pools/CodecWrapperTransformation;", "()V", "mKeepCodecPool", "Lcom/tencent/tmediacodec/pools/CodecWrapperPool;", "mRunningCodecPool", "clearAndReleaseAll", "", "getDumpInfo", "", "obtainCodecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "format", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "removeFromRunning", "codecWrapper", "transToRunning", "transTokeep", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class CodecWrapperManager
  implements CodecWrapperTransformation
{
  public static final CodecWrapperManager.Companion Companion = new CodecWrapperManager.Companion(null);
  @NotNull
  public static final String TAG = "CodecWrapperManager";
  private final CodecWrapperPool mKeepCodecPool = new CodecWrapperPool(2);
  private final CodecWrapperPool mRunningCodecPool = new CodecWrapperPool(2147483647);
  
  public CodecWrapperManager()
  {
    this.mKeepCodecPool.setActionCallback((PoolActionCallback)new CodecWrapperManager.1());
  }
  
  public void clearAndReleaseAll()
  {
    LogUtils.INSTANCE.i("CodecWrapperManager", "clearAndReleaseAll");
    this.mRunningCodecPool.clear();
    this.mKeepCodecPool.clear();
  }
  
  @NotNull
  public final String getDumpInfo()
  {
    return "runningPool:" + this.mRunningCodecPool + " keepPool:" + this.mKeepCodecPool;
  }
  
  @Nullable
  public ReuseCodecWrapper obtainCodecWrapper(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "format");
    paramFormatWrapper = this.mKeepCodecPool.obtain(paramFormatWrapper);
    LogUtils.INSTANCE.d("CodecWrapperManager", "obtainCodecWrapper codecWrapper:" + paramFormatWrapper);
    return paramFormatWrapper;
  }
  
  public void removeFromRunning(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    LogUtils.INSTANCE.d("CodecWrapperManager", "removeFromRunning codecWrapper:" + paramReuseCodecWrapper);
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
  }
  
  public void transToRunning(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    LogUtils.INSTANCE.d("CodecWrapperManager", "transToRunning codecWrapper:" + paramReuseCodecWrapper);
    this.mKeepCodecPool.remove(paramReuseCodecWrapper);
    this.mRunningCodecPool.put(paramReuseCodecWrapper);
    paramReuseCodecWrapper = paramReuseCodecWrapper.getCallback();
    if (paramReuseCodecWrapper != null) {
      paramReuseCodecWrapper.onTransToRunningPool();
    }
  }
  
  public void transTokeep(@NotNull ReuseCodecWrapper paramReuseCodecWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    LogUtils.INSTANCE.d("CodecWrapperManager", "transTokeep codecWrapper:" + paramReuseCodecWrapper);
    this.mRunningCodecPool.remove(paramReuseCodecWrapper);
    this.mKeepCodecPool.put(paramReuseCodecWrapper);
    paramReuseCodecWrapper = paramReuseCodecWrapper.getCallback();
    if (paramReuseCodecWrapper != null) {
      paramReuseCodecWrapper.onTransToKeepPool();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperManager
 * JD-Core Version:    0.7.0.1
 */