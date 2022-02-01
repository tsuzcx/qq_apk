package com.tencent.video.decode;

public class AVDecodeFactory
{
  public static final int TYPE_MP4_AVDECODE = 0;
  public static final int TYPE_YUV_AVDECODE = 1;
  
  public static AbstractAVDecode newDecode(AVDecodeOption paramAVDecodeOption)
  {
    if (paramAVDecodeOption.mDecodeType == 0) {
      return AVDecode.newInstance(paramAVDecodeOption);
    }
    if (paramAVDecodeOption.mDecodeType == 1) {
      return YuvAVDecode.newInstance(paramAVDecodeOption);
    }
    return null;
  }
  
  public static AbstractAVDecode newDecodeUncatched(AVDecodeOption paramAVDecodeOption)
  {
    if (paramAVDecodeOption.mDecodeType == 0) {
      return AVDecode.newInstanceUncatched(paramAVDecodeOption);
    }
    if (paramAVDecodeOption.mDecodeType == 1) {
      return YuvAVDecode.newInstance(paramAVDecodeOption);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.video.decode.AVDecodeFactory
 * JD-Core Version:    0.7.0.1
 */