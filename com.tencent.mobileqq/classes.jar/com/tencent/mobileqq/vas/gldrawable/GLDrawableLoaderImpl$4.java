package com.tencent.mobileqq.vas.gldrawable;

import java.util.List;

class GLDrawableLoaderImpl$4
  implements GLDrawableProxy.LoaderCallback
{
  GLDrawableLoaderImpl$4(GLDrawableLoaderImpl paramGLDrawableLoaderImpl) {}
  
  public void a()
  {
    List localList = GLDrawableLoaderImpl.a(this.a);
    int i = 0;
    try
    {
      while (i < GLDrawableLoaderImpl.a(this.a).size())
      {
        ((GLDrawableProxy.LoaderCallback)GLDrawableLoaderImpl.a(this.a).get(i)).a();
        i += 1;
      }
      GLDrawableLoaderImpl.a(this.a).clear();
      return;
    }
    finally {}
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.4
 * JD-Core Version:    0.7.0.1
 */