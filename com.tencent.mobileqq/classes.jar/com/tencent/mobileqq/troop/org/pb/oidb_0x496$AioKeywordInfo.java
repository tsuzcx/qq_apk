package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$AioKeywordInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "word", "rule_id" }, new Object[] { "", Integer.valueOf(0) }, AioKeywordInfo.class);
  public final PBRepeatField rule_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeywordInfo
 * JD-Core Version:    0.7.0.1
 */