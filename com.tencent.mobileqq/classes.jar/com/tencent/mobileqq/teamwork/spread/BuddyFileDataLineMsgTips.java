package com.tencent.mobileqq.teamwork.spread;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class BuddyFileDataLineMsgTips
  extends BaseTimDataLineTipsProcessor
{
  public BuddyFileDataLineMsgTips(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord, ConfigSettingForDataLine paramConfigSettingForDataLine)
  {
    super(paramQQAppInterface, paramDataLineMsgRecord, paramConfigSettingForDataLine);
  }
  
  protected String a()
  {
    return this.d.filename;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileDataLineMsgTips
 * JD-Core Version:    0.7.0.1
 */