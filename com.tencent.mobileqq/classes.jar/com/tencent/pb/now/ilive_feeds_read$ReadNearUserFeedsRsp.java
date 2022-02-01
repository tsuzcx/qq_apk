package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_read$ReadNearUserFeedsRsp
  extends MessageMicro<ReadNearUserFeedsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "result", "err_msg", "end_flag", "infos", "total", "pos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReadNearUserFeedsRsp.class);
  public final PBUInt32Field end_flag = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsRsp
 * JD-Core Version:    0.7.0.1
 */