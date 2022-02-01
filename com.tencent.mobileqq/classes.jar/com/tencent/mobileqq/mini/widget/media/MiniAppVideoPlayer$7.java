package com.tencent.mobileqq.mini.widget.media;

import android.widget.ImageView;
import com.tencent.mobileqq.mini.util.ImageUtil;
import java.io.File;

class MiniAppVideoPlayer$7
  implements MediaUtils.OnLoadVideoImageListener
{
  MiniAppVideoPlayer$7(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onLoadImage(File paramFile)
  {
    if ((MiniAppVideoPlayer.access$2800(this.this$0) != null) && (paramFile != null)) {
      MiniAppVideoPlayer.access$2800(this.this$0).setImageBitmap(ImageUtil.getLocalBitmap(paramFile.getAbsolutePath()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.7
 * JD-Core Version:    0.7.0.1
 */