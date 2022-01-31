package com.tencent.thumbplayer.api.composition;

public abstract interface ITPMediaAsset
{
  public static final int INVALID_ID = -1;
  public static final int MEDIA_TYPE_AUDIO = 3;
  public static final int MEDIA_TYPE_AV_MIX = 1;
  public static final int MEDIA_TYPE_MUTABLE = 4;
  public static final int MEDIA_TYPE_VIDEO = 2;
  
  public abstract int getMediaType();
  
  public abstract String getUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.api.composition.ITPMediaAsset
 * JD-Core Version:    0.7.0.1
 */