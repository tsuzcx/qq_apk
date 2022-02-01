package com.tencent.mobileqq.shortvideo.util;

import bdee;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class OffScreenGLSurface$1
  implements Runnable
{
  public OffScreenGLSurface$1(bdee parambdee) {}
  
  public void run()
  {
    bdee.a(this.this$0).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1
 * JD-Core Version:    0.7.0.1
 */