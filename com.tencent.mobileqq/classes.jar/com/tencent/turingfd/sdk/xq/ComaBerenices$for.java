package com.tencent.turingfd.sdk.xq;

import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComaBerenices$for
  implements Eridanus
{
  public int a;
  public long b = -1L;
  public long c;
  public List<ComaBerenices.new> d = new ArrayList();
  public String e;
  public boolean f = false;
  public boolean g = false;
  
  public ComaBerenices$for(ComaBerenices paramComaBerenices, String paramString, int paramInt)
  {
    this.a = paramInt;
    this.e = paramString;
  }
  
  public final void a()
  {
    this.b = -1L;
    this.c = 0L;
    this.d.clear();
    this.f = false;
    this.g = false;
  }
  
  public void a(Equuleus paramEquuleus)
  {
    if (!this.e.equals(paramEquuleus.m)) {
      return;
    }
    int j = paramEquuleus.g;
    int i = 0;
    boolean bool;
    if (j <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramEquuleus.h == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.g = bool;
    }
    j = paramEquuleus.f;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3) {
            return;
          }
          a();
          return;
        }
        if (this.b != -1L) {
          i = 1;
        }
        if (i != 0)
        {
          paramEquuleus = new ComaBerenices.new(this.h, 2, paramEquuleus.i, paramEquuleus.j, paramEquuleus.k, paramEquuleus.l);
        }
        else
        {
          a();
          paramEquuleus = new ComaBerenices.new(this.h, 0, paramEquuleus.i, paramEquuleus.j, paramEquuleus.k, paramEquuleus.l);
          this.b = System.currentTimeMillis();
        }
        this.d.add(paramEquuleus);
        return;
      }
      long l1 = this.b;
      this.c = (System.currentTimeMillis() - l1);
      paramEquuleus = new ComaBerenices.new(this.h, 1, paramEquuleus.i, paramEquuleus.j, paramEquuleus.k, paramEquuleus.l);
      this.d.add(paramEquuleus);
      Object localObject1 = this.h;
      paramEquuleus = this.d;
      localObject1.getClass();
      localObject1 = new ArrayList();
      ComaBerenices.new localnew;
      if (paramEquuleus.size() <= 8)
      {
        ((ArrayList)localObject1).addAll(paramEquuleus);
      }
      else
      {
        localObject2 = (ComaBerenices.new)paramEquuleus.get(0);
        localnew = (ComaBerenices.new)paramEquuleus.get(paramEquuleus.size() - 1);
        paramEquuleus.remove(localObject2);
        paramEquuleus.remove(localnew);
        j = (int)Math.ceil(paramEquuleus.size() / 6);
        ((ArrayList)localObject1).add(localObject2);
        i = 1;
        while (i < paramEquuleus.size())
        {
          ((ArrayList)localObject1).add((ComaBerenices.new)paramEquuleus.get(i));
          i += j;
        }
        ((ArrayList)localObject1).add(localnew);
      }
      paramEquuleus = this.h;
      l1 = this.b;
      long l2 = this.c;
      paramEquuleus.getClass();
      paramEquuleus = new Pyxis();
      paramEquuleus.c = ((int)l2);
      paramEquuleus.b = l1;
      Object localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localnew = (ComaBerenices.new)((Iterator)localObject1).next();
        Sagittarius localSagittarius = new Sagittarius();
        i = localnew.a;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                localSagittarius.a = 0;
              } else {
                localSagittarius.a = 4;
              }
            }
            else {
              localSagittarius.a = 2;
            }
          }
          else {
            localSagittarius.a = 3;
          }
        }
        else {
          localSagittarius.a = 1;
        }
        localSagittarius.b = localnew.b;
        localSagittarius.c = localnew.c;
        localSagittarius.d = localnew.d;
        localSagittarius.e = localnew.e;
        ((ArrayList)localObject2).add(localSagittarius);
      }
      paramEquuleus.d = ((ArrayList)localObject2);
      if ((!this.f) && (!this.g))
      {
        localObject2 = this.h;
        localObject1 = this.e;
        i = this.a;
        localObject2 = ((ComaBerenices)localObject2).d;
        if (localObject2 != null) {
          ((Crux)localObject2).a((String)localObject1, i, 1, paramEquuleus);
        }
      }
      else
      {
        localObject2 = this.h;
        localObject1 = this.e;
        i = this.a;
        localObject2 = ((ComaBerenices)localObject2).d;
        if (localObject2 != null) {
          ((Crux)localObject2).a((String)localObject1, i, 2, paramEquuleus);
        }
      }
      a();
      return;
    }
    a();
    this.b = System.currentTimeMillis();
    paramEquuleus = new ComaBerenices.new(this.h, 0, paramEquuleus.i, paramEquuleus.j, paramEquuleus.k, paramEquuleus.l);
    this.d.add(paramEquuleus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.ComaBerenices.for
 * JD-Core Version:    0.7.0.1
 */