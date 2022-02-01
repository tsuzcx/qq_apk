package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_read$ReadUserFeedsNumRsp
  extends MessageMicro<ReadUserFeedsNumRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "err_msg", "total" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ReadUserFeedsNumRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadUserFeedsNumRsp
 * JD-Core Version:    0.7.0.1
 */