package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/AuthorCommentDeleteData;", "", "simpleCommentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "commentType", "", "commentId", "", "subCommentId", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;ILjava/lang/String;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getCommentType", "()I", "setCommentType", "(I)V", "getSimpleCommentData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "setSimpleCommentData", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;)V", "getSubCommentId", "setSubCommentId", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class AuthorCommentDeleteData
{
  @NotNull
  private SimpleCommentData a;
  private int b;
  @NotNull
  private String c;
  @Nullable
  private String d;
  
  public AuthorCommentDeleteData(@NotNull SimpleCommentData paramSimpleCommentData, int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    this.a = paramSimpleCommentData;
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  @NotNull
  public final SimpleCommentData a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AuthorCommentDeleteData(simpleCommentData=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", commentType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", commentId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', subCommentId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.AuthorCommentDeleteData
 * JD-Core Version:    0.7.0.1
 */