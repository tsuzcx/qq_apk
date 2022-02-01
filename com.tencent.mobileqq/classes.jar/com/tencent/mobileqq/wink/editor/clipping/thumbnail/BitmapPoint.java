package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import .r8.java8methods.utility.Long.hashCode.IJ;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/BitmapPoint;", "", "bitmap", "Landroid/graphics/Bitmap;", "time", "", "(Landroid/graphics/Bitmap;J)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BitmapPoint
{
  @Nullable
  private final Bitmap a;
  private final long b;
  
  public BitmapPoint(@Nullable Bitmap paramBitmap, long paramLong)
  {
    this.a = paramBitmap;
    this.b = paramLong;
  }
  
  @Nullable
  public final Bitmap a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BitmapPoint))
      {
        paramObject = (BitmapPoint)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (this.b == paramObject.b)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Bitmap localBitmap = this.a;
    int i;
    if (localBitmap != null) {
      i = localBitmap.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BitmapPoint(bitmap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.BitmapPoint
 * JD-Core Version:    0.7.0.1
 */