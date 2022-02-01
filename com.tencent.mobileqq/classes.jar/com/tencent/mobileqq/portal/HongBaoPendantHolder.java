package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class HongBaoPendantHolder
  extends BaseAnimHolder
{
  private Interpolator G;
  private int H = 0;
  RectF a = new RectF();
  RectF b = new RectF();
  public boolean c = false;
  BaseAnimHolder d;
  BaseAnimHolder e;
  BaseAnimHolder f;
  public SaQianView g;
  public int h = 0;
  public Context i;
  public View j;
  public int k = 2;
  ImageSwitchAnim l;
  int m;
  int n;
  ImageSwitchAnimView o = null;
  public int p = 2;
  public int q = 0;
  public long r = 0L;
  public long s = 1L;
  public int t = 0;
  public int u = 0;
  public int v = 0;
  
  public HongBaoPendantHolder(View paramView)
  {
    this.j = paramView;
    this.i = paramView.getContext();
    this.g = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.g.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    this.o = new ImageSwitchAnimView(this.i);
  }
  
  public RectF a(int paramInt)
  {
    float f1 = this.z / 4;
    RectF localRectF = this.a;
    float f2 = this.x;
    float f3 = this.y;
    float f4 = this.t;
    float f5 = paramInt;
    localRectF.set(f2 - f1, f3 - f1 + f4 - f5, this.x + this.z + f1, this.y + this.A + f1 + this.t - f5);
    return this.a;
  }
  
  public void a()
  {
    if (!this.c) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.r);
    float f1 = 1.0F;
    f2 = f2 * 1.0F / (float)this.s;
    Interpolator localInterpolator = this.G;
    if (localInterpolator != null)
    {
      float f3 = localInterpolator.getInterpolation(f2);
      if (f3 <= 1.0F) {
        f1 = f3;
      }
    }
    else
    {
      f1 = f2;
    }
    int i1 = this.v;
    c((int)(i1 + (this.u - i1) * f1));
    if (f2 > 0.99D)
    {
      i1 = this.p;
      if (i1 != 1)
      {
        if (i1 != 3)
        {
          e();
          return;
        }
        this.p = 2;
        return;
      }
      this.p = 3;
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.h = paramInt2;
    this.d = new BaseAnimHolder();
    paramInt2 = (int)this.i.getResources().getDimension(2131299023);
    this.m = ((int)this.i.getResources().getDimension(2131299022));
    paramInt3 = this.z / 2;
    paramInt4 = paramInt2 / 2;
    this.d.B = this.i.getResources().getDrawable(2130846894);
    this.d.a(paramInt1 + paramInt3 - paramInt4, 0, paramInt2, this.m, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    int i1 = this.h;
    this.v = i1;
    this.u = (i1 + paramInt);
    this.G = new DecelerateInterpolator();
    this.p = 1;
    a(paramLong);
  }
  
  public void a(long paramLong)
  {
    this.s = paramLong;
    this.r = AnimationUtils.currentAnimationTimeMillis();
    this.c = true;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",switchAnim = ");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).b(paramBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f = new BaseAnimHolder();
      int i1 = (int)this.i.getResources().getDimension(2131299002);
      int i2 = (int)this.i.getResources().getDimension(2131298999);
      int i4 = (int)this.i.getResources().getDimension(2131299000);
      int i3 = this.j.getWidth() - i4 - i1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init close Btn, mParentView.getWidth() = ");
        localStringBuilder.append(this.j.getWidth());
        localStringBuilder.append("closeBtnRightMargin = ");
        localStringBuilder.append(i4);
        localStringBuilder.append("closeBtnWidth = ");
        localStringBuilder.append(i1);
        localStringBuilder.append("closeBtnLeft = ");
        localStringBuilder.append(i3);
        QLog.d("HongBaoPendantHolder", 2, localStringBuilder.toString());
      }
      i4 = (int)this.j.getResources().getDimension(2131299001);
      this.f.B = this.i.getResources().getDrawable(2130846864);
      this.f.a(i3, i4, i1, i2, this.j);
    }
    else
    {
      this.f = null;
    }
    a();
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchLogo ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      int i1 = (int)this.j.getResources().getDimension(2131299003);
      if (this.B == null) {
        this.B = new BitmapDrawable(this.i.getResources(), BitmapFactory.decodeResource(this.i.getResources(), 2130846728).copy(Bitmap.Config.ARGB_8888, true));
      }
      int i2 = (int)this.j.getResources().getDimension(2131299020);
      int i4 = (int)this.j.getResources().getDimension(2131299015);
      int i3 = (int)this.j.getResources().getDimension(2131299019);
      i4 = this.j.getWidth() - i2 - i4;
      this.n = i3;
      localObject = paramBitmap;
      Bitmap localBitmap;
      if (paramBitmap == null) {
        try
        {
          if (this.k == 1)
          {
            localObject = BitmapFactory.decodeResource(this.i.getResources(), 2130846911);
            paramBitmap = (Bitmap)localObject;
          }
          else
          {
            localObject = BitmapFactory.decodeResource(this.i.getResources(), 2130846729);
            paramBitmap = (Bitmap)localObject;
          }
          localObject = paramBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          localBitmap = paramBitmap;
        }
      }
      float f1;
      float f4;
      float f2;
      float f3;
      float f5;
      if (this.k == 1)
      {
        f1 = this.j.getResources().getDimension(2131299006);
        f4 = localBitmap.getHeight() * f1 / localBitmap.getWidth();
        f2 = i1 - f4 - this.j.getResources().getDimension(2131299010);
        f3 = this.j.getResources().getDimension(2131299009);
        f5 = f1;
      }
      else
      {
        f1 = this.j.getResources().getDimension(2131299005);
        f2 = i1 - f1 - this.j.getResources().getDimension(2131299008);
        f3 = (i2 - f1) / 2.0F;
        f5 = f1;
        f4 = f1;
      }
      if (this.l == null)
      {
        this.l = new ImageSwitchAnim(this.i, i2, i1, i4, i3, (int)f3, (int)f2, (int)f5, (int)f4);
        this.l.n = ((int)this.j.getResources().getDimension(2131299017));
        this.l.o = ((int)this.j.getResources().getDimension(2131299016));
        try
        {
          this.l.c(BitmapFactory.decodeResource(this.i.getResources(), 2130846730));
        }
        catch (OutOfMemoryError paramBitmap)
        {
          paramBitmap.printStackTrace();
        }
      }
      paramBitmap = this.l;
      paramBitmap.e = ((int)f3);
      paramBitmap.f = ((int)f2);
      paramBitmap.g = ((int)f5);
      paramBitmap.h = ((int)f4);
      if (this.k == 1)
      {
        paramBitmap.p = ((int)this.j.getResources().getDimension(2131299013));
        this.l.q = ((int)this.j.getResources().getDimension(2131299011));
      }
      else
      {
        paramBitmap.p = ((int)this.j.getResources().getDimension(2131299014));
        this.l.q = 0;
      }
      if (this.k == 3)
      {
        this.l.a(localBitmap);
        this.l.b();
      }
      else
      {
        this.l.b(localBitmap);
      }
      a(i4, i3, i2, i1, this.j);
      if (paramBoolean)
      {
        this.e = null;
      }
      else
      {
        this.e = new BaseAnimHolder();
        this.H = ((int)this.i.getResources().getDimension(2131298998));
        int i5 = (int)this.i.getResources().getDimension(2131298997);
        int i6 = (int)this.i.getResources().getDimension(2131298996);
        i2 /= 2;
        int i7 = i5 / 2;
        int i8 = this.H;
        this.e.B = this.i.getResources().getDrawable(2130846722);
        this.e.a(i4 + i2 - i7, i3 + i1 + i8, i5, i6, this.j);
      }
      a();
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool3 = super.i();
    a();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.t);
    if ((this.d != null) && (this.E != 0))
    {
      this.d.E = this.E;
      this.d.a(paramCanvas);
    }
    super.d(paramCanvas);
    Object localObject = this.f;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).a(paramCanvas);
    }
    localObject = this.l;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ImageSwitchAnim)localObject).a(paramCanvas);
    } else {
      bool1 = false;
    }
    if ((this.e != null) && (this.E != 0))
    {
      this.e.E = this.E;
      this.e.a(paramCanvas);
    }
    this.g.a(paramCanvas);
    paramCanvas.restore();
    if ((this.c) || (bool3) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public RectF b(int paramInt)
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      float f1 = ((BaseAnimHolder)localObject).z;
      this.b.set(this.f.x - f1, this.f.y - f1 + this.t, this.f.x + this.f.z + f1, this.f.y + this.f.A + f1 + this.t);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCloseBtnTouchRect debug click event, span = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", closeBtnHolder.x = ");
        ((StringBuilder)localObject).append(this.f.x);
        ((StringBuilder)localObject).append(", closeBtnHolder.y = ");
        ((StringBuilder)localObject).append(this.f.y);
        ((StringBuilder)localObject).append(", closeBtnHolder.width = ");
        ((StringBuilder)localObject).append(this.f.z);
        ((StringBuilder)localObject).append(", closeBtnHolder.height = ");
        ((StringBuilder)localObject).append(this.f.A);
        ((StringBuilder)localObject).append(", offsetY = ");
        ((StringBuilder)localObject).append(this.t);
        ((StringBuilder)localObject).append(", listViewScrollY = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", closeBtnTouchRect = ");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
      }
      return this.b;
    }
    return null;
  }
  
  public void b()
  {
    this.v = this.y;
    this.u = this.h;
    this.p = 3;
    this.G = new BounceInterpolatorX();
    a(1500L);
  }
  
  public void c()
  {
    super.c();
    e();
    this.D = 1.0F;
    this.C = 1.0F;
    ImageSwitchAnim localImageSwitchAnim = this.l;
    if (localImageSwitchAnim != null)
    {
      localImageSwitchAnim.j = 1.0F;
      localImageSwitchAnim.i = 1.0F;
    }
  }
  
  public void c(int paramInt)
  {
    float f1 = paramInt;
    int i1 = this.n;
    f1 = f1 * 1.0F / i1;
    float f2 = this.m - i1;
    this.y = paramInt;
    Object localObject = this.d;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).A = ((int)(f2 * f1) + paramInt);
    }
    localObject = this.l;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).d = paramInt;
    }
    localObject = this.e;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).y = (paramInt + this.A + this.H);
    }
    if (this.g != null)
    {
      paramInt = (int)this.i.getResources().getDimension(2131299018);
      this.g.a(paramInt + this.x + this.z / 2, this.y);
    }
  }
  
  public void d()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new HongBaoPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.g.b();
  }
  
  public void e()
  {
    this.c = false;
    this.r = -1L;
    this.s = 1L;
    this.p = 2;
    c(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder
 * JD-Core Version:    0.7.0.1
 */