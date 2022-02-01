package com.tencent.oskplayer.player;

import android.graphics.Rect;

public abstract interface IExo2MediaPlayer
  extends ISegmentMediaPlayer
{
  public static final int EXO_MEDIA_ERROR_EXTRA_CONN = -3;
  public static final int EXO_MEDIA_ERROR_EXTRA_NETWORK = -2;
  public static final int EXO_MEDIA_ERROR_EXTRA_UNKNOWN = -1;
  public static final int EXO_MEDIA_ERROR_RESPONSE_403 = -10;
  public static final int EXO_MEDIA_ERROR_RESPONSE_404 = -11;
  public static final int EXO_MEDIA_ERROR_RESPONSE_500 = -12;
  public static final int EXO_MEDIA_ERROR_RESPONSE_502 = -13;
  public static final int EXO_MEDIA_ERROR_RESPONSE_OTHER = -30;
  public static final int EXO_MEDIA_ERROR_WHAT_EXTRACTOR = -4001;
  public static final int EXO_MEDIA_ERROR_WHAT_IO = -4000;
  public static final int EXO_MEDIA_ERROR_WHAT_UNKNOWN = -4999;
  public static final int EXO_MEIDA_ERROR_ILLEGAL_STATE = -4002;
  public static final int EXO_MEIDA_ERROR_MEDIACODEC_DECODER_INIT = -4003;
  
  public abstract String getAudioDecoderName();
  
  public abstract String getAudioMIMEType();
  
  public abstract int getVideoBitrate();
  
  public abstract String getVideoDecoderName();
  
  public abstract Rect getVideoDimension();
  
  public abstract String getVideoMIMEType();
  
  public abstract void setRate(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.IExo2MediaPlayer
 * JD-Core Version:    0.7.0.1
 */