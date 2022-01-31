package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFunCallAndRing$TSsoCmd0x4Req
  extends MessageMicro<TSsoCmd0x4Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "i32_funcall_id", "i32_ring_id", "rpt_uins" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, TSsoCmd0x4Req.class);
  public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
  public final PBInt32Field i32_ring_id = PBField.initInt32(0);
  public final PBRepeatField<Long> rpt_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x4Req
 * JD-Core Version:    0.7.0.1
 */