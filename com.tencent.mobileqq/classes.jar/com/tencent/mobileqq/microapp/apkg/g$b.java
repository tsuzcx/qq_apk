package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g$b
{
  int a = 0;
  boolean b = false;
  boolean c = false;
  byte[] d = new byte[0];
  List e = new LinkedList();
  int f = 1;
  int g = 1;
  f h = null;
  private g.d i;
  
  private void a(int paramInt)
  {
    int j = 0;
    for (;;)
    {
      synchronized (this.d)
      {
        if (this.c) {
          return;
        }
        this.a |= paramInt;
        if (this.a == 3) {
          break label111;
        }
        if (this.b)
        {
          break label111;
          if (paramInt != 0) {
            this.c = true;
          }
          if (paramInt == 0) {
            break label110;
          }
          if ((this.g == 0) && (this.f == 0))
          {
            paramInt = j;
            this.i.onInitApkgInfo(paramInt, this.h);
          }
        }
        else
        {
          paramInt = 0;
        }
      }
      paramInt = 1;
      continue;
      label110:
      return;
      label111:
      paramInt = 1;
    }
  }
  
  public void a(g.a parama)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      g.a locala = (g.a)localIterator.next();
      if (parama.c == locala.c) {
        return;
      }
    }
    this.e.add(parama);
  }
  
  public void a(g.d paramd)
  {
    if (paramd == null) {}
    for (;;)
    {
      return;
      this.i = paramd;
      if (this.e.size() == 0)
      {
        this.i.onInitApkgInfo(1, null);
        return;
      }
      paramd = this.e.iterator();
      while (paramd.hasNext()) {
        ThreadManager.excute(new n(this, (g.a)paramd.next()), 16, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.g.b
 * JD-Core Version:    0.7.0.1
 */