package com.tencent.xaction.anim;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/XARect;", "", "id", "", "bitmap", "Landroid/graphics/Bitmap;", "x", "", "y", "w", "h", "rotate", "alpha", "(ILandroid/graphics/Bitmap;FFIIFF)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getH", "()I", "setH", "(I)V", "getId", "setId", "getRotate", "setRotate", "getW", "setW", "getX", "setX", "getY", "setY", "centerX", "centerY", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "", "XAPhysical_release"}, k=1, mv={1, 1, 16})
public final class XARect
{
  private int a;
  @Nullable
  private Bitmap b;
  private float c;
  private float d;
  private int e;
  private int f;
  private float g;
  private float h;
  
  public XARect(int paramInt1, @Nullable Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4)
  {
    this.a = paramInt1;
    this.b = paramBitmap;
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramFloat3;
    this.h = paramFloat4;
  }
  
  public final float a()
  {
    return this.c + this.e / 2;
  }
  
  public final void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public final float b()
  {
    return this.d + this.f / 2;
  }
  
  public final void b(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  @Nullable
  public final Bitmap c()
  {
    return this.b;
  }
  
  public final void c(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public final float d()
  {
    return this.c;
  }
  
  public final float e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof XARect))
      {
        paramObject = (XARect)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Float.compare(this.c, paramObject.c) == 0) && (Float.compare(this.d, paramObject.d) == 0) && (this.e == paramObject.e) && (this.f == paramObject.f) && (Float.compare(this.g, paramObject.g) == 0) && (Float.compare(this.h, paramObject.h) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.e;
  }
  
  public final int g()
  {
    return this.f;
  }
  
  public final float h()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    int j = this.a;
    Bitmap localBitmap = this.b;
    int i;
    if (localBitmap != null) {
      i = localBitmap.hashCode();
    } else {
      i = 0;
    }
    return ((((((j * 31 + i) * 31 + Float.floatToIntBits(this.c)) * 31 + Float.floatToIntBits(this.d)) * 31 + this.e) * 31 + this.f) * 31 + Float.floatToIntBits(this.g)) * 31 + Float.floatToIntBits(this.h);
  }
  
  public final float i()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XARect(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", bitmap=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", w=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", h=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", alpha=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.XARect
 * JD-Core Version:    0.7.0.1
 */