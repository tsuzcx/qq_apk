package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.image.NativeGifImage;
import java.io.File;

class SkinGifImageDownloader$1
  extends NativeGifImage
{
  SkinGifImageDownloader$1(SkinGifImageDownloader paramSkinGifImageDownloader, File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentLoop == 1) {
      return;
    }
    super.executeNewTask();
  }
  
  public void reset()
  {
    super.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.SkinGifImageDownloader.1
 * JD-Core Version:    0.7.0.1
 */