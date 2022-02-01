package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "commentRptDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "getCommentRptDataList", "()Ljava/util/List;", "setCommentRptDataList", "(Ljava/util/List;)V", "commentStr", "getCommentStr", "()Ljava/lang/String;", "setCommentStr", "(Ljava/lang/String;)V", "firstCommentId", "getFirstCommentId", "setFirstCommentId", "repliedSubAuthorId", "", "getRepliedSubAuthorId", "()J", "setRepliedSubAuthorId", "(J)V", "repliedSubCommentId", "getRepliedSubCommentId", "setRepliedSubCommentId", "wholeStringContent", "getWholeStringContent", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class SubCommentCreateData
  extends SimpleCommentData
  implements Parcelable
{
  public static final SubCommentCreateData.CREATOR CREATOR = new SubCommentCreateData.CREATOR(null);
  private long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private List<BaseCommentData.CommentRptData> jdField_a_of_type_JavaUtilList;
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  
  public SubCommentCreateData(int paramInt, @NotNull String paramString)
  {
    super(paramInt, paramString);
  }
  
  public SubCommentCreateData(@NotNull Parcel paramParcel)
  {
    this(i, str);
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    b(str);
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    c(str);
    b(paramParcel.readInt());
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.b = str;
    this.jdField_a_of_type_Long = paramParcel.readLong();
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    }
    this.c = paramParcel;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentRptData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable List<BaseCommentData.CommentRptData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public final long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String f()
  {
    return this.c;
  }
  
  @NotNull
  public final String g()
  {
    Object localObject1 = new StringBuilder(this.b);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(((BaseCommentData.CommentRptData)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "stringBuilder.toString()");
    return localObject1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubCommentCreateData:");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("commentStr: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("firstCommentId: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("repliedSubAuthorId: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("repliedSubCommentId: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData
 * JD-Core Version:    0.7.0.1
 */