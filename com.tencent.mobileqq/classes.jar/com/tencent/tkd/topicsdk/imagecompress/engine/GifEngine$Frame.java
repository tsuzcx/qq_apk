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
  private final int jdField_a_of_type_Int;
  @NotNull
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  public GifEngine$Frame(@NotNull Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Frame))
      {
        paramObject = (Frame)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_AndroidGraphicsBitmap, paramObject.jdField_a_of_type_AndroidGraphicsBitmap)) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int)) {}
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
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    int i;
    if (localBitmap != null) {
      i = localBitmap.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.jdField_a_of_type_Int);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame(bitmap=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngine.Frame
 * JD-Core Version:    0.7.0.1
 */