package com.tencent.mobileqq.kandian.biz.comment.entity;

import android.os.Parcel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "commentRptDataList", "", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData$CommentRptData;", "getCommentRptDataList", "()Ljava/util/List;", "setCommentRptDataList", "(Ljava/util/List;)V", "commentStr", "getCommentStr", "()Ljava/lang/String;", "setCommentStr", "(Ljava/lang/String;)V", "wholeStringContent", "getWholeStringContent", "describeContents", "readFromParcel", "", "toString", "writeToParcel", "flags", "CREATOR", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentCreateData
  extends SimpleCommentData
{
  public static final FirstCommentCreateData.CREATOR CREATOR = new FirstCommentCreateData.CREATOR(null);
  @NotNull
  private String a = "";
  @Nullable
  private List<BaseCommentData.CommentRptData> b;
  
  public FirstCommentCreateData(int paramInt, @NotNull String paramString)
  {
    super(paramInt, paramString);
  }
  
  public FirstCommentCreateData(@NotNull Parcel paramParcel)
  {
    this(i, str);
    a(paramParcel);
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.a(paramParcel);
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    }
    this.a = paramParcel;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  public final void a(@Nullable List<BaseCommentData.CommentRptData> paramList)
  {
    this.b = paramList;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentRptData> b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    Object localObject1 = new StringBuilder(this.a);
    Object localObject2 = this.b;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(((BaseCommentData.CommentRptData)((Iterator)localObject2).next()).b);
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "stringBuilder.toString()");
    return localObject1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FirstCommentCreateData:");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("commentStr: ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData
 * JD-Core Version:    0.7.0.1
 */