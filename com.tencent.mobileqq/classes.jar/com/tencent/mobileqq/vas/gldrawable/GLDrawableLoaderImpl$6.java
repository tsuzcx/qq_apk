package com.tencent.mobileqq.vas.gldrawable;

import bgic;
import bgim;
import java.util.List;

public class GLDrawableLoaderImpl$6
  implements Runnable
{
  public GLDrawableLoaderImpl$6(bgic parambgic, bgim parambgim) {}
  
  public void run()
  {
    if (this.a != null) {
      synchronized (bgic.a(this.this$0))
      {
        bgic.a(this.this$0).add(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.6
 * JD-Core Version:    0.7.0.1
 */