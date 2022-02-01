package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$ReadNewUserFeedsReq
  extends MessageMicro<ReadNewUserFeedsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt64Field pos = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "pos", "num", "uin" }, new Object[] { localLong, Integer.valueOf(0), localLong }, ReadNewUserFeedsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadNewUserFeedsReq
 * JD-Core Version:    0.7.0.1
 */