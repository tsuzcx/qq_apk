package com.tencent.tkd.comment.publisher.qq.model;

import com.google.gson.annotations.SerializedName;

public class TkdCommentLinkData
{
  public static final int TYPE_ACTIVITY = 2;
  public static final int TYPE_CONTENT = 3;
  public static final int TYPE_GOODS = 1;
  public static final int TYPE_MINI_APP = 4;
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
    return "CommentLinkData{wording='" + this.wording + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", type=" + this.type + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData
 * JD-Core Version:    0.7.0.1
 */