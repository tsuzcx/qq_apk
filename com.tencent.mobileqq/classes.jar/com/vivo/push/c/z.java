package com.vivo.push.c;

import com.vivo.push.b.t;
import com.vivo.push.e;
import com.vivo.push.m;
import com.vivo.push.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class z
  extends y
{
  z(o paramo)
  {
    super(paramo);
  }
  
  protected final void a(o paramo)
  {
    paramo = (t)paramo;
    Object localObject2 = paramo.d();
    Object localObject1 = paramo.e();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    int j = paramo.h();
    String str1 = paramo.g();
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        if (str2.startsWith("ali/")) {
          localArrayList2.add(str2.replace("ali/", ""));
        } else if (str2.startsWith("tag/")) {
          localArrayList1.add(str2.replace("tag/", ""));
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith("ali/")) {
          localArrayList4.add(((String)localObject2).replace("ali/", ""));
        } else if (((String)localObject2).startsWith("tag/")) {
          localArrayList3.add(((String)localObject2).replace("tag/", ""));
        }
      }
    }
    if ((localArrayList1.size() > 0) || (localArrayList3.size() > 0))
    {
      if (localArrayList1.size() > 0) {
        e.a().a(localArrayList1);
      }
      localObject1 = e.a();
      localObject2 = paramo.g();
      int i;
      if (localArrayList3.size() > 0) {
        i = 10000;
      } else {
        i = j;
      }
      ((e)localObject1).a((String)localObject2, i);
      m.b(new aa(this, j, localArrayList1, localArrayList3, str1));
    }
    if ((localArrayList2.size() > 0) || (localArrayList4.size() > 0))
    {
      if (localArrayList2.size() > 0) {
        e.a().b((String)localArrayList2.get(0));
      }
      e.a().a(paramo.g(), j);
      m.b(new ab(this, j, localArrayList2, localArrayList4, str1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.z
 * JD-Core Version:    0.7.0.1
 */