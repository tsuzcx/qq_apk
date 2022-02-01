package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTinyID$STUserAccInfo
  extends MessageMicro<STUserAccInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "tinyid", "identifier" }, new Object[] { Long.valueOf(0L), "" }, STUserAccInfo.class);
  public final PBStringField identifier = PBField.initString("");
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STUserAccInfo
 * JD-Core Version:    0.7.0.1
 */