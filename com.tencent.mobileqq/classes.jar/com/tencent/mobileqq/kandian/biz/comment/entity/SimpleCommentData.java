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
  @NotNull
  private String a;
  @NotNull
  private String b;
  private int c;
  private final long d;
  private final int e;
  @Nullable
  private List<BaseCommentData.CommentLinkData> f;
  private int g;
  @NotNull
  private String h;
  
  public SimpleCommentData(int paramInt, @NotNull String paramString)
  {
    this.g = paramInt;
    this.h = paramString;
    this.a = "";
    this.b = "";
    this.d = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    this.e = 20;
  }
  
  public SimpleCommentData(@NotNull Parcel paramParcel)
  {
    this(i, str);
    a(paramParcel);
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    String str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.a = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.b = str;
    this.c = paramParcel.readInt();
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  public final void b(@Nullable List<BaseCommentData.CommentLinkData> paramList)
  {
    this.f = paramList;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.b;
  }
  
  public final int f()
  {
    return this.c;
  }
  
  public final long g()
  {
    return this.d;
  }
  
  public final int h()
  {
    return this.e;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentLinkData> i()
  {
    return this.f;
  }
  
  public final int j()
  {
    return this.g;
  }
  
  @NotNull
  public final String k()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rowKey: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("articleId: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("authorId: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", ");
    localStringBuilder.append("contentSrc: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", ");
    localStringBuilder.append("businessInfo: ");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData
 * JD-Core Version:    0.7.0.1
 */