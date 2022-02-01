package com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser;

import tencent.mobileim.structmsg.structmsg.StructMsg;

public abstract interface IGeneralGroupNotifyParser
{
  public abstract <T extends IGeneralGroupNotifyParser.GeneralGroupNotifyInfo> T a(structmsg.StructMsg paramStructMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser
 * JD-Core Version:    0.7.0.1
 */