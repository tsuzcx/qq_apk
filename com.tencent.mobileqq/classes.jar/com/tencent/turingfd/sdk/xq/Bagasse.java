package com.tencent.turingfd.sdk.xq;

import android.content.Context;

public class Bagasse
{
  public static Bagasse zg = new Bagasse();
  
  public static Bagasse getInstance()
  {
    return zg;
  }
  
  public boolean a(Context paramContext, Almond paramAlmond)
  {
    long l1 = paramAlmond.d(paramContext, "112");
    long l2 = System.currentTimeMillis();
    long l3 = Arbutus.zg.I(paramContext);
    return Math.abs(l1 - l2) >= l3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bagasse
 * JD-Core Version:    0.7.0.1
 */