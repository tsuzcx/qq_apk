package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentSinkData;", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "commentID", "", "rowkey", "contentSrc", "", "businessInfo", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCommentID", "()Ljava/lang/String;", "opType", "getOpType", "()I", "setOpType", "(I)V", "toString", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentSinkData
  extends SimpleCommentData
{
  public static final FirstCommentSinkData.Companion a = new FirstCommentSinkData.Companion(null);
  private int b;
  @NotNull
  private final String c;
  
  public FirstCommentSinkData(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3)
  {
    super(paramInt, paramString3);
    this.c = paramString1;
    b(paramString2);
    this.b = 3;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FirstCommentSinkData(commentID='");
    localStringBuilder.append(this.c);
    localStringBuilder.append("', opType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(") super=");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData
 * JD-Core Version:    0.7.0.1
 */