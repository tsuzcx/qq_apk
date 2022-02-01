package com.tencent.mobileqq.vpng.glrenderer;

import java.util.Iterator;
import java.util.LinkedList;

class GLRenderer$RenderThreadThread
  extends Thread
{
  private boolean a = true;
  
  private GLRenderer$RenderThreadThread(GLRenderer paramGLRenderer)
  {
    paramGLRenderer = new StringBuilder();
    paramGLRenderer.append("GLRenderer-");
    paramGLRenderer.append(getId());
    setName(paramGLRenderer.toString());
  }
  
  public void run()
  {
    GLRenderer.a(this.this$0);
    this.this$0.d();
    for (;;)
    {
      if (this.a) {
        try
        {
          long l = System.currentTimeMillis();
          synchronized (GLRenderer.a(this.this$0))
          {
            Iterator localIterator = GLRenderer.a(this.this$0).iterator();
            while (localIterator.hasNext()) {
              ((Runnable)localIterator.next()).run();
            }
            GLRenderer.a(this.this$0).clear();
            if (!this.this$0.a) {
              GLRenderer.b(this.this$0);
            }
            sleep(Math.max(0L, 33L - (System.currentTimeMillis() - l)));
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    if (GLRenderer.a(this.this$0) != null)
    {
      GLRenderer.a(this.this$0).run();
      GLRenderer.a(this.this$0, null);
    }
    this.this$0.g();
    GLRenderer.c(this.this$0);
    GLRenderer.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.glrenderer.GLRenderer.RenderThreadThread
 * JD-Core Version:    0.7.0.1
 */