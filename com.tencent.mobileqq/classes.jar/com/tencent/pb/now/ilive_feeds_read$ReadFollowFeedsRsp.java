package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_read$ReadFollowFeedsRsp
  extends MessageMicro<ReadFollowFeedsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end_flag = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "result", "err_msg", "end_flag", "infos", "total" }, new Object[] { localInteger, "", localInteger, null, localInteger }, ReadFollowFeedsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadFollowFeedsRsp
 * JD-Core Version:    0.7.0.1
 */