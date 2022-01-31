package com.tencent.mobileqq.data.qzone;

import auko;
import aulz;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="ownerUin")
public class FeedInfo
  extends auko
{
  public int appid;
  public String content;
  public long feedTime;
  public int hasPic;
  @aulz
  public boolean isExpose;
  public long ownerUin;
  public boolean showInTab = true;
  public String strImgUrl;
  public String strkey;
  public int typeId;
  
  public String toString()
  {
    return "ownerUin:" + this.ownerUin + "  appid:" + this.appid + "  typeid:" + this.typeId + "  feedTime:" + this.feedTime + "  strKey:" + this.strkey + "  hasPic:" + this.hasPic + "  content:" + this.content + "  strImgUrl:" + this.strImgUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.qzone.FeedInfo
 * JD-Core Version:    0.7.0.1
 */