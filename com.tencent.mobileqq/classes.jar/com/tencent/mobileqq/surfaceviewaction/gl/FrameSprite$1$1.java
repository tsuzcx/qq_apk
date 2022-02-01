package com.tencent.mobileqq.surfaceviewaction.gl;

import bdfm;
import bdfz;
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
        bdfz[] arrayOfbdfz = bdfm.a(this.a.this$0);
        if ((arrayOfbdfz == null) || (bdfm.a(this.a.this$0))) {
          return;
        }
        bdfm.a(this.a.this$0, new bdfz[bdfm.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < bdfm.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            bdfm localbdfm2 = this.a.this$0;
            int k = i + 1;
            bdfm.a(localbdfm2, i, arrayOfbdfz[j]);
            i = k;
          }
          else
          {
            bdfm.a(this.a.this$0).remove(arrayOfbdfz[j]);
            arrayOfbdfz[j].c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
 * JD-Core Version:    0.7.0.1
 */