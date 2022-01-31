package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_read$ReadOriginalFeedsRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34 }, new String[] { "result", "err_msg", "info" }, new Object[] { Integer.valueOf(0), "", null }, ReadOriginalFeedsRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public ilive_feeds_read.FeedsInfo info = new ilive_feeds_read.FeedsInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadOriginalFeedsRsp
 * JD-Core Version:    0.7.0.1
 */