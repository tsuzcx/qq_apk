package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import java.io.File;

class MiniAppVideoController$13
  implements MediaUtils.OnLoadVideoImageListener
{
  MiniAppVideoController$13(MiniAppVideoController paramMiniAppVideoController) {}
  
  public void onLoadImage(File paramFile)
  {
    if (paramFile != null)
    {
      paramFile = ImageUtil.getLocalBitmap(paramFile.getAbsolutePath());
      MiniAppVideoController.access$300(this.this$0).setPoster(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.13
 * JD-Core Version:    0.7.0.1
 */