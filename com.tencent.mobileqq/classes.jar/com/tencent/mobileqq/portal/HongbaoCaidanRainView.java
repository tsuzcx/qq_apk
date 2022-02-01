package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HongbaoCaidanRainView
  extends View
{
  private long a = 0L;
  private long b = 0L;
  private long c = 0L;
  private List<HongbaoCaidanRainView.Node> d = new ArrayList();
  private List<HongbaoCaidanRainView.Node> e = new ArrayList();
  private List<Bitmap> f = new ArrayList(5);
  private Random g = new Random(System.currentTimeMillis());
  private boolean h = false;
  private boolean i = false;
  private Matrix j = new Matrix();
  private int k = 1000;
  private float l = 0.0F;
  private int m = 0;
  private float n = 0.0F;
  private float o = 10.0F;
  private float p = 1.0F;
  private float q = 0.0F;
  private int r = 0;
  
  public HongbaoCaidanRainView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HongbaoCaidanRainView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (this.f.size() == 0) {
      return;
    }
    int i1 = 0;
    while (i1 < paramInt)
    {
      HongbaoCaidanRainView.Node localNode = new HongbaoCaidanRainView.Node(null);
      localNode.a = this.g.nextInt(this.k);
      localNode.c = this.g.nextInt(360);
      float f1 = this.g.nextFloat();
      float f2 = this.n;
      double d1 = this.g.nextFloat();
      int i3 = -1;
      if (d1 > 0.5D) {
        i2 = 1;
      } else {
        i2 = -1;
      }
      localNode.f = (f1 * f2 * i2);
      Object localObject = this.f;
      localNode.h = ((Bitmap)((List)localObject).get(this.g.nextInt(((List)localObject).size())));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addNode n.bitmap = ");
        ((StringBuilder)localObject).append(localNode.h);
        QLog.d("HongbaoCaidanRainView", 2, ((StringBuilder)localObject).toString());
      }
      localNode.g = (this.m * 1.0F / localNode.h.getWidth() * (this.g.nextFloat() * this.l + 1.0F));
      localNode.e = (this.g.nextFloat() * this.q + this.o);
      f1 = this.g.nextFloat();
      f2 = this.p;
      int i2 = i3;
      if (this.g.nextFloat() > 0.5D) {
        i2 = 1;
      }
      localNode.d = (f1 * f2 * i2);
      localNode.b = ((int)(-localNode.h.getHeight() * localNode.g));
      this.d.add(localNode);
      i1 += 1;
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3)
  {
    this.k = paramInt1;
    this.l = paramFloat1;
    this.m = paramInt2;
    this.n = paramFloat2;
    this.o = paramFloat3;
    this.q = paramFloat5;
    this.r = paramInt3;
    this.p = paramFloat4;
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(2, null);
    }
  }
  
  public void a(Bitmap... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(), Bitmap=");
      localStringBuilder.append(paramVarArgs);
      QLog.d("HongbaoCaidanRainView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.2(this, paramVarArgs), null, true);
  }
  
  public void a(String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start(), paths=");
      localStringBuilder.append(paramVarArgs);
      QLog.d("HongbaoCaidanRainView", 2, localStringBuilder.toString());
    }
    ThreadManager.postImmediately(new HongbaoCaidanRainView.1(this, paramVarArgs), null, true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.i)
    {
      if (!this.h) {
        return;
      }
      super.onDraw(paramCanvas);
      long l1 = System.currentTimeMillis();
      if ((l1 - this.a < 1300L) && (l1 - this.b > 40L))
      {
        a(1);
        this.b = l1;
      }
      double d1 = l1 - this.c;
      Double.isNaN(d1);
      float f1 = (float)(d1 * 1.0D / 1000.0D);
      this.c = l1;
      int i3 = this.d.size();
      int i2 = 0;
      int i1 = 0;
      HongbaoCaidanRainView.Node localNode;
      while (i1 < i3)
      {
        localNode = (HongbaoCaidanRainView.Node)this.d.get(i1);
        localNode.b = ((int)(localNode.b + localNode.e * f1));
        if (localNode.b > this.r)
        {
          this.e.add(localNode);
        }
        else
        {
          localNode.a = ((int)(localNode.a + localNode.d * f1));
          localNode.c += localNode.f * f1;
        }
        i1 += 1;
      }
      this.d.removeAll(this.e);
      this.e.clear();
      i3 = this.d.size();
      i1 = i2;
      if (i3 == 0)
      {
        this.h = false;
        return;
      }
      while (i1 < i3)
      {
        localNode = (HongbaoCaidanRainView.Node)this.d.get(i1);
        this.j.reset();
        this.j.setTranslate(-localNode.h.getWidth() / 2, -localNode.h.getHeight() / 2);
        this.j.postRotate(localNode.c);
        this.j.preScale(localNode.g, localNode.g);
        this.j.postTranslate(localNode.a, localNode.b);
        paramCanvas.drawBitmap(localNode.h, this.j, null);
        i1 += 1;
      }
      invalidate();
    }
  }
  
  public void setPause(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.i) {
      this.d.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoCaidanRainView
 * JD-Core Version:    0.7.0.1
 */