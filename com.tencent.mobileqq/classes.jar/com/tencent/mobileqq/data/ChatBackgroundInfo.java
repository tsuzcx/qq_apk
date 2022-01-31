package com.tencent.mobileqq.data;

import aukm;
import auma;
import java.io.Serializable;

public class ChatBackgroundInfo
  extends aukm
  implements Serializable
{
  public static final int COMPLETED = 0;
  public static final String ID = "id";
  public static final int INCOMPLETE = 1;
  public static final String NAME = "name";
  public static final String THUMBURL = "thumbUrl";
  public static final String URL = "url";
  private static final long serialVersionUID = 1L;
  @auma
  public String id;
  public String name;
  public String thumbUrl;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append("id==" + this.id);
    localStringBuilder.append(",name==" + this.name);
    localStringBuilder.append(",url==" + this.url);
    localStringBuilder.append(",thumbUrl==" + this.thumbUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatBackgroundInfo
 * JD-Core Version:    0.7.0.1
 */