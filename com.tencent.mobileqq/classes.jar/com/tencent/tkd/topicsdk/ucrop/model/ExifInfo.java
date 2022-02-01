package com.tencent.tkd.topicsdk.ucrop.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/model/ExifInfo;", "", "exifOrientation", "", "exifDegrees", "exifTranslation", "(III)V", "getExifDegrees", "()I", "setExifDegrees", "(I)V", "getExifOrientation", "setExifOrientation", "getExifTranslation", "setExifTranslation", "equals", "", "other", "hashCode", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public final class ExifInfo
{
  private int a;
  private int b;
  private int c;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((ExifInfo)this == paramObject) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if ((Intrinsics.areEqual(getClass(), paramObject.getClass()) ^ true)) {
        return false;
      }
      paramObject = (ExifInfo)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      if (this.b != paramObject.b) {
        return false;
      }
      bool1 = bool2;
      if (this.c == paramObject.c) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (this.a * 31 + this.b) * 31 + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.model.ExifInfo
 * JD-Core Version:    0.7.0.1
 */