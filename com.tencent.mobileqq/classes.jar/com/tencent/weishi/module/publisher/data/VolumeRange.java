package com.tencent.weishi.module.publisher.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weishi/module/publisher/data/VolumeRange;", "Landroid/os/Parcelable;", "start", "", "end", "(FF)V", "getEnd", "()F", "getStart", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "libtavcut_debug"}, k=1, mv={1, 1, 16})
@Parcelize
public final class VolumeRange
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new VolumeRange.Creator();
  public static final VolumeRange.Companion Companion = new VolumeRange.Companion(null);
  private final float end;
  private final float start;
  
  public VolumeRange(float paramFloat1, float paramFloat2)
  {
    this.start = paramFloat1;
    this.end = paramFloat2;
  }
  
  public final float component1()
  {
    return this.start;
  }
  
  public final float component2()
  {
    return this.end;
  }
  
  @NotNull
  public final VolumeRange copy(float paramFloat1, float paramFloat2)
  {
    return new VolumeRange(paramFloat1, paramFloat2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof VolumeRange))
      {
        paramObject = (VolumeRange)paramObject;
        if ((Float.compare(this.start, paramObject.start) == 0) && (Float.compare(this.end, paramObject.end) == 0)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final float getEnd()
  {
    return this.end;
  }
  
  public final float getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    return Float.floatToIntBits(this.start) * 31 + Float.floatToIntBits(this.end);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VolumeRange(start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", end=");
    localStringBuilder.append(this.end);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeFloat(this.start);
    paramParcel.writeFloat(this.end);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.data.VolumeRange
 * JD-Core Version:    0.7.0.1
 */