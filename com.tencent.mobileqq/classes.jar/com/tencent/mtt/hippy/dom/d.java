package com.tencent.mtt.hippy.dom;

import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayDeque;

public class d
{
  private static d d;
  final ArrayDeque<d.a> a = new ArrayDeque();
  int b = 0;
  boolean c = false;
  private final d.b e = new d.b(this, null);
  
  public static d a()
  {
    if (d == null) {
      d = new d();
    }
    return d;
  }
  
  public void a(d.a parama)
  {
    if (!this.a.contains(parama))
    {
      this.a.addLast(parama);
      this.b += 1;
      if (!this.c) {
        try
        {
          a.a().a(this.e);
          this.c = true;
          return;
        }
        catch (Exception parama)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("postFrameCallback: ");
          localStringBuilder.append(parama.getMessage());
          LogUtils.d("HippyChoreographer", localStringBuilder.toString());
        }
      }
    }
  }
  
  void b()
  {
    if ((this.b == 0) && (this.c))
    {
      a.a().b(this.e);
      this.c = false;
    }
  }
  
  public void b(d.a parama)
  {
    if (this.a.removeFirstOccurrence(parama))
    {
      this.b -= 1;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.d
 * JD-Core Version:    0.7.0.1
 */