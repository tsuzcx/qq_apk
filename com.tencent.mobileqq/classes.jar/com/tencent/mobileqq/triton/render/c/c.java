package com.tencent.mobileqq.triton.render.c;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.jni.b;
import com.tencent.mobileqq.triton.render.RenderContext.a;

public class c
  implements RenderContext.a
{
  private TTEngine a;
  private boolean b = true;
  
  public c(TTEngine paramTTEngine)
  {
    this.a = paramTTEngine;
  }
  
  private void b()
  {
    if ((this.b) && (b.g(this.a)))
    {
      this.b = false;
      this.a.getGameLauncher().a();
    }
  }
  
  public void a()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.c.c
 * JD-Core Version:    0.7.0.1
 */