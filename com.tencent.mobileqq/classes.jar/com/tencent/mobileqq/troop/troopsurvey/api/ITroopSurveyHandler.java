package com.tencent.mobileqq.troop.troopsurvey.api;

import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;

public abstract interface ITroopSurveyHandler
{
  public abstract void a(String paramString, int paramInt);
  
  public abstract boolean a(TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsurvey.api.ITroopSurveyHandler
 * JD-Core Version:    0.7.0.1
 */