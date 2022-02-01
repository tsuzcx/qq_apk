package com.tencent.mobileqq.data.qzone;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="ownerUin")
public class FeedInfo
  extends Entity
{
  public int appid;
  public String content;
  public long feedTime;
  public int hasPic;
  @notColumn
  public boolean isExpose;
  public long ownerUin;
  public boolean showInTab = true;
  public String strImgUrl;
  public String strkey;
  public int typeId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ownerUin:");
    localStringBuilder.append(this.ownerUin);
    localStringBuilder.append("  appid:");
    localStringBuilder.append(this.appid);
    localStringBuilder.append("  typeid:");
    localStringBuilder.append(this.typeId);
    localStringBuilder.append("  feedTime:");
    localStringBuilder.append(this.feedTime);
    localStringBuilder.append("  strKey:");
    localStringBuilder.append(this.strkey);
    localStringBuilder.append("  hasPic:");
    localStringBuilder.append(this.hasPic);
    localStringBuilder.append("  content:");
    localStringBuilder.append(this.content);
    localStringBuilder.append("  strImgUrl:");
    localStringBuilder.append(this.strImgUrl);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.qzone.FeedInfo
 * JD-Core Version:    0.7.0.1
 */