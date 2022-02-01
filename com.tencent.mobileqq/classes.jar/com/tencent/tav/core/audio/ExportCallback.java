package com.tencent.tav.core.audio;

public abstract interface ExportCallback
{
  public static final int STATUS_CANCEL = 4;
  public static final int STATUS_ERROR = 255;
  public static final int STATUS_EXPORTING = 1;
  public static final int STATUS_FINISH = 2;
  public static final int STATUS_IDEL = 0;
  
  public abstract void onProgress(int paramInt, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.core.audio.ExportCallback
 * JD-Core Version:    0.7.0.1
 */