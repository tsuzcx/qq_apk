package com.tencent.mobileqq.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView.ScaleType;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RoundedDrawable
  extends Drawable
{
  private final RectF a = new RectF();
  private final RectF b = new RectF();
  private final RectF c = new RectF();
  private final Bitmap d;
  private final Paint e;
  private final int f;
  private final int g;
  private final RectF h = new RectF();
  private final Paint i;
  private final Matrix j = new Matrix();
  private final RectF k = new RectF();
  private Shader.TileMode l = Shader.TileMode.CLAMP;
  private Shader.TileMode m = Shader.TileMode.CLAMP;
  private boolean n = true;
  private float o = 0.0F;
  private final boolean[] p = { 1, 1, 1, 1 };
  private boolean q = false;
  private float r = 0.0F;
  private ColorStateList s = ColorStateList.valueOf(-16777216);
  private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;
  
  public RoundedDrawable(Bitmap paramBitmap)
  {
    this.d = paramBitmap;
    this.f = paramBitmap.getWidth();
    this.g = paramBitmap.getHeight();
    this.c.set(0.0F, 0.0F, this.f, this.g);
    this.e = new Paint();
    this.e.setStyle(Paint.Style.FILL);
    this.e.setAntiAlias(true);
    this.i = new Paint();
    this.i.setStyle(Paint.Style.STROKE);
    this.i.setAntiAlias(true);
    this.i.setColor(this.s.getColorForState(getState(), -16777216));
    this.i.setStrokeWidth(this.r);
  }
  
  public static Drawable a(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof RoundedDrawable)) {
        return paramDrawable;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        localObject = paramDrawable.mutate().getConstantState();
        if (localObject != null) {
          paramDrawable = ((Drawable.ConstantState)localObject).newDrawable();
        }
        paramDrawable = (LayerDrawable)paramDrawable;
        int i2 = paramDrawable.getNumberOfLayers();
        int i1 = 0;
        while (i1 < i2)
        {
          localObject = paramDrawable.getDrawable(i1);
          paramDrawable.setDrawableByLayerId(paramDrawable.getId(i1), a((Drawable)localObject));
          i1 += 1;
        }
        return paramDrawable;
      }
      Bitmap localBitmap = b(paramDrawable);
      localObject = paramDrawable;
      if (localBitmap != null) {
        localObject = new RoundedDrawable(localBitmap);
      }
    }
    return localObject;
  }
  
  public static RoundedDrawable a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return new RoundedDrawable(paramBitmap);
    }
    return null;
  }
  
  private void a()
  {
    int i1 = RoundedDrawable.1.a[this.t.ordinal()];
    Object localObject;
    float f1;
    if (i1 != 1)
    {
      float f2;
      float f3;
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 5)
          {
            if (i1 != 6)
            {
              if (i1 != 7)
              {
                this.h.set(this.c);
                this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.h);
                localObject = this.h;
                f1 = this.r;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              }
              else
              {
                this.h.set(this.a);
                localObject = this.h;
                f1 = this.r;
                ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
                this.j.reset();
                this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
              }
            }
            else
            {
              this.h.set(this.c);
              this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
              this.j.mapRect(this.h);
              localObject = this.h;
              f1 = this.r;
              ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
              this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
            }
          }
          else
          {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            localObject = this.h;
            f1 = this.r;
            ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
          }
        }
        else
        {
          this.j.reset();
          if ((this.f <= this.a.width()) && (this.g <= this.a.height())) {
            f1 = 1.0F;
          } else {
            f1 = Math.min(this.a.width() / this.f, this.a.height() / this.g);
          }
          f2 = (int)((this.a.width() - this.f * f1) * 0.5F + 0.5F);
          f3 = (int)((this.a.height() - this.g * f1) * 0.5F + 0.5F);
          this.j.setScale(f1, f1);
          this.j.postTranslate(f2, f3);
          this.h.set(this.c);
          this.j.mapRect(this.h);
          localObject = this.h;
          f1 = this.r;
          ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
          this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
      }
      else
      {
        this.h.set(this.a);
        localObject = this.h;
        f1 = this.r;
        ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
        this.j.reset();
        f2 = this.f;
        f3 = this.h.height();
        float f4 = this.h.width();
        float f5 = this.g;
        f1 = 0.0F;
        if (f2 * f3 > f4 * f5)
        {
          f2 = this.h.height() / this.g;
          f3 = (this.h.width() - this.f * f2) * 0.5F;
        }
        else
        {
          f2 = this.h.width() / this.f;
          f1 = (this.h.height() - this.g * f2) * 0.5F;
          f3 = 0.0F;
        }
        this.j.setScale(f2, f2);
        localObject = this.j;
        f2 = (int)(f3 + 0.5F);
        f3 = this.r;
        ((Matrix)localObject).postTranslate(f2 + f3 / 2.0F, (int)(f1 + 0.5F) + f3 / 2.0F);
      }
    }
    else
    {
      this.h.set(this.a);
      localObject = this.h;
      f1 = this.r;
      ((RectF)localObject).inset(f1 / 2.0F, f1 / 2.0F);
      this.j.reset();
      this.j.setTranslate((int)((this.h.width() - this.f) * 0.5F + 0.5F), (int)((this.h.height() - this.g) * 0.5F + 0.5F));
    }
    this.b.set(this.h);
    this.n = true;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (b(this.p)) {
      return;
    }
    if (this.o == 0.0F) {
      return;
    }
    float f1 = this.b.left;
    float f2 = this.b.top;
    float f3 = this.b.width() + f1;
    float f4 = this.b.height() + f2;
    float f5 = this.o;
    if (this.p[0] == 0)
    {
      this.k.set(f1, f2, f1 + f5, f2 + f5);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[1] == 0)
    {
      this.k.set(f3 - f5, f2, f3, f5);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[2] == 0)
    {
      this.k.set(f3 - f5, f4 - f5, f3, f4);
      paramCanvas.drawRect(this.k, this.e);
    }
    if (this.p[3] == 0)
    {
      this.k.set(f1, f4 - f5, f5 + f1, f4);
      paramCanvas.drawRect(this.k, this.e);
    }
  }
  
  private static boolean a(boolean[] paramArrayOfBoolean)
  {
    int i2 = paramArrayOfBoolean.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfBoolean[i1] != 0) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i1 = Math.max(paramDrawable.getIntrinsicWidth(), 2);
    int i2 = Math.max(paramDrawable.getIntrinsicHeight(), 2);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (Throwable paramDrawable)
    {
      label76:
      break label76;
    }
    QLog.e("RoundedDrawable", 1, "Failed to create bitmap from drawable!");
    return null;
  }
  
  private void b(Canvas paramCanvas)
  {
    if (b(this.p)) {
      return;
    }
    if (this.o == 0.0F) {
      return;
    }
    float f1 = this.b.left;
    float f2 = this.b.top;
    float f3 = f1 + this.b.width();
    float f4 = f2 + this.b.height();
    float f5 = this.o;
    float f6 = this.r / 2.0F;
    if (this.p[0] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f2, f1 + f5, f2, this.i);
      paramCanvas.drawLine(f1, f2 - f6, f1, f2 + f5, this.i);
    }
    if (this.p[1] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f2, f3, f2, this.i);
      paramCanvas.drawLine(f3, f2 - f6, f3, f2 + f5, this.i);
    }
    if (this.p[2] == 0)
    {
      paramCanvas.drawLine(f3 - f5 - f6, f4, f3 + f6, f4, this.i);
      paramCanvas.drawLine(f3, f4 - f5, f3, f4, this.i);
    }
    if (this.p[3] == 0)
    {
      paramCanvas.drawLine(f1 - f6, f4, f1 + f5, f4, this.i);
      paramCanvas.drawLine(f1, f4 - f5, f1, f4, this.i);
    }
  }
  
  private static boolean b(boolean[] paramArrayOfBoolean)
  {
    int i2 = paramArrayOfBoolean.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramArrayOfBoolean[i1] != 0) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public RoundedDrawable a(float paramFloat)
  {
    this.r = paramFloat;
    this.i.setStrokeWidth(this.r);
    return this;
  }
  
  public RoundedDrawable a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = new HashSet(4);
    ((Set)localObject).add(Float.valueOf(paramFloat1));
    ((Set)localObject).add(Float.valueOf(paramFloat2));
    ((Set)localObject).add(Float.valueOf(paramFloat3));
    ((Set)localObject).add(Float.valueOf(paramFloat4));
    ((Set)localObject).remove(Float.valueOf(0.0F));
    if (((Set)localObject).size() <= 1)
    {
      if (!((Set)localObject).isEmpty())
      {
        float f1 = ((Float)((Set)localObject).iterator().next()).floatValue();
        if ((!Float.isInfinite(f1)) && (!Float.isNaN(f1)) && (f1 >= 0.0F))
        {
          this.o = f1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid radius value: ");
          ((StringBuilder)localObject).append(f1);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.o = 0.0F;
      }
      localObject = this.p;
      int i2 = 0;
      if (paramFloat1 > 0.0F) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject[0] = i1;
      localObject = this.p;
      if (paramFloat2 > 0.0F) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject[1] = i1;
      localObject = this.p;
      if (paramFloat3 > 0.0F) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject[2] = i1;
      localObject = this.p;
      int i1 = i2;
      if (paramFloat4 > 0.0F) {
        i1 = 1;
      }
      localObject[3] = i1;
      return this;
    }
    throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
  }
  
  public RoundedDrawable a(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(0);
    }
    this.s = paramColorStateList;
    this.i.setColor(this.s.getColorForState(getState(), -16777216));
    return this;
  }
  
  public RoundedDrawable a(Shader.TileMode paramTileMode)
  {
    if (this.l != paramTileMode)
    {
      this.l = paramTileMode;
      this.n = true;
      invalidateSelf();
    }
    return this;
  }
  
  public RoundedDrawable a(ImageView.ScaleType paramScaleType)
  {
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.FIT_CENTER;
    }
    if (this.t != localScaleType)
    {
      this.t = localScaleType;
      a();
    }
    return this;
  }
  
  public RoundedDrawable a(boolean paramBoolean)
  {
    this.q = paramBoolean;
    return this;
  }
  
  public RoundedDrawable b(Shader.TileMode paramTileMode)
  {
    if (this.m != paramTileMode)
    {
      this.m = paramTileMode;
      this.n = true;
      invalidateSelf();
    }
    return this;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.n)
    {
      BitmapShader localBitmapShader = new BitmapShader(this.d, this.l, this.m);
      if ((this.l == Shader.TileMode.CLAMP) && (this.m == Shader.TileMode.CLAMP)) {
        localBitmapShader.setLocalMatrix(this.j);
      }
      this.e.setShader(localBitmapShader);
      this.n = false;
    }
    if (this.q)
    {
      if (this.r > 0.0F)
      {
        paramCanvas.drawOval(this.b, this.e);
        paramCanvas.drawOval(this.h, this.i);
        return;
      }
      paramCanvas.drawOval(this.b, this.e);
      return;
    }
    if (a(this.p))
    {
      float f1 = this.o;
      if (this.r > 0.0F)
      {
        paramCanvas.drawRoundRect(this.b, f1, f1, this.e);
        paramCanvas.drawRoundRect(this.h, f1, f1, this.i);
        a(paramCanvas);
        b(paramCanvas);
        return;
      }
      paramCanvas.drawRoundRect(this.b, f1, f1, this.e);
      a(paramCanvas);
      return;
    }
    paramCanvas.drawRect(this.b, this.e);
    if (this.r > 0.0F) {
      paramCanvas.drawRect(this.h, this.i);
    }
  }
  
  public int getAlpha()
  {
    return this.e.getAlpha();
  }
  
  public ColorFilter getColorFilter()
  {
    return this.e.getColorFilter();
  }
  
  public int getIntrinsicHeight()
  {
    return this.g;
  }
  
  public int getIntrinsicWidth()
  {
    return this.f;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean isStateful()
  {
    return this.s.isStateful();
  }
  
  protected void onBoundsChange(@NonNull Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.a.set(paramRect);
    a();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i1 = this.s.getColorForState(paramArrayOfInt, 0);
    if (this.i.getColor() != i1)
    {
      this.i.setColor(i1);
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.e.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.e.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedDrawable
 * JD-Core Version:    0.7.0.1
 */