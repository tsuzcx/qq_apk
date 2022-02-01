package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x496$AioKeyword
  extends MessageMicro<AioKeyword>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "keywords", "rules", "version" }, new Object[] { null, null, Integer.valueOf(0) }, AioKeyword.class);
  public final PBRepeatMessageField<oidb_0x496.AioKeywordInfo> keywords = PBField.initRepeatMessage(oidb_0x496.AioKeywordInfo.class);
  public final PBRepeatMessageField<oidb_0x496.AioKeywordRuleInfo> rules = PBField.initRepeatMessage(oidb_0x496.AioKeywordRuleInfo.class);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword
 * JD-Core Version:    0.7.0.1
 */