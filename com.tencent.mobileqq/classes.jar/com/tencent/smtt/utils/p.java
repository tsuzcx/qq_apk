package com.tencent.smtt.utils;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class p
{
  private p.b a = null;
  private p.b b = null;
  
  private boolean a(p.b paramb1, p.b paramb2)
  {
    if ((paramb1 != null) && (paramb1.a() != null) && (paramb2 != null) && (paramb2.a() != null))
    {
      Object localObject1 = paramb1.a();
      paramb1 = paramb2.a();
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (p.a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (p.a)paramb1.get(localObject1);
          if ((((p.a)localObject2).a() == ((p.a)localObject1).a()) && (((p.a)localObject2).b() == ((p.a)localObject1).b())) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(File paramFile)
  {
    this.a = new p.b(this, paramFile);
  }
  
  public boolean a()
  {
    p.b localb = this.b;
    if (localb != null)
    {
      if (this.a == null) {
        return false;
      }
      if ((localb.a().size() == this.a.a().size()) && (a(this.a, this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(File paramFile)
  {
    this.b = new p.b(this, paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.p
 * JD-Core Version:    0.7.0.1
 */