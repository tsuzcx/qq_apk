package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import java.util.List;

public abstract interface IProtocolCodecListener
{
  public abstract void onDecodeInvalidData(int paramInt);
  
  public abstract void onDecodeSucessfully(List<HwResponse> paramList);
  
  public abstract void onEncodePkgError(HwRequest paramHwRequest, int paramInt);
  
  public static abstract interface CODEC_ERROR_CODE
  {
    public static final int DECODE_DATA_EXCEED = 1;
    public static final int DECODE_DATA_INVALID_FORMAT = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.IProtocolCodecListener
 * JD-Core Version:    0.7.0.1
 */