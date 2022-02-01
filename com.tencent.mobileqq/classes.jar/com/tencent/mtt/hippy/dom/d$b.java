package com.tencent.mtt.hippy.dom;

import java.util.ArrayDeque;

class d$b
  implements d.a
{
  private d$b(d paramd) {}
  
  public void a(long paramLong)
  {
    d locald = this.a;
    int i = 0;
    locald.c = false;
    int j = locald.a.size();
    while (i < j)
    {
      ((d.a)this.a.a.removeFirst()).a(paramLong);
      locald = this.a;
      locald.b -= 1;
      i += 1;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.d.b
 * JD-Core Version:    0.7.0.1
 */