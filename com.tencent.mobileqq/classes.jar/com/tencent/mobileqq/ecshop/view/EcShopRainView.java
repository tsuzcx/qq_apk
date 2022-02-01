package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EcShopRainView
  extends View
{
  private boolean a;
  private float b;
  private float c;
  private Random d;
  private Matrix e;
  private Paint f;
  private long g;
  private int h;
  private Bitmap i = null;
  private final List<EcShopRainView.RainIcon> j = new ArrayList();
  
  public EcShopRainView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public EcShopRainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public EcShopRainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private boolean a(int paramInt)
  {
    return ((EcShopRainView.RainIcon)this.j.get(paramInt)).d > getHeight();
  }
  
  private void b()
  {
    setVisibility(8);
    setWillNotDraw(false);
    c();
    d();
  }
  
  private void b(EcShopRainView.Conf paramConf)
  {
    if (paramConf == null) {
      return;
    }
    this.b = paramConf.b;
    this.c = paramConf.c;
    this.g = System.currentTimeMillis();
    this.i = paramConf.a;
    this.j.clear();
    int k = 0;
    int m = 0;
    while (k < 8)
    {
      paramConf = new EcShopRainView.RainIcon(this.i);
      int i2 = (getWidth() - this.h * 2) / 4;
      int i1 = i2 - (int)this.c;
      int i3 = new int[] { 1, 2, 0, 3, 2, 1, 3, 0 }[k];
      Random localRandom = this.d;
      int n = i1;
      if (i1 <= 0) {
        n = 1;
      }
      paramConf.c = (i2 * i3 + localRandom.nextInt(n) + this.h);
      n = (int)-Math.ceil(this.b);
      paramConf.d = n;
      i1 = (int)((getHeight() + -n) * 16.0F / (this.d.nextInt(501) + 1500));
      n = i1;
      if (i1 == 0) {
        n = 1;
      }
      paramConf.e = n;
      paramConf.a = m;
      this.j.add(paramConf);
      m += this.d.nextInt(300);
      k += 1;
    }
  }
  
  private void c()
  {
    this.d = new Random();
    this.h = DisplayUtil.a(getContext(), 20.0F);
  }
  
  private void d()
  {
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setFilterBitmap(true);
    this.f.setDither(true);
    this.e = new Matrix();
  }
  
  public void a()
  {
    this.a = false;
    setVisibility(8);
    Bitmap localBitmap = this.i;
    if (localBitmap == null) {
      return;
    }
    if (!localBitmap.isRecycled()) {
      this.i.recycle();
    }
  }
  
  public void a(EcShopRainView.Conf paramConf)
  {
    if (paramConf != null)
    {
      if (paramConf.a == null) {
        return;
      }
      a();
      setVisibility(0);
      post(new EcShopRainView.1(this, paramConf));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.a) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.g;
    int k = this.j.size();
    int m = 0;
    if (k > 0) {
      for (k = 0;; k = n)
      {
        n = k;
        if (m >= this.j.size()) {
          break;
        }
        EcShopRainView.RainIcon localRainIcon = (EcShopRainView.RainIcon)this.j.get(m);
        Bitmap localBitmap = localRainIcon.b;
        n = k;
        if (!localBitmap.isRecycled())
        {
          n = k;
          if (!a(m)) {
            if (l1 - l2 < localRainIcon.a)
            {
              n = k;
            }
            else
            {
              this.e.reset();
              float f1 = this.b / localBitmap.getHeight();
              float f2 = this.c / localBitmap.getWidth();
              this.e.setScale(f2, f1);
              localRainIcon.d += localRainIcon.e;
              this.e.postTranslate(localRainIcon.c, localRainIcon.d);
              paramCanvas.drawBitmap(localBitmap, this.e, this.f);
              n = 1;
            }
          }
        }
        m += 1;
      }
    }
    int n = 0;
    if (n == 0)
    {
      a();
      return;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcShopRainView
 * JD-Core Version:    0.7.0.1
 */