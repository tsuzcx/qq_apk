package com.tencent.thumbplayer.core.imagegenerator;

import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import java.util.Map;

public class TPImageGenerator
{
  private ITPImageGeneratorCallback mCallback = null;
  private int mFd = -1;
  private Map<String, String> mHttpHeader = null;
  private boolean mInited = false;
  private boolean mIsLibLoaded = false;
  private long mNativeContext = 0L;
  private String mUrl = null;
  
  public TPImageGenerator(int paramInt, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    loadLibrary();
    this.mFd = paramInt;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPImageGeneratorCallback;
  }
  
  public TPImageGenerator(String paramString, Map<String, String> paramMap, ITPImageGeneratorCallback paramITPImageGeneratorCallback)
  {
    loadLibrary();
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
  
  private void loadLibrary()
  {
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      this.mIsLibLoaded = true;
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      localUnsupportedOperationException.printStackTrace();
      this.mIsLibLoaded = false;
    }
  }
  
  public void cancelAllImageGenerations()
  {
    if (this.mIsLibLoaded)
    {
      if (!this.mInited) {
        return;
      }
      _cancelAllImageGenerations();
      return;
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void generateImageAsyncAtTime(long paramLong1, long paramLong2, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _generateImageAsyncAtTime(paramLong1, paramLong2, paramTPImageGeneratorParams);
        return;
      }
      paramTPImageGeneratorParams = new StringBuilder();
      paramTPImageGeneratorParams.append("Failed to generate image at time ");
      paramTPImageGeneratorParams.append(paramLong1);
      paramTPImageGeneratorParams.append(" due to invalid state.");
      throw new IllegalStateException(paramTPImageGeneratorParams.toString());
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void generateImagesAsyncForTimes(long[] paramArrayOfLong, long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _generateImagesAsyncForTimes(paramArrayOfLong, paramLong, paramTPImageGeneratorParams);
        return;
      }
      throw new IllegalStateException("Failed to generate images due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void init()
  {
    if (this.mIsLibLoaded)
    {
      if (!this.mInited)
      {
        this.mInited = true;
        if ((this.mUrl != null) && (this.mHttpHeader != null)) {
          return;
        }
        String str = this.mUrl;
        if (str != null)
        {
          _createWithUrl(str, this.mCallback);
          return;
        }
        _createWithFd(this.mFd, this.mCallback);
        return;
      }
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void unInit()
  {
    if (this.mIsLibLoaded)
    {
      if (!this.mInited) {
        return;
      }
      this.mInited = false;
      _release();
      return;
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator
 * JD-Core Version:    0.7.0.1
 */