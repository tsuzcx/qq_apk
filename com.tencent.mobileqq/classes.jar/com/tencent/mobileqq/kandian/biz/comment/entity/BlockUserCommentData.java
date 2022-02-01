package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/BlockUserCommentData;", "", "firstCommentId", "", "subCommentId", "commentType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCommentType", "()I", "setCommentType", "(I)V", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "getSubCommentId", "setSubCommentId", "toString", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentData
{
  public static final BlockUserCommentData.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private String b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBlockUserCommentData$Companion = new BlockUserCommentData.Companion(null);
  }
  
  public BlockUserCommentData(@NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlockUserCommentData(firstCommentId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("', subCommentId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append("', commentType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.BlockUserCommentData
 * JD-Core Version:    0.7.0.1
 */