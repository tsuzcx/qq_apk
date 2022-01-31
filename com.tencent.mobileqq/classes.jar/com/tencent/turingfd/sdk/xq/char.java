package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class char
{
  public static AtomicBoolean A = new AtomicBoolean(false);
  public static AtomicBoolean B = new AtomicBoolean(false);
  public static final Object C = new Object();
  public static AtomicBoolean D = new AtomicBoolean(false);
  
  static
  {
    Log.d("TuringFdJava", getVersionInfo());
  }
  
  public static void a(case paramcase)
  {
    boolean bool1 = true;
    if (D.get()) {
      return;
    }
    synchronized (C)
    {
      if (B.get())
      {
        switch.Yb.a(paramcase);
        return;
      }
    }
    if (D.get()) {
      return;
    }
    D.set(true);
    if (!A.get())
    {
      if (paramcase.n())
      {
        TextUtils.isEmpty(paramcase.k());
        String str = paramcase.k();
        for (;;)
        {
          try
          {
            boolean bool2 = TextUtils.isEmpty(str);
            if (!bool2) {
              continue;
            }
            System.loadLibrary("turingxq");
          }
          catch (Throwable localThrowable)
          {
            Log.w("TuringFdJava", localThrowable);
            bool1 = false;
            continue;
          }
          A.set(bool1);
          if (bool1) {
            break label150;
          }
          return;
          System.load(str);
        }
      }
      A.set(true);
    }
    label150:
    switch.Yb.a(paramcase);
    B.set(true);
    D.set(false);
  }
  
  public static String getVersionInfo()
  {
    return String.format(Locale.getDefault(), "TuringFD v%d (c%d, l%s, t%d, %s, %s, e%d, d%d, compiled %s)", new Object[] { Integer.valueOf(38), Integer.valueOf(105668), "E4CB9BCAD0D4BD9B", Integer.valueOf(1), "xqMini", "taf", Integer.valueOf(0), Integer.valueOf(0), "2019_12_26_23_42_36" });
  }
  
  public static int o()
  {
    if (!A.get()) {
      return -10001;
    }
    if (!B.get()) {
      return -10002;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.char
 * JD-Core Version:    0.7.0.1
 */