package com.tencent.mobileqq.multiaio.utils;

import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class GC
{
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 25)
    {
      Runtime.getRuntime().gc();
      Runtime.getRuntime().gc();
      Runtime.getRuntime().runFinalization();
      return;
    }
    int i = 0;
    while (i < 2)
    {
      ArrayList localArrayList = new ArrayList();
      double d1;
      double d2;
      do
      {
        localArrayList.add(new WeakReference(new byte[100]));
        d1 = Math.random();
        d2 = localArrayList.size();
        Double.isNaN(d2);
      } while (((WeakReference)localArrayList.get((int)(d1 * d2))).get() != null);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.utils.GC
 * JD-Core Version:    0.7.0.1
 */