package com.tencent.mobileqq.kandian.biz.comment.data;

import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;

public class AtlasCommentData
{
  public CommentData a;
  public boolean b = false;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (AtlasCommentData)paramObject;
    return this.a.commentId.equals(paramObject.a.commentId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.AtlasCommentData
 * JD-Core Version:    0.7.0.1
 */