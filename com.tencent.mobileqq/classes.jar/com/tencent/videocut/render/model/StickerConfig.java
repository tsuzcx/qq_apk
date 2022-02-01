package com.tencent.videocut.render.model;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/model/StickerConfig;", "Landroid/os/Parcelable;", "type", "", "actionType", "frame", "Lcom/tencent/videocut/render/model/StickerFrameConfig;", "animationMode", "", "playEndDuration", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/render/model/StickerFrameConfig;IJ)V", "getActionType", "()Ljava/lang/String;", "getAnimationMode", "()I", "getFrame", "()Lcom/tencent/videocut/render/model/StickerFrameConfig;", "getPlayEndDuration", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class StickerConfig
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new StickerConfig.Creator();
  @SerializedName("type")
  @NotNull
  private final String a;
  @SerializedName("actionType")
  @NotNull
  private final String b;
  @SerializedName("frame")
  @NotNull
  private final StickerFrameConfig c;
  @SerializedName("animationMode")
  private final int d;
  @SerializedName("playEndDuration")
  private final long e;
  
  public StickerConfig(@NotNull String paramString1, @NotNull String paramString2, @NotNull StickerFrameConfig paramStickerFrameConfig, int paramInt, long paramLong)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramStickerFrameConfig;
    this.d = paramInt;
    this.e = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StickerConfig))
      {
        paramObject = (StickerConfig)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e)) {}
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
    Object localObject = this.a;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((i * 31 + j) * 31 + k) * 31 + .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d)) * 31 + .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.e);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerConfig(type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", frame=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", animationMode=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", playEndDuration=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    this.c.writeToParcel(paramParcel, 0);
    paramParcel.writeInt(this.d);
    paramParcel.writeLong(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.model.StickerConfig
 * JD-Core Version:    0.7.0.1
 */