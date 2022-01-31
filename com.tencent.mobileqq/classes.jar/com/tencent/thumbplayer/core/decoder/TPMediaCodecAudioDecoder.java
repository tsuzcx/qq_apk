package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.nio.ByteBuffer;

@RequiresApi(api=16)
public class TPMediaCodecAudioDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String TAG = "TPMediaCodecAudioDecoder";
  private int mChannelCount = 0;
  private byte[] mCsd0Data = null;
  private boolean mIsAdts = false;
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private int mSampleRate = 0;
  
  void configCodec(@NonNull MediaCodec paramMediaCodec)
  {
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: ");
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannelCount);
    if (this.mCsd0Data != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(this.mCsd0Data));
    }
    if (this.mIsAdts)
    {
      TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: set is adts");
      localMediaFormat.setInteger("is-adts", 1);
    }
    paramMediaCodec.configure(localMediaFormat, null, this.mMediaCrypto, 0);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecAudioDecoder";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2)
  {
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "initDecoder: ");
    this.mMimeType = paramString;
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    return true;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface)
  {
    return false;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(@NonNull MediaCodec paramMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.sampleRate = this.mSampleRate;
    paramTPFrameInfo.channelCount = this.mChannelCount;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (ByteBuffer localByteBuffer = paramMediaCodec.getOutputBuffer(paramInt);; localByteBuffer = paramMediaCodec.getOutputBuffers()[paramInt])
    {
      byte[] arrayOfByte = null;
      if (localByteBuffer != null)
      {
        arrayOfByte = new byte[paramBufferInfo.size];
        localByteBuffer.get(arrayOfByte, paramBufferInfo.offset, paramBufferInfo.size);
      }
      paramTPFrameInfo.data = arrayOfByte;
      if ((paramBufferInfo.flags == 4) && (paramBufferInfo.size <= 0))
      {
        TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
        paramTPFrameInfo.errCode = 2;
      }
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
  }
  
  void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat)
  {
    try
    {
      if (paramMediaFormat.containsKey("sample-rate")) {
        this.mSampleRate = paramMediaFormat.getInteger("sample-rate");
      }
      if (paramMediaFormat.containsKey("channel-count")) {
        this.mChannelCount = paramMediaFormat.getInteger("channel-count");
      }
      if ((Build.VERSION.SDK_INT < 24) || (!paramMediaFormat.containsKey("pcm-encoding"))) {
        break label142;
      }
      i = paramMediaFormat.getInteger("pcm-encoding");
    }
    catch (Exception paramMediaFormat)
    {
      for (;;)
      {
        TPNativeLog.printLog(4, "TPMediaCodecAudioDecoder", "processOutputFormatChanged got one exception: " + getStackTrace(paramMediaFormat));
        label142:
        int i = 2;
      }
    }
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "processOutputFormatChanged: mSampleRate: " + this.mSampleRate + ", mChannelCount: " + this.mChannelCount + " pcmFormat: " + i);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      this.mIsAdts = paramBoolean;
      return true;
    }
    return super.setParamBool(paramInt, paramBoolean);
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    }
    return super.setParamBytes(paramInt, paramArrayOfByte);
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      return true;
    }
    return super.setParamObject(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */