package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SendPublicAccountMessageReceiptRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint64_unique_id", "uint32_op", "pcuin", "cuin", "receipt_type", "unique_ids" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, SendPublicAccountMessageReceiptRequest.class);
  public final PBUInt64Field cuin = PBField.initUInt64(0L);
  public final PBUInt64Field pcuin = PBField.initUInt64(0L);
  public final PBUInt32Field receipt_type = PBField.initUInt32(0);
  public final PBUInt64Field uint32_op = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_unique_id = PBField.initUInt64(0L);
  public final PBRepeatField unique_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SendPublicAccountMessageReceiptRequest
 * JD-Core Version:    0.7.0.1
 */