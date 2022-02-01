package com.tencent.mobileqq.vas.gldrawable;

import java.util.List;

class GLDrawableLoaderImpl$6
  implements Runnable
{
  GLDrawableLoaderImpl$6(GLDrawableLoaderImpl paramGLDrawableLoaderImpl, GLDrawableProxy.LoaderCallback paramLoaderCallback) {}
  
  public void run()
  {
    if (this.a != null) {
      synchronized (GLDrawableLoaderImpl.a(this.this$0))
      {
        GLDrawableLoaderImpl.a(this.this$0).add(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.6
 * JD-Core Version:    0.7.0.1
 */