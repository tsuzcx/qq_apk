package com.tencent.mobileqq.kandian.biz.video.danmaku;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/danmaku/DanmakuInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "content", "", "time", "", "(Ljava/lang/String;J)V", "id", "type", "", "source", "rowkey", "(Ljava/lang/String;IILjava/lang/String;JLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "getRowkey", "getSource", "()I", "getTime", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuInfo
  implements Parcelable
{
  public static final DanmakuInfo.CREATOR CREATOR = new DanmakuInfo.CREATOR(null);
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  @Nullable
  private final String c;
  
  public DanmakuInfo(@NotNull Parcel paramParcel)
  {
    this(str1, i, j, str2, paramParcel.readLong(), paramParcel.readString());
  }
  
  public DanmakuInfo(@NotNull String paramString1, int paramInt1, int paramInt2, @NotNull String paramString2, long paramLong, @Nullable String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramString3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DanmakuInfo))
      {
        paramObject = (DanmakuInfo)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    String str = this.jdField_a_of_type_JavaLangString;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    int m = this.jdField_a_of_type_Int;
    int n = this.jdField_b_of_type_Int;
    str = this.jdField_b_of_type_JavaLangString;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    long l = this.jdField_a_of_type_Long;
    int i1 = (int)(l ^ l >>> 32);
    str = this.c;
    if (str != null) {
      k = str.hashCode();
    }
    return ((((i * 31 + m) * 31 + n) * 31 + j) * 31 + i1) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DanmakuInfo(id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("', content='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("', time=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", rowkey=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.DanmakuInfo
 * JD-Core Version:    0.7.0.1
 */