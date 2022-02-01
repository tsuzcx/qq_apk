package com.tencent.mobileqq.vas.gldrawable;

import bhqx;
import bhrh;
import java.util.List;

public class GLDrawableLoaderImpl$6
  implements Runnable
{
  public GLDrawableLoaderImpl$6(bhqx parambhqx, bhrh parambhrh) {}
  
  public void run()
  {
    if (this.a != null) {
      synchronized (bhqx.a(this.this$0))
      {
        bhqx.a(this.this$0).add(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.6
 * JD-Core Version:    0.7.0.1
 */