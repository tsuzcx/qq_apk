package com.tencent.tkd.topicsdk.imagecompress.engine;

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
    if (this != paramObject)
    {
      if ((paramObject instanceof Frame))
      {
        paramObject = (Frame)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_AndroidGraphicsBitmap, paramObject.jdField_a_of_type_AndroidGraphicsBitmap)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0) {
      return i * 31 + Integer.hashCode(this.jdField_a_of_type_Int);
    }
  }
  
  @NotNull
  public String toString()
  {
    return "Frame(bitmap=" + this.jdField_a_of_type_AndroidGraphicsBitmap + ", duration=" + this.jdField_a_of_type_Int + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.GifEngine.Frame
 * JD-Core Version:    0.7.0.1
 */