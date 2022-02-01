package com.tencent.mtt.hippy.dom;

import android.os.Build.VERSION;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final boolean a;
  private static a b;
  private final Map<d.a, Choreographer.FrameCallback> c = new HashMap();
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  public void a(d.a parama)
  {
    if (a)
    {
      a.1 local1 = new a.1(this, parama);
      this.c.put(parama, local1);
      Choreographer.getInstance().postFrameCallback(local1);
      return;
    }
    e.a().a(parama);
  }
  
  public void b(d.a parama)
  {
    if (a)
    {
      Choreographer.FrameCallback localFrameCallback = (Choreographer.FrameCallback)this.c.get(parama);
      if (localFrameCallback != null)
      {
        this.c.remove(parama);
        Choreographer.getInstance().removeFrameCallback(localFrameCallback);
      }
    }
    else
    {
      e.a().b(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.a
 * JD-Core Version:    0.7.0.1
 */