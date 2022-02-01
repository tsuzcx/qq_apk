package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/BlockUserCommentData;", "", "firstCommentId", "", "subCommentId", "commentType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCommentType", "()I", "setCommentType", "(I)V", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "getSubCommentId", "setSubCommentId", "toString", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentData
{
  public static final BlockUserCommentData.Companion a = new BlockUserCommentData.Companion(null);
  @NotNull
  private String b;
  @Nullable
  private String c;
  private int d;
  
  public BlockUserCommentData(@NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  @Nullable
  public final String b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlockUserCommentData(firstCommentId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', subCommentId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', commentType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.BlockUserCommentData
 * JD-Core Version:    0.7.0.1
 */