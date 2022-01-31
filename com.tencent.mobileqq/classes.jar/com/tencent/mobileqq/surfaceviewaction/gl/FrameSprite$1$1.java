package com.tencent.mobileqq.surfaceviewaction.gl;

import axby;
import axcl;
import java.util.LinkedList;

class FrameSprite$1$1
  implements Runnable
{
  FrameSprite$1$1(FrameSprite.1 param1) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      synchronized (this.a.this$0)
      {
        axcl[] arrayOfaxcl = axby.a(this.a.this$0);
        if ((arrayOfaxcl == null) || (axby.a(this.a.this$0))) {
          return;
        }
        axby.a(this.a.this$0, new axcl[axby.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < axby.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            axby localaxby2 = this.a.this$0;
            int k = i + 1;
            axby.a(localaxby2, i, arrayOfaxcl[j]);
            i = k;
          }
          else
          {
            axby.a(this.a.this$0).remove(arrayOfaxcl[j]);
            arrayOfaxcl[j].c();
          }
        }
        else {
          return;
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
 * JD-Core Version:    0.7.0.1
 */