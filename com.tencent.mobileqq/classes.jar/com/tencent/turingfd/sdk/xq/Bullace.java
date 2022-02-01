package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bullace
{
  public static synchronized<Cantaloupe> a = new synchronized(3);
  public static synchronized<Cantaloupe> b = new synchronized(3);
  public static List<Cantaloupe> c = new CopyOnWriteArrayList();
  public static long d = 0L;
  public static long e = 1000L;
  public static Context f;
  public static final Crux g = new Bullace.do();
  public static final Dorado h = new Bullace.if();
  
  public static void a()
  {
    if (c.size() == 0) {
      return;
    }
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Cantaloupe localCantaloupe = (Cantaloupe)localIterator.next();
      int i = localCantaloupe.b;
      if ((i != 2) && (i != 3))
      {
        if (a.b.size() != 0) {
          break label128;
        }
        synchronized (a)
        {
          a.a(localCantaloupe);
        }
      }
      synchronized (b)
      {
        b.b.size();
        b.a(localCantaloupe);
        b.b.size();
        label128:
        c.remove(localCantaloupe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bullace
 * JD-Core Version:    0.7.0.1
 */