package com.tencent.mobileqq.surfaceviewaction.gl;

import bdyx;
import bdzk;
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
        bdzk[] arrayOfbdzk = bdyx.a(this.a.this$0);
        if ((arrayOfbdzk == null) || (bdyx.a(this.a.this$0))) {
          return;
        }
        bdyx.a(this.a.this$0, new bdzk[bdyx.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < bdyx.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            bdyx localbdyx2 = this.a.this$0;
            int k = i + 1;
            bdyx.a(localbdyx2, i, arrayOfbdzk[j]);
            i = k;
          }
          else
          {
            bdyx.a(this.a.this$0).remove(arrayOfbdzk[j]);
            arrayOfbdzk[j].c();
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