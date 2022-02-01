package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "", "bitmap", "Landroid/graphics/Bitmap;", "key", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSSegmentManager$BitmapWithKey
{
  @Nullable
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  public WSSegmentManager$BitmapWithKey(@Nullable Bitmap paramBitmap, @NotNull String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BitmapWithKey))
      {
        paramObject = (BitmapWithKey)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_AndroidGraphicsBitmap, paramObject.jdField_a_of_type_AndroidGraphicsBitmap)) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString))) {}
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
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BitmapWithKey(bitmap=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSSegmentManager.BitmapWithKey
 * JD-Core Version:    0.7.0.1
 */