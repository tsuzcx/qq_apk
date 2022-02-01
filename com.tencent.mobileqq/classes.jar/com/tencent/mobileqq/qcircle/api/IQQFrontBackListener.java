package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQQFrontBackListener
{
  public abstract void onQQEnterBackground();
  
  public abstract void onQQEnterForeground();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
 * JD-Core Version:    0.7.0.1
 */