package com.tencent.smtt.utils;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n
{
  private n.b a = null;
  private n.b b = null;
  
  private boolean a(n.b paramb1, n.b paramb2)
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
        localObject2 = (n.a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (n.a)paramb1.get(localObject1);
          if ((((n.a)localObject2).a() != ((n.a)localObject1).a()) || (((n.a)localObject2).b() != ((n.a)localObject1).b())) {
            return false;
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
    this.a = new n.b(this, paramFile);
  }
  
  public boolean a()
  {
    if ((this.b == null) || (this.a == null)) {}
    while ((this.b.a().size() != this.a.a().size()) || (!a(this.a, this.b))) {
      return false;
    }
    return true;
  }
  
  public void b(File paramFile)
  {
    this.b = new n.b(this, paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */