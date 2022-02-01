package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;

public abstract interface QQDanceEventHandler
{
  public abstract boolean changeDanceStatus(boolean paramBoolean, String paramString);
  
  public abstract void closeEvent(boolean paramBoolean);
  
  public abstract void enterSilhouette();
  
  public abstract void playSceneEndEvent(BoyDataReport paramBoyDataReport);
  
  public abstract void readySceneBegin(long paramLong);
  
  public abstract void scoreSceneEnd(int paramInt, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler
 * JD-Core Version:    0.7.0.1
 */