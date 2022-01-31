package com.tencent.tmediacodec.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/callback/CodecCallback;", "", "onCreate", "", "isReUse", "", "onRealRelease", "onReuseCodecAPIException", "msg", "", "e", "", "onTransToKeepPool", "onTransToRunningPool", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public abstract interface CodecCallback
{
  public abstract void onCreate(boolean paramBoolean);
  
  public abstract void onRealRelease();
  
  public abstract void onReuseCodecAPIException(@NotNull String paramString, @NotNull Throwable paramThrowable);
  
  public abstract void onTransToKeepPool();
  
  public abstract void onTransToRunningPool();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.callback.CodecCallback
 * JD-Core Version:    0.7.0.1
 */