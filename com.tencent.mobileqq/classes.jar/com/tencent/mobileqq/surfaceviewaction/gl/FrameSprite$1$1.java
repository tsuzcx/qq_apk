package com.tencent.mobileqq.surfaceviewaction.gl;

import java.util.LinkedList;

class FrameSprite$1$1
  implements Runnable
{
  FrameSprite$1$1(FrameSprite.1 param1) {}
  
  public void run()
  {
    int i;
    synchronized (this.a.this$0)
    {
      Texture[] arrayOfTexture = FrameSprite.a(this.a.this$0);
      if ((arrayOfTexture != null) && (!FrameSprite.a(this.a.this$0)))
      {
        FrameSprite.a(this.a.this$0, new Texture[FrameSprite.a(this.a.this$0).length / 2]);
        i = 0;
        int j = 0;
        if (i < FrameSprite.a(this.a.this$0).length) {
          if (i % 2 == 0)
          {
            FrameSprite.a(this.a.this$0, j, arrayOfTexture[i]);
            j += 1;
          }
          else
          {
            FrameSprite.a(this.a.this$0).remove(arrayOfTexture[i]);
            arrayOfTexture[i].c();
          }
        }
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
 * JD-Core Version:    0.7.0.1
 */