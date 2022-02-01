package com.tencent.rlottie;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

class AXrLottieDrawable$5
  implements Runnable
{
  AXrLottieDrawable$5(AXrLottieDrawable paramAXrLottieDrawable) {}
  
  public void run()
  {
    if (AXrLottieDrawable.c(this.this$0))
    {
      if (AXrLottieDrawable.j(this.this$0) != null) {
        AXrLottieDrawable.j(this.this$0).onRecycle();
      }
      return;
    }
    if (AXrLottieDrawable.e(this.this$0) == 0L)
    {
      if (AXrLottieDrawable.k(this.this$0) != null) {
        AXrLottieDrawable.k(this.this$0).countDown();
      }
      AXrLottieDrawable.l().post(AXrLottieDrawable.l(this.this$0));
      return;
    }
    if (AXrLottieDrawable.m(this.this$0) == null) {
      try
      {
        AXrLottieDrawable.a(this.this$0, Bitmap.createBitmap(AXrLottieDrawable.g(this.this$0), AXrLottieDrawable.h(this.this$0), Bitmap.Config.ARGB_8888));
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    if (AXrLottieDrawable.m(this.this$0) != null) {}
    for (;;)
    {
      try
      {
        if (AXrLottieNative.getFrame(AXrLottieDrawable.e(this.this$0), AXrLottieDrawable.n(this.this$0), AXrLottieDrawable.m(this.this$0), AXrLottieDrawable.g(this.this$0), AXrLottieDrawable.h(this.this$0), AXrLottieDrawable.m(this.this$0).getRowBytes()) == -1)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFrame fail, ret:-1, currentFrame:");
          localStringBuilder.append(AXrLottieDrawable.n(this.this$0));
          Log.e("AXrLottieDrawable", localStringBuilder.toString());
          AXrLottieDrawable.l().post(AXrLottieDrawable.l(this.this$0));
          if (AXrLottieDrawable.k(this.this$0) == null) {
            break label951;
          }
          AXrLottieDrawable.k(this.this$0).countDown();
          return;
        }
        if (AXrLottieDrawable.o(this.this$0)[2] != 0)
        {
          AXrLottieDrawable.l().post(AXrLottieDrawable.p(this.this$0));
          AXrLottieDrawable.o(this.this$0)[2] = 0;
        }
        AXrLottieDrawable.b(this.this$0, AXrLottieDrawable.m(this.this$0));
        i = this.this$0.a();
        int j = this.this$0.c();
        int k = this.this$0.d();
        if ((this.this$0.b()) && (AXrLottieDrawable.q(this.this$0)))
        {
          if (AXrLottieDrawable.n(this.this$0) > j)
          {
            if (AXrLottieDrawable.n(this.this$0) - i > j)
            {
              AXrLottieDrawable.a(this.this$0, AXrLottieDrawable.n(this.this$0) - i);
              AXrLottieDrawable.b(this.this$0, false);
            }
            else
            {
              AXrLottieDrawable.b(this.this$0, true);
            }
          }
          else if (AXrLottieDrawable.n(this.this$0) + i < j)
          {
            AXrLottieDrawable.a(this.this$0, AXrLottieDrawable.n(this.this$0) + i);
            AXrLottieDrawable.b(this.this$0, false);
          }
          else
          {
            AXrLottieDrawable.b(this.this$0, true);
          }
          if (AXrLottieDrawable.n(this.this$0) < k)
          {
            AXrLottieDrawable.a(this.this$0, k);
            AXrLottieDrawable.b(this.this$0, true);
          }
        }
        else
        {
          if (AXrLottieDrawable.r(this.this$0) == 2)
          {
            if (AXrLottieDrawable.s(this.this$0))
            {
              AXrLottieDrawable.a(this.this$0, AXrLottieDrawable.n(this.this$0) - i);
              if (AXrLottieDrawable.n(this.this$0) > k) {
                break label957;
              }
              AXrLottieDrawable.c(this.this$0, false);
              break label952;
            }
            AXrLottieDrawable.a(this.this$0, AXrLottieDrawable.n(this.this$0) + i);
            if (AXrLottieDrawable.n(this.this$0) < j) {
              break label957;
            }
            AXrLottieDrawable.c(this.this$0, true);
            break label952;
            AXrLottieDrawable.b(this.this$0, false);
          }
          else
          {
            if (AXrLottieDrawable.n(this.this$0) + i < j)
            {
              AXrLottieDrawable.a(this.this$0, AXrLottieDrawable.n(this.this$0) + i);
              AXrLottieDrawable.b(this.this$0, false);
              break label962;
            }
            if (AXrLottieDrawable.t(this.this$0) != -1) {
              break label967;
            }
            AXrLottieDrawable.a(this.this$0, k);
            AXrLottieDrawable.b(this.this$0, false);
            if (AXrLottieDrawable.j(this.this$0) == null) {
              break label962;
            }
            AXrLottieDrawable.j(this.this$0).onRepeat(-1, false);
            break label962;
          }
          if ((i != 0) && (AXrLottieDrawable.t(this.this$0) >= 0))
          {
            AXrLottieDrawable.u(this.this$0);
            if (AXrLottieDrawable.v(this.this$0) >= AXrLottieDrawable.t(this.this$0))
            {
              AXrLottieDrawable.c(this.this$0, false);
              AXrLottieDrawable.b(this.this$0, true);
              if (AXrLottieDrawable.j(this.this$0) != null) {
                AXrLottieDrawable.j(this.this$0).onRepeat(AXrLottieDrawable.v(this.this$0), true);
              }
            }
            else if (AXrLottieDrawable.r(this.this$0) == 1)
            {
              AXrLottieDrawable.a(this.this$0, k);
              if (AXrLottieDrawable.j(this.this$0) != null) {
                AXrLottieDrawable.j(this.this$0).onRepeat(AXrLottieDrawable.v(this.this$0), false);
              }
            }
          }
          else if (AXrLottieDrawable.n(this.this$0) > j)
          {
            AXrLottieDrawable.a(this.this$0, j);
          }
          else if (AXrLottieDrawable.n(this.this$0) < k)
          {
            AXrLottieDrawable.a(this.this$0, k);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      AXrLottieDrawable.l().post(AXrLottieDrawable.w(this.this$0));
      if (AXrLottieDrawable.k(this.this$0) != null) {
        AXrLottieDrawable.k(this.this$0).countDown();
      }
      return;
      label951:
      return;
      label952:
      int i = 1;
      continue;
      label957:
      i = 0;
      continue;
      label962:
      i = 0;
      continue;
      label967:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieDrawable.5
 * JD-Core Version:    0.7.0.1
 */