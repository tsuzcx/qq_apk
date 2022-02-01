package com.tencent.mobileqq.kandian.biz.comment.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/entity/AuthorCommentDeleteData;", "", "simpleCommentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "commentType", "", "commentId", "", "subCommentId", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;ILjava/lang/String;Ljava/lang/String;)V", "getCommentId", "()Ljava/lang/String;", "setCommentId", "(Ljava/lang/String;)V", "getCommentType", "()I", "setCommentType", "(I)V", "getSimpleCommentData", "()Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;", "setSimpleCommentData", "(Lcom/tencent/mobileqq/kandian/biz/comment/entity/SimpleCommentData;)V", "getSubCommentId", "setSubCommentId", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class AuthorCommentDeleteData
{
  private int jdField_a_of_type_Int;
  @NotNull
  private SimpleCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private String b;
  
  public AuthorCommentDeleteData(@NotNull SimpleCommentData paramSimpleCommentData, int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData = paramSimpleCommentData;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final SimpleCommentData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData;
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
    localStringBuilder.append("AuthorCommentDeleteData(simpleCommentData=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData);
    localStringBuilder.append(", commentType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", commentId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("', subCommentId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.AuthorCommentDeleteData
 * JD-Core Version:    0.7.0.1
 */