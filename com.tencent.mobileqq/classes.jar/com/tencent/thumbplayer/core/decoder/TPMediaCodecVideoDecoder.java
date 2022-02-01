package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.tmediacodec.TMediaCodec;
import java.nio.ByteBuffer;

@RequiresApi(api=16)
public class TPMediaCodecVideoDecoder
  extends TPBaseMediaCodecDecoder
{
  private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
  private static final String KEY_CROP_BOTTOM = "crop-bottom";
  private static final String KEY_CROP_LEFT = "crop-left";
  private static final String KEY_CROP_RIGHT = "crop-right";
  private static final String KEY_CROP_TOP = "crop-top";
  private static final String TAG = "TPMediaCodecVideoDecode";
  private int mCropBottom = 0;
  private int mCropLeft = 0;
  private int mCropRight = 0;
  private int mCropTop = 0;
  private byte[] mCsd0Data = null;
  private byte[] mCsd1Data = null;
  private byte[] mCsd2Data = null;
  private String mMimeType = null;
  private int mRotation = 0;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  public TPMediaCodecVideoDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  void configCodec(@NonNull TMediaCodec paramTMediaCodec)
  {
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
    if (Build.VERSION.SDK_INT > 22) {
      localMediaFormat.setInteger("rotation-degrees", this.mRotation);
    }
    if (TPSystemInfo.getDeviceName().equalsIgnoreCase("vivo X5L")) {
      localMediaFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
    }
    byte[] arrayOfByte = this.mCsd0Data;
    if (arrayOfByte != null) {
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(arrayOfByte));
    }
    arrayOfByte = this.mCsd1Data;
    if (arrayOfByte != null) {
      localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(arrayOfByte));
    }
    arrayOfByte = this.mCsd2Data;
    if (arrayOfByte != null) {
      localMediaFormat.setByteBuffer("csd-2", ByteBuffer.wrap(arrayOfByte));
    }
    if (this.mMimeType.equals("video/dolby-vision"))
    {
      localMediaFormat.setInteger("profile", TPCodecUtils.convertDolbyVisionToOmxProfile(this.mDolbyVisionProfile));
      localMediaFormat.setInteger("level", TPCodecUtils.convertDolbyVisionToOmxLevel(this.mDolbyVisionLevel));
    }
    paramTMediaCodec.configure(localMediaFormat, this.mSurface, this.mMediaCrypto, 0);
    paramTMediaCodec.setVideoScalingMode(1);
  }
  
  String getLogTag()
  {
    return "TPMediaCodecVideoDecode";
  }
  
  String getMimeType()
  {
    return this.mMimeType;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mMimeType = paramString;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mRotation = paramInt3;
    this.mSurface = paramSurface;
    this.mDrmType = paramInt4;
    this.mDolbyVisionProfile = paramInt5;
    this.mDolbyVisionLevel = paramInt6;
    return true;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.width = this.mVideoWidth;
    paramTPFrameInfo.height = this.mVideoHeight;
    paramTPFrameInfo.cropLeft = this.mCropLeft;
    paramTPFrameInfo.cropRight = this.mCropRight;
    paramTPFrameInfo.cropTop = this.mCropTop;
    paramTPFrameInfo.cropBottom = this.mCropBottom;
  }
  
  void processOutputConfigData(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.errCode = 0;
    processOutputBuffer(paramTMediaCodec, paramInt, paramBufferInfo, paramTPFrameInfo);
  }
  
  void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat)
  {
    int i;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {
      i = 1;
    } else {
      i = 0;
    }
    this.mVideoWidth = paramMediaFormat.getInteger("width");
    this.mVideoHeight = paramMediaFormat.getInteger("height");
    if (i != 0)
    {
      this.mCropLeft = paramMediaFormat.getInteger("crop-left");
      this.mCropRight = paramMediaFormat.getInteger("crop-right");
      this.mCropTop = paramMediaFormat.getInteger("crop-top");
      this.mCropBottom = paramMediaFormat.getInteger("crop-bottom");
    }
    paramMediaFormat = new StringBuilder();
    paramMediaFormat.append("processOutputFormatChanged: mVideoWidth: ");
    paramMediaFormat.append(this.mVideoWidth);
    paramMediaFormat.append(", mVideoHeight: ");
    paramMediaFormat.append(this.mVideoHeight);
    paramMediaFormat.append(", mCropLeft: ");
    paramMediaFormat.append(this.mCropLeft);
    paramMediaFormat.append(", mCropRight: ");
    paramMediaFormat.append(this.mCropRight);
    paramMediaFormat.append(", mCropTop: ");
    paramMediaFormat.append(this.mCropTop);
    paramMediaFormat.append(", mCropBottom: ");
    paramMediaFormat.append(this.mCropBottom);
    TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", paramMediaFormat.toString());
  }
  
  public int setOperateRate(float paramFloat)
  {
    return super.setOperateRate(paramFloat);
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    return super.setOutputSurface(paramSurface);
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt == 200) {
      this.mCsd0Data = paramArrayOfByte;
    } else if (paramInt == 201) {
      this.mCsd1Data = paramArrayOfByte;
    } else if (paramInt == 202) {
      this.mCsd2Data = paramArrayOfByte;
    }
    return super.setParamBytes(paramInt, paramArrayOfByte);
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    return super.setParamObject(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */