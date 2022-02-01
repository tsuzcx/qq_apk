package com.tencent.mobileqq.minicode.recog;

import apcu;
import java.util.List;

public abstract interface RecogCallback
{
  public abstract void onDetectReady(int paramInt);
  
  public abstract void onDetectResult(List<apcu> paramList, long paramLong);
  
  public abstract void onSaveImg(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.recog.RecogCallback
 * JD-Core Version:    0.7.0.1
 */