package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_new_anchor_follow_interface$GetFansNumberRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "ret", "msg", "fans_count", "is_fans", "anchor_uid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetFansNumberRsp.class);
  public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
  public final PBUInt32Field fans_count = PBField.initUInt32(0);
  public final PBUInt32Field is_fans = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field ret = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.ilive_new_anchor_follow_interface.GetFansNumberRsp
 * JD-Core Version:    0.7.0.1
 */