package com.tencent.mobileqq.kandian.biz.comment.entity;

import com.google.gson.annotations.SerializedName;

public class BaseCommentData$CommentRptData
{
  @SerializedName("type")
  public int a;
  @SerializedName("content")
  public String a;
  @SerializedName("uid")
  public String b;
  @SerializedName("url")
  public String c;
  @SerializedName("topicId")
  public String d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentRptData{type=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData
 * JD-Core Version:    0.7.0.1
 */