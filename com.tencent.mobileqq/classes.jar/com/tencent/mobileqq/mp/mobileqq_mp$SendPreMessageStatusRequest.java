package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SendPreMessageStatusRequest
  extends MessageMicro<SendPreMessageStatusRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "luin", "uint64_unique_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, SendPreMessageStatusRequest.class);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SendPreMessageStatusRequest
 * JD-Core Version:    0.7.0.1
 */