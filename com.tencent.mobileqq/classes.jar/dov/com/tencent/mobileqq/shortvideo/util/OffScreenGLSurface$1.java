package dov.com.tencent.mobileqq.shortvideo.util;

import blcm;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class OffScreenGLSurface$1
  implements Runnable
{
  public OffScreenGLSurface$1(blcm paramblcm) {}
  
  public void run()
  {
    blcm.a(this.this$0).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.1
 * JD-Core Version:    0.7.0.1
 */