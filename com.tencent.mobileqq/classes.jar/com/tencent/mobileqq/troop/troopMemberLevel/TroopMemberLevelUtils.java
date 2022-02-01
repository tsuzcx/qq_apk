package com.tencent.mobileqq.troop.troopMemberLevel;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopMemberLevelUtils
{
  public static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      try
      {
        troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
        localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
        if (localGroupUserCardHonor.level.has())
        {
          int i = localGroupUserCardHonor.level.get();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberLevelUtils", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelUtils", 2, "data error");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils
 * JD-Core Version:    0.7.0.1
 */