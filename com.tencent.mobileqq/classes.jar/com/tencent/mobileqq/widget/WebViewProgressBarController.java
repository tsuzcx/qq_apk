package com.tencent.mobileqq.widget;

import android.os.Handler;

public class WebViewProgressBarController
{
  protected WebViewProgressBar a;
  public boolean b = true;
  private byte c = -1;
  private int d = 0;
  private Handler e = new WebViewProgressBarController.MainThreadHandler(this);
  private boolean f = false;
  private int g = 255;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private byte m = 6;
  private long n;
  
  private long a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong > 30L) {
      l1 = 30L;
    }
    return l1;
  }
  
  public byte a()
  {
    return this.m;
  }
  
  public void a(byte paramByte)
  {
    if (!this.b) {
      return;
    }
    if (paramByte != 0)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2) {
          return;
        }
        paramByte = this.c;
        if ((paramByte == 0) || (paramByte == 1)) {
          g();
        }
        this.c = 2;
        return;
      }
      f();
      return;
    }
    if (this.c == 0) {
      return;
    }
    this.c = 0;
    e();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(WebViewProgressBar paramWebViewProgressBar)
  {
    this.a = paramWebViewProgressBar;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean == this.b) {
      return;
    }
    if (!paramBoolean)
    {
      if (this.c != 2) {
        a((byte)2);
      }
      this.a.setVisibility(8);
      this.b = false;
    }
  }
  
  public float b()
  {
    return this.l;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public byte d()
  {
    return this.c;
  }
  
  public void e()
  {
    int i2 = WebViewProgressBarController.DurationGenerator.a(0).b();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = WebViewProgressBarController.DurationGenerator.a(0).a();
    }
    this.j = (20.0F / i1);
    this.i = 0.0F;
    this.m = 0;
    this.l = this.k;
    this.g = 255;
    this.n = System.currentTimeMillis();
    WebViewProgressBar localWebViewProgressBar = this.a;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.setVisibility(0);
    }
    i();
  }
  
  public void f()
  {
    WebViewProgressBarController.DurationGenerator.a(0).c();
    int i2 = WebViewProgressBarController.DurationGenerator.a(1).b();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = WebViewProgressBarController.DurationGenerator.a(1).a();
    }
    this.j = (60.0F / i1);
    this.n = System.currentTimeMillis();
    this.m = 2;
    this.c = 1;
    i();
  }
  
  public void g()
  {
    WebViewProgressBarController.DurationGenerator.a(1).c();
    this.n = System.currentTimeMillis();
    this.m = 5;
    this.j = 0.1333333F;
    float f1 = this.i;
    if (f1 <= 60.0F)
    {
      this.j = (((60.0F - f1) * 0.5F + 40.0F) / 300.0F);
      this.h = 0.8166667F;
    }
    else
    {
      this.h = (this.j * 245.0F / (100.0F - f1));
    }
    i();
  }
  
  public void h()
  {
    this.m = 6;
    this.i = 0.0F;
    this.k = ((int)(this.i * this.d / 100.0F));
    this.g = 255;
    this.n = System.currentTimeMillis();
  }
  
  public void i()
  {
    if (this.m != 6)
    {
      long l1 = System.currentTimeMillis();
      float f1 = this.i;
      if (f1 >= 100.0F)
      {
        h();
      }
      else
      {
        int i1 = this.m;
        long l2;
        float f2;
        float f3;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 3)
              {
                if (i1 != 4)
                {
                  if (i1 == 5)
                  {
                    l2 = a(l1 - this.n);
                    f1 = this.i;
                    f2 = (float)l2;
                    this.i = (f1 + this.j * f2);
                    this.n = l1;
                    i1 = this.d;
                    this.l = (i1 * this.i / 100.0F);
                    if (this.f)
                    {
                      if (this.l >= i1) {
                        this.l = i1;
                      }
                    }
                    else
                    {
                      this.g -= (int)(f2 * this.h);
                      if (this.g <= 0)
                      {
                        h();
                        this.g = 0;
                      }
                    }
                  }
                }
                else {
                  this.l = (this.d * f1 / 100.0F);
                }
              }
              else
              {
                l2 = a(l1 - this.n);
                this.i += (float)l2 * this.j;
                this.n = l1;
                if (this.i >= 98.0F)
                {
                  this.n = l1;
                  this.m = 4;
                  this.j = 0.0F;
                }
                this.l = (this.d * this.i / 100.0F);
              }
            }
            else
            {
              l2 = a(l1 - this.n);
              f1 = this.i;
              f2 = (float)l2;
              f3 = this.j;
              this.i = (f1 + f2 * f3);
              this.n = l1;
              if (this.i >= 80.0F)
              {
                this.n = l1;
                this.m = 3;
                this.j = (f3 / 20.0F);
              }
              this.l = (this.d * this.i / 100.0F);
            }
          }
          else
          {
            l2 = a(l1 - this.n);
            this.i += (float)l2 * this.j;
            this.n = l1;
            if (this.i >= 98.0F)
            {
              this.n = l1;
              this.m = 4;
              this.i = 98.0F;
              this.j = 0.0F;
            }
            this.l = (this.d * this.i / 100.0F);
          }
        }
        else
        {
          l2 = a(l1 - this.n);
          f1 = this.i;
          f2 = (float)l2;
          f3 = this.j;
          this.i = (f1 + f2 * f3);
          this.n = l1;
          if (this.i >= 20.0F)
          {
            this.n = l1;
            this.m = 1;
            this.j = (f3 / 5.0F);
          }
          this.l = (this.d * this.i / 100.0F);
        }
      }
      this.e.removeMessages(200);
      this.e.sendEmptyMessageDelayed(200, 20L);
    }
    WebViewProgressBar localWebViewProgressBar = this.a;
    if (localWebViewProgressBar != null) {
      localWebViewProgressBar.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController
 * JD-Core Version:    0.7.0.1
 */