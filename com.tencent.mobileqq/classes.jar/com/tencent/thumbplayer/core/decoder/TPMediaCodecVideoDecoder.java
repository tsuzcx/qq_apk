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
import com.tencent.thumbplayer.core.common.TPSystemInfo;

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
  private MediaCrypto mMediaCrypto = null;
  private String mMimeType = null;
  private int mRotation = 0;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  
  void configCodec(@NonNull MediaCodec paramMediaCodec)
  {
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mMimeType, this.mVideoWidth, this.mVideoHeight);
    if (Build.VERSION.SDK_INT > 22) {
      localMediaFormat.setInteger("rotation-degrees", this.mRotation);
    }
    if (TPSystemInfo.getDeviceName().equalsIgnoreCase("vivo X5L")) {
      localMediaFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
    }
    paramMediaCodec.configure(localMediaFormat, this.mSurface, this.mMediaCrypto, 0);
    paramMediaCodec.setVideoScalingMode(1);
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
  
  public boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4)
  {
    this.mMimeType = paramString;
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mRotation = paramInt3;
    this.mSurface = paramSurface;
    this.mDrmType = paramInt4;
    return true;
  }
  
  void processMediaCodecException(Exception paramException) {}
  
  void processOutputBuffer(@NonNull MediaCodec paramMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.width = this.mVideoWidth;
    paramTPFrameInfo.height = this.mVideoHeight;
    paramTPFrameInfo.cropLeft = this.mCropLeft;
    paramTPFrameInfo.cropRight = this.mCropRight;
    paramTPFrameInfo.cropTop = this.mCropTop;
    paramTPFrameInfo.cropBottom = this.mCropBottom;
  }
  
  void processOutputConfigData(@NonNull MediaCodec paramMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo)
  {
    paramTPFrameInfo.errCode = 0;
    processOutputBuffer(paramMediaCodec, paramInt, paramBufferInfo, paramTPFrameInfo);
  }
  
  void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {}
    for (int i = 1;; i = 0)
    {
      this.mVideoWidth = paramMediaFormat.getInteger("width");
      this.mVideoHeight = paramMediaFormat.getInteger("height");
      if (i != 0)
      {
        this.mCropLeft = paramMediaFormat.getInteger("crop-left");
        this.mCropRight = paramMediaFormat.getInteger("crop-right");
        this.mCropTop = paramMediaFormat.getInteger("crop-top");
        this.mCropBottom = paramMediaFormat.getInteger("crop-bottom");
      }
      TPNativeLog.printLog(2, "TPMediaCodecVideoDecode", "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
      return;
    }
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    return super.setOutputSurface(paramSurface);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder
 * JD-Core Version:    0.7.0.1
 */