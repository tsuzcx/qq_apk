package com.tencent.tmediacodec.callback;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/callback/SimpleCodecCallback;", "Lcom/tencent/tmediacodec/callback/CodecCallback;", "()V", "onCreate", "", "isReUse", "", "onRealRelease", "onReuseCodecAPIException", "msg", "", "e", "", "onTransToKeepPool", "onTransToRunningPool", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public class SimpleCodecCallback
  implements CodecCallback
{
  public void onCreate(boolean paramBoolean) {}
  
  public void onRealRelease() {}
  
  public void onReuseCodecAPIException(@NotNull String paramString, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "e");
  }
  
  public void onTransToKeepPool() {}
  
  public void onTransToRunningPool() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.callback.SimpleCodecCallback
 * JD-Core Version:    0.7.0.1
 */