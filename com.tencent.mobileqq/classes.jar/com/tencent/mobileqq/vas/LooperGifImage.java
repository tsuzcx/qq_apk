package com.tencent.mobileqq.vas;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class LooperGifImage
  extends NativeGifImage
{
  private int a = 1;
  
  public LooperGifImage(File paramFile, boolean paramBoolean, float paramFloat, int paramInt)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
    this.a = paramInt;
  }
  
  public void executeNewTask()
  {
    if (this.mCurrentLoop == this.a) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.LooperGifImage
 * JD-Core Version:    0.7.0.1
 */