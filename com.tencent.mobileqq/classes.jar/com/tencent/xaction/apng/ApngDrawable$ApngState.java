package com.tencent.xaction.apng;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.image.ApngImage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/ApngDrawable$ApngState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "mApng", "Lcom/tencent/image/ApngImage;", "(Lcom/tencent/image/ApngImage;)V", "getMApng", "()Lcom/tencent/image/ApngImage;", "setMApng", "mChangingConfigurations", "", "getMChangingConfigurations", "()I", "setMChangingConfigurations", "(I)V", "mGravity", "getMGravity", "setMGravity", "mPaint", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "mTargetDensity", "getMTargetDensity", "setMTargetDensity", "getChangingConfigurations", "newDrawable", "Landroid/graphics/drawable/Drawable;", "res", "Landroid/content/res/Resources;", "XAApng_release"}, k=1, mv={1, 1, 16})
public final class ApngDrawable$ApngState
  extends Drawable.ConstantState
{
  private int a;
  private int b;
  private int c;
  @NotNull
  private Paint d;
  @Nullable
  private ApngImage e;
  
  public ApngDrawable$ApngState(@Nullable ApngImage paramApngImage)
  {
    this.e = paramApngImage;
    this.b = 119;
    this.c = 160;
    this.d = new Paint(6);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  @NotNull
  public final Paint c()
  {
    return this.d;
  }
  
  @Nullable
  public final ApngImage d()
  {
    return this.e;
  }
  
  public int getChangingConfigurations()
  {
    return this.a;
  }
  
  @NotNull
  public Drawable newDrawable()
  {
    return (Drawable)new ApngDrawable().init(this, null);
  }
  
  @NotNull
  public Drawable newDrawable(@Nullable Resources paramResources)
  {
    return (Drawable)new ApngDrawable().init(this, paramResources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.ApngDrawable.ApngState
 * JD-Core Version:    0.7.0.1
 */