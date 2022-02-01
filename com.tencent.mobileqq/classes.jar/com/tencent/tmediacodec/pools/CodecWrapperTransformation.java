package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;

public abstract interface CodecWrapperTransformation
{
  public abstract void clearAndReleaseAll();
  
  @Nullable
  public abstract ReuseCodecWrapper obtainCodecWrapper(@NonNull FormatWrapper paramFormatWrapper);
  
  public abstract void removeFromRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper);
  
  public abstract void transToRunning(@NonNull ReuseCodecWrapper paramReuseCodecWrapper);
  
  public abstract void transTokeep(@NonNull ReuseCodecWrapper paramReuseCodecWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.CodecWrapperTransformation
 * JD-Core Version:    0.7.0.1
 */