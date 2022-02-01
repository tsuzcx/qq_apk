package com.tencent.mobileqq.kandian.repo.comment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/comment/CommentReportInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "firstCommentId", "", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "reportReason", "getReportReason", "setReportReason", "reportType", "", "getReportType", "()I", "setReportType", "(I)V", "rowkey", "getRowkey", "setRowkey", "subCommentId", "getSubCommentId", "setSubCommentId", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class CommentReportInfo
  implements Parcelable
{
  public static final CommentReportInfo.CREATOR CREATOR = new CommentReportInfo.CREATOR(null);
  private int jdField_a_of_type_Int;
  @Nullable
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private String b = "";
  @Nullable
  private String c = "";
  @Nullable
  private String d = "";
  
  public CommentReportInfo() {}
  
  public CommentReportInfo(@NotNull Parcel paramParcel)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CommentReportInfo[");
    ((StringBuilder)localObject).append("rowkey:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("firstCommentId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("subCommentId:");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("reportType:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("\n");
    ((StringBuilder)localObject).append("reportReason:");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
    return localObject;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo
 * JD-Core Version:    0.7.0.1
 */