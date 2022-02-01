package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class NowSummaryCard$CommonTag$Tag
  extends MessageMicro<Tag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "topic", "name" }, new Object[] { "", "" }, Tag.class);
  public final PBRepeatField<String> name = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField topic = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.CommonTag.Tag
 * JD-Core Version:    0.7.0.1
 */