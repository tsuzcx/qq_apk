package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import java.util.List;

public abstract interface IProtocolCodecListener
{
  public abstract void onDecodeInvalidData(int paramInt);
  
  public abstract void onDecodeSucessfully(List<HwResponse> paramList);
  
  public abstract void onEncodePkgError(HwRequest paramHwRequest, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.IProtocolCodecListener
 * JD-Core Version:    0.7.0.1
 */