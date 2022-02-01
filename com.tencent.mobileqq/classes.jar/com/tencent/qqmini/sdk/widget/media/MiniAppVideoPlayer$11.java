package com.tencent.qqmini.sdk.widget.media;

import android.widget.ImageView;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import java.io.File;

class MiniAppVideoPlayer$11
  implements MediaUtils.OnLoadVideoImageListener
{
  MiniAppVideoPlayer$11(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onLoadImage(File paramFile)
  {
    if ((MiniAppVideoPlayer.access$3100(this.this$0) != null) && (paramFile != null)) {
      MiniAppVideoPlayer.access$3100(this.this$0).setImageBitmap(ImageUtil.getLocalBitmap(paramFile.getAbsolutePath()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayer.11
 * JD-Core Version:    0.7.0.1
 */