package com.tencent.protofile.avredpacket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVRedPacketGameSyncInfo$C2CGameInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 66, 72, 80, 88, 96 }, new String[] { "key", "state", "exceptionType", "fromWho", "musicId", "money", "resultCode", "resultState", "scores", "enterType", "maxScore", "totalEmojiNum" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, C2CGameInfo.class);
  public final PBUInt32Field enterType = PBField.initUInt32(0);
  public final PBUInt32Field exceptionType = PBField.initUInt32(0);
  public final PBUInt32Field fromWho = PBField.initUInt32(0);
  public final PBStringField key = PBField.initString("");
  public final PBUInt32Field maxScore = PBField.initUInt32(0);
  public final PBStringField money = PBField.initString("");
  public final PBUInt32Field musicId = PBField.initUInt32(0);
  public final PBUInt32Field resultCode = PBField.initUInt32(0);
  public final PBStringField resultState = PBField.initString("");
  public final PBUInt32Field scores = PBField.initUInt32(0);
  public final PBEnumField state = PBField.initEnum(0);
  public final PBUInt32Field totalEmojiNum = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.C2CGameInfo
 * JD-Core Version:    0.7.0.1
 */