package com.tencent.thumbplayer.core.subtitle;

import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPSubtitleFrameWrapper;

public class TPSubtitleParser
{
  public static final int TP_SUBTITLE_OUTPUT_RGBA = 1;
  public static final int TP_SUBTITLE_OUTPUT_TEXT = 0;
  private ITPSubtitleParserCallback mCallback = null;
  private boolean mInited = false;
  private boolean mIsLibLoaded = false;
  private long mNativeContext = 0L;
  private int mOutputType = 0;
  private String mUrl = null;
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback)
  {
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
  }
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback, int paramInt)
  {
    loadLibrary();
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
    this.mOutputType = paramInt;
  }
  
  private native int _subtitleCreate(String paramString, Object paramObject, int paramInt);
  
  private native void _subtitleDelete();
  
  private native TPSubtitleFrameWrapper _subtitleGetFrame(long paramLong);
  
  private native String _subtitleGetText(long paramLong, int paramInt);
  
  private native int _subtitleGetTrackCount();
  
  private native String _subtitleGetTrackName(int paramInt);
  
  private native void _subtitleLoadAsync();
  
  private native void _subtitlePauseAsync();
  
  private native int _subtitleSelectTrackAsync(int paramInt, long paramLong);
  
  private native void _subtitleSetRenderParams(TPNativeSubtitleRenderParams paramTPNativeSubtitleRenderParams);
  
  private native void _subtitleStartAsync();
  
  private native void _subtitleStop();
  
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
  
  public TPSubtitleFrameWrapper getSubtitleFrame(long paramLong)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited) {
        return _subtitleGetFrame(paramLong);
      }
      throw new IllegalStateException("Failed to getSubtitleFrame due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public String getSubtitleText(long paramLong, int paramInt)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited) {
        return _subtitleGetText(paramLong, paramInt);
      }
      throw new IllegalStateException("Failed to getSubtitleText due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        localObject = null;
        int j = _subtitleGetTrackCount();
        if (j > 0)
        {
          TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = new TPMediaTrackInfo[j];
          int i = 0;
          for (;;)
          {
            localObject = arrayOfTPMediaTrackInfo;
            if (i >= j) {
              break;
            }
            localObject = new TPMediaTrackInfo();
            ((TPMediaTrackInfo)localObject).trackType = 3;
            ((TPMediaTrackInfo)localObject).trackName = _subtitleGetTrackName(i);
            arrayOfTPMediaTrackInfo[i] = localObject;
            i += 1;
          }
        }
        return localObject;
      }
      throw new IllegalStateException("Failed to getTrackInfo due to invalid state.");
    }
    Object localObject = new UnsupportedOperationException("Failed to load native library");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void init()
  {
    if (this.mIsLibLoaded)
    {
      if (!this.mInited)
      {
        this.mInited = true;
        String str = this.mUrl;
        if (str != null)
        {
          ITPSubtitleParserCallback localITPSubtitleParserCallback = this.mCallback;
          if (localITPSubtitleParserCallback != null)
          {
            _subtitleCreate(str, localITPSubtitleParserCallback, this.mOutputType);
            _subtitleLoadAsync();
          }
        }
        return;
      }
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void pauseAsync()
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _subtitlePauseAsync();
        return;
      }
      throw new IllegalStateException("Failed to pauseAsync due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited) {
        return _subtitleSelectTrackAsync(paramInt, paramLong);
      }
      throw new IllegalStateException("Failed to selectTrackAsync due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public int selectTracksAsync(int[] paramArrayOfInt, long paramLong)
  {
    return 0;
  }
  
  public void setRenderParams(TPNativeSubtitleRenderParams paramTPNativeSubtitleRenderParams)
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _subtitleSetRenderParams(paramTPNativeSubtitleRenderParams);
        return;
      }
      throw new IllegalStateException("Failed to setRenderParams due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void startAsync()
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _subtitleStartAsync();
        return;
      }
      throw new IllegalStateException("Failed to startAsync due to invalid state.");
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
  
  public void stop()
  {
    if (this.mIsLibLoaded)
    {
      if (this.mInited)
      {
        _subtitleStop();
        return;
      }
      throw new IllegalStateException("Failed to stop due to invalid state.");
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
      _subtitleDelete();
      return;
    }
    throw new UnsupportedOperationException("Failed to load native library");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.TPSubtitleParser
 * JD-Core Version:    0.7.0.1
 */