package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetEqqDetailInfoRequest
  extends MessageMicro<GetEqqDetailInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "eqq_id", "seqno", "leqq_id", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GetEqqDetailInfoRequest.class);
  public final PBUInt32Field eqq_id = PBField.initUInt32(0);
  public final PBUInt64Field leqq_id = PBField.initUInt64(0L);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetEqqDetailInfoRequest
 * JD-Core Version:    0.7.0.1
 */