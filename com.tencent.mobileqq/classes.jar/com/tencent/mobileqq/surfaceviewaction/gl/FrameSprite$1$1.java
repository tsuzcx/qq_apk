package com.tencent.mobileqq.surfaceviewaction.gl;

import baei;
import baev;
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
        baev[] arrayOfbaev = baei.a(this.a.this$0);
        if ((arrayOfbaev == null) || (baei.a(this.a.this$0))) {
          return;
        }
        baei.a(this.a.this$0, new baev[baei.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < baei.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            baei localbaei2 = this.a.this$0;
            int k = i + 1;
            baei.a(localbaei2, i, arrayOfbaev[j]);
            i = k;
          }
          else
          {
            baei.a(this.a.this$0).remove(arrayOfbaev[j]);
            arrayOfbaev[j].c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
 * JD-Core Version:    0.7.0.1
 */