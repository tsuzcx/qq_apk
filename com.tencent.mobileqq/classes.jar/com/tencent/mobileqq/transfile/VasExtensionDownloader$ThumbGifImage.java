package com.tencent.mobileqq.transfile;

import com.tencent.image.NativeGifImage;
import java.io.File;

public class VasExtensionDownloader$ThumbGifImage
  extends NativeGifImage
{
  public VasExtensionDownloader$ThumbGifImage(VasExtensionDownloader paramVasExtensionDownloader, File paramFile, boolean paramBoolean, float paramFloat)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
  }
  
  protected void executeNewTask()
  {
    if (this.mCurrentFrameIndex >= 1) {
      return;
    }
    super.executeNewTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader.ThumbGifImage
 * JD-Core Version:    0.7.0.1
 */