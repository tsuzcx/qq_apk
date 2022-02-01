package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/PatrolArbitrationData;", "", "uin", "", "firstCommentId", "subCommentId", "rowKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "getRowKey", "setRowKey", "getSubCommentId", "setSubCommentId", "getUin", "setUin", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class PatrolArbitrationData
{
  @NotNull
  private String a;
  @NotNull
  private String b;
  @NotNull
  private String c;
  @NotNull
  private String d;
  
  public PatrolArbitrationData(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PatrolArbitrationData(patrolUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("', firstCommentId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', subCommentId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', rowKey=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.PatrolArbitrationData
 * JD-Core Version:    0.7.0.1
 */