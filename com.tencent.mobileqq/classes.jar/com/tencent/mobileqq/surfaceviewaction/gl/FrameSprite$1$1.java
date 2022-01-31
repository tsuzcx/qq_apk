package com.tencent.mobileqq.surfaceviewaction.gl;

import azzz;
import baam;
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
        baam[] arrayOfbaam = azzz.a(this.a.this$0);
        if ((arrayOfbaam == null) || (azzz.a(this.a.this$0))) {
          return;
        }
        azzz.a(this.a.this$0, new baam[azzz.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < azzz.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            azzz localazzz2 = this.a.this$0;
            int k = i + 1;
            azzz.a(localazzz2, i, arrayOfbaam[j]);
            i = k;
          }
          else
          {
            azzz.a(this.a.this$0).remove(arrayOfbaam[j]);
            arrayOfbaam[j].c();
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