package com.tencent.thumbplayer.core.imagegenerator;

import java.util.Map;

public class TPImageGenerator
{
  private ITPImageGeneratorCallback mCallback = null;
  private int mFd = -1;
  private Map<String, String> mHttpHeader = null;
  private boolean mInited = false;
  private long mNativeContext = 0L;
  private String mUrl = null;
  
  public TPImageGenerator(int paramInt, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mFd = paramInt;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mUrl = paramString;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, Map<String, String> paramMap, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    this.mUrl = paramString;
    this.mHttpHeader = paramMap;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  private native void _cancelAllImageGenerations();
  
  private native int _createWithFd(int paramInt, Object paramObject);
  
  private native int _createWithUrl(String paramString, Object paramObject);
  
  private native void _generateImageAsyncAtTime(long paramLong1, long paramLong2, Object paramObject);
  
  private native void _generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, Object paramObject);
  
  private native void _release();
  
  public void cancelAllImageGenerations()
  {
    if (!this.mInited) {
      return;
    }
    _cancelAllImageGenerations();
  }
  
  public void generateImageAsyncAtTime(long paramLong1, long paramLong2, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    if (!this.mInited) {
      throw new IllegalStateException("Failed to generate image at time " + paramLong1 + " due to invalid state.");
    }
    _generateImageAsyncAtTime(paramLong1, paramLong2, paramTPImageGeneratorParams);
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    if (!this.mInited) {
      throw new IllegalStateException("Failed to generate images due to invalid state.");
    }
    _generateImagesAsyncForTimes(paramArrayOfLong, paramLong, paramTPImageGeneratorParams);
  }
  
  public void init()
  {
    if (this.mInited) {
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    this.mInited = true;
    if ((this.mUrl != null) && (this.mHttpHeader != null)) {
      return;
    }
    if (this.mUrl != null)
    {
      _createWithUrl(this.mUrl, this.mCallback);
      return;
    }
    _createWithFd(this.mFd, this.mCallback);
  }
  
  public void unInit()
  {
    if (!this.mInited) {
      return;
    }
    this.mInited = false;
    _release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator
 * JD-Core Version:    0.7.0.1
 */