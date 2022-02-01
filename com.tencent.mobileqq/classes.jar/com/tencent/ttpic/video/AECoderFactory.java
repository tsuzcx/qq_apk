package com.tencent.ttpic.video;

public class AECoderFactory
{
  private static AECoderFactory.AEDecoderFactory mAEDecoderFactory;
  private static AECoderFactory.AEEncoderFactory mAEEncoderFactory;
  
  public static AEDecoder createDecoder(String paramString)
  {
    AECoderFactory.AEDecoderFactory localAEDecoderFactory = mAEDecoderFactory;
    if (localAEDecoderFactory == null) {
      return null;
    }
    return localAEDecoderFactory.createDecoder(paramString);
  }
  
  public static AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    AECoderFactory.AEEncoderFactory localAEEncoderFactory = mAEEncoderFactory;
    if (localAEEncoderFactory == null) {
      return null;
    }
    return localAEEncoderFactory.createEncoder(paramString, paramInt1, paramInt2);
  }
  
  public static void setAEDecoder(AECoderFactory.AEDecoderFactory paramAEDecoderFactory)
  {
    mAEDecoderFactory = paramAEDecoderFactory;
  }
  
  public static void setAEEncoder(AECoderFactory.AEEncoderFactory paramAEEncoderFactory)
  {
    mAEEncoderFactory = paramAEEncoderFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.video.AECoderFactory
 * JD-Core Version:    0.7.0.1
 */