package com.tencent.mobileqq.surfaceviewaction.gl;

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
        Texture[] arrayOfTexture = FrameSprite.a(this.a.this$0);
        if ((arrayOfTexture == null) || (FrameSprite.a(this.a.this$0))) {
          return;
        }
        FrameSprite.a(this.a.this$0, new Texture[FrameSprite.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < FrameSprite.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            FrameSprite localFrameSprite2 = this.a.this$0;
            int k = i + 1;
            FrameSprite.a(localFrameSprite2, i, arrayOfTexture[j]);
            i = k;
          }
          else
          {
            FrameSprite.a(this.a.this$0).remove(arrayOfTexture[j]);
            arrayOfTexture[j].c();
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