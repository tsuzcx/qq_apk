package com.tencent.mobileqq.surfaceviewaction.gl;

import bcry;
import bcsl;
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
        bcsl[] arrayOfbcsl = bcry.a(this.a.this$0);
        if ((arrayOfbcsl == null) || (bcry.a(this.a.this$0))) {
          return;
        }
        bcry.a(this.a.this$0, new bcsl[bcry.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < bcry.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            bcry localbcry2 = this.a.this$0;
            int k = i + 1;
            bcry.a(localbcry2, i, arrayOfbcsl[j]);
            i = k;
          }
          else
          {
            bcry.a(this.a.this$0).remove(arrayOfbcsl[j]);
            arrayOfbcsl[j].c();
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