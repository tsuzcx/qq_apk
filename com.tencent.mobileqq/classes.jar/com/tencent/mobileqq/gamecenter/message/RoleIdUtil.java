package com.tencent.mobileqq.gamecenter.message;

import com.tencent.mobileqq.data.MessageRecord;

public class RoleIdUtil
{
  public static String a(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.fromRoleId;
    }
    return localTinyInfo.toRoleId;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo = new TinyInfo();
    localTinyInfo.parseFromMessageRecord(paramMessageRecord);
    if (paramMessageRecord.isSend()) {
      return localTinyInfo.toRoleId;
    }
    return localTinyInfo.fromRoleId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.RoleIdUtil
 * JD-Core Version:    0.7.0.1
 */