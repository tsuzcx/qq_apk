package com.tencent.qqmusic.mediaplayer.codec;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.SoNotFindException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.List;

public abstract class BaseDecoder
{
  private AudioFormat.AudioType mAudioType = null;
  private final boolean mHasLoadSoSuccess = NativeLibs.loadAll(getNativeLibs());
  public int mNativeApeDecoderRef = 0;
  
  private void throwIfSoNotLoadSuccess()
  {
    if (this.mHasLoadSoSuccess) {
      return;
    }
    throw new SoNotFindException("has't load so success , can't call native funcation");
  }
  
  public int decodeData(int paramInt, byte[] paramArrayOfByte)
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public AudioInformation getAudioInformation()
  {
    throwIfSoNotLoadSuccess();
    return null;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return this.mAudioType;
  }
  
  public abstract long getBytePositionOfTime(long paramLong);
  
  public long getCurrentTime()
  {
    throwIfSoNotLoadSuccess();
    return -1L;
  }
  
  public long getDuration()
  {
    return -1L;
  }
  
  public int getErrorCodeMask()
  {
    return -1;
  }
  
  public long getMinBufferSize()
  {
    return 0L;
  }
  
  protected abstract List<NativeLibs> getNativeLibs();
  
  public int init(IDataSource paramIDataSource)
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public int init(INativeDataSource paramINativeDataSource)
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public int init(String paramString, boolean paramBoolean)
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public int release()
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public int seekTo(int paramInt)
  {
    throwIfSoNotLoadSuccess();
    return -1;
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack) {}
  
  public void setAudioType(AudioFormat.AudioType paramAudioType)
  {
    this.mAudioType = paramAudioType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
 * JD-Core Version:    0.7.0.1
 */