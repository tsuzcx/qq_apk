package com.tencent.mtt.hippy.modules.nativemodules.animation;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class c$1
  implements a.a
{
  c$1(c paramc) {}
  
  public void onAnimationCancel(a parama) {}
  
  public void onAnimationEnd(a parama) {}
  
  public void onAnimationRepeat(a parama) {}
  
  public void onAnimationStart(a parama) {}
  
  public void onAnimationUpdate(a parama)
  {
    c.a(this.a, parama);
    if (this.a.c == null) {}
    for (;;)
    {
      return;
      parama = this.a.c.iterator();
      while (parama.hasNext()) {
        ((a.a)parama.next()).onAnimationUpdate(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.c.1
 * JD-Core Version:    0.7.0.1
 */