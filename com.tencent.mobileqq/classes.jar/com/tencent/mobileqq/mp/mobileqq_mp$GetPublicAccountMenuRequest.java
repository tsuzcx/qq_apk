package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$GetPublicAccountMenuRequest
  extends MessageMicro<GetPublicAccountMenuRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "seqno", "uin", "luin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetPublicAccountMenuRequest.class);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field seqno = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuRequest
 * JD-Core Version:    0.7.0.1
 */