package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;

public class AtlasCommentData
{
  public CommentData a;
  public boolean a;
  
  public AtlasCommentData()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (AtlasCommentData)paramObject;
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommentData.commentId.equals(paramObject.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommentData.commentId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.AtlasCommentData
 * JD-Core Version:    0.7.0.1
 */