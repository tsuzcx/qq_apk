package com.tencent.mobileqq.microapp.widget.media;

import android.widget.ImageView;
import java.io.File;

final class j
  implements c
{
  j(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void a(File paramFile)
  {
    if (MiniAppVideoPlayer.a(this.a) != null) {
      MiniAppVideoPlayer.a(this.a).setImageBitmap(com.tencent.mobileqq.microapp.a.c.q(paramFile.getAbsolutePath()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.j
 * JD-Core Version:    0.7.0.1
 */