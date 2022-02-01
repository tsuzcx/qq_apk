package com.tencent.thumbplayer.core.decoder;

import android.support.annotation.NonNull;
import android.view.Surface;

public abstract interface ITPMediaCodecDecoder
{
  public static final int BOOL_ENABLE_ASYNC_MODE = 1;
  public static final int BOOL_ENABLE_MEDIACODEC_REUSE = 4;
  public static final int BOOL_ENABLE_SET_OUTPUT_SURFACE_API = 0;
  public static final int BOOL_SET_IS_ADTS = 2;
  public static final int BOOL_SET_IS_AUDIO_PASSTHROUGH = 3;
  public static final int BYTES_SET_CSD0_DATA = 200;
  public static final int BYTES_SET_CSD1_DATA = 201;
  public static final int BYTES_SET_CSD2_DATA = 202;
  public static final int OBJECT_SET_MEDIA_CRYPTO = 300;
  public static final int TP_CODEC_RETURN_CODE_EOS = 2;
  public static final int TP_CODEC_RETURN_CODE_ERROR = 3;
  public static final int TP_CODEC_RETURN_CODE_INTERNAL_RESET = 4;
  public static final int TP_CODEC_RETURN_CODE_OK = 0;
  public static final int TP_CODEC_RETURN_CODE_TRY_AGAIN = 1;
  public static final int TP_ERROR_DECODE_FAILED = 103;
  public static final int TP_ERROR_FLUSH_FAILED = 104;
  public static final int TP_ERROR_INVALID_CODECPAR = 100;
  public static final int TP_ERROR_NO_CODEC = 101;
  public static final int TP_ERROR_OPEN_FAILED = 102;
  
  public abstract int decode(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2);
  
  public abstract TPFrameInfo dequeueOutputBuffer();
  
  public abstract int flush();
  
  public abstract boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean initDecoder(String paramString, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface, int paramInt4, int paramInt5, int paramInt6);
  
  public abstract int release();
  
  public abstract int releaseOutputBuffer(int paramInt, boolean paramBoolean);
  
  public abstract void setCryptoInfo(int paramInt1, @NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2, int paramInt2);
  
  public abstract int setOperateRate(float paramFloat);
  
  public abstract int setOutputSurface(Surface paramSurface);
  
  public abstract boolean setParamBool(int paramInt, boolean paramBoolean);
  
  public abstract boolean setParamBytes(int paramInt, byte[] paramArrayOfByte);
  
  public abstract boolean setParamInt(int paramInt1, int paramInt2);
  
  public abstract boolean setParamLong(int paramInt, long paramLong);
  
  public abstract boolean setParamObject(int paramInt, Object paramObject);
  
  public abstract boolean setParamString(int paramInt, String paramString);
  
  public abstract int signalEndOfStream();
  
  public abstract boolean startDecoder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */