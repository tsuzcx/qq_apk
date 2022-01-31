package com.tencent.protofile.avredpacket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AVRedPacketGameSyncInfo$Emoji
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "emojiTypeId", "startTime", "eventType", "trackNum", "id", "isBigEmoji", "fallDownDuration" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, Emoji.class);
  public final PBUInt32Field emojiTypeId = PBField.initUInt32(0);
  public final PBUInt32Field eventType = PBField.initUInt32(0);
  public final PBUInt32Field fallDownDuration = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBoolField isBigEmoji = PBField.initBool(false);
  public final PBUInt64Field startTime = PBField.initUInt64(0L);
  public final PBUInt32Field trackNum = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.Emoji
 * JD-Core Version:    0.7.0.1
 */