package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.TMediaCodec;
import java.nio.ByteBuffer;

@RequiresApi(api=16)
public class TPMediaCodecAudioDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String TAG = "TPMediaCodecAudioDecoder";
  private int mAudioFormat = 0;
  private int mChannelCount = 0;
  private byte[] mCsd0Data = null;
  private boolean mEnableAudioPassThrough = false;
  private boolean mIsAdts = false;
  private String mMimeType = null;
  private int mSampleRate = 0;
  
  public TPMediaCodecAudioDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(@NonNull TMediaCodec paramTMediaCodec)
  {
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: ");
    MediaFormat localMediaFormat = MediaFormat.createAudioFormat(this.mMimeType, this.mSampleRate, this.mChannelCount);
    byte[] arrayOfByte = this.mCsd0Data;
    if (arrayOfByte != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(arrayOfByte));
    }
    if (this.mIsAdts)
    {
      TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", "configCodec: set is adts");
      localMediaFormat.setInteger("is-adts", 1);
    }
    paramTMediaCodec.configure(localMediaFormat, null, this.mMediaCrypto, 0);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecAudioDecoder";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDecoder, mimeType:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" sampleRate:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" channelCount:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" drmType:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" audioFormat:");
    localStringBuilder.append(paramInt4);
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", localStringBuilder.toString());
    this.mMimeType = paramString;
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    this.mDrmType = paramInt3;
    this.mAudioFormat = paramInt4;
    return true;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6)
  {
    return false;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.sampleRate = this.mSampleRate;
    paramTPFrameInfo.channelCount = this.mChannelCount;
    paramTPFrameInfo.format = this.mAudioFormat;
    ByteBuffer localByteBuffer;
    if (Build.VERSION.SDK_INT >= 21) {
      localByteBuffer = paramTMediaCodec.getOutputBuffer(paramInt);
    } else {
      localByteBuffer = paramTMediaCodec.getOutputBuffers()[paramInt];
    }
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
    paramTMediaCodec.releaseOutputBuffer(paramInt, false);
  }
  
  void processOutputConfigData(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTMediaCodec.releaseOutputBuffer(paramInt, false);
    paramTPFrameInfo.errCode = 1;
  }
  
  void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat)
  {
    int i;
    try
    {
      if (paramMediaFormat.containsKey("sample-rate")) {
        this.mSampleRate = paramMediaFormat.getInteger("sample-rate");
      }
      if (paramMediaFormat.containsKey("channel-count")) {
        this.mChannelCount = paramMediaFormat.getInteger("channel-count");
      }
      if ((Build.VERSION.SDK_INT >= 24) && (paramMediaFormat.containsKey("pcm-encoding")))
      {
        i = paramMediaFormat.getInteger("pcm-encoding");
        try
        {
          paramMediaFormat = new StringBuilder();
          paramMediaFormat.append("processOutputFormatChanged: MediaFormat.KEY_PCM_ENCODING: ");
          paramMediaFormat.append(i);
          TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", paramMediaFormat.toString());
        }
        catch (Exception paramMediaFormat)
        {
          break label108;
        }
      }
      else
      {
        i = 2;
      }
    }
    catch (Exception paramMediaFormat)
    {
      i = 2;
      label108:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processOutputFormatChanged got one exception: ");
      localStringBuilder.append(getStackTrace(paramMediaFormat));
      TPNativeLog.printLog(4, "TPMediaCodecAudioDecoder", localStringBuilder.toString());
    }
    paramMediaFormat = new StringBuilder();
    paramMediaFormat.append("processOutputFormatChanged, mEnableAudioPassThrough:");
    paramMediaFormat.append(this.mEnableAudioPassThrough);
    paramMediaFormat.append(", mSampleRate: ");
    paramMediaFormat.append(this.mSampleRate);
    paramMediaFormat.append(", mChannelCount: ");
    paramMediaFormat.append(this.mChannelCount);
    paramMediaFormat.append(" mAudioFormat: ");
    paramMediaFormat.append(this.mAudioFormat);
    paramMediaFormat.append(" pcmFormat:");
    paramMediaFormat.append(i);
    TPNativeLog.printLog(2, "TPMediaCodecAudioDecoder", paramMediaFormat.toString());
  }
  
  public int setOperateRate(float paramFloat)
  {
    return super.setOperateRate(paramFloat);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 2)
    {
      this.mIsAdts = paramBoolean;
      return true;
    }
    if (paramInt == 3)
    {
      this.mEnableAudioPassThrough = paramBoolean;
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamBool mEnableAudioPassThrough:");
      localStringBuilder.append(this.mEnableAudioPassThrough);
      TPNativeLog.printLog(2, str, localStringBuilder.toString());
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
    return super.setParamObject(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecAudioDecoder
 * JD-Core Version:    0.7.0.1
 */