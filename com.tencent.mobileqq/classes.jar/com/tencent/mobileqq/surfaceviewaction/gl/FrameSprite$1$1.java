package com.tencent.mobileqq.surfaceviewaction.gl;

import ayca;
import aycn;
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
        aycn[] arrayOfaycn = ayca.a(this.a.this$0);
        if ((arrayOfaycn == null) || (ayca.a(this.a.this$0))) {
          return;
        }
        ayca.a(this.a.this$0, new aycn[ayca.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < ayca.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            ayca localayca2 = this.a.this$0;
            int k = i + 1;
            ayca.a(localayca2, i, arrayOfaycn[j]);
            i = k;
          }
          else
          {
            ayca.a(this.a.this$0).remove(arrayOfaycn[j]);
            arrayOfaycn[j].c();
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