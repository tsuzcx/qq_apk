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
  
  private native int _subtitleSelectTrackAsync(int paramInt, long paramLong);
  
  private native void _subtitleSetCanvasSize(int paramInt1, int paramInt2);
  
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
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to getSubtitleFrame due to invalid state.");
    }
    return _subtitleGetFrame(paramLong);
  }
  
  public String getSubtitleText(long paramLong, int paramInt)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to getSubtitleText due to invalid state.");
    }
    return _subtitleGetText(paramLong, paramInt);
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to getTrackInfo due to invalid state.");
    }
    Object localObject = null;
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
  
  public void init()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (this.mInited) {
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    this.mInited = true;
    if ((this.mUrl != null) && (this.mCallback != null)) {
      _subtitleCreate(this.mUrl, this.mCallback, this.mOutputType);
    }
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to selectTrackAsync due to invalid state.");
    }
    return _subtitleSelectTrackAsync(paramInt, paramLong);
  }
  
  public int selectTracksAsync(int[] paramArrayOfInt, long paramLong)
  {
    return 0;
  }
  
  public void setCanvasSize(int paramInt1, int paramInt2)
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      throw new IllegalStateException("Failed to setCanvasSize due to invalid state.");
    }
    _subtitleSetCanvasSize(paramInt1, paramInt2);
  }
  
  public void unInit()
  {
    if (!this.mIsLibLoaded) {
      throw new UnsupportedOperationException("Failed to load native library");
    }
    if (!this.mInited) {
      return;
    }
    this.mInited = false;
    _subtitleDelete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.TPSubtitleParser
 * JD-Core Version:    0.7.0.1
 */