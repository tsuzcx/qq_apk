package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;

public class Cepheus
{
  public static Cepheus rd = new Cepheus();
  
  public void V(Context paramContext)
  {
    if (Canesatici.B(paramContext) == 0L) {
      Canesatici.K(paramContext);
    }
  }
  
  public boolean a(Context paramContext, Canesatici paramCanesatici)
  {
    long l3 = Canesatici.B(paramContext);
    long l2 = paramCanesatici.u(paramContext);
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
    l1 = paramCanesatici.c(paramContext, "112");
    l2 = System.currentTimeMillis();
    l3 = Cassiopeia.rd.R(paramContext);
    return Math.abs(l1 - l2) >= l3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Cepheus
 * JD-Core Version:    0.7.0.1
 */