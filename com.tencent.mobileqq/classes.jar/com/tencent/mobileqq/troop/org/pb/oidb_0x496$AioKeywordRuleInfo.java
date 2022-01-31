package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$AioKeywordRuleInfo
  extends MessageMicro<AioKeywordRuleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "rule_id", "start_time", "end_time", "postion_flag", "match_group_class", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AioKeywordRuleInfo.class);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBRepeatField<Integer> match_group_class = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field postion_flag = PBField.initUInt32(0);
  public final PBUInt32Field rule_id = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordRuleInfo
 * JD-Core Version:    0.7.0.1
 */