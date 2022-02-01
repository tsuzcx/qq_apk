package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin,type")
public class DraftTextInfo
  extends Entity
{
  public String mAtInfoStr;
  public String mSourceAtInfoStr;
  public int mSourceMsgTime;
  public String mSourceRichMsg;
  public int mSourceSummaryFlag;
  public int mSourceType;
  public long mSourceUid;
  public String mixedMsgInfoHtml;
  public long sourceMsgSeq;
  public String sourceMsgText;
  public String sourceMsgTroopName;
  public long sourceSenderUin;
  public long sourceToUin;
  public String text;
  public long time;
  public int type;
  @unique
  public String uin;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DraftTextInfo
 * JD-Core Version:    0.7.0.1
 */