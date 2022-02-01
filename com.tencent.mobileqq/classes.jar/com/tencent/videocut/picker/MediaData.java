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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/picker/MediaData;", "Landroid/os/Parcelable;", "type", "", "mimeType", "", "width", "height", "selectStart", "", "selectDuration", "duration", "mediaPath", "compressPath", "displayName", "(ILjava/lang/String;IIJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCompressPath", "()Ljava/lang/String;", "getDisplayName", "getDuration", "()J", "getHeight", "()I", "getMediaPath", "getMimeType", "getSelectDuration", "getSelectStart", "getType", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class MediaData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new MediaData.Creator();
  public static final MediaData.Companion a = new MediaData.Companion(null);
  private final int b;
  @NotNull
  private final String c;
  private final int d;
  private final int e;
  private final long f;
  private final long g;
  private final long h;
  @NotNull
  private final String i;
  @Nullable
  private final String j;
  @Nullable
  private final String k;
  
  public MediaData(int paramInt1, @NotNull String paramString1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, @NotNull String paramString2, @Nullable String paramString3, @Nullable String paramString4)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramLong1;
    this.g = paramLong2;
    this.h = paramLong3;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramString4;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final long d()
  {
    return this.h;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.i;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MediaData))
      {
        paramObject = (MediaData)paramObject;
        if ((this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h) && (Intrinsics.areEqual(this.i, paramObject.i)) && (Intrinsics.areEqual(this.j, paramObject.j)) && (Intrinsics.areEqual(this.k, paramObject.k))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final String f()
  {
    return this.j;
  }
  
  public int hashCode()
  {
    int i3 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.b);
    String str = this.c;
    int i2 = 0;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    int i4 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.d);
    int i5 = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.e);
    int i6 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.f);
    int i7 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.g);
    int i8 = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.h);
    str = this.i;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.j;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.k;
    if (str != null) {
      i2 = str.hashCode();
    }
    return ((((((((i3 * 31 + m) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MediaData(type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mimeType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", selectStart=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", selectDuration=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", duration=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mediaPath=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", compressPath=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", displayName=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.g);
    paramParcel.writeLong(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.picker.MediaData
 * JD-Core Version:    0.7.0.1
 */