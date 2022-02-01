package com.tencent.mtt.hippy.dom;

import java.util.ArrayDeque;

class d$b
  implements d.a
{
  private d$b(d paramd) {}
  
  public void a(long paramLong)
  {
    this.a.c = false;
    int j = this.a.a.size();
    int i = 0;
    while (i < j)
    {
      ((d.a)this.a.a.removeFirst()).a(paramLong);
      d locald = this.a;
      locald.b -= 1;
      i += 1;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.d.b
 * JD-Core Version:    0.7.0.1
 */