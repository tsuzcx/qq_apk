package com.tencent.mobileqq.troop.shortcutbar;

import java.util.ArrayList;
import java.util.Iterator;

public class TroopShortcutBarInfo
{
  private long a = 0L;
  private long b = 0L;
  private int c = 0;
  private int d = 0;
  private long e = 0L;
  private int f = 0;
  private long g = 0L;
  private ArrayList<TroopShortcutBarApp> h;
  
  public TroopShortcutBarInfo()
  {
    this.a = 0L;
    this.c = 0;
    this.d = 0;
    this.h = null;
  }
  
  public TroopShortcutBarInfo(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, ArrayList<TroopShortcutBarApp> paramArrayList)
  {
    this.a = paramLong1;
    this.b = (System.currentTimeMillis() + paramInt1 * 1000);
    this.c = paramInt2;
    this.d = paramInt3;
    this.f = (paramInt4 * 1000);
    this.h = paramArrayList;
    this.g = paramLong2;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public TroopShortcutBarApp a(long paramLong)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)localIterator.next();
      if (localTroopShortcutBarApp.d() == paramLong) {
        return localTroopShortcutBarApp;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public long c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.b = paramInt;
  }
  
  public ArrayList<TroopShortcutBarApp> d()
  {
    return this.h;
  }
  
  public void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public long e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public long g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo
 * JD-Core Version:    0.7.0.1
 */