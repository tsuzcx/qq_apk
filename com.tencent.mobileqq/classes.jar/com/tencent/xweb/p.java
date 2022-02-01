package com.tencent.xweb;

import android.content.Context;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class p
{
  static boolean a = false;
  static List<p.a> b = new ArrayList();
  
  public static void a()
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      Context localContext = XWalkEnvironment.getApplicationContext();
      if (localContext == null) {
        return;
      }
      try
      {
        XWalkEnvironment.getApplicationContext().registerReceiver(new p.b(null), new IntentFilter("com.tencent.xweb.update"));
        a = true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("registerReceiver failed exception is ");
        localStringBuilder.append(localException.getMessage());
        Log.e("UpdateListener", localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  static void a(int paramInt)
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((p.a)localIterator.next()).b(paramInt);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void a(p.a parama)
  {
    try
    {
      a();
      if (parama == null) {
        return;
      }
      boolean bool = b.contains(parama);
      if (bool) {
        return;
      }
      b.add(parama);
      return;
    }
    finally {}
  }
  
  static void b()
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((p.a)localIterator.next()).a();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  static void b(int paramInt)
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((p.a)localIterator.next()).a(paramInt);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static void b(p.a parama)
  {
    try
    {
      a();
      if (parama == null) {
        return;
      }
      boolean bool = b.contains(parama);
      if (!bool) {
        return;
      }
      b.remove(parama);
      return;
    }
    finally {}
  }
  
  static void c()
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((p.a)localIterator.next()).b();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  static void d()
  {
    try
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        ((p.a)localIterator.next()).c();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.p
 * JD-Core Version:    0.7.0.1
 */