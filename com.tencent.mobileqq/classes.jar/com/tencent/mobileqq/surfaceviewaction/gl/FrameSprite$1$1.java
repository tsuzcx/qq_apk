package com.tencent.mobileqq.surfaceviewaction.gl;

import aycc;
import aycp;
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
        aycp[] arrayOfaycp = aycc.a(this.a.this$0);
        if ((arrayOfaycp == null) || (aycc.a(this.a.this$0))) {
          return;
        }
        aycc.a(this.a.this$0, new aycp[aycc.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < aycc.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            aycc localaycc2 = this.a.this$0;
            int k = i + 1;
            aycc.a(localaycc2, i, arrayOfaycp[j]);
            i = k;
          }
          else
          {
            aycc.a(this.a.this$0).remove(arrayOfaycp[j]);
            arrayOfaycp[j].c();
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