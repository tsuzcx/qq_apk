package com.tencent.protofile.avredpacket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AVRedPacketGameSyncInfo$FrameSyncInfo
  extends MessageMicro<FrameSyncInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "emojis", "focusInfo", "hitInfo", "currScores", "frameSyncGameState", "seq" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FrameSyncInfo.class);
  public final PBUInt32Field currScores = PBField.initUInt32(0);
  public final PBRepeatMessageField<AVRedPacketGameSyncInfo.Emoji> emojis = PBField.initRepeatMessage(AVRedPacketGameSyncInfo.Emoji.class);
  public AVRedPacketGameSyncInfo.FocusInfo focusInfo = new AVRedPacketGameSyncInfo.FocusInfo();
  public final PBEnumField frameSyncGameState = PBField.initEnum(0);
  public AVRedPacketGameSyncInfo.HitInfo hitInfo = new AVRedPacketGameSyncInfo.HitInfo();
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FrameSyncInfo
 * JD-Core Version:    0.7.0.1
 */