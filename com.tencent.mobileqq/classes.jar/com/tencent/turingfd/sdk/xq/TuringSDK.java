package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

public class TuringSDK
  extends final
{
  public TuringSDK(TuringSDK.Builder paramBuilder)
  {
    this.b = TuringSDK.Builder.a(paramBuilder);
    this.d = TuringSDK.Builder.b(paramBuilder);
    this.r = TuringSDK.Builder.c(paramBuilder);
    this.s = TuringSDK.Builder.d(paramBuilder);
    this.h = TuringSDK.Builder.e(paramBuilder);
    this.g = TuringSDK.Builder.f(paramBuilder);
    this.i = TuringSDK.Builder.g(paramBuilder);
    this.j = TuringSDK.Builder.h(paramBuilder);
    this.k = TuringSDK.Builder.i(paramBuilder);
    this.c = TuringSDK.Builder.j(paramBuilder);
    this.l = TuringSDK.Builder.k(paramBuilder);
    this.e = TuringSDK.Builder.l(paramBuilder);
    this.m = TuringSDK.Builder.m(paramBuilder);
    this.f = TuringSDK.Builder.n(paramBuilder);
    this.p = TuringSDK.Builder.o(paramBuilder);
    TuringSDK.Builder.p(paramBuilder);
    this.n = TuringSDK.Builder.q(paramBuilder);
    this.o = TuringSDK.Builder.r(paramBuilder);
    this.q = TuringSDK.Builder.s(paramBuilder);
    this.a = new TuringSDK.do(this, TuringSDK.Builder.t(paramBuilder));
  }
  
  public static TuringSDK.Builder a(Context paramContext)
  {
    return new TuringSDK.Builder(paramContext);
  }
  
  public static String c()
  {
    return while.b();
  }
  
  public void d()
  {
    if (while.d.get()) {
      return;
    }
    synchronized (while.c)
    {
      int i = this.c;
      if (i > 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("c : ");
        localStringBuilder.append(this.c);
        Log.i("TuringFdJava", localStringBuilder.toString());
        native.a = this.c;
      }
      if (while.b.get())
      {
        while.a(this);
        return;
      }
      if (while.d.get()) {
        return;
      }
      while.d.set(true);
      System.currentTimeMillis();
      if (!while.b(this))
      {
        while.b.set(false);
        return;
      }
      if (native.a == 0)
      {
        Log.e("TuringFdJava", "pleace input channel info");
        while.b.set(false);
        return;
      }
      while.a(this);
      while.b.set(true);
      while.d.set(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringSDK
 * JD-Core Version:    0.7.0.1
 */