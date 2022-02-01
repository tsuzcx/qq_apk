package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class ChatBackgroundInfo
  extends Entity
  implements Serializable
{
  public static final int COMPLETED = 0;
  public static final String ID = "id";
  public static final int INCOMPLETE = 1;
  public static final String NAME = "name";
  public static final String THUMBURL = "thumbUrl";
  public static final String URL = "url";
  private static final long serialVersionUID = 1L;
  @unique
  public String id;
  public String name;
  public String thumbUrl;
  public String url;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("(");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("id==");
    localStringBuilder2.append(this.id);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",name==");
    localStringBuilder2.append(this.name);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",url==");
    localStringBuilder2.append(this.url);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",thumbUrl==");
    localStringBuilder2.append(this.thumbUrl);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(")");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ChatBackgroundInfo
 * JD-Core Version:    0.7.0.1
 */