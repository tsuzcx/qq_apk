package com.tencent.videocut.picker;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/picker/PickersConfig;", "Landroid/os/Parcelable;", "selectType", "", "maxDuration", "", "minDuration", "maxVideoNum", "maxImageNum", "minVideoNum", "minImageNum", "minTotalNum", "maxTotalNum", "selectNumLimit", "shootingTips", "", "(IJJIIIIIIILjava/lang/String;)V", "getMaxDuration", "()J", "getMaxImageNum", "()I", "getMaxTotalNum", "getMaxVideoNum", "getMinDuration", "getMinImageNum", "getMinTotalNum", "getMinVideoNum", "getSelectNumLimit", "getSelectType", "getShootingTips", "()Ljava/lang/String;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class PickersConfig
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new PickersConfig.Creator();
  private final int a;
  private final long b;
  private final long c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  @NotNull
  private final String k;
  
  public PickersConfig()
  {
    this(0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, null, 2047, null);
  }
  
  public PickersConfig(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, @NotNull String paramString)
  {
    this.a = paramInt1;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramInt6;
    this.i = paramInt7;
    this.j = paramInt8;
    this.k = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PickersConfig))
      {
        paramObject = (PickersConfig)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
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
    int n = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.a);
    int i1 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.b);
    int i2 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.c);
    int i3 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d);
    int i4 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
    int i5 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.f);
    int i6 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.g);
    int i7 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.h);
    int i8 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.i);
    int i9 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.j);
    String str = this.k;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    return (((((((((n * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PickersConfig(selectType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", maxDuration=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", minDuration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", maxVideoNum=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", maxImageNum=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", minVideoNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", minImageNum=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", minTotalNum=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", maxTotalNum=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", selectNumLimit=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", shootingTips=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.picker.PickersConfig
 * JD-Core Version:    0.7.0.1
 */