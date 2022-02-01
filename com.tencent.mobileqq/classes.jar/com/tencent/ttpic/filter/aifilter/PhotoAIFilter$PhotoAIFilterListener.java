package com.tencent.ttpic.filter.aifilter;

import org.jetbrains.annotations.NotNull;

public abstract interface PhotoAIFilter$PhotoAIFilterListener
{
  public abstract void onAIFilterEnd(boolean paramBoolean);
  
  public abstract void onAIFilterProcessCancel();
  
  public abstract void onAIFilterStart();
  
  public abstract void onReqSuccess(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoAIFilter.PhotoAIFilterListener
 * JD-Core Version:    0.7.0.1
 */