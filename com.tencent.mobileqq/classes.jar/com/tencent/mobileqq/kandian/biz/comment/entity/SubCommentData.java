package com.tencent.mobileqq.kandian.biz.comment.entity;

public class SubCommentData
  extends BaseCommentData
{
  public int hasTarget;
  public String parentCommentId;
  public SubCommentData.RepliedCommentData repliedCommentData;
  public String repliedCommentId;
  public String repliedUserHomePage;
  public String repliedUserNickname;
  public String repliedUserUin;
  
  public boolean hasTarget()
  {
    return this.hasTarget == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubCommentData{parentCommentId='");
    localStringBuilder.append(this.parentCommentId);
    localStringBuilder.append('\'');
    localStringBuilder.append("，repliedCommentId='");
    localStringBuilder.append(this.repliedCommentId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", repliedUserUin='");
    localStringBuilder.append(this.repliedUserUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", repliedUserNickname='");
    localStringBuilder.append(this.repliedUserNickname);
    localStringBuilder.append('\'');
    localStringBuilder.append(", repliedUserHomePage='");
    localStringBuilder.append(this.repliedUserHomePage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", repliedCommentData='");
    localStringBuilder.append(this.repliedCommentData);
    localStringBuilder.append('\'');
    localStringBuilder.append(", hasTarget=");
    localStringBuilder.append(this.hasTarget);
    localStringBuilder.append('\'');
    localStringBuilder.append(super.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData
 * JD-Core Version:    0.7.0.1
 */