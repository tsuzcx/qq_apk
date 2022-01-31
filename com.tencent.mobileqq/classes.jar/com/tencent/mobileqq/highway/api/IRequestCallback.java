package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.HwResponse;

public abstract interface IRequestCallback
{
  public abstract void onFailed(int paramInt);
  
  public abstract void onResponse(HwResponse paramHwResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.api.IRequestCallback
 * JD-Core Version:    0.7.0.1
 */