package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode a = Shader.TileMode.CLAMP;
  private static final ImageView.ScaleType[] c = { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
  private final float[] d = { 0.0F, 0.0F, 0.0F, 0.0F };
  private Drawable e;
  private ColorStateList f = ColorStateList.valueOf(-16777216);
  private float g = 0.0F;
  private ColorFilter h = null;
  private boolean i = false;
  private Drawable j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private int n;
  private int o;
  private ImageView.ScaleType p;
  private Shader.TileMode q;
  private Shader.TileMode r;
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
    paramContext = a;
    this.q = paramContext;
    this.r = paramContext;
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Shader.TileMode localTileMode = a;
    this.q = localTileMode;
    this.r = localTileMode;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundedImageView, paramInt, 0);
    paramInt = paramContext.getInt(0, -1);
    if (paramInt >= 0) {
      setScaleType(c[paramInt]);
    } else {
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    float f2 = paramContext.getDimensionPixelSize(3, -1);
    this.d[0] = paramContext.getDimensionPixelSize(6, -1);
    this.d[1] = paramContext.getDimensionPixelSize(7, -1);
    this.d[2] = paramContext.getDimensionPixelSize(5, -1);
    this.d[3] = paramContext.getDimensionPixelSize(4, -1);
    int i2 = this.d.length;
    paramInt = 0;
    int i1 = 0;
    while (paramInt < i2)
    {
      paramAttributeSet = this.d;
      if (paramAttributeSet[paramInt] < 0.0F) {
        paramAttributeSet[paramInt] = 0.0F;
      } else {
        i1 = 1;
      }
      paramInt += 1;
    }
    if (i1 == 0)
    {
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = 0.0F;
      }
      i1 = this.d.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        this.d[paramInt] = f1;
        paramInt += 1;
      }
    }
    this.g = paramContext.getDimensionPixelSize(2, -1);
    if (this.g < 0.0F) {
      this.g = 0.0F;
    }
    this.f = paramContext.getColorStateList(1);
    if (this.f == null) {
      this.f = ColorStateList.valueOf(-16777216);
    }
    this.m = paramContext.getBoolean(8, false);
    this.l = paramContext.getBoolean(9, false);
    paramInt = paramContext.getInt(10, -2);
    if (paramInt != -2)
    {
      setTileModeX(a(paramInt));
      setTileModeY(a(paramInt));
    }
    paramInt = paramContext.getInt(11, -2);
    if (paramInt != -2) {
      setTileModeX(a(paramInt));
    }
    paramInt = paramContext.getInt(12, -2);
    if (paramInt != -2) {
      setTileModeY(a(paramInt));
    }
    c();
    a(true);
    if (this.m) {
      super.setBackgroundDrawable(this.e);
    }
    paramContext.recycle();
  }
  
  private static Shader.TileMode a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return null;
        }
        return Shader.TileMode.MIRROR;
      }
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.CLAMP;
  }
  
  private Drawable a()
  {
    Object localObject4 = getResources();
    Object localObject3 = null;
    if (localObject4 == null) {
      return null;
    }
    int i1 = this.n;
    Object localObject1 = localObject3;
    Object localObject2;
    if (i1 != 0) {
      try
      {
        localObject1 = ((Resources)localObject4).getDrawable(i1);
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Unable to find resource: ");
        ((StringBuilder)localObject4).append(this.n);
        QLog.w("RoundedImageView", 1, ((StringBuilder)localObject4).toString(), localException);
        this.n = 0;
        localObject2 = localObject3;
      }
    }
    return RoundedDrawable.a(localObject2);
  }
  
  private void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramDrawable == null) {
      return;
    }
    boolean bool = paramDrawable instanceof RoundedDrawable;
    int i1 = 0;
    if (bool)
    {
      paramDrawable = (RoundedDrawable)paramDrawable;
      paramDrawable.a(paramScaleType).a(this.g).a(this.f).a(this.l).a(this.q).b(this.r);
      paramScaleType = this.d;
      if (paramScaleType != null) {
        paramDrawable.a(paramScaleType[0], paramScaleType[1], paramScaleType[2], paramScaleType[3]);
      }
      d();
      return;
    }
    if ((paramDrawable instanceof LayerDrawable))
    {
      paramDrawable = (LayerDrawable)paramDrawable;
      int i2 = paramDrawable.getNumberOfLayers();
      while (i1 < i2)
      {
        a(paramDrawable.getDrawable(i1), paramScaleType);
        i1 += 1;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.m)
    {
      if (paramBoolean) {
        this.e = RoundedDrawable.a(this.e);
      }
      a(this.e, ImageView.ScaleType.FIT_XY);
    }
  }
  
  private Drawable b()
  {
    Object localObject4 = getResources();
    Object localObject3 = null;
    if (localObject4 == null) {
      return null;
    }
    int i1 = this.o;
    Object localObject1 = localObject3;
    Object localObject2;
    if (i1 != 0) {
      try
      {
        localObject1 = ((Resources)localObject4).getDrawable(i1);
      }
      catch (Exception localException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("Unable to find resource: ");
        ((StringBuilder)localObject4).append(this.o);
        QLog.w("RoundedImageView", 1, ((StringBuilder)localObject4).toString(), localException);
        this.o = 0;
        localObject2 = localObject3;
      }
    }
    return RoundedDrawable.a(localObject2);
  }
  
  private void c()
  {
    a(this.j, this.p);
  }
  
  private void d()
  {
    Drawable localDrawable = this.j;
    if ((localDrawable != null) && (this.i))
    {
      this.j = localDrawable.mutate();
      if (this.k) {
        this.j.setColorFilter(this.h);
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  @ColorInt
  public int getBorderColor()
  {
    return this.f.getDefaultColor();
  }
  
  public ColorStateList getBorderColors()
  {
    return this.f;
  }
  
  public float getBorderWidth()
  {
    return this.g;
  }
  
  public float getCornerRadius()
  {
    return getMaxCornerRadius();
  }
  
  public float getMaxCornerRadius()
  {
    float[] arrayOfFloat = this.d;
    int i2 = arrayOfFloat.length;
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(arrayOfFloat[i1], f1);
      i1 += 1;
    }
    return f1;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.p;
  }
  
  public Shader.TileMode getTileModeX()
  {
    return this.q;
  }
  
  public Shader.TileMode getTileModeY()
  {
    return this.r;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.e = new ColorDrawable(paramInt);
    setBackgroundDrawable(this.e);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    a(true);
    super.setBackgroundDrawable(this.e);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    if (this.o != paramInt)
    {
      this.o = paramInt;
      this.e = b();
      setBackgroundDrawable(this.e);
    }
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (this.f.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList == null) {
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
    this.f = paramColorStateList;
    c();
    a(false);
    if (this.g > 0.0F) {
      invalidate();
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (this.g == paramFloat) {
      return;
    }
    this.g = paramFloat;
    c();
    a(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.h != paramColorFilter)
    {
      this.h = paramColorFilter;
      this.k = true;
      this.i = true;
      d();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    setCornerRadius(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = this.d;
    if ((arrayOfFloat[0] == paramFloat1) && (arrayOfFloat[1] == paramFloat2) && (arrayOfFloat[2] == paramFloat4) && (arrayOfFloat[3] == paramFloat3)) {
      return;
    }
    arrayOfFloat = this.d;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[3] = paramFloat3;
    arrayOfFloat[2] = paramFloat4;
    c();
    a(false);
    invalidate();
  }
  
  public void setCornerRadius(int paramInt, float paramFloat)
  {
    float[] arrayOfFloat = this.d;
    if (arrayOfFloat[paramInt] == paramFloat) {
      return;
    }
    arrayOfFloat[paramInt] = paramFloat;
    c();
    a(false);
    invalidate();
  }
  
  public void setCornerRadiusDimen(int paramInt)
  {
    float f1 = getResources().getDimension(paramInt);
    setCornerRadius(f1, f1, f1, f1);
  }
  
  public void setCornerRadiusDimen(int paramInt1, int paramInt2)
  {
    setCornerRadius(paramInt1, getResources().getDimensionPixelSize(paramInt2));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.n = 0;
    this.j = RoundedDrawable.a(paramBitmap);
    c();
    super.setImageDrawable(this.j);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.n = 0;
    this.j = RoundedDrawable.a(paramDrawable);
    c();
    super.setImageDrawable(this.j);
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    if (this.n != paramInt)
    {
      this.n = paramInt;
      this.j = a();
      c();
      super.setImageDrawable(this.j);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    this.l = paramBoolean;
    c();
    a(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((!b) && (paramScaleType == null)) {
      throw new AssertionError();
    }
    if (this.p != paramScaleType)
    {
      this.p = paramScaleType;
      switch (RoundedImageView.1.a[paramScaleType.ordinal()])
      {
      default: 
        super.setScaleType(paramScaleType);
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        super.setScaleType(ImageView.ScaleType.FIT_XY);
      }
      c();
      a(false);
      invalidate();
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (this.q == paramTileMode) {
      return;
    }
    this.q = paramTileMode;
    c();
    a(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (this.r == paramTileMode) {
      return;
    }
    this.r = paramTileMode;
    c();
    a(false);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedImageView
 * JD-Core Version:    0.7.0.1
 */