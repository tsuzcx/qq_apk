package com.tencent.tbs.one.impl.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g<T>
  extends a<T>
{
  private List<a<T>> b;
  private a<T> c;
  
  public g(a<T>[] paramArrayOfa)
  {
    this.b = new ArrayList(Arrays.asList(paramArrayOfa));
  }
  
  protected final void a()
  {
    c();
  }
  
  public final void b()
  {
    super.b();
    a locala = this.c;
    if (locala != null) {
      locala.b();
    }
  }
  
  final void c()
  {
    List localList = this.b;
    boolean bool = false;
    this.c = ((a)localList.remove(0));
    if (this.b.size() == 0) {
      bool = true;
    }
    this.c.a(new g.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.g
 * JD-Core Version:    0.7.0.1
 */