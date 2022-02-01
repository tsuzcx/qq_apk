package com.tencent.tmdownloader.internal.downloadservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class f
{
  protected static f a;
  protected final List<h> b = Collections.synchronizedList(new ArrayList());
  
  public static f a()
  {
    if (a == null) {
      a = new f();
    }
    return a;
  }
  
  public void a(h paramh)
  {
    try
    {
      if (!this.b.contains(paramh)) {
        this.b.add(paramh);
      }
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(paramString);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(paramString1, paramInt1, paramInt2, paramString2);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(paramString, paramLong1, paramLong2);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(h paramh)
  {
    try
    {
      this.b.remove(paramh);
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadservice.f
 * JD-Core Version:    0.7.0.1
 */