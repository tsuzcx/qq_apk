package com.trunk.group_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_feeds$GroupFeedsMessage$ThemeBrief
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_state", "rpt_uint64_msguin", "uint32_speaker_num", "uint64_open_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ThemeBrief.class);
  public final PBRepeatField rpt_uint64_msguin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_speaker_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_state = PBField.initUInt32(0);
  public final PBUInt64Field uint64_open_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.trunk.group_feeds.group_feeds.GroupFeedsMessage.ThemeBrief
 * JD-Core Version:    0.7.0.1
 */