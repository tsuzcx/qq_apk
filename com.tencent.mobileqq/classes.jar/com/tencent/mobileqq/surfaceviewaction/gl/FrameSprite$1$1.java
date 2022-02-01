package com.tencent.mobileqq.surfaceviewaction.gl;

import bdyh;
import bdyu;
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
        bdyu[] arrayOfbdyu = bdyh.a(this.a.this$0);
        if ((arrayOfbdyu == null) || (bdyh.a(this.a.this$0))) {
          return;
        }
        bdyh.a(this.a.this$0, new bdyu[bdyh.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < bdyh.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            bdyh localbdyh2 = this.a.this$0;
            int k = i + 1;
            bdyh.a(localbdyh2, i, arrayOfbdyu[j]);
            i = k;
          }
          else
          {
            bdyh.a(this.a.this$0).remove(arrayOfbdyu[j]);
            arrayOfbdyu[j].c();
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