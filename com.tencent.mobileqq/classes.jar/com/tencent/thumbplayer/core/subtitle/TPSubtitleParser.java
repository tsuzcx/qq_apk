package com.tencent.thumbplayer.core.subtitle;

import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;

public class TPSubtitleParser
{
  private ITPSubtitleParserCallback mCallback = null;
  private boolean mInited = false;
  private long mNativeContext = 0L;
  private String mUrl = null;
  
  public TPSubtitleParser(String paramString, ITPSubtitleParserCallback paramITPSubtitleParserCallback)
  {
    this.mUrl = paramString;
    this.mCallback = paramITPSubtitleParserCallback;
  }
  
  private native int _subtitleCreate(String paramString, Object paramObject);
  
  private native void _subtitleDelete();
  
  private native String _subtitleGetText(long paramLong, int paramInt);
  
  private native int _subtitleGetTrackCount();
  
  private native String _subtitleGetTrackName(int paramInt);
  
  public String getSubtitleText(long paramLong, int paramInt)
  {
    if (this.mInited) {
      return _subtitleGetText(paramLong, paramInt);
    }
    return null;
  }
  
  public TPMediaTrackInfo[] getTrackInfo()
  {
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo2 = null;
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo1 = arrayOfTPMediaTrackInfo2;
    if (this.mInited)
    {
      int j = _subtitleGetTrackCount();
      arrayOfTPMediaTrackInfo1 = arrayOfTPMediaTrackInfo2;
      if (j > 0)
      {
        arrayOfTPMediaTrackInfo2 = new TPMediaTrackInfo[j];
        int i = 0;
        for (;;)
        {
          arrayOfTPMediaTrackInfo1 = arrayOfTPMediaTrackInfo2;
          if (i >= j) {
            break;
          }
          arrayOfTPMediaTrackInfo2[i].trackType = 3;
          arrayOfTPMediaTrackInfo2[i].trackName = _subtitleGetTrackName(i);
          i += 1;
        }
      }
    }
    return arrayOfTPMediaTrackInfo1;
  }
  
  public void init()
  {
    if (this.mInited) {
      throw new IllegalStateException("Failed to init due to invalid state.");
    }
    if ((this.mUrl != null) && (this.mCallback != null))
    {
      this.mInited = true;
      _subtitleCreate(this.mUrl, this.mCallback);
    }
  }
  
  public int selectTrackAsync(int paramInt, long paramLong)
  {
    return 0;
  }
  
  public int selectTracksAsync(int[] paramArrayOfInt, long paramLong)
  {
    return 0;
  }
  
  public void unInit()
  {
    if (!this.mInited) {
      return;
    }
    _subtitleDelete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.subtitle.TPSubtitleParser
 * JD-Core Version:    0.7.0.1
 */