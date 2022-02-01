package com.tencent.mobileqq.emoticonview;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class LooperGifImage
  extends NativeGifImage
{
  private int maxLoopTimes = 1;
  
  public LooperGifImage(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
    this.maxLoopTimes = paramInt;
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == this.maxLoopTimes) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */