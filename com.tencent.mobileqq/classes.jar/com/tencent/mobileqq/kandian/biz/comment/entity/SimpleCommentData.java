package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "articleId", "getArticleId", "()Ljava/lang/String;", "setArticleId", "(Ljava/lang/String;)V", "authorId", "", "getAuthorId", "()J", "getBusinessInfo", "setBusinessInfo", "getContentSrc", "()I", "setContentSrc", "(I)V", "linkDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentLinkData;", "getLinkDataList", "()Ljava/util/List;", "setLinkDataList", "(Ljava/util/List;)V", "reportScene", "getReportScene", "setReportScene", "rowKey", "getRowKey", "setRowKey", "src", "getSrc", "describeContents", "readFromParcel", "", "toString", "writeToParcel", "flags", "CREATOR", "kandian-api_release"}, k=1, mv={1, 1, 16})
public class SimpleCommentData
  implements Parcelable
{
  public static final SimpleCommentData.CREATOR CREATOR = new SimpleCommentData.CREATOR(null);
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
  private final int jdField_b_of_type_Int;
  @NotNull
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  @NotNull
  private String jdField_c_of_type_JavaLangString;
  
  public SimpleCommentData(int paramInt, @NotNull String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    this.jdField_b_of_type_Int = 20;
  }
  
  public SimpleCommentData(@NotNull Parcel paramParcel)
  {
    this(i, str);
    a(paramParcel);
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    String str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.jdField_b_of_type_JavaLangString = str;
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentLinkData> b()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void b(@Nullable List<BaseCommentData.CommentLinkData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public final String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rowKey: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("articleId: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", ");
    localStringBuilder.append("authorId: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", ");
    localStringBuilder.append("contentSrc: ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", ");
    localStringBuilder.append("businessInfo: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData
 * JD-Core Version:    0.7.0.1
 */