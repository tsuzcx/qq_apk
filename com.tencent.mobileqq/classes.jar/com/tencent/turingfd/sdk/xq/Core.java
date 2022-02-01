package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public class Core
{
  public static Core Tg = new Core();
  
  public boolean a(Context paramContext, Cascara paramCascara)
  {
    long l3 = Cascara.L(paramContext);
    long l2 = paramCascara.E(paramContext);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 14400000L;
    }
    int i;
    if (Math.abs(l3 - System.currentTimeMillis()) >= l1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    l1 = paramCascara.f(paramContext, "112");
    l2 = System.currentTimeMillis();
    l3 = Coconut.Tg.aa(paramContext);
    return Math.abs(l1 - l2) >= l3;
  }
  
  public void ea(Context paramContext)
  {
    if (Cascara.L(paramContext) == 0L) {
      Cascara.T(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Core
 * JD-Core Version:    0.7.0.1
 */