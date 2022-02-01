package com.tencent.mobileqq.kandian.biz.comment.entity;

import com.google.gson.annotations.SerializedName;

public class BaseCommentData$CommentRptData
{
  @SerializedName("type")
  public int a;
  @SerializedName("content")
  public String b;
  @SerializedName("uid")
  public String c;
  @SerializedName("url")
  public String d;
  @SerializedName("topicId")
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentRptData{type=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData
 * JD-Core Version:    0.7.0.1
 */