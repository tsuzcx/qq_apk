package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$GetUserEqqListRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "begin", "limit", "seqno", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetUserEqqListRequest.class);
  public final PBUInt32Field begin = PBField.initUInt32(0);
  public final PBUInt32Field limit = PBField.initUInt32(0);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListRequest
 * JD-Core Version:    0.7.0.1
 */