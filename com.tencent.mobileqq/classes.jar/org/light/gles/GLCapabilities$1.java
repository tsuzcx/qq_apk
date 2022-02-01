package org.light.gles;

import org.light.utils.LightLogUtil;

final class GLCapabilities$1
  implements Runnable
{
  GLCapabilities$1(boolean paramBoolean) {}
  
  public void run()
  {
    GLCapabilities.access$000(this.val$enableFramebufferFetch);
    GLCapabilities.access$102(true);
    LightLogUtil.i("GLCapabilities", "init: async end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.gles.GLCapabilities.1
 * JD-Core Version:    0.7.0.1
 */