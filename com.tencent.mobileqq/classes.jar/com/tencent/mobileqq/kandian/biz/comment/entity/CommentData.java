package com.tencent.mobileqq.kandian.biz.comment.entity;

import java.util.List;

public class CommentData
  extends BaseCommentData
{
  public static final int EXPOSURE_SUB_COMMENT_COUNT = 2;
  public List<SubCommentData> subCommentList;
  public int subCommentNum;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentData{'subCommentNum=");
    localStringBuilder.append(this.subCommentNum);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subCommentList=");
    localStringBuilder.append(this.subCommentList);
    localStringBuilder.append('\'');
    localStringBuilder.append(super.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.CommentData
 * JD-Core Version:    0.7.0.1
 */