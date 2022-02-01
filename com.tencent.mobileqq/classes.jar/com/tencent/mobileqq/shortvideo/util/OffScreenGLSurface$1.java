package com.tencent.mobileqq.shortvideo.util;

import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

class OffScreenGLSurface$1
  implements Runnable
{
  OffScreenGLSurface$1(OffScreenGLSurface paramOffScreenGLSurface) {}
  
  public void run()
  {
    OffScreenGLSurface.a(this.this$0).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1
 * JD-Core Version:    0.7.0.1
 */