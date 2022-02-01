package com.tencent.videocut.render.model;

import .r8.java8methods.utility.Float.hashCode.IF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/model/StickerFrameConfig;", "Landroid/os/Parcelable;", "centerX", "", "centerY", "angle", "minScale", "maxScale", "scale", "(FFFFFF)V", "getAngle", "()F", "getCenterX", "getCenterY", "getMaxScale", "getMinScale", "getScale", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class StickerFrameConfig
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new StickerFrameConfig.Creator();
  @SerializedName("centerX")
  private final float a;
  @SerializedName("centerY")
  private final float b;
  @SerializedName("angle")
  private final float c;
  @SerializedName("minScale")
  private final float d;
  @SerializedName("maxScale")
  private final float e;
  @SerializedName("scale")
  private final float f;
  
  public StickerFrameConfig()
  {
    this(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 63, null);
  }
  
  public StickerFrameConfig(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StickerFrameConfig))
      {
        paramObject = (StickerFrameConfig)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0) && (Float.compare(this.d, paramObject.d) == 0) && (Float.compare(this.e, paramObject.e) == 0) && (Float.compare(this.f, paramObject.f) == 0)) {}
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
    return ((((.r8.java8methods.utility.Float.hashCode.IF.hashCode(this.a) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.b)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.c)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.d)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.e)) * 31 + .r8.java8methods.utility.Float.hashCode.IF.hashCode(this.f);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerFrameConfig(centerX=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", centerY=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", angle=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", minScale=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", maxScale=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", scale=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeFloat(this.a);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    paramParcel.writeFloat(this.e);
    paramParcel.writeFloat(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.model.StickerFrameConfig
 * JD-Core Version:    0.7.0.1
 */