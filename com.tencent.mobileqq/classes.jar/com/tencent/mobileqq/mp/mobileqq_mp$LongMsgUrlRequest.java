package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$LongMsgUrlRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "puin", "str_fileid" }, new Object[] { Long.valueOf(0L), "" }, LongMsgUrlRequest.class);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField str_fileid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest
 * JD-Core Version:    0.7.0.1
 */