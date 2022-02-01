package com.tencent.tkd.topicsdk.imagecompress.engine;

import .r8.java8methods.utility.Integer.hashCode.II;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/GifEngine$Frame;", "", "bitmap", "Landroid/graphics/Bitmap;", "duration", "", "(Landroid/graphics/Bitmap;I)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getDuration", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GifEngine$Frame
{
  @NotNull
  private final Bitmap a;
  private final int b;
  
  public GifEngine$Frame(@NotNull Bitmap paramBitmap, int paramInt)
  {
    this.a = paramBitmap;
    this.b = paramInt;
  }
  
  @NotNull
  public final Bitmap a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Frame))
      {
        paramObject = (Frame)paramObject;
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
    return i * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame(bitmap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngine.Frame
 * JD-Core Version:    0.7.0.1
 */