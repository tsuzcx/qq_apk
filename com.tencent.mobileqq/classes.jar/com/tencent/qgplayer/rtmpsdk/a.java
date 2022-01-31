package com.tencent.qgplayer.rtmpsdk;

import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.view.TextureView;

public class a
{
  private TextureView a;
  private Handler b;
  private int c = 0;
  private int d = 0;
  private int e = 640;
  private int f = 480;
  private int g = 0;
  private int h = 0;
  private int i = 1;
  private boolean j = false;
  
  public a(TextureView paramTextureView)
  {
    this.a = paramTextureView;
    this.c = paramTextureView.getWidth();
    this.d = paramTextureView.getHeight();
    this.b = new Handler(paramTextureView.getContext().getMainLooper());
  }
  
  private void a()
  {
    try
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          a.a(a.this, a.a(a.this), a.b(a.this));
          a.a(a.this, a.c(a.this));
        }
      });
      return;
    }
    catch (Exception localException)
    {
      QGLog.e("QGPlayer.VideoViewWrapper", "adjustVideSize Exception : " + localException.toString());
    }
  }
  
  private void b(int paramInt)
  {
    this.i = paramInt;
    if ((this.a != null) && (this.h > 0) && (this.g > 0))
    {
      this.j = false;
      float f1 = 1.0F;
      float f2;
      if (paramInt == 0)
      {
        f1 = this.d / this.h;
        f2 = this.c / this.g;
        if (f1 >= f2) {
          break label106;
        }
        f1 = f2;
      }
      label106:
      for (;;)
      {
        f2 = f1;
        if (f1 < 0.0F) {
          f2 = -f1;
        }
        if (f2 != 0.0F)
        {
          this.a.setScaleX(f2);
          this.a.setScaleY(Math.abs(f2));
        }
        return;
      }
    }
    this.j = true;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoViewWrapper", "now viewWidth : " + this.c + " , viewHeight : " + this.d + " , videoWidth : " + paramInt1 + " , videoHeight : " + paramInt2);
    if ((this.a == null) || (paramInt1 == 0) || (paramInt2 == 0)) {}
    while ((this.c == 0) || (this.d == 0)) {
      return;
    }
    double d1 = paramInt2 / paramInt1;
    if (this.d > (int)(this.c * d1)) {
      this.g = this.c;
    }
    for (this.h = ((int)(d1 * this.c));; this.h = this.d)
    {
      float f1 = (this.c - this.g) / 2.0F;
      float f2 = (this.d - this.h) / 2.0F;
      float f3 = this.g / this.c;
      float f4 = this.h / this.d;
      Matrix localMatrix = new Matrix();
      this.a.getTransform(localMatrix);
      localMatrix.setScale(f3, f4);
      localMatrix.postTranslate(f1, f2);
      this.a.setTransform(localMatrix);
      this.a.requestLayout();
      QGLog.i("QGPlayer.VideoViewWrapper", "mVideoShowWidth : " + this.g + " , mVideoShowHeight : " + this.h);
      return;
      this.g = ((int)(this.d / d1));
    }
  }
  
  public void a(final int paramInt)
  {
    try
    {
      this.b.post(new Runnable()
      {
        public void run()
        {
          a.a(a.this, paramInt);
        }
      });
      return;
    }
    catch (Exception localException)
    {
      QGLog.e("QGPlayer.VideoViewWrapper", "setRenderMode Exception : " + localException.toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoViewWrapper", "setVideoSize, width = " + paramInt1 + ", height = " + paramInt2);
    this.e = paramInt1;
    this.f = paramInt2;
    a();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    QGLog.i("QGPlayer.VideoViewWrapper", "setViewSize, width = " + paramInt1 + ", height = " + paramInt2);
    this.c = paramInt1;
    this.d = paramInt2;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qgplayer.rtmpsdk.a
 * JD-Core Version:    0.7.0.1
 */