package com.tencent.pb.onlinepush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OnlinePushTrans$ExtGroupKeyInfo
  extends MessageMicro<ExtGroupKeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "cur_max_seq", "cur_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ExtGroupKeyInfo.class);
  public final PBUInt32Field cur_max_seq = PBField.initUInt32(0);
  public final PBUInt64Field cur_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.onlinepush.OnlinePushTrans.ExtGroupKeyInfo
 * JD-Core Version:    0.7.0.1
 */