package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="msgSeq")
public class TroopTipsEntity
  extends Entity
{
  public static final int SHOW_IN_AIO_BOTTOM = 1;
  public String OptActionData_a;
  public String OptActionData_i;
  public int actiontType;
  public String currentUin;
  public long expireTime;
  public String extra;
  public int grayTipsRemindFlag;
  public String grayTipsSummary = "";
  public String highlightItems;
  public int highlightNum;
  public boolean isOfflineMsg;
  public boolean isSupportImage = true;
  public long msgSeq;
  public String optActionData;
  public String optButton;
  public String optContent;
  public int optIcon;
  public long optMsgTime;
  public int optShowLatest;
  public String optTitle;
  public String optUrl;
  public String optUrlP;
  public boolean read;
  public String senderUin;
  public long time;
  public int tipsPromptType;
  public String troopUin;
  public int uinType = 1;
  
  public boolean need2InsertIntoMsgListRightNow()
  {
    return (!this.isOfflineMsg) && (this.optShowLatest != 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopTipsEntity
 * JD-Core Version:    0.7.0.1
 */