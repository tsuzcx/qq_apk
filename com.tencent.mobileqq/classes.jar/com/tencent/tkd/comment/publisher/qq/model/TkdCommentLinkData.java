package com.tencent.tkd.comment.publisher.qq.model;

import com.google.gson.annotations.SerializedName;

public class TkdCommentLinkData
{
  public static final int TYPE_ACTIVITY = 2;
  public static final int TYPE_CONTENT = 3;
  public static final int TYPE_GOODS = 1;
  public static final int TYPE_MINI_APP = 4;
  public static final int TYPE_QQ_GROUP = 5;
  @SerializedName("icon")
  public String iconUrl;
  @SerializedName("url")
  public String linkUrl;
  @SerializedName("type")
  public int type;
  @SerializedName("wording")
  public String wording;
  
  public TkdCommentLinkData() {}
  
  public TkdCommentLinkData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.linkUrl = paramString1;
    this.wording = paramString2;
    this.iconUrl = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommentLinkData{wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", linkUrl='");
    localStringBuilder.append(this.linkUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData
 * JD-Core Version:    0.7.0.1
 */