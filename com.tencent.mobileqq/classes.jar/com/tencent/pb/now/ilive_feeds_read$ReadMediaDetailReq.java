package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$ReadMediaDetailReq
  extends MessageMicro<ReadMediaDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField feedid = PBField.initString("");
  public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "feedid", "start", "num", "type", "follow_uid" }, new Object[] { "", localInteger, localInteger, localInteger, Long.valueOf(0L) }, ReadMediaDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadMediaDetailReq
 * JD-Core Version:    0.7.0.1
 */