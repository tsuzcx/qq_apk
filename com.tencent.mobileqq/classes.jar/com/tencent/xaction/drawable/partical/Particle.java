package com.tencent.xaction.drawable.partical;

import android.graphics.Matrix;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/Particle;", "", "i", "", "(I)V", "cursor", "getCursor", "()I", "setCursor", "index", "getIndex", "setIndex", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "scale", "", "getScale", "()F", "setScale", "(F)V", "x", "getX", "setX", "y", "getY", "setY", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Particle
{
  private int cursor;
  private int index;
  @NotNull
  private Matrix matrix;
  private float scale;
  private int x;
  private int y;
  
  public Particle(int paramInt)
  {
    this.index = paramInt;
    this.matrix = new Matrix();
    this.scale = 1.0F;
    this.cursor = 1;
  }
  
  public final int getCursor()
  {
    return this.cursor;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  @NotNull
  public final Matrix getMatrix()
  {
    return this.matrix;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final int getX()
  {
    return this.x;
  }
  
  public final int getY()
  {
    return this.y;
  }
  
  public final void setCursor(int paramInt)
  {
    this.cursor = paramInt;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void setMatrix(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "<set-?>");
    this.matrix = paramMatrix;
  }
  
  public final void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public final void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void setY(int paramInt)
  {
    this.y = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.Particle
 * JD-Core Version:    0.7.0.1
 */