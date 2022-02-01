package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetTinyID$STTinyID2UserAccInfoReq
  extends MessageMicro<STTinyID2UserAccInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "tinyids" }, new Object[] { Long.valueOf(0L) }, STTinyID2UserAccInfoReq.class);
  public final PBRepeatField<Long> tinyids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoReq
 * JD-Core Version:    0.7.0.1
 */